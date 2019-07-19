package ttc19;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.xbase.lib.Pair;

import yamtl.core.YAMTLModule;


@Aspect
public class SetterAspect {
	YAMTLModule module;

	// when initializing many-valued features, a get is performed
	// we need this variable to control that initilize is only applied 
	// at the top level (first get)
	private int getLevel = 0;
	private int colLevel = 0;
	
	// TO BE UPDATED: where model classes are
	@Pointcut("within(docbook.impl.*)")
	// END TO BE UPDATED 
	private void syntacticScope() {}
	

	// //////////////////////////////////////////////////////////////
	// DO NOT MODIFY BELOW
	// //////////////////////////////////////////////////////////////
	@Before("within(yamtl.core.YAMTLModule) && execution(void execute())")
	public void getModule(JoinPoint thisJoinPoint) {
		module = (YAMTLModule) thisJoinPoint.getThis(); 
	}

	@Pointcut("( (within(yamtl.utils.ReduceUtil) && execution(void reduce(yamtl.core.MatchMap))) )")
	private void controlFlowReduceScope() {}

	@After("(cflowbelow(controlFlowReduceScope()) ) && syntacticScope() && target(org.eclipse.emf.ecore.EObject) && execution(* *..set* (..))") 
	public void featureGetCallInReduce(JoinPoint thisJoinPoint) {
		EObject eObj = (EObject) thisJoinPoint.getTarget();
		String featureName = thisJoinPoint.getSignature().getName();
		featureName = decapitalize(featureName.substring(3, featureName.length()));
		
		module.featureGetCallInReduce(eObj, featureName);
	}
	
	@After("within(java.util.*) && (cflowbelow(controlFlowReduceScope()) ) && syntacticScope() && target(java.util.Collection) "
			+ "&& ("
				+ "call(* java.util.Collection.add(..)) || "
				+ "call(* java.util.Collection.addAll(..)) ||"
				+ "call(* java.util.Collection.remove(..)) ||"
				+ "call(* java.util.Collection.removeAll(..)) ||"
				+ "call(* java.util.Collection.clear(..)) ||"
				+ "call(* java.util.Collection.retainAll(..))"
			+ ")") 
	public void collectionModification(JoinPoint thisJoinPoint) {
		if (colLevel==0) {
			colLevel++;
			
			if (module != null) {
				module.collectionModification(thisJoinPoint);
			}
			
			colLevel--;
		}
	}
	
	
	public static String getFeatureName(String featureName) {
		if (featureName.startsWith("set"))
			return featureName.substring(3, featureName.length());
		else // unset
			return featureName.substring(5, featureName.length());
	}
	public static String decapitalize(String string) {
	    if (string == null || string.length() == 0) {
	        return string;
	    }
	    char c[] = string.toCharArray();
	    c[0] = Character.toLowerCase(c[0]);
	    return new String(c);
	}
	
}
