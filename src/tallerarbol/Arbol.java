
package tallerarbol;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Queue;

public class Arbol {
    private Nodo raiz;
    
    public void insertar(int n)
    {
        if (raiz == null) {
            raiz = new Nodo(n);
        } else {
            raiz.insertar(new Nodo(n));
        }
    }
    
    public int altura()
    {
        if (raiz == null) {
            return 0;
        } else {
            return raiz.altura();
        }
    }
        
    public int tamaño()
    {
        if (raiz == null) {
            return 0;
        } else {
            return raiz.tamaño();
        }
    }
        
    public String EnOrden()
    {
        return (raiz == null) ? "" : raiz.EnOrden();
    }
    
    public void dibujar(Graphics dibujo)
    {
        if (raiz != null) {
            raiz.dibujarNodo(dibujo, 0, 0);
        }
    }
}
