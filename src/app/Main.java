package app;

import java.util.Scanner;
import modelo.Nodo;
import negocio.ArbolBinario;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static ArbolBinario<String> arbol = new ArbolBinario<>();

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Opcion: ");

            switch (opcion) {
                case 1:
                    arbol = crearArbolInicial();
                    System.out.println("Arbol inicial creado correctamente.");
                    break;
                case 2:
                    arbol.mostrarArbol();
                    break;
                case 3:
                    System.out.println("Numero de nodos: " + arbol.contarNodos());
                    break;
                case 4:
                    System.out.println("Numero de hojas: " + arbol.contarHojas());
                    break;
                case 5:
                    System.out.println("Altura (aristas): " + arbol.altura());
                    break;
                case 6:
                    consultarGrado();
                    break;
                case 7:
                    verificarHoja();
                    break;
                case 8:
                    ejecutarCasosDePrueba();
                    break;
                case 9:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion invalida. Intente de nuevo.");
            }
        } while (opcion != 9);

        sc.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n=== ARBOL BINARIO - DEPENDENCIAS UTA ===");
        System.out.println("1. Crear arbol inicial");
        System.out.println("2. Visualizar arbol");
        System.out.println("3. Consultar numero de nodos");
        System.out.println("4. Consultar numero de hojas");
        System.out.println("5. Consultar altura");
        System.out.println("6. Consultar grado de un nodo");
        System.out.println("7. Verificar si un nodo es hoja");
        System.out.println("8. Ejecutar casos de prueba");
        System.out.println("9. Salir");
    }

    /** Construye el árbol del enunciado: 9 nodos, 5 hojas, altura 3. */
    private static ArbolBinario<String> crearArbolInicial() {
        ArbolBinario<String> a = new ArbolBinario<>();
        a.crearRaiz("UNIVERSIDAD");
        Nodo<String> universidad = a.getRaiz();

        a.agregarIzquierdo(universidad, "FISEI");
        a.agregarDerecho(universidad, "DIDE");

        Nodo<String> fisei = universidad.getIzquierdo();
        Nodo<String> dide = universidad.getDerecho();

        a.agregarIzquierdo(fisei, "SOFTWARE");
        a.agregarDerecho(fisei, "TI");

        a.agregarIzquierdo(dide, "INVEST.");
        a.agregarDerecho(dide, "VINCULACION");

        Nodo<String> software = fisei.getIzquierdo();
        a.agregarIzquierdo(software, "NIVEL1");
        a.agregarDerecho(software, "NIVEL3");

        return a;
    }

    /** Pide un nombre y lo busca en el árbol. */
    private static Nodo<String> pedirNodo() {
        if (arbol.esVacio()) {
            System.out.println("El arbol esta vacio. Primero cree el arbol (opcion 1).");
            return null;
        }
        System.out.print("Nombre de la dependencia: ");
        String nombre = sc.nextLine().trim().toUpperCase();
        Nodo<String> nodo = arbol.buscar(nombre);
        if (nodo == null) {
            System.out.println("No existe la dependencia '" + nombre + "' en el arbol.");
        }
        return nodo;
    }

    private static void consultarGrado() {
        Nodo<String> nodo = pedirNodo();
        if (nodo != null) {
            System.out.println("Grado de " + nodo.getDato() + ": " + nodo.grado());
        }
    }

    private static void verificarHoja() {
        Nodo<String> nodo = pedirNodo();
        if (nodo != null) {
            if (nodo.esHoja()) {
                System.out.println(nodo.getDato() + " SI es una hoja.");
            } else {
                System.out.println(nodo.getDato() + " NO es una hoja (tiene "
                        + nodo.grado() + " hijo(s)).");
            }
        }
    }

    /** Los 5 casos de prueba obligatorios del enunciado. */
    private static void ejecutarCasosDePrueba() {
        System.out.println("\n----- CASO 1: Arbol vacio -----");
        ArbolBinario<String> vacio = new ArbolBinario<>();
        System.out.println("Nodos: " + vacio.contarNodos() + " (esperado 0)");
        System.out.println("Altura: " + vacio.altura() + " (esperado -1)");

        System.out.println("\n----- CASO 2: Arbol con un solo nodo -----");
        ArbolBinario<String> unNodo = new ArbolBinario<>();
        unNodo.crearRaiz("UNIVERSIDAD");
        System.out.println("Hojas: " + unNodo.contarHojas() + " (esperado 1)");
        System.out.println("Altura: " + unNodo.altura() + " (esperado 0)");

        System.out.println("\n----- CASO 3: Arbol inicial -----");
        ArbolBinario<String> inicial = crearArbolInicial();
        inicial.mostrarArbol();
        System.out.println("Nodos: " + inicial.contarNodos() + " (esperado 9)");
        System.out.println("Hojas: " + inicial.contarHojas() + " (esperado 5)");
        System.out.println("Altura: " + inicial.altura() + " (esperado 3)");

        System.out.println("\n----- CASO 4: Insertar en posicion ocupada -----");
        Nodo<String> fisei = inicial.buscar("FISEI");
        boolean resultado = inicial.agregarIzquierdo(fisei, "NUEVA");
        System.out.println("Insercion realizada: " + resultado + " (esperado false)");

        System.out.println("\n----- CASO 5: Grado de FISEI y SOFTWARE -----");
        System.out.println("Grado de FISEI: " + fisei.grado() + " (esperado 2)");
        System.out.println("Grado de SOFTWARE: " + inicial.buscar("SOFTWARE").grado() + " (esperado 2)");
    }

    /** Lee un entero sin que el programa se caiga si el usuario escribe letras. */
    private static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String linea = sc.nextLine().trim();
            try {
                return Integer.parseInt(linea);
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un numero.");
            }
        }
    }
}