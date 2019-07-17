package ttc2019.live.mutator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import ttc2019.live.changes.ChangesFactory;
import ttc2019.live.changes.ModelChangeSet;
import ttc2019.live.docbook.DocBook;
import ttc2019.live.docbook.DocbookPackage;
import ttc2019.live.mutator.ops.AddRandomPara;
import ttc2019.live.mutator.ops.AppendRandomText;
import ttc2019.live.mutator.ops.IMutationOperator;
import ttc2019.live.mutator.ops.RemoveRandomInstance;
import ttc2019.live.mutator.ops.SwapRandomSibling;

/**
 * Creates "mutated" versions of a model according to a set of mutation
 * operators. Each version receives a number of mutations
 * ({@link #DEFAULT_MUTATIONS_PER_MUTANT} is the default value).
 */
public class Mutator {

	public static final int DEFAULT_MUTATIONS_PER_MUTANT = 5;

	private final Random rnd;

	private List<IMutationOperator> operators = new ArrayList<>(); 

	private String directoryPrefix = "mutated";
	private int mutantCounter = 0;
	private int mutationsPerMutant = DEFAULT_MUTATIONS_PER_MUTANT;

	public Mutator(Random rnd) {
		this.rnd = rnd;

		final DocbookPackage pkg = DocbookPackage.eINSTANCE;
		operators.add(new RemoveRandomInstance("RS1", pkg.getSect1(), rnd));
		operators.add(new RemoveRandomInstance("RPA", pkg.getPara(), rnd));
		operators.add(new SwapRandomSibling("SS1", pkg.getSect1(), rnd));
		operators.add(new SwapRandomSibling("SPA", pkg.getPara(), rnd));
		operators.add(new AddRandomPara(rnd));
		operators.add(new AppendRandomText("PS1", pkg.getSect1(), pkg.getTitledElement_Title(), rnd));
		operators.add(new AppendRandomText("PPA", pkg.getPara(), pkg.getPara_Content(), rnd));
	}

	public String getDirectoryPrefix() {
		return directoryPrefix;
	}

	public void setDirectoryPrefix(String directoryPrefix) {
		this.directoryPrefix = directoryPrefix;
	}

	public int getMutationsPerMutant() {
		return mutationsPerMutant;
	}

	public void setMutationsPerMutant(int mutationsPerMutant) {
		this.mutationsPerMutant = mutationsPerMutant;
	}

	public void mutate(DocBook docbook, int nMutants) throws IOException {
		for (int iMutant = 0; iMutant < nMutants; ++iMutant) {
			mutate(docbook);
			System.out.println(String.format("Produced mutant %d out of %d", iMutant + 1, nMutants));
		}
	}

	public void mutate(DocBook source) throws IOException {
		final File fMutantDir = new File(directoryPrefix + "-" + ++mutantCounter);
		fMutantDir.mkdirs();

		final ResourceSet rs = new ResourceSetImpl();
		rs.getPackageRegistry().put(DocbookPackage.eNS_URI, DocbookPackage.eINSTANCE);
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());

		final Resource rMutated = rs.createResource(URI.createFileURI(new File(fMutantDir, "mutated.docbook").getCanonicalPath()));
		final DocBook toMutate = EcoreUtil.copy(source);
		rMutated.getContents().add(toMutate);

		final Resource rChanges = rs.createResource(URI.createFileURI(new File(fMutantDir, "applied.changes").getCanonicalPath()));
		final ModelChangeSet changeSet = ChangesFactory.eINSTANCE.createModelChangeSet();
		rChanges.getContents().add(changeSet);

		try {
			for (int iMutation = 0; iMutation < mutationsPerMutant; ++iMutation) {
				final IMutationOperator op = operators.get(rnd.nextInt(operators.size()));
				op.apply(source, toMutate, changeSet);
			}
		} finally {
			rMutated.save(null);
			rChanges.save(null);
		}
	}

}
