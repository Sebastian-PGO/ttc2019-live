package ttc2019.solutions.xtend;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

import ttc2019.live.bibtex.BibtexPackage;
import ttc2019.live.changes.ChangesPackage;
import ttc2019.live.changes.ModelChangeSet;
import ttc2019.live.docbook.DocBook;
import ttc2019.live.docbook.DocbookPackage;

public class LiveContestDriver {

	public static void main(String[] args) {
		try {
	        Initialize();
	        Load();
	        Run();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

    private static String Tool;
    private static String MutantSet;
    private static String SourcePath;
    private static String Mutant;
    private static String MutantPath;
    private static String RunIndex;
    private static long stopwatch;

    private static ResourceSet repository;
	private static Solution solution;

    static void Load()
    {
    	stopwatch = System.nanoTime();
    	
    	repository = new ResourceSetImpl();
		repository.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new Resource.Factory() {
			@Override
			public Resource createResource(URI uri) {
				XMIResourceImpl ret = new XMIResourceImpl(uri);
				ret.setIntrinsicIDToEObjectMap(new HashMap<>());
				ret.getDefaultLoadOptions().put(XMLResource.OPTION_DEFER_IDREF_RESOLUTION, true);
				return ret;
			}
		});
		repository.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
		repository.getPackageRegistry().put(BibtexPackage.eINSTANCE.getNsURI(), BibtexPackage.eINSTANCE);
		repository.getResourceFactoryRegistry().getExtensionToFactoryMap().put("bibtex", new XMIResourceFactoryImpl());
		repository.getPackageRegistry().put(DocbookPackage.eINSTANCE.getNsURI(), DocbookPackage.eINSTANCE);
		repository.getResourceFactoryRegistry().getExtensionToFactoryMap().put("docbook", new XMIResourceFactoryImpl());
		repository.getPackageRegistry().put(ChangesPackage.eINSTANCE.getNsURI(), ChangesPackage.eINSTANCE);
		repository.getResourceFactoryRegistry().getExtensionToFactoryMap().put("changes", new XMIResourceFactoryImpl());
		
		String ChangePath = MutantPath.replaceAll("mutated.docbook", "applied.changes");
		String TargetPath = SourcePath.replaceAll(".bibtex", ".docbook");
		Boolean followingEVL = false;
		if("EMFSolutionXtendFollowingEVL".contentEquals(Tool)) {
			followingEVL = true;
		} else {
			followingEVL = false;
		}
		solution = new Solution(followingEVL, (DocBook)loadFile(TargetPath), (ModelChangeSet)loadFile(ChangePath));

    	stopwatch = System.nanoTime() - stopwatch;
        Report(BenchmarkPhase.Load, null);
    }
    
    private static Object loadFile(String path) {
    	Resource mRes;
		try {
			mRes = repository.getResource(URI.createFileURI(new File(path).getCanonicalPath()), true);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
    	return mRes.getContents().get(0);
    }

    static void Initialize() throws Exception
    {
    	stopwatch = System.nanoTime();
 
    	// Make sure that both metamodels are available and loaded
    	BibtexPackage.eINSTANCE.getName();
    	DocbookPackage.eINSTANCE.getName();

		Tool = System.getenv("Tool");
		MutantSet = System.getenv("MutantSet");
		SourcePath = System.getenv("SourcePath");
		Mutant = System.getenv("Mutant");
		MutantPath = System.getenv("MutantPath");
		RunIndex = System.getenv("RunIndex");
		
        stopwatch = System.nanoTime() - stopwatch;
        Report(BenchmarkPhase.Initialization, null);
    }

    static void Run() throws Exception
    {
        stopwatch = System.nanoTime();

        int problems = solution.execute();
        
        stopwatch = System.nanoTime() - stopwatch;
        Report(BenchmarkPhase.Run, Integer.toString(problems));
    }

    static void Report(BenchmarkPhase phase, String result)
    {
        System.out.println(String.format("%s;%s;%s;%s;%s;%s;Time;%s", Tool, MutantSet, new File(SourcePath).getName(), Mutant, RunIndex, phase.toString(), Long.toString(stopwatch)));

        if ("true".equals(System.getenv("NoGC"))) {
			// nothing to do
		} else {
			Runtime.getRuntime().gc();
			Runtime.getRuntime().gc();
			Runtime.getRuntime().gc();
			Runtime.getRuntime().gc();
			Runtime.getRuntime().gc();
		}
        long memoryUsed = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println(String.format("%s;%s;%s;%s;%s;%s;Memory;%s", Tool, MutantSet, new File(SourcePath).getName(), Mutant, RunIndex, phase.toString(), Long.toString(memoryUsed)));

        if (result != null)
        {
            System.out.println(String.format("%s;%s;%s;%s;%s;%s;Problems;%s", Tool, MutantSet, new File(SourcePath).getName(), Mutant, RunIndex, phase.toString(), result));
        }
    }

    enum BenchmarkPhase {
        Initialization,
        Load,
        Run
    }
}
