package br.com.dio.collection.map;

import java.util.*;

public class ExemploMap {
    /**
     * <p>Dada os modelos dos carros e seus respectivos consumos na estrada, faça:
     * <lu>
     * <li>modelo = gol - consumo = 14,4km/l
     * <li>modelo = uno - consumo = 15,6 km/l
     * <li>modelo = mobi - consumo = 16,1 km/l
     * <li>modelo = hb20 - consumo = 14,5 km/l
     * <li>modelo = kwid - consumo = 15,6 km/l</lu>
     */
    public static void main(String[] args) {
//        Map carrosPopulares2020 = new HashMap(); //antes do java 5
//        Map<String, Double> carrosPopulares = new HashMap<>(); //Generics(jdk 5) - Diamont Operator(jdk 7)
//        HashMap<String, Double> carrosPopulares = new HashMap<>();
//        Map<String, Double> carrosPopulares2020 = Map.of("gol", 14.4, "uno", 15.6, "mobi", 16.1, "hb20", 14.5, "kwid", 15.6)

        System.out.println("Crie um dicionário que relacione os modelos e seus respectivos consumos: ");
        Map<String, Double> carrosPopulares = new HashMap<>() {{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        System.out.println(carrosPopulares.toString());

        System.out.println("\nSubstitua o consumo do kwid por 16,1 km/l: ");
        carrosPopulares.put("kwid", 16.1);
        System.out.println(carrosPopulares);

        System.out.println("\nConfira se o modelo tucson está no dicionário: " + carrosPopulares.containsKey("tucson"));

        System.out.println("\nExiba o consumo do uno: " + carrosPopulares.get("uno"));


        System.out.println("\nExiba os modelos: ");
        Set<String> modelos = carrosPopulares.keySet();
        System.out.println(modelos);

        System.out.println("\nExiba os consumos dos carros: " + carrosPopulares.values());

        System.out.println("\nExiba o modelo mais econômico e seu consumo: ");
        Double consumoMaisEficiente = Collections.max(carrosPopulares.values());//recebi o maior valor
        Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet();//
        String modeloMiasEficiente = "";

        // Uso do for -> Verifica se o valor é o maior e exibe na tela
        for (Map.Entry<String, Double> entrie : entries) {
            if (entrie.getValue().equals(consumoMaisEficiente)) {// se o valor do Elemento igual ao consumoMaisEficiente
                modeloMiasEficiente = entrie.getKey(); // recebi a key do elemento
                System.out.println("Modelo mais Eficiente: " + modeloMiasEficiente + " -> " + consumoMaisEficiente);
            }
        }

        System.out.println("\nExiba o modelo menos econômico e seu consumo: ");
        Double consumoMenosEficiente = Collections.min(carrosPopulares.values());
        for (Map.Entry<String, Double> entrie : carrosPopulares.entrySet()) {
            if (entrie.getValue().equals(consumoMenosEficiente)) {
                String modeloMenosEficiente = entrie.getKey(); // recebi a key do elemento
                System.out.println("Modelo nenos Eficiente: " + modeloMenosEficiente + " -> " + consumoMenosEficiente);
            }
        }

        System.out.print("\nExiba a soma dos consumos: ");
        double soma = 0;
        for (Double value : carrosPopulares.values()) {
            soma += value;
          }
        System.out.println(soma);

        System.out.println("\nExiba o terceiro modelo: ");
        System.out.println(carrosPopulares);
        int cont = 0;
        for (String key : carrosPopulares.keySet()) {
            cont++;
            if (cont == 3) System.out.println(key+ " -> "+carrosPopulares.get(key));
        }

        System.out.println("\nExiba o terceiro modelo adicionado: ");
        Map<String, Double> carrosPopulares1 = new LinkedHashMap<>(){{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        Iterator<String> iterator = carrosPopulares1.keySet().iterator();
        System.out.println(carrosPopulares1);
        int cont2 = 0;
        while (iterator.hasNext()) {
            String next = iterator.next();
            cont2++;
            if (cont2 == 3) System.out.println(next+ " -> "+carrosPopulares1.get(next));
        }

        System.out.println("\nExiba a média dos consumos deste dicionário de carros: " + (soma/carrosPopulares.size()));

        System.out.println("\nExiba todos os carros na ordem em que foram informados: ");
        System.out.println(carrosPopulares1);

        System.out.println("\nExiba o dicionário ordenado pelo modelo: ");
        Map<String, Double> carrosPopularesOrdem = new TreeMap<>(carrosPopulares1);
        System.out.println(carrosPopularesOrdem.toString());

        System.out.println("\nRemova os modelos com o consumo igual a 15,6 km/l: ");

        Iterator<Double> consumos = carrosPopulares1.values().iterator();
        System.out.println(carrosPopulares1);
        while (consumos.hasNext()){
            if(consumos.next().equals(15.6))
                consumos.remove();
        }
        System.out.println(carrosPopulares1);


        System.out.println("\nApague o conjunto de carros: ");
        carrosPopulares.clear();

        System.out.println("\nConfira se a lista está vazia: ");
        System.out.println(carrosPopulares.isEmpty());
    }
}
