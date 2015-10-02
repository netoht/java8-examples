package book;
import java.util.concurrent.TimeUnit;

/**
 * Toda interface que possui somente um método abstrado pode ser instanciada
 * como um código lambda, que também fica conhecida como uma interface
 * funcional!
 *
 * Mas essa interface também pode possuir métodos default.
 *
 * Foi adicionado no Java 8 o pacote java.util.function com uma série de interfaces
 * funcionais.
 */
public class Capitulo3 {

    public static void main(String[] args) throws Exception {

        // modo antigo
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println(i);
                }
            }
        };
        new Thread(r).start();

        // modo novo
        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(i);
            }
        }).start();


        // modo antigo
        Validador<String> validadorCEP = new Validador<String>() {
            @Override
            public boolean valida(String valor) {
                return valor.matches("[0-9]{5}-[0-9]{3}");
            }
        };

        // modo novo
        Validador<String> validadorCEP2 = (valor) -> valor.matches("[0-9]{5}-[0-9]{3}");

        TimeUnit.SECONDS.sleep(1);
        System.out.println(validadorCEP2.valida("00023-123"));

        // captura de variáveis locais
        final int numero = 5;
        Runnable r2 = () -> { System.out.println(numero); };

        int numero2 = 5;
        Runnable r3 = () -> { System.out.println(numero2); };
        new Thread(r3).start();

        /**
         * irá ocorrer um erro de compilação pois a variáveis numero2 deve ser final
         * ou não deve sofrer alteração após ser usada em um lambda caso não seja final
         */
//        numero2 = 10;

    }
}

/**
 * A nova interface @FunctionalInterface serve apenas para que ninguém torne aquela
 * interface em não-funcional acidentalmente, mas ela é opcional justamente para
 * que as interfaces das antigas bibliotecas possam também ser tratadas como lambdas
 * independente da anotação, bastando a existência de um único método abstrato.
 */
@FunctionalInterface
interface Validador<T> {
    boolean valida(T t);
//    boolean outroMetodo(T t);
}