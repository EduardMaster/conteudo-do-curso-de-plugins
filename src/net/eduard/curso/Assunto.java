package net.eduard.curso;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * Anotação criada para marcar o nivel de um assunto do curso
 * @author Eduard
 *
 */
@Target({ ElementType.TYPE, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Assunto {
	
	/**
	 * Existem trez nives basico , para coisas simples<br>
	 * Existe o intermediario, para coisas que são mais dificeis de fazer<br>
	 * Existe o Avançado, para coisas que são  bem complexas de fazer
	 * @return O nivel do assunto
	 */
	AssuntoNivel nivel() default AssuntoNivel.BASICO;
	/**
	 * Nivel secundario do assunto alem dos nivel basico, intermediario e avancado tera este subnivel
	 * @return O subnivel atual
	 */
	int subnivel() default 1; 
	/**
	 * Em qual vez ser ensinado este assunto<br>
	 * caso for -1 o retorno é que não é ensinado mas pode ser ensinado se o aluno quiser
	 * @return o numero da vez que aquele assunto é ensinado
	 */
	int cronograma() default -1;

}
