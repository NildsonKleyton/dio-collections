package br.com.dio.collection.stream;

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

