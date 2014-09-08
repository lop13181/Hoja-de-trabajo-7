/*
 *  Universidad del Valle de Guatemala
 *  Algoritmos y estructura de datos 2014
 *  
 *  Autores:    Nancy Girón Muñoz - 13467
 *              Martín Meyer Ramazzini - 13043
 *              Alberto López Montenegro - 13181
 *  
 *  ArbolHuffman.java implementa un arbol de Huffman
 */

package huffman;

import structure.BinaryTree;
import java.util.HashMap;

public class ArbolHuffman implements Comparable<ArbolHuffman>{
    private BinaryTree<Nodo> raiz;
    private int pesoTotal;
    
    /* Constructor con nodo */
    public ArbolHuffman(Nodo e){
        raiz = new BinaryTree<Nodo>(e);
        pesoTotal = e.frecuencia;
    }
    
    /* A partir de la mezcla de dos construye un nuevo arbol */
    public ArbolHuffman(ArbolHuffman izq, ArbolHuffman der){
        pesoTotal = izq.pesoTotal + der.pesoTotal;
        Nodo r = new Nodo(pesoTotal);
        
        raiz = new BinaryTree<Nodo>(r, izq.raiz, der.raiz);
    }

    /* Crea un mapa con la codificación de cada uno de los caracteres */
    public HashMap<Character, String> generarMapaCodificacion(){
        HashMap<Character,String> mapa = new HashMap<Character, String>();
        
        generarMapaCodificacion(raiz, "", mapa);
        return mapa;
    }
    
    /* Con la codificación del arbol dado crea el mapa */
    protected void generarMapaCodificacion(BinaryTree arbol, String representacion, HashMap<Character, String> mapa){
        /* Por cada uno de los nodos del arbol hace una iteracion */
        if(arbol.left().isEmpty() && arbol.right().isEmpty()){
            /* Hoja */
            Nodo n = (Nodo)arbol.value();
            mapa.put(n.car, representacion);
        } 
        else {
            if( !arbol.left().isEmpty() )
                generarMapaCodificacion( arbol.left(), representacion + "0",mapa);
            if( !arbol.right().isEmpty() )
                generarMapaCodificacion( arbol.right(), representacion + "1",mapa);
        }
    }
    
    /* En relación a su peso compara dos arboles de Huffman */
    @Override
    public int compareTo(ArbolHuffman otro) {
        return this.pesoTotal - otro.pesoTotal;
    }

    /* Si dos objetos representan al mismo objeto los compara */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ArbolHuffman other = (ArbolHuffman) obj;
        if (this.raiz != other.raiz && (this.raiz == null || !this.raiz.equals(other.raiz))) {
            return false;
        }
        if (this.pesoTotal != other.pesoTotal) {
            return false;
        }
        return true;
    }
    
    /* Devuelve el arbol binario asociado al arbol de Huffman */
    BinaryTree<Nodo> obtenerArbol(){
        return raiz;
    }

    /* La codificación representada por el arbol la imprime*/
    public void print() {
        print( raiz, "" );
    }
    
    /* Con el prefijo dado por la representación imprime los strings asociados a los caracteres en el arbol */
    protected void print(BinaryTree<Nodo> arbol, String representacion){
        // Itera por cada uno de los nodos del arbol
        if(arbol.left().isEmpty() && arbol.right().isEmpty()){
            /* Hoja */
            Nodo n = arbol.value();
            System.out.println("Codificación de " + n.car + " es " + representacion + "(frecuencia = " + n.frecuencia + ")");
        } 
        else {
            if(!arbol.left().isEmpty())
                print(arbol.left(), representacion + "0");
            if(!arbol.right().isEmpty())
                print(arbol.right(), representacion + "1");
        }
    }
}