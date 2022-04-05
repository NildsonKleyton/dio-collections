package br.com.dio.collection.list;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
* Dadas as seguintes informações sobre meus gatos, crie uma
* lista e ordene esta lista exibindo:
* (nome - idade - cor);
* Gato 1 = nome: Jon, idade: 18, cor: preto
* Gato 2 = nome: Simba, idade: 6, cor: tigrado
* Gato 3 = nome: Jon, genero: 12, cor: amarelo
*/
public class ExemploOrdenacaoList {

    public static void main(String[] args) {

        List<Gato> osGatos = new ArrayList<>() {{
            add(new Gato("Joh", 18, "preto"));
            add(new Gato("Joh", 12, "brando"));
            add(new Gato("Joh", 12, "amarelo"));
            add(new Gato("Joh", 18, "preto"));
            add(new Gato("Simba", 6, "tigrado"));
            add(new Gato("Simba", 6, "brando"));
            add(new Gato("Simba", 7, "tigrado"));
            add(new Gato("Simba", 6, "tigrado"));

        }};

        System.out.println("--\tOrdem de Inserção\t---");
        System.out.println(osGatos);

        System.out.println("\n--\tOrdem aleatória  \t---");
        Collections.shuffle(osGatos);
        System.out.println(osGatos);

        System.out.println("\n--\tOrdem Natural (Nome)\t---");
//        osGatos.sort(); // na list tem o método sort(), para realizar a ordenação presica do metodo Comparator e a classe Gato implementa a Comparable
        Collections.sort(osGatos);
        System.out.println(osGatos);

        System.out.println("\n--\tOrdem Idade\t---");
//        Collections.sort(osGatos,new ComparatorIdade() );
        osGatos.sort(new ComparatorIdade());
        System.out.println(osGatos);

        System.out.println("--\tOrdem cor\t---");
//        Collections.sort(osGatos,new ComparatorCor() );
        osGatos.sort(new ComparatorCor());
        System.out.println(osGatos);

        System.out.println("--\tOrdem Nome/Idade/Cor\t---");
//        Collections.sort(osGatos,new ComparatorNomeIdadeCor());
        osGatos.sort(new ComparatorNomeIdadeCor());
        System.out.println(osGatos);
    }
}
class Gato implements Comparable<Gato> { // implenta o método Comparable para poder realizar comparação e ordenar por nome
    private String nome;
    private Integer idade;
    private String cor;

    public Gato(String nome, Integer idade, String cor) {
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public String getCor() {
        return cor;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cor='" + cor + '\'' +
                "}\n";
    }

    @Override
    public int compareTo(Gato gato) {
        /**
         * Realiza uma comparação entre dois  nomes.
         * o métopdo "compareTo"
         * se nome iguas renotora 0 se diferente 1
         */
        return this.getNome().compareToIgnoreCase(gato.getNome());
    }
}
/*
 * Como já foi usado o Comparable na classe Gato,
 * agora temos que criar uma classe para utilizar o Comparator<>
 */
class ComparatorIdade implements Comparator<Gato> {

    @Override
    public int compare(Gato gato1, Gato gato2) {
        return Integer.compare(gato1.getIdade(), gato2.getIdade());
    }
}
class ComparatorCor implements Comparator<Gato> {

    @Override
    public int compare(Gato gato1, Gato gato2) {
        return gato1.getCor().compareToIgnoreCase(gato2.getCor());
    }
}
class ComparatorNomeIdadeCor implements Comparator<Gato> {
    @Override
    public int compare(Gato g1, Gato g2) {
        int nome = g1.getNome().compareToIgnoreCase(g2.getNome());
        if (nome != 0) return nome;
        //como a idade é um inteiro usa-se o compare do Interger
        int idade = Integer.compare(g1.getIdade(), g2.getIdade());
        if (idade != 0) return idade;
        int cor = g1.getCor().compareToIgnoreCase(g2.getCor());
        return cor;
    }
}

