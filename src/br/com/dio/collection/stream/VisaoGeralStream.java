package br.com.dio.collection.stream;

import java.util.*;
import java.util.function.Function;


public class VisaoGeralStream {
    public static void main(String[] args) {
        List<Gato> meusGatos = new ArrayList<>() {{
            add(new Gato("Joh", 18, "preto"));
            add(new Gato("Joh", 12, "brando"));
            add(new Gato("Joh", 12, "amarelo"));
            add(new Gato("Joeh", 18, "preto"));
            add(new Gato("Simba", 6, "tigrado"));
            add(new Gato("Simba", 6, "brando"));
            add(new Gato("Simba", 7, "tigrado"));
            add(new Gato("Simbo", 6, "tigrado"));
        }};
        /**
         *  Ordenta a lista comparando pelo nome.
         */
        // uso da classe Anônima
/*        meusGatos.sort(Comparator.comparing(new Function<Gato, String>() {
            @Override
            public String apply(Gato gato) {
                return gato.getNome();
            }
        }));*/

        //usando Labda
//        meusGatos.sort(Comparator.comparing(g -> g.getNome()));

        //Referencia do Método (Reference Method)
        meusGatos.sort(Comparator.comparing(Gato::getNome));

        System.out.println("Lista Gato ordenada por nome.");
        for (Gato gato : meusGatos) {//exibe a lista
            System.out.println(gato.getNome() + " " + gato.getIdade() + " " + gato.getCor());
        }

        /**
         *  Ordenta a lista comparando pelo cor.
         *  O uso da classe Anõnima e Lambda, seria igual aos exemplos usado acima
         */
        //Referencia do Método (Reference Method)
        meusGatos.sort(Comparator.comparing(Gato::getCor));

        System.out.println("\nLista Gato ordenada por cor.");
        for (Gato gato : meusGatos) {//exibe a lista
            System.out.println(gato.getNome() + " " + gato.getIdade() + " " + gato.getCor());
        }

        /**
         *  Ordenta a lista comparando pelo idade.
         */
        // uso da classe Anônima
        meusGatos.sort(new Comparator<Gato>() {
                    @Override
                    public int compare(Gato g1, Gato g2) {
                        return Integer.compare(g1.getIdade(), g2.getIdade());
                    }
                }
        );

        //usando Labda
        meusGatos.sort((g1, g2) -> Integer.compare(g1.getIdade(), g2.getIdade()));

        //Referencia do Método (Reference Method)
        meusGatos.sort(Comparator.comparingInt(Gato::getIdade));
        System.out.println("\nLista Gato ordenada por idade.");
        for (Gato gato : meusGatos) {//exibe a lista
            System.out.println(gato.getNome() + " " + gato.getIdade() + " " + gato.getCor());
        }

        System.out.println("\nLista Gato ordenada por nome idade e cor");
        List<Gato> meusGatosOrdem = new ArrayList<>();
        meusGatosOrdem.addAll(meusGatos);// acrecenta os itens de uma lista meusGatos na lista meusGatosOrdem


        /**
         *  Ordenta a lista comparando pelo nome-> idade -> cor.
         */

/*
        como eu estava tentando fazer
        //uso da classe Anõnima
        meusGatosOrdem.sort(Comparator.comparing(new Function<Gato, String>() {
            @Override
            public String apply(Gato gato) {
                if ((gato.getNome().equalsIgnoreCase(gato.getNome())))
                    return gato.getNome();
                if ((gato.getIdade() == gato.getIdade()))
                    return gato.getCor();
                return gato.getCor();
            }
        }));


        //usando Labda
//        meusGatosOrdem.sort(Comparator.comparing((Gato gato) ->
//                if ((gato.getNome().equalsIgnoreCase(gato.getNome())))
//                    return gato.getNome();
//                if ((gato.getIdade() == gato.getIdade()))
//                    return gato.getCor();
//                return gato.getCor();
//            }
//        }));
        //Referencia do Método (Reference Method)
        for (Gato g : meusGatosOrdem) {//exibe a lista
            System.out.println(g.getNome() + " " + g.getIdade() + " " + g.getCor());
        }*/
        //como a professora ensinou

        //Objeto comparator que faz a comparação de acordo com a ordem dos atributos.
        Comparator<Gato> comparator = Comparator.comparing(Gato::getNome)
                .thenComparing(Gato::getIdade)
                .thenComparing(Gato::getCor);

        //A chamada dessa classe Collections com o método sort, é quem faz a ordenação.
        Collections.sort(meusGatos, comparator);

        meusGatos.forEach(g -> System.out.println(g.getNome() + " " + g.getIdade() + " " + g.getCor()));
    }
}
