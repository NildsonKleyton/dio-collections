package br.com.dio.collection.map;

import java.util.*;

public class ExemploOrdenacaoMap {
    /*
    Dadas as seguintes informações sobre meus livros favoritos e seus autores,
    crie um dicionário e ordene este dicionário:
    exibindo (Nome Autor - Nome Livro);
    Autor = Hawking, Stephen  - Livro = nome: Uma Breve História do Tempo. páginas: 256
    Autor = Duhigg, Charles - Livro = nome: O Poder do Hábito, paginas: 408
    Autor = Harari, Yuval Noah  - Livro = 21 Lições Para o Século 21, páginas: 432
    */
    public static void main(String[] args) {
        System.out.println("--\tOrdem aleatória\t--");
        Map<String, Livro> meusLivros = new HashMap<>() {{
            put("Hawking, Stephen", new Livro("Uma Breve História do Tempo", 256));
            put("Duhigg, Charles", new Livro("O Poder do Hábito", 408));
            put("Harari, Yuval Noah", new Livro("21 Lições Para o Século 21", 432));
        }};

        for (Map.Entry<String, Livro> livro : meusLivros.entrySet())
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome() +" "+livro.getValue().getPaginas() +"Pg");

        System.out.println("\n--\tOrdem Inserção\t--");
        Map<String, Livro> meusLivrosOrdem = new LinkedHashMap<>() {{
            put("Hawking, Stephen", new Livro("Uma Breve História do Tempo", 256));
            put("Duhigg, Charles", new Livro("O Poder do Hábito", 408));
            put("Harari, Yuval Noah", new Livro("21 Lições Para o Século 21", 432));
        }};
        for (Map.Entry<String, Livro> livro : meusLivrosOrdem.entrySet())
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome() +" "+livro.getValue().getPaginas() +"Pg");

        System.out.println("\n--\tOrdem alfabética autores\t--");
        Map<String , Livro> meusLivrosOrdemAutores = new TreeMap<>(meusLivros);
        for (Map.Entry<String, Livro> livro : meusLivrosOrdemAutores.entrySet())
            System.out.println(livro.getKey() + " -> " + livro.getValue().getNome() +" "+livro.getValue().getPaginas()+"Pg");

        System.out.println("\n--\tOrdem alfabética nomes dos livros\t--");
        Set<Map.Entry<String, Livro>> meusLivrosOrdemNomes = new TreeSet<>(new ComparatorNeme());
        meusLivrosOrdemNomes.addAll(meusLivros.entrySet());
        for (Map.Entry<String, Livro> livro : meusLivrosOrdemNomes)
            System.out.println(livro.getKey() + " -> " + livro.getValue().getNome() +" "+livro.getValue().getPaginas()+"Pg");


// Pra você
        System.out.println("\n--\tOrdem número de página\t--");
        Set<Map.Entry<String, Livro>> meusLivroOrdemesPaginas = new TreeSet<>(new ComparatorPaginas());
        meusLivroOrdemesPaginas.addAll(meusLivros.entrySet());
        for (Map.Entry<String , Livro> livro :meusLivroOrdemesPaginas)
            System.out.println(livro.getKey() + " -> " + livro.getValue().getNome()+" "+livro.getValue().getPaginas());

    }
}

class Livro {
    private String nome;
    private Integer paginas;

    public Livro(String nome, Integer paginas) {
        this.nome = nome;
        this.paginas = paginas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return nome.equals(livro.nome) && paginas.equals(livro.paginas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, paginas);
    }

    @Override
    public String toString() {
        return "Livro{" +
                "nome='" + nome + '\'' +
                ", paginas=" + paginas +
                '}';
    }
}

class ComparatorNeme implements Comparator<Map.Entry<String, Livro>> {

    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return l1.getValue().getNome().compareToIgnoreCase(l2.getValue().getNome());
    }
}

class  ComparatorPaginas implements Comparator<Map.Entry<String , Livro>>{

    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return Integer.compareUnsigned( l1.getValue().getPaginas(), l2.getValue().getPaginas());
    }
}