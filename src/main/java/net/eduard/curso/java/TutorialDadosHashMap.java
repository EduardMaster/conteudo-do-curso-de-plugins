package net.eduard.curso.java;


import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.stream.Collectors;
/**
 * Explicando como o HashMap funciona<br>
 * Hashmap basicamnete armaze quantas informações você quiser em uma só variavel
 *
 * @author Eduard
 *
 */
public class TutorialDadosHashMap {
	public static class FakeMaquina {
		private String dono;
		private FakeLocation local;

		public FakeLocation getLocal() {
			return local;
		}

		public void setLocal(FakeLocation local) {
			this.local = local;
		}

		public String getDono() {
			return dono;
		}

		public void setDono(String dono) {
			this.dono = dono;
		}


	}


	public static class FakeLocation {
		String world;
		int x;
		int y;
		int z;
		int hash;

		public String getWorld() {
			return world;
		}

		public void setWorld(String world) {
			this.world = world;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		public int getZ() {
			return z;
		}

		public void setZ(int z) {
			this.z = z;
		}

		public int getHash() {
			return hash;
		}

		public void setHash(int hash) {
			this.hash = hash;
		}

		@Override
		public boolean equals(Object o) {


			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			FakeLocation that = (FakeLocation) o;
			return x == that.x &&
					y == that.y &&
					z == that.z &&
					Objects.equals(world, that.world);
		}

		@Override
		public int hashCode() {
			if (hash == 0) {
				hash = Objects.hash(world, x, y, z);
			}

			return hash;
		}
	}

	public static HashMap<String, String> sobrenomeDosJogadores = new HashMap<>();
	public static HashMap<String, Integer> placarDosJogadores = new HashMap<>();

	public static void main(String[] args) {

		sobrenomeDosJogadores.put("Tiago", "Ramos");
		sobrenomeDosJogadores.put("Gustavo", "Campos");
		placarDosJogadores.put("edu", 25);
		placarDosJogadores.put("beta", 30);
		placarDosJogadores.put("eduard", 50);
		placarDosJogadores.put("Gustavo", 100);
		placarDosJogadores.put("zbeta", 1);
		placarDosJogadores.put("tiagorx", 10);
		
		if (placarDosJogadores.containsValue(50)) {
			System.out.println("Alguem tem 50 pontos");
		}
		if (placarDosJogadores.containsKey("eduard")) {
			System.out.println("o Eduard tem pontos");
			Integer pontosDoEdu = placarDosJogadores.get("eduard");
			
			System.out.println("Pontos do edu: "+pontosDoEdu);
			
		}
		
		if (sobrenomeDosJogadores.containsKey("Tiago")) {
			System.out.println("O tiago tem sobrenome");
			String sobrenomeDoTiago = sobrenomeDosJogadores.get("Tiago");
			System.out.println("Sobrenome do tiago: " + sobrenomeDoTiago);
		}
//		mostrarTopPlacares();

	}

	public static void mostrarTopPlacares() {

		List<Entry<String, Integer>> placarSorteadoDoMaiorParaOMenor =
				placarDosJogadores.entrySet().stream()
				.sorted((entrada1, entrada2) -> {
					return entrada2.getValue().compareTo(entrada1.getValue());
				}).collect(Collectors.toList());
		
		int id = 1;
		for (Entry<String, Integer> placarDoJogador : placarSorteadoDoMaiorParaOMenor) {
			String jogadorNome = placarDoJogador.getKey();
			Integer placar = placarDoJogador.getValue();
			System.out.println(" "+id+"º "+jogadorNome+ ": "+ placar);
			id++;
			 
		}
		
		
		

	}

}
