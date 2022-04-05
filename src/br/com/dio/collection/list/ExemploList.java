package br.com.dio.collection.list;

import java.util.*;

public class ExemploList {
    public static void main(String[] args) {
// Dada uma lista com 7 notas de um aluno [7, 8.5, 9.3, 5, 7, 0, 3.6], faça:
        /**
         * Formas de intaciar uma lista.
         */
//      List notas = new ArrayList(); // usado antes do java 5 - ainda Copila
//      List<Double> notas = new ArrayList<Double>(); // Conceito de Generics(jdk 5)
//      List<Double> notas = new ArrayList<>(); // Diamont Operator(jdk 7)
//      ArrayList<Double> notas = new ArrayList<>(); // não é recomedano quando for voltado a interface, apenas pra implementação
//      List<Double> notas = new ArrayList<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
//      List<Double> notas = Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6);// Forma valida, porem limitada, não podendo ADD ou Remover
//      List<Double> notas = List.of(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6);// não podendo ADD ou Remover
        /**
         * Fim de Forma
         */


/*        System.out.println(notas);
        notas.add(1d);
        System.out.println(notas);
        notas.remove(5d);
        System.out.println(notas);*/

        System.out.println("Criar uma lista e adicione as sete notas: ");
        List<Double> notas = new ArrayList<Double>();
        notas.add(7d);
        notas.add(8.5);
        notas.add(9.3);
        notas.add(5d);
        notas.add(7d);
        notas.add(0d);
        notas.add(3.6);
        System.out.println(notas.toString());

        // indexOf recebe o objeto e informa a posição
        System.out.println("\nExiba a posição da nota 5.0:  posição" + notas.indexOf(5d));

        System.out.println("\nAdicione na lista a nota 8.0 na posição 4: ");
        notas.add(4, 8d);
        System.out.println(notas);

        System.out.println("\nSubstitua a nota 5.0 pela nota 6.0: ");
        notas.set(notas.indexOf(5d), 6.0); //o set recebe a posição e elemento, notas.indexOf(5.0) mostra a posição
        System.out.println(notas);

        System.out.println("\nConfira se a nota 5.0 está na lista: " + notas.contains(5d));// contains() - verifica se Contem o elemento

        System.out.println("\nExiba todas as notas na ordem em que foram informados:");
        for (Double nota : notas) System.out.print(nota + " ");

        System.out.println("\n\nExiba a terceira nota adicionada: " + notas.get(2));

        /**
         * Como não existe um método no list para verificar o menor ou mair valor, usa-se a clase Collection.min ou .max que recebe uma collection (c)
         */
        System.out.println("\nExiba a menor nota: " + Collections.min(notas));

        System.out.println("Exiba a maior nota: " + Collections.max(notas));

        System.out.print("\nExiba a soma dos valores: ");
        /**
         * Usando o método iterator, para interagir na list e pegando os elementos para somar.
         *
         */
        Iterator<Double> iterator = notas.iterator();
        Double soma = 0.0;
        while (iterator.hasNext()) {//iterator.hasNext - verifica se tem um próximo item
            Double proximo = iterator.next();
            soma += proximo;
        }
        System.out.println(soma);

        System.out.println("Exiba a média das notas: " + soma / notas.size());// a média e a soma das notas dividido pela quantidade de nota

        System.out.println("\nRemova a nota 0: ");
        System.out.println(notas);
        notas.remove(0d);// remove informando o objeto
        System.out.println(notas);

        System.out.println("\nRemova a nota da posição 0");
        System.out.println(notas);
        notas.remove(0);// remove informando a posição do index
        System.out.println(notas);

        System.out.println("\nRemova as notas menores que 7 e exiba a lista: ");
        Iterator<Double> elementosList = notas.iterator();
        System.out.println(notas);
        while (elementosList.hasNext()) {// enquanto (elementoList tem próxmo elemento)
            Double verElemento = elementosList.next(); // verElemento recebi próximo elemento da elementoList
            if (verElemento < 7)// se verElemento menor que 7
                elementosList.remove(); // remove o elemento menor que 7
        }
        System.out.println(notas);

        System.out.println("\nApague toda a lista");
        notas.clear();
        System.out.println(notas);

        System.out.print("\nConfira se a lista está vazia: ");
        // notas.isEmpty() - verifica se a lista está vazia retornando um boolean
        if (notas.isEmpty()) System.out.println("Sim");
        else System.out.println("Não");

/*
Para você: Resolva esses exercícios utilizando os métodos da implementação LinkedList:
*/
        System.out.println("Crie uma lista chamada notas2 e coloque todos os elementos da list Arraylist nessa nova lista: ");
        LinkedList<Double> notas2 = new LinkedList<>();
        notas2.add(7d);
        notas2.add(8.5);
        notas2.add(9.3);
        notas2.add(5d);
        notas2.add(7d);
        notas2.add(0d);
        notas2.add(3.6);
        System.out.println(notas2);

        System.out.println("\nMostre a primeira nota da nova lista sem removê-lo: " + notas2.getFirst());

        System.out.println("Mostre a primeira nota da nova lista removendo-o: " + notas2.removeFirst() +"\n"+notas2);



    }

}
