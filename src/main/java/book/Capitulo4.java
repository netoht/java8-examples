package book;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;


public class Capitulo4 {

    public static void main(String[] args) throws MalformedURLException, IOException {
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilherme Silveira", 190);

        final List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(user1);
        usuarios.add(user2);
        usuarios.add(user3);

        usuarios.removeIf(u -> u.getPontos() > 160);

        Consumer<Usuario> beforePrintName = u -> System.out.println("antes de imprimir o nome:");

        usuarios.forEach(beforePrintName.andThen(u -> System.out.println(u.getNome())));

        List<Double> d = new LinkedList<Double>();
        List<Integer> i = new LinkedList<Integer>();
        List<String> s = getValue(d);
        List<String> s2 = getValue(i);
    }

    private static List<String> getValue(List d) {
        return null;
    }
}
