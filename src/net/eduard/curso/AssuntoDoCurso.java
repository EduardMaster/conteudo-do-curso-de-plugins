package net.eduard.curso;

import org.bukkit.plugin.java.JavaPlugin;
/**
 * Interface feita para o registro das funcionabilidades de cada assunto
 * @author Eduard
 *
 * @param <Retorno> O Objeto que será retornado apos ligar
 */
public  interface AssuntoDoCurso<Retorno> {

	/**
	 * Metodo usado para ligar os assuntos
	 * @param plugin Plugin necessario para ligar use 'this'
	 * @return O objeto do Tipo expecificado pelo 'Retorno'
	 */
	default Retorno ligar(JavaPlugin plugin) {
		try {
			return aoLigar(plugin);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	/**
	 * Método abstrado que cada assunto define oque vai acontecer quando ele ser ligado
	 * @param plugin Plugin que será usado para ligar o assunto
	 * @return A classe que o assunto desejar
	 */
	Retorno aoLigar(JavaPlugin plugin);

}
