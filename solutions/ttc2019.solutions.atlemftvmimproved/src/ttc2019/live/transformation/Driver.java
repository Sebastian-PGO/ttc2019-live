package ttc2019.live.transformation;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import ttc2019.live.bibtex.BibTeXFile;
import ttc2019.live.bibtex.BibtexPackage;
import ttc2019.live.docbook.DocbookPackage;

/**
 * This class is not part of any solutions: it's just a utility for running the
 * original transformation that produces the reference DocBook document, which
 * is later mutated.
 */
public class Driver {

	private final File fBibtex, fDocbook;
	private BibTeXFile bibtexFile;
	private Resource outputResource;

	public Driver(File fBibtex, File fDocbook) {
		this.fBibtex = fBibtex;
		this.fDocbook = fDocbook;
	}

	public static void main(String[] args) {
		if (args.length != 2) {
			System.err.println("Usage: java -jar ... in.bibtex out.docbook");
			System.exit(1);
		}

		final File fBibtex = new File(args[0]);
		final File fDocbook = new File(args[1]);
		final Driver driver = new Driver(fBibtex, fDocbook);
		try {
			driver.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void execute() throws Exception {
		initialize();
		load();
		run();
	}

	private ResourceSet repository;
	private Transformation solution;
	private long stopwatch;

	@SuppressWarnings("unchecked")
	private <T> T loadFile(File file) {
		Resource mRes;
		try {
			mRes = repository.getResource(URI.createFileURI(file.getCanonicalPath()), true);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return (T) mRes.getContents().get(0);
	}

	private void load() throws IOException {
		stopwatch = System.nanoTime();
		bibtexFile = loadFile(fBibtex);

		URI uri = URI.createFileURI(fDocbook.getCanonicalPath());
		outputResource = repository.createResource(uri);
		outputResource.getContents().clear();

		stopwatch = System.nanoTime() - stopwatch;
		report(BenchmarkPhase.Load);
	}

	private void initialize() throws Exception {
		stopwatch = System.nanoTime();

		repository = new ResourceSetImpl();
		repository.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
		repository.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		repository.getPackageRegistry().put(BibtexPackage.eINSTANCE.getNsURI(), BibtexPackage.eINSTANCE);
		repository.getPackageRegistry().put(DocbookPackage.eINSTANCE.getNsURI(), BibtexPackage.eINSTANCE);

		stopwatch = System.nanoTime() - stopwatch;
		report(BenchmarkPhase.Initialization);
	}

	private void run() throws IOException {
		stopwatch = System.nanoTime();

		solution = new Transformation(bibtexFile, outputResource);		
		solution.run();

		stopwatch = System.nanoTime() - stopwatch;
		report(BenchmarkPhase.Run);
		outputResource.save(null);
	}

	private void report(BenchmarkPhase phase) {
		if ("true".equals(System.getenv("NoGC"))) {
			// nothing to do
		} else {
			Runtime.getRuntime().gc();
			Runtime.getRuntime().gc();
			Runtime.getRuntime().gc();
			Runtime.getRuntime().gc();
			Runtime.getRuntime().gc();
		}

		final long memoryUsed = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		System.out.println(String.format("Phase %s run in %s ns, using %s bytes of memory", phase.toString(), Long.toString(stopwatch), Long.toString(memoryUsed)));
	}

	enum BenchmarkPhase {
		Initialization, Load, Run
	}
}
