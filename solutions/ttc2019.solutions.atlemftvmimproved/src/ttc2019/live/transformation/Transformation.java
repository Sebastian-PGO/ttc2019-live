package ttc2019.live.transformation;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Metamodel;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.impl.resource.EMFTVMResourceFactoryImpl;
import org.eclipse.m2m.atl.emftvm.util.ClassModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.ModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.TimingData;

import ttc2019.live.bibtex.BibTeXFile;
import ttc2019.live.bibtex.BibtexPackage;
import ttc2019.live.docbook.DocbookPackage;

/**
 * Encapsulates the <code>BibTeX2DocBook</code> transformation as a single
 * class. To use it, simply create an instance with the appropriate source
 * {@link BibTeXFile} and target {@link Resource}, and run the {@link #run()}
 * method.
 */
public class Transformation {

	private static final String OUT_METAMODEL = "DocBook";
	private static final String IN_METAMODEL = "BibTeX";
	private static final String MODULE_NAME = "BibTeX2DocBook";
	private final BibTeXFile bibFile;
	private final Resource outputResource;

	public Transformation(BibTeXFile bibFile, Resource outputResource) {
		this.bibFile = bibFile;
		this.outputResource = outputResource;
	}

	public BibTeXFile getBibFile() {
		return bibFile;
	}

	public void run() {
		  ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
          ResourceSet rs = new ResourceSetImpl();
  
          Metamodel ttMetamodel = EmftvmFactory.eINSTANCE.createMetamodel();
          ttMetamodel.setResource(BibtexPackage.eINSTANCE.getArticle().eResource());
          env.registerMetaModel(IN_METAMODEL, ttMetamodel);

          Metamodel bddMetamodel = EmftvmFactory.eINSTANCE.createMetamodel();
          bddMetamodel.setResource(DocbookPackage.eINSTANCE.getBook().eResource());
          env.registerMetaModel(OUT_METAMODEL, bddMetamodel);

          // loading models
          rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("emftvm", new EMFTVMResourceFactoryImpl());

          Model inModel = EmftvmFactory.eINSTANCE.createModel();
          inModel.setResource(bibFile.eResource());
          env.registerInputModel("IN", inModel);

          Model outModel = EmftvmFactory.eINSTANCE.createModel();
          outModel.setResource(outputResource);
          env.registerOutputModel("OUT", outModel);

          ModuleResolver mr = new ClassModuleResolver(Transformation.class);
          TimingData td = new TimingData();
          env.loadModule(mr, MODULE_NAME);
          td.finishLoading();
          env.run(td);
          td.finish();
	}

	public Resource getOutputResource() {
		return outputResource;
	}
}
