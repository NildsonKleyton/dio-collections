package br.com.dio.collection.set;

import java.util.*;

/*
Crie uma conjunto contendo as cores do arco-aliança e:
a) Exiba todas as cores o arco-aliança uma abaixo da outra;
b) A quantidade de cores que o arco-aliança tem;
c) Exiba as cores em ordem alfabética;
d) Exiba as cores na ordem inversa da que foi informada;
e) Exiba todas as cores que começam com a letra ”v”;
f) Remova todas as cores que não começam com a letra “v”;
g) Limpe o conjunto;
h) Confira se o conjunto está vazio;
 */
public class ExercicioProposto01 {
    public static void main(String[] args) {
        System.out.println("Crie uma conjunto contendo as cores do arco-aliança: ");
        Set<String> arcoAliancaCores = new LinkedHashSet<>() {{
            add("violeta");
            add("anil");
            add("azul");
            add("verde");
            add("amarelo");
            add("laranja");
            add("vermelho");
        }};
        System.out.println(arcoAliancaCores);

        System.out.println("\nExiba todas as cores o arco-aliança uma abaixo da outra: ");
        for (String arcoAlianca : arcoAliancaCores)
            System.out.println(arcoAlianca);

        System.out.println("\nA quantidade de cores que o arco-aliança tem: " + arcoAliancaCores.size());

        System.out.println("\nExiba as cores em ordem alfabética: ");
        Set<String> arcoAliancaCoresOrdem = new TreeSet<>(arcoAliancaCores);
        System.out.println(arcoAliancaCoresOrdem);

        System.out.println("\nExiba as cores na ordem inversa da que foi informada ");
        //Como o arcoAliancaCores foi criado com LinkedHashSet quem mantem a ordem de inserção,
        //podemos usar no List
        List<String> arcoAliancaCoresOrdemInversa = new ArrayList<>(arcoAliancaCores);
        Collections.reverse(arcoAliancaCoresOrdemInversa);
        System.out.println(arcoAliancaCoresOrdemInversa);

        System.out.println("\nExiba todas as cores que começam com a letra ”v”: ");
        for (String cor : arcoAliancaCores) {
            //startsWith("v") - Testa se essa string inicia com o prefixo especificado.
            if (cor.startsWith("v")) System.out.println(cor);// se cor inicia com a letra "v" imprime
        }

        System.out.println("\nRemova todas as cores que não começam com a letra “v”: ");
        Iterator<String> posicaoCor = arcoAliancaCores.iterator();
        while (posicaoCor.hasNext()) {
            String proximo = posicaoCor.next();
            if (!proximo.startsWith("v"))
                posicaoCor.remove();
        }
        System.out.println(arcoAliancaCores);

        System.out.println("\nLimpe o conjunto: ");
        arcoAliancaCores.clear();

        System.out.println("Confira se o conjunto está vazio: " + arcoAliancaCores.isEmpty());

    }
}
