package negocio;

import modelo.Nodo;

public class ArbolBinario<T> {
    private Nodo<T> raiz;

    public void crearRaiz(T dato) { /* TODO */ }

    public boolean agregarIzquierdo(Nodo<T> padre, T dato) { /* TODO */ return false; }

    public boolean agregarDerecho(Nodo<T> padre, T dato) { /* TODO */ return false; }

    public int contarNodos() { /* TODO: recursivo */ return 0; }

    public int contarHojas() { /* TODO: recursivo */ return 0; }

    public int altura() { /* TODO: recursivo, en aristas (vacío = -1) */ return -1; }

    public boolean esVacio() { /* TODO */ return true; }

    public void mostrarArbol() { /* TODO */ }

    public Nodo<T> getRaiz() { return raiz; }
}