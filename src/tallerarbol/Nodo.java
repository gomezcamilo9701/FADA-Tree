
package tallerarbol;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Queue;

public class Nodo {
    protected int info;  // key
        
    Nodo izq, der; // children
    
    // Nodo hijos[];  // n-arios
    Nodo padre;  
    
    int nivel, altura;
    
    Color color = Color.black;
    
    Nodo(int info) {
        this.info = info;
        izq = der = null;
        
        // Por defecto un nodo es la raiz
        nivel = 1;
    }

    public int getInfo() {
        return info;
    }
    
    public void setInfo(int newInfo){
        this.info = newInfo;
    }
    
    public int altura()
    {
        int  max = 0;     
        
        if (izq != null) max = izq.altura();        
        if (der != null && max < der.altura()) max = der.altura();
        
        return 1 + max;
    }
    
    public int tamaño()
    {
        int  tam = 1;     
        
        if (izq != null) tam += izq.tamaño();        
        if (der != null) tam += der.tamaño();
        
        return tam;
    }
    
    
    // T(n) = O(log(n))
    public void insertar(Nodo n) 
    {
        if (n.info < info) {
            if (izq == null) {
                izq = n;
            } else {
                izq.insertar(n);
            }
        } else {            
            if (der == null) {
                der = n;
            } else {
                der.insertar(n);
            }
        }
    }
    
    /**
     * VERIFICAR SI TIENE HIJOS
     * @return 
     */
    public boolean verificarHijos(Nodo nodo){
        //Dado un nodo tenemos que verificar si tiene hijos
        if (nodo.izq==null && nodo.der==null){
            System.out.println("No tiene hijos");
            return false;
            
        }
        System.out.println("Tiene hijos");
        return true;
            
    }
               
    public String EnOrden()
    {
        String salida = "";
                
        // Izquierdo
        if (izq != null) {
            salida += izq.EnOrden();
        }
        
        // Raiz
        salida += info + ", ";
        
        // Derecho
        if (der != null) {
            salida += der.EnOrden();
        }        
        
        return salida;
    }
    
    public void dibujarNodo(Graphics g, int x, int nivel)
    {
        int hor = (int)(250 / Math.pow(2,nivel+1));
        
        if (izq != null) {
            g.drawLine(265 + x, 40 * nivel + 30, 265 + x - hor, 40 * nivel + 40);
            izq.dibujarNodo(g, x - hor, nivel + 1);
        }
        
        g.drawOval(250 + x, 40 * nivel, 30, 30);
        g.drawString(Integer.toString(info), 262 + x, 40 * nivel + 20 );
        
        if (der != null) {
            g.drawLine(265 + x, 40 * nivel + 30, 265 + x + hor, 40 * nivel + 40);
            der.dibujarNodo(g, x + hor, nivel + 1);
        }        
    }
}
