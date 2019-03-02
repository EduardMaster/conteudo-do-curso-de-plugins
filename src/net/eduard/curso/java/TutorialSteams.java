package net.eduard.curso.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.bukkit.inventory.ItemStack;

import net.eduard.api.lib.Mine;

public class TutorialSteams {

	public static void main(String[] args) {
		HashMap<String, Double> mapa = new HashMap<>();
		mapa.put("Edu", 10D);
		mapa.put("Eduardo", 10D);
		mapa.put("Vitor", 10D);
		String concatenando = mapa.keySet().stream().reduce((s1,s2)->s1+", "+s2).get();
		System.out.println("Nomes "+ concatenando);
		
		Entry<String, Double> entradaSomada = mapa.entrySet().stream().reduce(new BinaryOperator<Map.Entry<String,Double>>() {

			@Override
			public Entry<String, Double> apply(Entry<String, Double> t, Entry<String, Double> u) {
				t.setValue(t.getValue()+u.getValue());
				return t;
			}
		}).get();
		System.out.println("Soma bolada " + entradaSomada);
		Double resultadoFinal= mapa.entrySet().stream().reduce(Double.valueOf(0), new BiFunction<Double, Entry<String, Double>, Double>() {

			@Override
			public Double apply(Double t, Entry<String, Double> u) {
				System.out.println("Valor do t "+t);
				
				return t+50;
			}

			
		},new BinaryOperator<Double>() {

			@Override
			public Double apply(Double t, Double u) {
				// TODO Auto-generated method stub
				return u-t;
			}

			
		});
		System.out.println("Resultado final "+resultadoFinal);
		
		
	 double resultado = mapa.values().stream().reduce(0D, new BinaryOperator<Double>() {

			@Override
			public Double apply(Double t, Double u) {
				return t+u;
			}
		});
	 System.out.println("Resultado1 "+resultado);
		
	 Optional<Double> resultado2 = mapa.values().stream().reduce( new BinaryOperator<Double>() {

			@Override
			public Double apply(Double t, Double u) {
				return t+u;
			}
		});
	 
	 
	 
	 
	 
	 System.out.println("Resultado 2 "+resultado2.get());
	 
		Object resultado3 = mapa.values().stream().reduce(0D,new BiFunction<Double, Double, Double>() {

		@Override
		public Double apply(Double t, Double u) {
			// TODO Auto-generated method stub
			return 1D;
		}
	},new BinaryOperator<Double>() {

		@Override
		public Double apply(Double t, Double u) {
			// TODO Auto-generated method stub
			System.out.println(" ");
			System.out.println(t);
			return t +u;
		}
	});
	 
	 
	 
	 
	 
	 System.out.println("Resultado 3 "  +resultado3 );
	 
		ArrayList<String> nomes = new ArrayList<>();
		nomes.add("Eduard");
		nomes.add("Edu");
		nomes.add("Mestre");
		Stream<String> stream = nomes.stream();
		
		String reduce = stream.reduce("        ", new BinaryOperator<String>() {
	
			@Override
			public String apply(String t, String u) {
				
				return t+" "+u;
			}
		});
		System.out.println(reduce);
		
	}
}
