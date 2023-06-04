package tallerarbol;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Queue;

public class Arbol {

    public Nodo raiz;

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
            System.out.println("contiene" + nodo.getInfo());
            return true;
        }

        return contieneRecursive(nodo.izq, numero) || contieneRecursive(nodo.der, numero);
    }

    /**
     * Dado el numero del nodo a borrar, vamos a recorrer el árbol hasta
     * encontrar dicho nodo y retornamos la clase Nodo.
     *
     * @param numero
     * @return Nodo
     */
    public Nodo encontrarNodo(int numero) {
        return encontrarNodoRecursive(raiz, numero);
    }

    public Nodo encontrarNodoRecursive(Nodo nodo, int numero) {

        if (nodo == null) {
            return null;
        }

        if (nodo.getInfo() == numero) {
            return nodo;
        }

        return encontrarNodoRecursive(nodo.izq, numero) != null ? encontrarNodoRecursive(nodo.izq, numero) : encontrarNodoRecursive(nodo.der, numero);
    }

    // Función que recorre el árbol hasta llegar a un numero dado, y retorna si
    // tiene hijos
    public boolean nodoTieneHijos(Nodo nodo) {
        return nodo.verificarHijos(nodo);
    }

    public Nodo deleteNode(Nodo raiz,int k) {

        // Base case
        if (raiz == null) {
            return raiz;
        }

        // Recursive calls for ancestors of
        // node to be deleted
        if (raiz.getInfo() > k) {
            System.out.println("key:" + raiz.getInfo());
            raiz.izq = deleteNode(raiz.izq, k);
            return raiz;
        } else if (raiz.getInfo() < k) {
            raiz.der = deleteNode(raiz.der, k);
            return raiz;
        }

        // We reach here when root is the node
        // to be deleted.
        // If one of the children is empty
        if (raiz.izq == null) {
            System.out.println("pasa aqui 2");
            Nodo temp = raiz.der;
            System.out.println("nodetemp");
            return temp;
        } else if (raiz.der == null) {
            Nodo temp = raiz.izq;
            return temp;
        } // If both children exist
        else {
            Nodo succParent = raiz;

            // Find successor
            Nodo succ = raiz.der;

            while (succ.izq != null) {
                succParent = succ;
                succ = succ.izq;
            }

            // Delete successor. Since successor
            // is always left child of its parent
            // we can safely make successor's right
            // right child as left of its parent.
            // If there is no succ, then assign
            // succ->right to succParent->right
            if (succParent != raiz) {
                succParent.izq = succ.der;
            } else {
                succParent.der = succ.der;
            }

            // Copy Successor Data to root
            raiz.setInfo(succ.getInfo());

            return raiz;
        }
    }
}
