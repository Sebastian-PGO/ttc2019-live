package ttc19

import docbook.DocbookPackage
import docbook.Para
import docbook.Sect1
import java.util.Map
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import yamtl.core.YAMTLModule.ExtentTypeModifier
import yamtl.incremental.ChangeDescriptionAnalysisUtil.YAMTLChangeType

class Runner_original {
	val static TRIVIAL_CHECK = [EObject eObj, Object value | true] as (EObject,Object)=>boolean
	
	val static FULL_SOLUTION = true
	
	def static void main(String[] args) {
//		val modelName = 'random10'
		val modelName = 'random100' 
//		val modelName = 'random1000' // 1.5 s
//		val modelName = 'random10000' // 90-94 s
		
		
		val type = 'double'
		
		var String inputModelPath = '''/Users/ab373/Documents/ArturData/WORK/git-ttc19-live-post/ttc2019-live/models/«modelName».bibtex'''
		
		val xform = new Bibtex2Docbook_original
		xform.debug = false
//		xform.initLocationsWhenLoading = true
		xform.fromRoots = true
		xform.stageUpperBound = 1
		xform.extentTypeModifier = ExtentTypeModifier.LIST
		xform.trackTargetUpdates = true
		
		// PREPARE MODELS
		xform.loadInputModels(#{'bib' -> inputModelPath})

		if (FULL_SOLUTION) {
		
			// EXECUTE TRAFO 
			xform.execute()
			
			// PRINT STATS
			println(xform.toStringStats)
	
			// STORE MODELS
			var String outputModelPath = '''src/main/resources/models/«modelName».output.xmi'''
			xform.saveOutputModels(#{'doc' -> outputModelPath})
	
		} else {
			var String outputModelPath = '''/Users/ab373/Documents/ArturData/WORK/git-ttc19-live-post/ttc2019-live/models/«modelName».docbook'''
			xform.loadOutputModels( #{'doc' -> outputModelPath} )
		
		
			(1..50).forEach [
				var deltaFileName = '''«modelName»-«type»-«it»'''
				var deltaFilePath = '''/Users/ab373/Documents/ArturData/WORK/git-ttc19-live-post/ttc2019-live/models/«modelName»/«deltaFileName»/applied.changes.xmi'''
				xform.loadDelta('doc', deltaFileName, deltaFilePath)
			
			
				// inconsistency language
				val DocBook = DocbookPackage.eINSTANCE
				val inconsistencyLang = #{
					DocBook.section -> #{ 'paras' -> 
						#{
							'Swapping paragraph' -> (YAMTLChangeType.MOVE -> TRIVIAL_CHECK  as (EObject, Object)=>boolean),
							'Deleting paragraph' -> (YAMTLChangeType.REMOVE -> TRIVIAL_CHECK  as (EObject, Object)=>boolean)
						}
					},
					DocBook.article -> #{ 
						'sections_1' -> #{ 
							'Deleting sections' -> (YAMTLChangeType.REMOVE -> TRIVIAL_CHECK  as (EObject, Object)=>boolean)
						}
					},
					DocBook.sect1 -> #{ 
						'sections_2' -> #{
							'Deleting sections' -> (YAMTLChangeType.REMOVE -> TRIVIAL_CHECK  as (EObject, Object)=>boolean)
						},
						'paras' -> #{
							'Adding an existing paragraph to Sect1' -> (YAMTLChangeType.ADD -> [ EObject eObj, Object value |
								val sect1 = eObj as Sect1
								val para = value as Para
								sect1.paras.exists[it.content.startsWith(para.content)]
							] as (EObject, Object)=>boolean)
						}
					}
				} as Map<EClass,Map<String,Map<String,Pair<YAMTLChangeType,(EObject,Object)=>boolean>>>>
				val result = xform.admissibleChange('doc', deltaFileName, inconsistencyLang)
				println( '''«deltaFileName»: «IF result»consistent«ELSE»inconsistent«ENDIF»''')
	//			val result = xform.findInconsistenciesInChange('doc', deltaFileName, inconsistencyLang, true)
			
			]
		
		}
	}
}