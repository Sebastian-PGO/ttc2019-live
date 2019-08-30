package ttc19;

import java.io.File;
import java.util.Map;

import bibtex.BibtexPackage;
import docbook.DocbookPackage;
import yamtl.core.YAMTLModule.ExtentTypeModifier;

public class LiveContestDriver {

	public static void main(String[] args) {
		if (args.length>0) { 
			runFullMode = args[0].equals("full");
		}
		
		try {
	        Initialize();
	        Load();
	        Run();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static boolean runFullMode = false;
    private static String Tool;
    private static String MutantSet;
    private static String SourcePath;
    private static String Mutant;
    private static String MutantPath;
    private static String TargetPath;
    private static String RunIndex;
    private static long stopwatch;

    private static Bibtex2Docbook xform;


    static void Initialize() throws Exception
    {
    	stopwatch = System.nanoTime();
    	xform = new Bibtex2Docbook();
    	xform.fromRoots = true;
		xform.stageUpperBound = 1;
		xform.extentTypeModifier = ExtentTypeModifier.LIST;
		xform.trackTargetUpdates = true;
		xform.warning_on = false;
 
    	// Make sure that both metamodels are available and loaded
    	BibtexPackage.eINSTANCE.getName();
    	DocbookPackage.eINSTANCE.getName();

		Tool = System.getenv("Tool");
		MutantSet = System.getenv("MutantSet");
		SourcePath = System.getenv("SourcePath");
		Mutant = System.getenv("Mutant");
		MutantPath = System.getenv("MutantPath");
		TargetPath = SourcePath.replaceAll(".bibtex", ".docbook");
		RunIndex = System.getenv("RunIndex");    	

        stopwatch = System.nanoTime() - stopwatch;
        Report(BenchmarkPhase.Initialization, null);
    }
    
    static void Load()
    {
    	stopwatch = System.nanoTime();

    	if (runFullMode) {
    		// solution B)
    		xform.loadInputModels(
	    		Map.of("bib", SourcePath)
	    	);	
    	} else {
    		// solution A)
    		xform.loadOutputModels(
	    		Map.of("doc", TargetPath)
	    	);
    		String deltaFilePath = new File(MutantPath).getParent() + "/" + "applied.changes.xmi";
    		xform.loadDelta("doc", Mutant, deltaFilePath);
    	}
    	
    	

    	stopwatch = System.nanoTime() - stopwatch;
        Report(BenchmarkPhase.Load, null);
    }


    static void Run() throws Exception
    {
    	boolean admissible = false;
        stopwatch = System.nanoTime();
//        List<String> result = new ArrayList<>();

        if (runFullMode) {
        	// OPTIONAL: compute the consistency relation between source and target
	        xform.execute();
        } else {
	        // Analyse change
	        admissible = xform.admissibleChange("doc", Mutant, YAMTLSolution.inconsistencySpec);
	//        result = xform.findInconsistenciesInChange("doc", Mutant, YAMTLSolution.inconsistencySpec, false);
        }
        stopwatch = System.nanoTime() - stopwatch;
        
        if (runFullMode)
        	Report(BenchmarkPhase.Run, "-1");
        else
        	Report(BenchmarkPhase.Run, admissible ? "0" : "1");
        	//        Report(BenchmarkPhase.Run, Integer.toString(result.size()));

		//String outputModelPath = "./tmp.xmi";
        //xform.saveOutputModels(Map.of("doc", outputModelPath));
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
