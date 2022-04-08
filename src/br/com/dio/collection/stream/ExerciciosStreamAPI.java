package br.com.dio.collection.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.*;
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
        Set<String> cincoPrimeirosNumeros = numerosAleatorios.stream()
                .limit(5)
                .collect(Collectors.toSet());
        System.out.println(cincoPrimeirosNumeros);

        System.out.println("\nTransforme esta lista de String em uma lista de números inteiros.");
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
                .forEach(System.out::println);//imprime a lista

        // colocando um uma variável
        List<Integer> numerosAleatoriosInt = numerosAleatorios.stream()
                .map(Integer::parseInt)//transforma os itens em inteiros
                .collect(Collectors.toList()); //cria uma lista de inteiros

        System.out.println(numerosAleatoriosInt);

        System.out.println("\nPegue os números pares e maiores que 2 e coloque em uma lista:");
        //Caso não tivecimos transformado a lista a em inteiro como foi realizaso acima, fariamos assim:
        numerosAleatorios.stream()
                .map(Integer::parseInt)//transforma os itens em inteiros
                .filter(new Predicate<Integer>() {//faz uma seleção para pegar os números pares
                    @Override
                    public boolean test(Integer integer) {
                        if (integer % 2 == 0 && integer > 2) return true;
                        return false;
                    }
                }).collect(Collectors.toList());
        // usando a lista acima
        numerosAleatoriosInt.stream()
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer i) {
                        if (i % 2 == 0 && i > 2) //se o numero da lista for par e maior que 2
                            return true;// retorna verdade e sai
                        return false;// senão retorna falso e sai
                    }
                })
                .forEach(System.out::println);// forech para exibir

        // refarorando pra espreção lambda => i -> (i %2 == 0 && i > 2)
        numerosAleatoriosInt.stream().filter(i -> (i % 2 == 0 && i > 2)).collect(Collectors.toList());

        // recebendo em uma variável
        List<Integer> numerosAleatoriosIntPares = numerosAleatoriosInt.stream()
                .filter(i -> (i % 2 == 0 && i > 2)).collect(Collectors.toList());

        System.out.println(numerosAleatoriosIntPares);

        System.out.println("\nMostre a média dos números: ");

//Caso não tivecimos transformado a lista a em inteiro como foi realizaso acima, fariamos assim:
        numerosAleatorios.stream()
                .mapToInt(new ToIntFunction<String>() {//transforma os itens em inteiros
                    @Override
                    public int applyAsInt(String value) {
                        return Integer.parseInt(value);
                    }
                });
        // refarorando pra espreção lambda
        numerosAleatorios.stream().mapToInt(i -> Integer.parseInt(i));

        // refarorando pra Reference Método
        numerosAleatorios.stream().mapToInt(Integer::parseInt);

        // recebendo a média => average {retorna um  OptionalDouble}
        numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)//transforma os itens em inteiros
                .average()//como retorna um double tem que usar uma fução do Optional
                .ifPresent(new DoubleConsumer() {
                    @Override
                    public void accept(double value) {
                        System.out.println(value);
                    }
                });
        //refatorado a expreção assima
        numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)//transforma os itens em inteiros
                .average()//como retorna um double tem que usar uma fução do Optional
                .ifPresent(System.out::println);

        //usando a lista numerosAleatoriosInt
        numerosAleatoriosInt.stream()
                .average()
                .ifPresent(System.out::println);
    }
}
