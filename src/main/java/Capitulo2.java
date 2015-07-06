import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Capitulo2 {

    public static void main(String[] args) {
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilherme Silveira", 190);

        List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

        // modo antigo
        for (Usuario u : usuarios) {
            System.out.println(u.getNome());
        }

        // modo novo criando uma classe consumidor externo
        usuarios.forEach(new Mostrador());

        // modo novo criando uma classe anônima, mas bastante verboso
        usuarios.forEach(new Consumer<Usuario>() {
            @Override
            public void accept(Usuario u) {
                System.out.println(u.getNome());
            }
        });

        // modo novo criando um lambda
        Consumer<Usuario> mostrador1 = (Usuario u) -> { System.out.println(u.getNome()); };

        Consumer<Usuario> mostrador2 = u -> System.out.println(u.getNome());

        usuarios.forEach(u -> System.out.println(u.getNome()));
    }
}

/**
 * Aqui você irá consumir o objeto.
 * "Consumir" significa realizar alguma tarefa que faça sentido para você.
 */
class Mostrador implements Consumer<Usuario> {
    @Override
    public void accept(Usuario u) {
        System.out.println(u.getNome());
    }
}