package br.com.dio.collection.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** Faça um programa que receba a temperatura média os 6
 * primeiros meses do ano e armazene-as em uma lista.
 * Após isto, calcule a média semestral das temperaturas e
 * mostre todas as temperaturas acima desta média, e em que
 * mês elas ocorreram (mostrar o mês por extenso: 1 – Janeiro,
 * 2 – Fevereiro e etc).
 */
public class ExercicioProposto_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Double> temperaturas = new ArrayList<>();
        double somaTempratura = 0.0;
        for (int i = 1; i <= 6; i++) {
            System.out.print("Digite a temperatua do mês " + i + ": ");
            double temp = scan.nextDouble();
            temperaturas.add(temp);
            somaTempratura += temp;
        }
        System.out.println();

        double mediaTemperatuda = somaTempratura / temperaturas.size();

        for (int i=0; i < temperaturas.size(); i++) {
        if (i < temperaturas.size()-1) {
            System.out.print(temperaturas.get(i) + " ");
            } else System.out.println( temperaturas.get(i)+ " = "+ somaTempratura + "ºC");
        }
//        for (Double temp : temperaturas) {
//            int posicao = temperaturas.indexOf(temp);
//            if (posicao < temperaturas.size()-1) {
//                System.out.print(temp + " ");
//            } else System.out.println( temp + " = "+ somaTempratura + "ºC");
//        }

        System.out.println("Temperaturas Semestral: " + temperaturas);
        System.out.printf("Média temperaturas Semestral: %.2fºC%n", mediaTemperatuda);
        System.out.println("Temperaturas do Semeste acima média");
        for (Double temp : temperaturas) {
            if (temp > mediaTemperatuda) {
                int index = temperaturas.indexOf(temp);
                switch (index) {
                    case 0:
                        System.out.println("1 - JANEIRO: " + temp + " oC");
                        break;
                    case 1:
                        System.out.println("2 - FEVEREIRO: " + temp + " oC");
                        break;
                    case 2:
                        System.out.println("3 - MARÇO: " + temp + " oC");
                        break;
                    case 3:
                        System.out.println("4 - ABRIL: " + temp + " oC");
                        break;
                    case 4:
                        System.out.println("5 - MAIO: " + temp + " oC");
                        break;
                    case 5:
                        System.out.println("6 - JUNHO: " + temp + " oC");
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
