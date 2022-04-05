package br.com.dio.collection.set;

import java.util.*;

/*
 * Crie uma classe LinguagemFavorita que possua os atributos nome, anoDeCriacao e IDE.
 * Em seguida, crie um conjunto com 3 linguagens e faça um programa que ordene esse conjunto por:
 * a) Ordem de inserção;
 * b) Ordem natural(nome);
 * c) IDE;
 * d) Ano de criação e nome;
 * e) Nome, ano de criação e IDE;
 * Ao final, exiba as linguagens no console, um abaixo da outra.
 */
public class ExercicioProposto02 {
    public static void main(String[] args) {
        System.out.println("a) Ordem de inserção: ");
        Set<LinguagemFavorita> linguagemFavorita = new LinkedHashSet<>(
                Arrays.asList(
                        new LinguagemFavorita("Python", 1991, "Pycharm"),
                        new LinguagemFavorita("JavaScript", 1995, "IntelliJ"),
                        new LinguagemFavorita("Java", 1991, "Visual Studio Code")
                )
        );
        for (LinguagemFavorita linguagem : linguagemFavorita)
            System.out.println(linguagem.getNome() + " " + linguagem.getAnoDeCriacao() + " " + linguagem.getIDE());

        System.out.println("\nb) Ordem natural(nome);");
        Set<LinguagemFavorita> linguagemFavoritasOrdemNome = new TreeSet<>(linguagemFavorita);
        for (LinguagemFavorita linguagem : linguagemFavoritasOrdemNome)
            System.out.println(linguagem.getNome() + " " + linguagem.getAnoDeCriacao() + " " + linguagem.getIDE());

        System.out.println("\nc) Ordem IDE;");
        Set<LinguagemFavorita> linguagemFavoritasIde = new TreeSet<>(new ComparatorIde());
        linguagemFavoritasIde.addAll(linguagemFavorita);
        for (LinguagemFavorita linguagem : linguagemFavoritasIde)
            System.out.println(linguagem.getNome() + " " + linguagem.getAnoDeCriacao() + " " + linguagem.getIDE());

        System.out.println("\nd) Ano de criação e nome;");
        Set<LinguagemFavorita> linguagemFavoritasAnoNome = new TreeSet<>(new ComparatorAnoNome());
        linguagemFavoritasAnoNome.addAll(linguagemFavorita);
        for (LinguagemFavorita linguagem : linguagemFavoritasAnoNome)
            System.out.println(linguagem.getNome() + " " + linguagem.getAnoDeCriacao() + " " + linguagem.getIDE());

        System.out.println("\ne) Nome, ano de criação e IDE;");
        Set<LinguagemFavorita> linguagemFavoritasNomeAnoIde = new TreeSet<>(new ComparatrorNomeAnoIde());
        linguagemFavoritasNomeAnoIde.addAll(linguagemFavorita);
        linguagemFavoritasNomeAnoIde.add(new LinguagemFavorita("Java", 1990, "Visual Studio Code"));
        linguagemFavoritasNomeAnoIde.add(new LinguagemFavorita("JavaScript", 1995, "Visual Studio Code"));
        for (LinguagemFavorita linguagem : linguagemFavoritasNomeAnoIde)
            System.out.println(linguagem.getNome() + " " + linguagem.getAnoDeCriacao() + " " + linguagem.getIDE());
    }
}

class LinguagemFavorita implements Comparable<LinguagemFavorita> {
    private String nome;
    private Integer anoDeCriacao;
    private String IDE;

    public LinguagemFavorita(String nome, Integer anoDeCriacao, String IDE) {
        this.nome = nome;
        this.anoDeCriacao = anoDeCriacao;
        this.IDE = IDE;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAnoDeCriacao() {
        return anoDeCriacao;
    }

    public void setAnoDeCriacao(Integer anoDeCriacao) {
        this.anoDeCriacao = anoDeCriacao;
    }

    public String getIDE() {
        return IDE;
    }

    @Override
    public String toString() {
        return "LinguagemFavorita{" +
                "nome='" + nome + '\'' +
                ", anoDeCriacao=" + anoDeCriacao +
                ", IDE='" + IDE + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinguagemFavorita that = (LinguagemFavorita) o;
        return Objects.equals(nome, that.nome) && Objects.equals(anoDeCriacao, that.anoDeCriacao) && Objects.equals(IDE, that.IDE);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, anoDeCriacao, IDE);
    }

    public void setIDE(String IDE) {
        this.IDE = IDE;
    }

    @Override
    public int compareTo(LinguagemFavorita linguagem) {// faz a comparação por nome
        return this.nome.compareTo(linguagem.nome);
    }
}

class ComparatorIde implements Comparator<LinguagemFavorita> {
    @Override
    public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {
        return l1.getIDE().compareTo(l2.getIDE());
    }
}

class ComparatorAnoNome implements Comparator<LinguagemFavorita> {

    @Override
    public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {
        int ide = Integer.compare(l1.getAnoDeCriacao(), l2.getAnoDeCriacao());
        if (ide != 0) return ide;
        return l1.getNome().compareTo(l2.getNome());
    }
}

class ComparatrorNomeAnoIde implements Comparator<LinguagemFavorita> {

    @Override
    public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {
        int nome = l1.getNome().compareTo(l2.getNome());
        if (nome != 0) return nome;

        int ano = Integer.compare(l1.getAnoDeCriacao(), l2.getAnoDeCriacao());
        if (ano != 0) return ano;

        return l1.getIDE().compareTo(l2.getIDE());
    }
}