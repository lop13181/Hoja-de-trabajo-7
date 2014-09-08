/*
 *  Universidad del Valle de Guatemala
 *  Algoritmos y estructura de datos 2014
 *  
 *  Autores:    Nancy Girón Muñoz - 13467
 *              Martín Meyer Ramazzini - 13043
 *              Alberto López Montenegro - 13181
 *  
 *  Huffman.java contiene clases que tiene el objetivo de codificar y decodificar
 *  los mensajes ingresados por el usuario
 */

package huffman;

/* paquete structure */
import structure.BinaryTree;
import structure.List;
import structure.SinglyLinkedList;
import structure.VectorHeap;

import java.util.HashMap;

public class Huffman {
    private ArbolHuffman arbol;

    public Huffman( String frase ){
        /* Introduce cada caracter en un nodo creado */
        List<Nodo> frecuencias = new SinglyLinkedList<Nodo>();
        for (char caracter : frase.toCharArray()) {
            /* En la lista busca el nodo nuevo */
            Nodo nodoCar = new Nodo(caracter);
            Nodo elemento = frecuencias.remove(nodoCar);
            
            if(elemento == null){
                /* En la lista se crea un nodo nuevo */
                frecuencias.addFirst(nodoCar);
            } 
            else {
                /* Se inserta el nodo en la lista luego de aumentar su frecuencia */
                elemento.frecuencia++;
                frecuencias.addFirst(elemento);
            }
        }
        
        /* Para los heaps es creado una nueva foresta */
        VectorHeap<ArbolHuffman> foresta = new VectorHeap<ArbolHuffman>();
        for(Nodo n : frecuencias){
            foresta.add(new ArbolHuffman(n));
        }
        
        /* Si alguno de los nodos se mantiene se mezclan */
        while(foresta.size() > 1){
            /* Obtiene los dos arboles siguientes */
            ArbolHuffman menor1 = foresta.remove();
            ArbolHuffman menor2 = foresta.remove();
            
            /* Ingresa los nuevos arboles a la foresta y los mezcla*/
            ArbolHuffman mezcla = new ArbolHuffman(menor1, menor2);
            foresta.add(mezcla);
        }
        arbol = foresta.getFirst();
    }

    /* A partir de uno ya existente, crea un arbol de Huffman */
    public Huffman(ArbolHuffman arbol) {
        this.arbol = arbol;
    }
    
    /* Utilizando el arbol dado codifica el mensaje */
    public String codificarFrase( String frase ) throws Excepcion{
        /* Valida la cadena de caracteres */
        if( frase.isEmpty() )
            return "";
        
        /* Utiliza los codigos de los strings para decodificar el mensaje */
        HashMap<Character, String> mapa = arbol.generarMapaCodificacion();
        String codificado = "";
        
        for( char caracter: frase.toCharArray() ){
            String codigo = mapa.get(caracter);
            if( codigo == null )
                throw new Excepcion();
            
            codificado += codigo;
        }
        return codificado;
    }
    
    /* Utilizando el arbol dado decodifica un mensaje */
    public String decodificarFrase( String frase ) throws Excepcion{
        /* Valida la cadena de caracteres */
        if( frase.isEmpty())
            return "";
        
        /* Para decodificar cada caracter rrecorre todo el arbol de huffman*/
        String decodificado = "";
        BinaryTree<Nodo> raíz = arbol.obtenerArbol();
        
        for( char caracter: frase.toCharArray() ){
            /* Recorre el arbol en base al caracter actual */
            if( caracter == '0' ){
                raíz = raíz.left();
            } else if( caracter == '1' ) {
                raíz = raíz.right();
            } else
                throw new Excepcion();
            
            /* Verifica si la parte actual del arbol corresponde a un caracter */
            if( raíz.left().isEmpty() && raíz.right().isEmpty() ){
                decodificado += raíz.value().car;
                raíz = arbol.obtenerArbol();
            }
        }
        
        /* Verificación final. Para saber que no sobraron caracteres */
        if( raíz != arbol.obtenerArbol() )
            throw new Excepcion();
        
        return decodificado;
    }
    
    /* Devuelve el arbol de Huffman asociado */
    public ArbolHuffman obtenerArbol(){
        return arbol;
    }
    
    /* Devuelve el diccionario de codificación asociado al arbol de Huffman */
    public HashMap<Character, String> obtenerCodificacion(){
        return arbol.generarMapaCodificacion();
    }
}