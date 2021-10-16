package net.eduard.curso.projeto.ban;


public class Punicao {

	private String autor, punido, motivo,prova;
	private PunicaoTipo tipo;
	private long duracao;
	private long data;

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getPunido() {
		return punido;
	}

	public void setPunido(String punido) {
		this.punido = punido;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public PunicaoTipo getTipo() {
		return tipo;
	}

	public void setTipo(PunicaoTipo tipo) {
		this.tipo = tipo;
	}

	public long getDuracao() {
		return duracao;
	}

	public void setDuracao(long duracao) {
		this.duracao = duracao;
	}

	public long getData() {
		return data;
	}

	public void setData(long data) {
		this.data = data;
	}

	public String getProva() {
		return prova;
	}

	public void setProva(String prova) {
		this.prova = prova;
	}

}
