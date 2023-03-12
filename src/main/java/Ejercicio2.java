import java.util.ArrayList;
import java.util.Scanner;
class Obra {
    private String titulo;
    private String autor;

    public Obra(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String toString() {
        return titulo + " de " + autor;
    }
}

class Libro extends Obra {
    private int numPaginas;

    public Libro(String titulo, String autor, int numPaginas) {
        super(titulo, autor);
        this.numPaginas = numPaginas;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public String toString() {
        return "Libro " + super.toString() + " (" + numPaginas + " páginas)";
    }
}

class Video extends Obra {
    private int duracion;

    public Video(String titulo, String autor, int duracion) {
        super(titulo, autor);
        this.duracion = duracion;
    }

    public int getDuracion() {
        return duracion;
    }

    public String toString() {
        int horas = duracion / 60;
        int minutos = duracion % 60;
        return "Vídeo " + super.toString() + " (" + horas + "h" + minutos + ")";
    }
}

class Pedido {
    private Ejercicio2 cliente;
    private ArrayList<Obra> obras;

    public Pedido(Ejercicio2 cliente) {
        this.cliente = cliente;
        this.obras = new ArrayList<>();
    }

    public void agregarObra(Obra obra) {
        this.obras.add(obra);
    }

    public Ejercicio2 getCliente() {
        return cliente;
    }

    public ArrayList<Obra> getObras() {
        return obras;
    }
}

public class Ejercicio2 {
    private static int ultimoNumeroCliente = 0;

    private String nombre;
    private int numeroCliente;

    public Ejercicio2(String nombre) {
        this.nombre = nombre;
        this.numeroCliente = ++ultimoNumeroCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumeroCliente() {
        return numeroCliente;
    }

    public String toString() {
        return "Cliente n.°" + numeroCliente + " [" + nombre + "]";
    }

    public static void main(String[] args) {
        ArrayList<Ejercicio2> clientes = new ArrayList<>();
        ArrayList<Obra> obras = new ArrayList<>();
        ArrayList<Pedido> pedidos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int opcion = 0;
        while (opcion != 6) {
            System.out.println("-- Menú --\n");
            System.out.println("1 - Mostrar clientes");
            System.out.println("2 - Crear un cliente");
            System.out.println("3 - Crear una obra");
            System.out.println("4 - Crear un pedido");
            System.out.println("5 - Mostrar pedidos");
            System.out.println("6 - Salir\n");
            System.out.print("Ingrese una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("\n-- Clientes --\n");
                    for (Ejercicio2 cliente : clientes) {
                        System.out.println(cliente);
                    }
                    System.out.println();
                    break;
                case 2:
                    System.out.print("\n¿Nombre? ");
                    String nombre = scanner.nextLine();

                    Ejercicio2 cliente = new Ejercicio2(nombre);
                    clientes.add(cliente);
                    System.out.println("Cliente n.°" + cliente.getNumeroCliente() + " [" + cliente.getNombre() + "] añadido\n");
                    break;
                case 3:
                    System.out.println("\n-- Crear obra --\n");
                    System.out.println("1 - Libro");
                    System.out.println("2 - Video");
                    System.out.print("Ingrese una opción: ");

                    int opcionObra = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("\n¿Título? ");
                    String titulo = scanner.nextLine();

                    System.out.print("¿Autor? ");
                    String autor = scanner.nextLine();

                    if (opcionObra == 1) {
                        System.out.print("¿Número de páginas? ");
                        int numPaginas = scanner.nextInt();
                        scanner.nextLine();

                        Libro libro = new Libro(titulo, autor, numPaginas);
                        obras.add(libro);
                        System.out.println("Libro " + libro + " añadido\n");
                    } else if (opcionObra == 2) {
                        System.out.print("¿Duración (minutos)? ");
                        int duracion = scanner.nextInt();
                        scanner.nextLine();

                        Video video = new Video(titulo, autor, duracion);
                        obras.add(video);
                        System.out.println("Video " + video + " añadido\n");
                    } else {
                        System.out.println("\nOpción inválida\n");
                    }

                    break;
                case 4:
                    System.out.println("\n-- Crear pedido --\n");

                    System.out.println("¿Número de cliente? ");
                    int numeroCliente = scanner.nextInt();
                    scanner.nextLine();

                    Ejercicio2 clientePedido = null;
                    for (Ejercicio2 Cliente : clientes) {
                        if (Cliente.getNumeroCliente() == numeroCliente) {
                            clientePedido = Cliente;
                            break;
                        }
                    }

                    if (clientePedido == null) {
                        System.out.println("Cliente no encontrado\n");
                        break;
                    }

                    Pedido pedido = new Pedido(clientePedido);
                    pedidos.add(pedido);

                    int opcionPedido = 0;

                    while (opcionPedido != 3) {
                        System.out.println("\n-- Pedido --\n");
                        System.out.println("1 - Agregar obra");
                        System.out.println("2 - Mostrar obras");
                        System.out.println("3 - Finalizar pedido");
                        System.out.print("Ingrese una opción: ");

                        opcionPedido = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcionPedido) {
                            case 1:
                                System.out.println("\n-- Obras --\n");
                                for (Obra obra : obras) {
                                    System.out.println(obra);
                                }
                                System.out.println();

                                System.out.print("¿Título de la obra? ");
                                String tituloObra = scanner.nextLine();

                                Obra obraPedido = null;
                                for (Obra obra : obras) {
                                    if (obra.getTitulo().equals(tituloObra)) {
                                        obraPedido = obra;
                                        break;
                                    }
                                }

                                if (obraPedido == null) {
                                    System.out.println("Obra no encontrada\n");
                                    break;
                                }

                                pedido.agregarObra(obraPedido);
                                System.out.println("Obra " + obraPedido + " añadida al pedido\n");
                                break;
                            case 2:
                                System.out.println("\n-- Obras --\n");
                                for (Obra obra : pedido.getObras()) {
                                    System.out.println(obra);
                                }
                                System.out.println();
                                break;
                            case 3:
                                System.out.println("\nPedido finalizado\n");
                                break;
                            default:
                                System.out.println("\nOpción inválida\n");
                                break;
                        }
                    }

                    break;
                case 5:
                    System.out.println("Mostrar pedidos");

                    for (Pedido Pedido : pedidos) {
                        System.out.println(Pedido);
                    }

                    break;



            }
        }
    }
}
