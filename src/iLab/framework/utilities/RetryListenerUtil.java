package iLab.framework.utilities;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class RetryListenerUtil implements IAnnotationTransformer {

    public void transform(ITestAnnotation testAnnotation, Class testClass, Constructor constructor, Method method){

        Class<? extends IRetryAnalyzer>  retry = testAnnotation.getRetryAnalyzerClass();

        if(retry ==null){
            testAnnotation.setRetryAnalyzer(MyRetryUtil.class);

        }
    }

}
