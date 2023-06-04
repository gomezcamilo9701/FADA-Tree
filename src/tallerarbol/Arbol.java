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
    
    public Nodo getMinimumKey(Nodo curr)
    {
        while (curr.izq != null) {
            curr = curr.izq;
        }
        return curr;
    }

    public Nodo deleteNode(Nodo root, int key) {
        // puntero para almacenar el padre del nodo actual
        Nodo parent = null;

        // comienza con el nodo raíz
        Nodo curr = root;

        // busca la clave en el BST y establece su puntero principal
        while (curr != null && curr.getInfo() != key) {
            // actualiza el padre al nodo actual
            parent = curr;

            // si la clave dada es menor que el nodo actual, vaya al subárbol izquierdo;
            // de lo contrario, vaya al subárbol derecho
            if (key < curr.getInfo()) {
                curr = curr.izq;
            } else {
                curr = curr.der;
            }
        }

        // regresa si la clave no se encuentra en el árbol
        if (curr == null) {
            return root;
        }

        // Caso 1: el nodo a eliminar no tiene hijos, es decir, es un nodo hoja
        if (curr.izq == null && curr.der == null) {
            // si el nodo a eliminar no es un nodo raíz, establezca su
            // padre izquierdo/derecho hijo a nulo
            if (curr != root) {
                if (parent.izq == curr) {
                    parent.izq = null;
                } else {
                    parent.der = null;
                }
            } // si el árbol solo tiene un nodo raíz, configúrelo como nulo
            else {
                root = null;
            }
        } // Caso 2: el nodo a eliminar tiene dos hijos
        else if (curr.izq != null && curr.der != null) {
            // encuentra su nodo sucesor en orden
            Nodo successor = getMinimumKey(curr.der);

            // almacenar el valor del sucesor
            int val = successor.getInfo();

            // borra recursivamentemente el sucesor. Nótese que el sucesor
            // tendrá como máximo un hijo (hijo derecho)
            deleteNode(root, successor.getInfo());

            // copia el valor del sucesor al nodo actual
            curr.setInfo(val);
        } // Caso 3: el nodo a eliminar solo tiene un hijo
        else {
            // elige un nodo hijo
            Nodo child = (curr.izq != null) ? curr.izq : curr.der;

            // si el nodo a eliminar no es un nodo raíz, establezca su padre
            // a su hijo
            if (curr != root) {
                if (curr == parent.izq) {
                    parent.izq = child;
                } else {
                    parent.der = child;
                }
            } // si el nodo que se va a eliminar es un nodo raíz, establezca la raíz en el hijo
            else {
                root = child;
            }
        }

        return root;
    }

}
