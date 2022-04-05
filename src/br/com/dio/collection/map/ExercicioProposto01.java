package br.com.dio.collection.map;

import java.util.*;

public class ExercicioProposto01 {
    /*
     Dada a população estimada de alguns estados do nordeste brasileiro, faça:
     Estado = PE - população = 9.616.621
     Estado = AL - população = 3.351.543
     Estado = CE - população  = 9.187.103
     Estado = RN - população = 3.534.265
    */
    public static void main(String[] args) {
        System.out.println("Crie um dicionário que relacione os estados e suas respectivas populações: ");
        Map<String, Integer> populacoes = new HashMap<>() {{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
        }};
        for (Map.Entry<String, Integer> populacao : populacoes.entrySet()) {
            System.out.printf("Estado= %s - população= %s%n", populacao.getKey(), populacao.getValue());
        }

        System.out.println("\nSubstitua a população do estado RN por : 3.534.165");
        populacoes.put("RN", 3534165);
        System.out.println(populacoes.toString());

        System.out.println("\nConfira se o estado da Paraíba (PB) está no dicionário, caso não, adicione " + "PB - 4.039.277: ");
        if (!populacoes.containsKey("PB")) {
            populacoes.put("PB", 4039277);
            System.out.println("Popupação de PB adicionado: " + populacoes);
        } else
            System.out.println("Dados já existente!");

        System.out.println("\nExiba a população do estado PE: "+populacoes.get("PE"));

        System.out.println("\nExiba todos os estados e suas populaçãos na ordem em que foram informados: ");
        Map<String, Integer> populaçoesOrdem = new LinkedHashMap<>(){{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
            put("PB", 4039277);
        }};
        System.out.println(populaçoesOrdem);

        System.out.println("\nExiba todos os estados e suas populações na ordem alfabética: ");
        Map<String,Integer> populaçõesOrdemAlfabetica =new TreeMap<>(populacoes);
        System.out.println(populaçõesOrdemAlfabetica);

        Collection<Integer> valorPòpulacoes = populacoes.values(); // criando uma lista para receber os valores
        String maiorPopulacao="", menorPopulacao = ""; // cria duas variável para receber as key
        for (Map.Entry<String,Integer> populacao: populacoes.entrySet()) {// usa o for para verificar todas posições.
            //verifica se o valor é o menor ou maior e a variável recebe
            //Collections.max(valorPòpulacoes) retorna o maior valor
            //Collections.min(valorPòpulacoes) retorna o menor valor
            if(populacao.getValue().equals(Collections.max(valorPòpulacoes)))//se valor da posção(populacao.getValue()) igual a maior valor
                maiorPopulacao = populacao.getKey();// variável recebi a key
            if(populacao.getValue().equals(Collections.min(valorPòpulacoes)))
                menorPopulacao = populacao.getKey();
        }
        System.out.printf("\nExiba o estado com o menor população (%s) e seu respectivo valor (%d)\n",menorPopulacao,Collections.min(valorPòpulacoes));
        System.out.printf("Exiba o estado com a maior população (%s) e seu respectivo valor (%d)\n",maiorPopulacao,Collections.max(valorPòpulacoes));

        System.out.print("\nExiba a soma da população desses estados: ");
        int soma=0;
        // usando o iterator
        Iterator<Integer> iterator = populacoes.values().iterator();
        while (iterator.hasNext()){
            soma += iterator.next();
        }
        //usando o foreach
//        for (Map.Entry<String,Integer> populacao: populacoes.entrySet()){
//            soma += populacao.getValue();
//        }
        System.out.println(soma);

        System.out.println("\nExiba a média da população deste dicionário de estados: " + soma / populacoes.size());

        System.out.println("\nRemova os estados com a população menor que 4.000.000: ");
        // como ja existe um iterator criado, é so usar o while.
        Iterator<Integer> iterator1 = populacoes.values().iterator();
        while (iterator1.hasNext()){
            if(iterator1.next() < 4000000)
                iterator1.remove();
        }
        System.out.println(populacoes);

        System.out.println("Apague o dicionario de estados com suas respectivas populações estimadas: ");
        populacoes.clear();
        System.out.println("Confira se a lista está vazia: "+ populacoes.isEmpty());
    }
}
