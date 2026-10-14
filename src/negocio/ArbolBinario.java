package negocio;

import modelo.Nodo;

/**
 * Árbol binario genérico.
 * Las operaciones de conteo, altura, búsqueda y visualización son recursivas.
 */
public class ArbolBinario<T> {
    private Nodo<T> raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    // ===================== INSERCIÓN =====================

    /** Crea el nodo raíz del árbol. */
    public void crearRaiz(T dato) {
        raiz = new Nodo<>(dato);
    }

    /** Agrega un hijo izquierdo al padre. Devuelve false si la posición ya está ocupada. */
    public boolean agregarIzquierdo(Nodo<T> padre, T dato) {
        if (padre == null) {
            System.out.println("Error: el nodo padre no existe.");
            return false;
        }
        if (padre.getIzquierdo() != null) {
            System.out.println("Error: " + padre.getDato() + " ya tiene hijo izquierdo ("
                    + padre.getIzquierdo().getDato() + ").");
            return false;
        }
        padre.setIzquierdo(new Nodo<>(dato));
        return true;
    }

    /** Agrega un hijo derecho al padre. Devuelve false si la posición ya está ocupada. */
    public boolean agregarDerecho(Nodo<T> padre, T dato) {
        if (padre == null) {
            System.out.println("Error: el nodo padre no existe.");
            return false;
        }
        if (padre.getDerecho() != null) {
            System.out.println("Error: " + padre.getDato() + " ya tiene hijo derecho ("
                    + padre.getDerecho().getDato() + ").");
            return false;
        }
        padre.setDerecho(new Nodo<>(dato));
        return true;
    }

    // ===================== CONSULTAS RECURSIVAS =====================

    /** Número total de nodos. */
    public int contarNodos() {
        return contarNodos(raiz);
    }

    private int contarNodos(Nodo<T> nodo) {
        if (nodo == null) {
            return 0;                                   // caso base
        }
        return 1 + contarNodos(nodo.getIzquierdo()) + contarNodos(nodo.getDerecho());
    }

    /** Número de hojas (nodos sin hijos). */
    public int contarHojas() {
        return contarHojas(raiz);
    }

    private int contarHojas(Nodo<T> nodo) {
        if (nodo == null) {
            return 0;                                   // caso base 1
        }
        if (nodo.esHoja()) {
            return 1;                                   // caso base 2
        }
        return contarHojas(nodo.getIzquierdo()) + contarHojas(nodo.getDerecho());
    }

    /** Altura en aristas: árbol vacío = -1, un solo nodo = 0. */
    public int altura() {
        return altura(raiz);
    }

    private int altura(Nodo<T> nodo) {
        if (nodo == null) {
            return -1;                                  // caso base
        }
        int alturaIzq = altura(nodo.getIzquierdo());
        int alturaDer = altura(nodo.getDerecho());
        return 1 + Math.max(alturaIzq, alturaDer);
    }

    /** Verifica si el árbol está vacío. */
    public boolean esVacio() {
        return raiz == null;
    }

    /** Busca un nodo por su dato. Devuelve null si no existe. */
    public Nodo<T> buscar(T dato) {
        return buscar(raiz, dato);
    }

    private Nodo<T> buscar(Nodo<T> nodo, T dato) {
        if (nodo == null) {
            return null;                                // no encontrado
        }
        if (nodo.getDato().equals(dato)) {
            return nodo;                                // encontrado
        }
        Nodo<T> encontrado = buscar(nodo.getIzquierdo(), dato);
        if (encontrado != null) {
            return encontrado;
        }
        return buscar(nodo.getDerecho(), dato);
    }

    // ===================== VISUALIZACIÓN =====================

    /** Muestra el árbol con sangría según el nivel de cada nodo. */
    public void mostrarArbol() {
        if (esVacio()) {
            System.out.println("(arbol vacio)");
            return;
        }
        mostrarArbol(raiz, "", true, true);
    }

    private void mostrarArbol(Nodo<T> nodo, String prefijo, boolean esUltimo, boolean esRaiz) {
        if (nodo == null) {
            return;
        }
        if (esRaiz) {
            System.out.println(nodo.getDato());
        } else {
            System.out.println(prefijo + (esUltimo ? "\\-- " : "+-- ") + nodo.getDato());
        }
        String nuevoPrefijo = esRaiz ? "" : prefijo + (esUltimo ? "    " : "|   ");

        Nodo<T> izq = nodo.getIzquierdo();
        Nodo<T> der = nodo.getDerecho();
        if (izq != null) {
            mostrarArbol(izq, nuevoPrefijo, der == null, false);
        }
        if (der != null) {
            mostrarArbol(der, nuevoPrefijo, true, false);
        }
    }

    public Nodo<T> getRaiz() {
        return raiz;
    }
}