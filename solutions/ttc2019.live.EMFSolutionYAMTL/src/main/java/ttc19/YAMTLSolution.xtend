package ttc19

import docbook.DocbookPackage
import docbook.Para
import docbook.Sect1
import java.util.Map
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.lib.annotations.Accessors
import yamtl.incremental.ChangeDescriptionAnalysisUtil.YAMTLChangeType

class YAMTLSolution {
	val static DocBook = DocbookPackage.eINSTANCE
	
	val static TRIVIAL_CHECK = [EObject eObj, Object value | true] as (EObject,Object)=>boolean
	
	// inconsistency specification
	@Accessors
	val public static inconsistencySpec = #{
		DocBook.section -> #{ 'paras' -> 
			#{
				'Swapping paragraph' -> (YAMTLChangeType.MOVE -> TRIVIAL_CHECK),
				'Deleting paragraph' -> (YAMTLChangeType.REMOVE -> TRIVIAL_CHECK)
			}
		},
		DocBook.article -> #{ 
			'sections_1' -> #{ 
				'Deleting sections' -> (YAMTLChangeType.REMOVE -> TRIVIAL_CHECK)
			}
		},
		DocBook.sect1 -> #{ 
			'sections_2' -> #{
				'Deleting sections' -> (YAMTLChangeType.REMOVE -> TRIVIAL_CHECK)
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
}