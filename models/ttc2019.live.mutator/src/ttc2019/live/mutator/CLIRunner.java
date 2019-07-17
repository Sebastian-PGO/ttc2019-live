package ttc2019.live.mutator;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import ttc2019.live.docbook.DocBook;
import ttc2019.live.docbook.DocbookPackage;


/**
 * Entry point from the command line.
 */
public class CLIRunner {

	public static void main(String[] args) {
		if (args.length < 3 || args.length > 5) {
			System.err.println("Usage: java -jar mutator.jar source.docbook dirPrefix nMutants [nMutationsPerMutant=1] [seed=time]");
			System.exit(1);
		}

		final File fSource = new File(args[0]);
		final String dirPrefix = args[1];
		final int nMutants = Integer.parseInt(args[2]);
		final int nMutationsPerMutant = args.length >= 4 ? Integer.parseInt(args[3]) : 1;
		final Random rnd = args.length >= 5 ? new Random(Integer.parseInt(args[4])) : new Random();

		final ResourceSet rs = new ResourceSetImpl();
		rs.getPackageRegistry().put(DocbookPackage.eNS_URI, DocbookPackage.eINSTANCE);
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());

		try {
			final Resource r = rs.createResource(URI.createFileURI(fSource.getCanonicalPath()));
			r.load(null);
			final DocBook docbook = (DocBook) r.getContents().get(0);

			final Mutator mutator = new Mutator(rnd);
			mutator.setDirectoryPrefix(dirPrefix);
			mutator.setMutationsPerMutant(nMutationsPerMutant);
			mutator.mutate(docbook, nMutants);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
