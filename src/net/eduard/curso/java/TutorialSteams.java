package net.eduard.curso.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class TutorialSteams {

	public static void main(String[] args) {
		HashMap<String, Double> banco = new HashMap<>();
		banco.put("Edu", 10D);
		banco.put("Eduardo", 10D);
		banco.put("Vitor", 10D);
		
		Double somandoDados = banco.values().stream().reduce(0D, (d1,d2)->d1+d2);
		System.out.println("Dados somados com Lambda: "+somandoDados);
		
		String concatenando = banco.keySet().stream()
				.reduce((donoDaConta1, donoDaConta2) -> donoDaConta1 + ", " + donoDaConta2).get();
		System.out.println("Nomes dos donos das Contas " + concatenando);

		//Altera os valores da HashMap
//		Entry<String, Double> entradaSomada = banco.entrySet().stream()
//				.reduce(new BinaryOperator<Map.Entry<String, Double>>() {
//
//					@Override
//					public Entry<String, Double> apply(Entry<String, Double> conta1, Entry<String, Double> conta2) {
//						conta1.setValue(conta1.getValue() + conta2.getValue());
//						return conta1;
//					}
//				}).get();
//		
//		System.out.println("Soma das contas " + entradaSomada.getValue());
		
		
		
		Double resultadoFinal = banco.entrySet().stream().reduce(Double.valueOf(0),
				new BiFunction<Double, Entry<String, Double>, Double>() {

					@Override
					public Double apply(Double saldoSendoSomado, Entry<String, Double> conta) {
						//System.out.println("Saldo do " + conta.getKey() + " : " + conta.getValue());

						return saldoSendoSomado + conta.getValue();
					}

				}, new BinaryOperator<Double>() {

					@Override
					public Double apply(Double t, Double u) {
						// TODO Auto-generated method stub
//						return u - t;
						System.out.println("Eu estou rodando? ");
						return 0D;
					}

				});
		System.out.println("Resultado da soma: " + resultadoFinal);

		double saldoInicial = 10;
		System.out.println("Somando dados da conta porem com um valor inicial " + saldoInicial);
		double somandoValoresDaContaComSaldoInicial = banco.values().stream().reduce(saldoInicial,
				new BinaryOperator<Double>() {

					@Override
					public Double apply(Double t, Double u) {
						return t + u;
					}
				});
		System.out.println("Resultado: " + somandoValoresDaContaComSaldoInicial);

		System.out.println("Somando todos os dados do hashmap");
		Optional<Double> somandoValoresDasContas = banco.values().stream().reduce(new BinaryOperator<Double>() {

			@Override
			public Double apply(Double t, Double u) {
				return t + u;
			}
		});

		System.out.println("Soma das contas: " + somandoValoresDasContas.get());

		System.out.println("Usando reduce com biFunction");

		Double usadoBiFunction = banco.values().stream().reduce(0D, new BiFunction<Double, Double, Double>() {

			@Override
			public Double apply(Double t, Double u) {
				// TODO Auto-generated method stub
				return 1D;
			}
		}, new BinaryOperator<Double>() {

			@Override
			public Double apply(Double t, Double u) {
				// TODO Auto-generated method stub
				System.out.println(" ");
				System.out.println(t);
				return t + u;
			}
		});
		System.out.println("Resultado: " + usadoBiFunction);

		System.out.println("Usando reduce com binaryOperator");

		ArrayList<String> nomes = new ArrayList<>();
		nomes.add("Eduard");
		nomes.add("Edu");
		nomes.add("Mestre");
		Stream<String> stream = nomes.stream();

		String concatenandoOsNomesDasContas = stream.reduce("        ", new BinaryOperator<String>() {

			@Override
			public String apply(String t, String u) {

				return t + " " + u;
			}
		});
		System.out.println("Resultado: " + concatenandoOsNomesDasContas);

	}
}
