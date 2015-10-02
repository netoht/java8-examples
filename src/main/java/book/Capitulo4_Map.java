package book;

import java.util.HashMap;
import java.util.Map;

public class Capitulo4_Map {

    public static void main(String[] args) {

        Map<String, String> myMap = new HashMap<>();

        myMap.put("key1", "Waldinar");
        myMap.put("key2", "Neto");

        String defaultValue = myMap.getOrDefault("key0", "chave não existe");
        System.out.println(defaultValue);

        // executa se a chave existe
        myMap.computeIfPresent("key1", (key, value) -> {
            System.out.println("key  : " + key);
            System.out.println("value: " + value);
            return null; //-- apaga a entrada se retornado null
            // return value + "Novo"; //-- altera o valor
            // throw new RuntimeException(); //-- nada é alterado e a execução é interrompida
        });

        // executa se a chave não existe
        myMap.computeIfAbsent("key1", (key) -> {
            return "NovoValor"; // -- retorna o valor para key inexistente, assim criando a nova chave
            // return null; //-- não sera adicionada a entrada se retornado null
            // throw new RuntimeException(); //-- nada é alterado e a execução é interrompida
        });

        // executa sempre, caso a chave exista ou não
        myMap.compute("key0", (key, value) -> {
            System.out.println("--- key?   " + key);
            System.out.println("--- value? " + value);
            return "teste";
        });

        // se a
        myMap.merge("key1", "NovoValor1", (valueExistente, valueNovo) -> {
            System.out.println("merge --- valueExistente?   " + valueExistente);
            System.out.println("merge --- valueNovo?        " + valueNovo);
            return valueNovo;
        });

        myMap.putIfAbsent("key3", "lalalala");

        myMap.replace("key3", "LALALA");

        myMap.replaceAll((key, value) -> value.toUpperCase());

        System.out.println(myMap);
    }
}
