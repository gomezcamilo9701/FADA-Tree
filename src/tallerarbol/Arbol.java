package tallerarbol;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Queue;

public class Arbol {

    private Nodo raiz;

    public void insertar(int n) {
        if (raiz == null) {
            raiz = new Nodo(n);
        } else {
            raiz.insertar(new Nodo(n));
        }
    }

    public int altura() {
        if (raiz == null) {
            return 0;
        } else {
            return raiz.altura();
        }
    }

    public int tamaño() {
        if (raiz == null) {
            return 0;
        } else {
            return raiz.tamaño();
        }
    }

    public String EnOrden() {
        return (raiz == null) ? "" : raiz.EnOrden();
    }

    public void dibujar(Graphics dibujo) {
        if (raiz != null) {
            raiz.dibujarNodo(dibujo, 0, 0);
        }
    }

    //Método que para el contiene, verificar si el numero está en el array.
    public boolean contiene(int numero) {
        return contieneRecursive(raiz, numero);
    }

    private boolean contieneRecursive(Nodo nodo, int numero) {
        if (nodo == null) {
            return false;
        }

        if (numero == nodo.getInfo()) {
            return true;
        }

        return contieneRecursive(nodo.izq, numero) || contieneRecursive(nodo.der, numero);
    }
}
