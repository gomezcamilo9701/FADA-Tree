/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallerarbol;

/**
 *
 * @author J.A Vargas
 */
public class Arbolv2 {
    
    
    char vector[] = new char[100];
    int aridad;
    
    
    // retornar el i-esimo hijo del nodo en la posicion x
    public char hijo(int x, int i) {
        return vector[aridad * x + i];
    }
    
    // retornar el padre del nodo x
    public char padre(int x){
        return vector[(int)(x - 1) / aridad];
    }
    
}
