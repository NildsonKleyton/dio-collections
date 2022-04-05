package br.com.dio.collection.set;


import java.util.*;

/*Dadas as seguintes informações sobre minhas séries favoritas,
crie um conjunto e ordene este conjunto exibindo:
(nome - genero - tempo de episódio);
Série 1 = Nome: got, genero: fantasia, tempoEpisodio: 60
Série 2 = nome: dark, genero: drama, tempoEpisodio: 60
Série 3 = nome: that 70's show, genero: comédia, tempoEpisodio: 25
*/
public class ExemploOrdenacaoSet {
    public static void main(String[] args) {

        System.out.println("--\tOrdem aleatória\t--");
        // usando o HashSet  o set vem em  Ordem Aleatória
        Set<Serie> minhasSeries = new HashSet<>() {{
            add(new Serie("got", "fantasia", 60));
            add(new Serie("dark", "drama", 60));
            add(new Serie("that 70's", "comédia", 25));
        }};

        for (Serie serie : minhasSeries)
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
//
        System.out.println("\n--\tOrdem inserção\t--");
        //usando o linkedHashSet o set vem na Ordem de inserção
        Set<Serie> minhasSerieInsercao = new LinkedHashSet<>();
        minhasSerieInsercao.add(new Serie("got", "fantasia", 60));
        minhasSerieInsercao.add(new Serie("dark", "drama", 60));
        minhasSerieInsercao.add(new Serie("that 70's", "comédia", 25));
        for (Serie serieInsercao : minhasSerieInsercao)
            System.out.println(serieInsercao.getNome() + " - " + serieInsercao.getGenero() + " - " + serieInsercao.getTempoEpisodio());

        System.out.println("\n--\tOrdem natural (TempoEpisodio)\t--");
        Set<Serie> minhasSerieOrdemEpisodio = new TreeSet<>(minhasSeries);
        for (Serie serieOrdemEpisodio : minhasSerieOrdemEpisodio)
            System.out.println(serieOrdemEpisodio.getNome() + " - " + serieOrdemEpisodio.getGenero() + " - " + serieOrdemEpisodio.getTempoEpisodio());

        System.out.println("\n--\tOrdem Nome/Gênero/TempoEpisodio\t--");
        Set<Serie> minhasSerieOrdem = new TreeSet<>(new ComparatorNomeGeneroTempoEpisodio());
        minhasSerieOrdem.addAll(minhasSeries);
        minhasSerieOrdem.add(new Serie("got", "fantasia", 30));
        minhasSerieOrdem.add(new Serie("dark", "comédia", 60));
        for (Serie serieOrdem : minhasSerieOrdem)
            System.out.println(serieOrdem.getNome() + " - " + serieOrdem.getGenero() + " - " + serieOrdem.getTempoEpisodio());


//Pra você
        System.out.println("\n--\tOrdem gênero\t--");
        Set<Serie> minhasSeriegenero = new TreeSet<>(new ComparatorGenero());
        minhasSeriegenero.addAll(minhasSerieOrdem);
        for (Serie serieGenero : minhasSeriegenero)
            System.out.println(serieGenero.getNome() + " - " + serieGenero.getGenero() + " - " + serieGenero.getTempoEpisodio());

        System.out.println("\n--\tOrdem Tempo Episódio\t--");
        Set<Serie> minhaSerieTempo = new TreeSet<>(new ComparatorTempo());
        minhaSerieTempo.addAll(minhasSerieOrdem);
        for (Serie serieTempo : minhaSerieTempo)
            System.out.println(serieTempo.getNome() + " - " + serieTempo.getGenero() + " - " + serieTempo.getTempoEpisodio());

    }

}

class ComparatorNomeGeneroTempoEpisodio implements Comparator<Serie> {

    @Override
    public int compare(Serie s1, Serie s2) {
        int nome = s1.getNome().compareToIgnoreCase(s2.getNome());
        if (nome != 0) return nome;

        int genero = s1.getGenero().compareTo(s2.getGenero());
        if (genero != 0) return genero;

        return Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());
    }
}

class ComparatorGenero implements Comparator<Serie> {

    @Override
    public int compare(Serie s1, Serie s2) {
        return s1.getGenero().compareTo(s2.getGenero());
    }
}

class ComparatorTempo implements Comparator<Serie> {

    @Override
    public int compare(Serie s1, Serie s2) {
        return s1.getTempoEpisodio().compareTo(s2.getTempoEpisodio());
    }
}