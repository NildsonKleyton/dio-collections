package br.com.dio.collection.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ExerciciosStreamAPI {
    public static void main(String[] args) {
        List<String> numerosAleatorios = Arrays.asList("1", "0", "4", "1", "2", "3", "9", "9", "6", "5");
        System.out.println("Imprima todos os elementos dessa lista de String: ");
        /*
        // usando classe Anônima
        numerosAleatorios.stream().forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println();
            }
        });
        //reduz usando lambda
        numerosAleatorios.stream().forEach(s -> System.out.println());
        //resduz usando o foreach da lista
        numerosAleatorios.forEach(s -> System.out.println());
        */

        //reduz usando o Reference Method
        numerosAleatorios.forEach(System.out::println);

        System.out.println("\nPegue os 5 primeiros números e coloque dentro de um Set:");
        numerosAleatorios.stream()
                .limit(5)
                .collect(Collectors.toSet())
                .forEach(System.out::println);
        // ou assim
        Set<String> cincoNumero = numerosAleatorios.stream()
                .limit(5)
                .collect(Collectors.toSet());
        System.out.println(cincoNumero);

        System.out.println("Transforme esta lista de String em uma lista de números inteiros.");
        /**
         *  como transforma os intens  de uma lista do Tipo String para Integer
         */

//        numerosAleatorios.stream()
//                .map(new Function<String, Integer>() {
//                    @Override
//                    public Integer apply(String s) {
//                        return Integer.parseInt(s);
//                    }
//                });
        // reduz para lambda
//        numerosAleatorios.stream().map(s -> Integer.parseInt(s));
        // redus para Reference method
        numerosAleatorios.stream().map(Integer::parseInt);

        /**
        * transformando em uma lista de números inteiros
        */
        numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList())
                .forEach(System.out::println);
        // colocando um uma variável
        List<Integer> numerosAleatoriosInt = numerosAleatorios.stream()
                .map(Integer::parseInt)//transforma os itens em inteiros
                .collect(Collectors.toList()); //cria uma lista de inteiros
        System.out.println(numerosAleatoriosInt);

        // ver vídeo parte 3

    }
}
