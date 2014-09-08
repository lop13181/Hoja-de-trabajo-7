/*
 *  Universidad del Valle de Guatemala
 *  Algoritmos y estructura de datos 2014
 *  
 *  Autores:    Nancy Girón Muñoz - 13467
 *              Martín Meyer Ramazzini - 13043
 *              Alberto López Montenegro - 13181
 *  
 *  Excepcion.java servira para mostrar el mensaje de excepcion si
 *  la cadena ingresada no pertenece al arbol Huffman escogido.
 */

package huffman;

public class Excepcion extends Exception {


    public Excepcion() {
        super( "El arbol Huffman utilizado no funciona con el mensaje que ingresó anteriormente... " );
    }

    public Excepcion(String msg) {
        super(msg);
    }
}