package app;

import java.util.Scanner;
import negocio.ArbolBinario;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArbolBinario<String> arbol = new ArbolBinario<>();
        int opcion;

        do {
            System.out.println("\n=== ARBOL BINARIO - DEPENDENCIAS UTA ===");
            System.out.println("1. Crear arbol inicial");
            System.out.println("2. Visualizar arbol");
            System.out.println("3. Numero de nodos");
            System.out.println("4. Numero de hojas");
            System.out.println("5. Altura");
            System.out.println("6. Grado de un nodo");
            System.out.println("7. Verificar si un nodo es hoja");
            System.out.println("8. Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1: /* TODO */ break;
                case 2: /* TODO */ break;
                case 3: /* TODO */ break;
                case 4: /* TODO */ break;
                case 5: /* TODO */ break;
                case 6: /* TODO */ break;
                case 7: /* TODO */ break;
                case 8: System.out.println("Saliendo..."); break;
                default: System.out.println("Opcion invalida");
            }
        } while (opcion != 8);

        sc.close();
    }
}