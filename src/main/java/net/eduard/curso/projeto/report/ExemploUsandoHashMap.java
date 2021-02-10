package net.eduard.curso.projeto.report;

import java.util.HashMap;

public class ExemploUsandoHashMap {

    public static void exemplo() {
        HashMap<String, Double> contas = new HashMap<>();
        contas.put("Eduard", 10000.0);
        contas.put("Yonatan", 20000.0);
        contas.put("Yonatan", (contas.get("Yonatan") - 200.0));
        contas.get("Yonatan");// 20000.0
        HashMap<String, HashMap<String, Integer>> moedas = new HashMap<>();

        HashMap<String, Integer> cash = new HashMap<>();
        cash.put("Eduard", 100);
        cash.put("Yonatan", 200);

        moedas.put("Cash", cash);

        HashMap<String, Integer> coins = new HashMap<>();
        coins.put("Eduard", 100000000);
        coins.put("Yonatan", 200000000);

        moedas.put("Coins", coins);

        HashMap<String, Integer> moedaCash = moedas.get("Cash");
        moedaCash.put("Eduard", moedaCash.get("Eduard") + 200);

        HashMap<String, Integer> moedaCoins = moedas.get("Coins");
        moedaCoins.put("Eduard", moedaCoins.get("Eduard") - 1000000);
    }
}
