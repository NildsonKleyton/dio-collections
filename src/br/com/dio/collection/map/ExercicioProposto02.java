package br.com.dio.collection.map;

import java.util.*;

public class ExercicioProposto02 {
    /**
     * Faça um programa que simule um lançamento de dados. Lance o dado 100 vezes e armazene.
     * Depois, mostre quantas vezes cada valor foi conseguido.
     */
    public static void main(String[] args) throws InterruptedException {
        List<Integer> valores = new ArrayList<>();// cria um lista para armazenar os dados
         /*
         * Usando o Random para criar valores aleatorios.
         * Criando uma variável que recebe a quantidade de vezes.
         * Usando o for para receber o [valor] e adicionar na lista {valores}.
         */
        Random lancamento = new Random();
        int vezes = 100;
        for (int i = 0; i < vezes; i++) {
            // para que os valores seja de (1 ~ 6), o lancamento.nextInt() é somado com + 1,
            // já que inicia em 0, onde 0=1, 1=2 ... 5=6
            int valor = lancamento.nextInt(6) + 1;
            valores.add(valor);//adicionar na lista
        }
        //usndo o foreach para exibir a list
        for (Integer valor : valores) {
            System.out.print(valor + " ");
        }
        System.out.println();

        Map<Integer, Integer> lancamentos = new HashMap<>();
        for (Integer resultado : valores) {
            if (lancamentos.containsKey(resultado))
                lancamentos.put(resultado, (lancamentos.get(resultado) + 1));
            else lancamentos.put(resultado, 1);
        }

        System.out.print("Quantas vezes cada valor foi repetido.\nCalculando");

        for (int i = 0; i < 3; i++) {
                Thread.sleep(300);
                System.out.print(".");
        }
        System.out.println();
        for (Map.Entry<Integer, Integer> lancamentoNovo : lancamentos.entrySet()) {
            System.out.print(lancamentoNovo + " ");
        }

        System.out.println();

        String texto = "Valor | Quant. de vezes";
        linha(texto);
        System.out.println("  "+texto);
        linha(texto);
        for (Map.Entry<Integer, Integer> entry : lancamentos.entrySet()) {
            System.out.printf("%5d\t| %8d\n", entry.getKey(), entry.getValue());
        }
    }

    /**
     * Exibe uma linha para ser colocada antes e depois do texto.
     * A linha tem um extenção de dois caracteres antes e depois do tamanho do texto.
     * @param texto
     * @author Nildson Kleyton CS
     */
    private static void linha(String texto) {

        if ( (texto.length() % 2) == 0) {
            for (int i = 0; i < texto.length() + 4; i++) {
                try {
                    Thread.sleep(50);
                    if (i == texto.length() + 3)
                        System.out.println("-");
                    else
                        System.out.print("-");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }else{
            for (int i = 0; i <= texto.length() + 3; i++) {
                try {
                    Thread.sleep(50);
                    if (i == texto.length() + 3)
                        System.out.println("-");
                    else
                        System.out.print("-");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
