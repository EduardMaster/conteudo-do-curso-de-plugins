package net.eduard.curso.ban;

import java.util.Date;
import java.util.UUID;


/**
 * Banimento feito no jogador salvando quem fez, o dia, entre outras informações
 * @author Eduard
 *
 */
public class Banimento {

	private String alvo;
	private UUID alvoId;
	private String autor;
	private UUID autorID;
	private String motivo;
	private Date dia;
	private int duracaoEmDias = 1;

	public String getAlvo() {
		return alvo;
	}

	public void setAlvo(String alvo) {
		this.alvo = alvo;
	}

	public UUID getAlvoId() {
		return alvoId;
	}

	public void setAlvoId(UUID alvoId) {
		this.alvoId = alvoId;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public UUID getAutorID() {
		return autorID;
	}

	public void setAutorID(UUID autorID) {
		this.autorID = autorID;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public Date getDia() {
		return dia;
	}

	public void setDia(Date dia) {
		this.dia = dia;
	}

	public int getDuracaoEmDias() {
		return duracaoEmDias;
	}

	public void setDuracaoEmDias(int duracaoEmDias) {
		this.duracaoEmDias = duracaoEmDias;
	}

}
