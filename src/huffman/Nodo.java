/*
 *  Universidad del Valle de Guatemala
 *  Algoritmos y estructura de datos 2014
 *  
 *  Autores:    Nancy Girón Muñoz - 13467
 *              Martín Meyer Ramazzini - 13043
 *              Alberto López Montenegro - 13181
 *  
 *  Adaptado de: Duane A. Bailey
 */

package huffman;

public class Nodo {
    int frecuencia;     /* Frecuencia del caracter*/
    char car;           /* Caracter asociado al nodo */

    /* Constructor frecuencia*/
    public Nodo(int frecuencia) {
        this.frecuencia = frecuencia;
    }

    /* Constructor caracter */
    public Nodo(char car) {
        this.car = car;
        this.frecuencia = 1;
    }

    /* Si los nodos representan el mismo caracter retorna un True*/
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Nodo other = (Nodo) obj;
        if (this.car != other.car) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Nodo{" + frecuencia + ":" + car + '}';
    }
}