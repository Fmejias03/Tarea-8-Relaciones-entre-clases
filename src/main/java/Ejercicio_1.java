import java.util.Scanner;

public class Ejercicio_1 {
    /*1. La guerra de dados
Requisitos previos: Ejercicio 1 del capítulo La programación orientada a objetos

Dos jugadores se enfrentan en una guerra de dados: cada jugador tiene un dado de seis caras y diez fichas.

Cree una clase JugadorGuerra, que tenga como atributos de instancia el número de fichas, un dado (una instancia de la clase Dado) y el nombre del jugador. Agregue dentro de esta clase el resto de elementos necesarios. Cree un algoritmo principal usando esta clase.

Ejemplo de ejecución:

¿Nombre del jugador?

Jimena

¿Nombre del jugador?

Lucía

Jimena ha sacado un 4

Lucía ha sacado un 1

Jimena gana

Marcador: Jimena 11 - Lucía 9

Jimena ha sacado un 1

Lucía ha sacado un 5

Lucía gana

Marcador: Jimena 10 - Lucía 10

Jimena ha sacado un 5

Lucía ha sacado un 2

Jimena gana

Marcador: Jimena 11 - Lucía 9

Jimena ha sacado un 1

Lucía ha sacado un 6

Lucía gana

Marcador: Jimena 10 - Lucía 10

Jimena ha sacado un 3

Lucía ha sacado un 6

Lucía gana

Marcador: Jimena 9 - Lucía 11

Jimena ha sacado un 5

Lucía ha sacado un 6

Lucía gana

Marcador: Jeanne 8 - Lucía 12

Jimena ha sacado un 2

Lucía ha sacado un 2

empate

Marcador: Jimena 8 - Lucía 12

Jimena ha sacado un 6

Lucía ha sacado un 6

empate

Marcador: Jimena 8 - Lucía 12

Jimena ha sacado un 3

Lucía ha sacado un 6

Lucía gana

Marcador: Jimena 7 - Lucía 13

Jimena ha sacado un 1

Lucía ha sacado un 5

Lucía gana

Marcador: Jimena 6 - Lucía 14

Jimena ha sacado un 2

Lucía ha sacado un 5

Lucía gana

Marcador: Jimena 5 - Lucía 15

Jimena ha sacado un 3

Lucía ha sacado un 5

Lucía gana

Marcador: Jimena 4 - Lucía 16

Jimena ha sacado un 2

Lucía ha sacado un 3

Lucía gana

Marcador: Jimena 3 - Lucía 17

Lucía ha sacado un 5

Lucía gana

Marcador: Jimena 2 - Lucía 18

Jimena ha sacado un 1

Lucía ha sacado un 6

Lucía gana

Marcador: Jimena 1 - Lucía 19

Jimena ha sacado un 1

Lucía ha sacado un 2

Lucía gana

Marcador: Jimena 0 - Lucía 20

Lucía ha ganado
en el main, la consola debera pedir los nombres de los jugadores mediante el metodo scanner*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        JugadorGuerra jugador1 = new JugadorGuerra();
        JugadorGuerra jugador2 = new JugadorGuerra();
        int dado1, dado2;
        System.out.println("¿Nombre del jugador?");
        jugador1.setNombre(sc.nextLine());
        System.out.println("¿Nombre del jugador?");
        jugador2.setNombre(sc.nextLine());


        while (jugador1.getFichas() > 0 && jugador2.getFichas() > 0) {
            dado1 = jugador1.tirarDado();
            dado2 = jugador2.tirarDado();
            System.out.println(jugador1.getNombre() + " ha sacado un " + dado1);
            System.out.println(jugador2.getNombre() + " ha sacado un " + dado2);
            if (dado1 > dado2) {
                jugador1.ganarFicha();
                jugador2.perderFicha();
                System.out.println(jugador1.getNombre() + " gana");
            } else if (dado1 < dado2) {
                jugador1.perderFicha();
                jugador2.ganarFicha();
                System.out.println(jugador2.getNombre() + " gana");
            } else {
                System.out.println("empate");
            }
            System.out.println("Marcador: " + jugador1.getNombre() + " " + jugador1.getFichas() + " - " + jugador2.getNombre() + " " + jugador2.getFichas());
        }
        if (jugador1.getFichas() == 0) {
            System.out.println(jugador2.getNombre() + " ha ganado");
        } else {
            System.out.println(jugador1.getNombre() + " ha ganado");
        }
    }


}

