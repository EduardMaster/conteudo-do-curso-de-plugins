package net.eduard.curso.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import net.eduard.api.lib.modules.Mine;
import net.eduard.api.lib.modules.Extra;


public class TutorialFazerRank {
	
	static class Usuario {
		private String nome;
		private int dinheiro;
		
		public int getDinheiro() {
			return dinheiro;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}
	}
	public static void main(String[] args) {

		ArrayList<Usuario> usuarios = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
				Usuario c = new Usuario();
				c.dinheiro = Mine.randomInt(1, 1000);
				c.nome = Extra.newKey(Extra.KeyType.ALPHANUMERIC, 8);
				usuarios.add(c);
		}
		
		Map<String, Integer> contas = new HashMap<>();

		contas.put("Eduard", 1000);
		contas.put("Edu", 2000);
		contas.put("Gabriel", 500);
		contas.put("Pedro", 200);
		contas.put("Caue", 100);
		contas.entrySet().stream().sorted(Comparator.comparing(Entry::getValue)).forEach(System.out::println);
		List<Usuario> retorno = usuarios.stream().sorted(Comparator.comparing(Usuario::getDinheiro).reversed()).collect(Collectors.toList());
		for ( Usuario clan : retorno) {
			System.out.println("Clan "+clan.getNome()+" dinheiro: "+clan.dinheiro);
			
		}
		
		contas.entrySet().stream().sorted((x, y) -> y.getValue().compareTo(x.getValue())).forEach(System.out::println);
		Map<String, Integer> dinheiros = new HashMap<>();
		dinheiros.put("Edu", 10000);
		dinheiros.put("Caue", 2500);
		dinheiros.put("Gabriel", 5000);

		Set<Entry<String, Integer>> contas2 = dinheiros.entrySet();
		// contas.removeIf(x -> x.getValue()<5001);
		List<Entry<String, Integer>> novascontas = contas2.stream().
		sorted((x, y) -> x.getValue().compareTo(y.getValue()))
		.collect(Collectors.toList());
		Collections.reverse(novascontas);
		System.out.println(novascontas);

		// List<Integer> nums = new ArrayList<>();
		// nums.add(1);
		// nums.add(5);
		// nums.add(10);
		//// nums.forEach((x)-> System.out.println(x));
		// nums.sort((x,y)-> x + y);
		// Collections.reverse(nums);
		// System.out.println(nums);
		

		HashMap<String, Double> map = new HashMap<>();
		map.put("Eduard", 2000D);
		map.put("Gabriel", 1000D);
		map.put("Caue", 500D);
//		String sql = "select * from tabela order by dinheiro desc;";
		

		ArrayList<Entry<String, Double>> listaCrescente = new ArrayList<>(
				map.entrySet());

		Collections.sort(listaCrescente, new Comparator<Entry<String, Double>>() {

			@Override
			public int compare(Entry<String, Double> entry1,
					Entry<String, Double> entry2) {
				return entry1.getValue().compareTo(entry2.getValue());
			}
		});
		List<Entry<String, Double>> listaDescrecente = new LinkedList<>(listaCrescente);
		Collections.reverse(listaDescrecente);
		
		for (Entry<String, Double> entry : listaDescrecente) {
			System.out.println(entry.getKey()+": "+entry.getValue());
		}
		System.out.println("---");
		for (Entry<String, Double> entry : listaCrescente) {
			
			System.out.println(entry.getKey()+": "+entry.getValue());
		}
	}
	

}
