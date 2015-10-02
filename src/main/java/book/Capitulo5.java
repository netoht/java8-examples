package book;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class Capitulo5 {

    public static void main(String[] args) {
        final List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Paulo Silveira", 150));
        usuarios.add(new Usuario("Rodrigo Turini", 120));
        usuarios.add(new Usuario("guilherme Silveira", 190));
//        usuarios.add(new Usuario(null, 190));

        // old
        //Collections.sort(usuarios, (u1, u2) -> String.CASE_INSENSITIVE_ORDER.compare(u1.getNome(), u2.getNome()));

        // new
        //usuarios.sort(Comparator.comparing(u -> Optional.ofNullable(u.getNome()).orElse("").toUpperCase()));

        Function<Usuario, String> extraiNome = u -> u.getNome();

        Comparator<Usuario> a = (Usuario u1, Usuario u2) -> extraiNome.apply(u1).compareTo(extraiNome.apply(u2));

        usuarios.sort(a);

        usuarios.forEach(System.out::println);

        String x = (String & Serializable) "";

    }

}
