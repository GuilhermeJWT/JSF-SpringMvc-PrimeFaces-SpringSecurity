package br.com.systemsgs.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public abstract @interface AnnotationCampoPesquisa {
	
	 String descricaoCampo();
	 String campoConsulta();
	 int principal() default 10000;

}
