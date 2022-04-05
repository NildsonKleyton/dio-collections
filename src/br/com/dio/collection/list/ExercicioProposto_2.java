package br.com.dio.collection.list;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/*
 *
 * Utilizando listas, faça um programa que faça 5 perguntas
 * para uma pessoa sobre um crime. As perguntas são:
 * 1. "Telefonou para a vítima?"
 * 2. "Esteve no local do crime?"
 * 3. "Mora perto da vítima?"
 * 4. "Devia para a vítima?"
 * 5. "Já trabalhou com a vítima?"
 * Se a pessoa responder positivamente a 2 questões ela deve
 *  ser classificada como "Suspeita", entre 3 e 4 como
 * "Cúmplice" e 5 como "Assassina". Caso contrário, ele será
 *  classificado como "Inocente".
 *
 */
public class ExercicioProposto_2 {

    public static void main(String[] args) {
        List<String> respostas = new ArrayList<>();
        String resposta;
        System.out.println("Você foi visto no local do Crime.\nResponda as perguntas com s-sim ou s-Não\n");

        resposta = pregunta("Telefonou para vítima? ");
        respostas.add(resposta.toLowerCase());
        resposta = pregunta("Esteve no local do crime? ");
        respostas.add(resposta.toLowerCase());
        resposta = pregunta("Mora perto da vítima? ");
        respostas.add(resposta.toLowerCase());
        resposta = pregunta("Devia para vítima? ");
        respostas.add(resposta.toLowerCase());
        resposta = pregunta("Já trabalhou com a vítima? ");
        respostas.add(resposta.toLowerCase());
/**laço usado para ver contos 's' existe*/
        System.out.println(respostas); // lista ok
        int sim = 0;
        for (String elementoResposta : respostas) {
            if (elementoResposta.contains("s")) sim++;
        }
/** Fazendo o laço acima usando iterator */
//        Iterator<String> respostaPositiva = respostas.iterator();
//        int sim = 0;
//        while (respostaPositiva.hasNext()) {//respostaPositiva.hasNext - verifica se tem um próximo item
//            String resp = respostaPositiva.next();//recebe o elemento
//            if (resp.contains("s")) sim++;// se respostaPositiva conter 's' sim recebe +1
//            //if (respostaPositiva.next().contains("s")) cont++; // alternativa de uma linha
//        }

//        System.out.println("Sim= "+ sim);
        System.out.print("\nVocê é ");
        if (sim == 2) System.out.println("Suspeita!");
        else if (sim >= 3 && sim <= 4) System.out.println("Cúmplice!");
        else if (sim == 5) System.out.println("Assassina!");
        else System.out.println("Inocente!");
    }

    /**
     * Rescebe um texte como pergunta e retorna uma resposta.
     * Verificando se a resposta é valida.
     *
     * @param mensagem
     * @return s ou n
     * @author Nildson Kleyton
     */
    private static String pregunta(String mensagem) {
        Scanner scan = new Scanner(System.in);
        System.out.print(mensagem);
        String entrada = scan.next().toLowerCase();

        String resposta = null;
        if (entrada.equals("s") || entrada.equals("n")) {
            return resposta = entrada;
        } else {
            do {
                resposta = JOptionPane.showInputDialog(null, "Digite 'S' para sim ou 'N' para Não:");
//                 resposta = getString("Digite s para sim ou n para Não: ");
                System.out.println(resposta);
            } while (!resposta.equalsIgnoreCase("s") && !resposta.equalsIgnoreCase("n"));
            return resposta;
        }
    }
}
