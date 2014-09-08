/*
 *  Universidad del Valle de Guatemala
 *  Algoritmos y estructura de datos 2014
 *  
 *  Autores:    Nancy Girón Muñoz - 13467
 *              Martín Meyer Ramazzini - 13043
 *              Alberto López Montenegro - 13181
 *  
 *  main.java clase principal
 */

import huffman.Excepcion;
import huffman.Huffman;
import huffman.ArbolHuffman;
import java.util.HashMap;
import java.util.Scanner;

public class main {
    private static Scanner entrada;
    private static Huffman arbol;
    
    public static void main(String[] args) {
        
        /* Instrucciones para el usuario */
        System.out.println("El programa construye un árbol de Huffman dado un mensaje de entrada, conformado por una cadena de caracteres, muestra \n" +
        "los códigos que le corresponden a cada caracter y la frecuencia de ese caracter en el mensaje." );
        System.out.print("Ingrese un mensaje: ");
        
        /* Lee cada caracter del mensaje ingresado */
        entrada = new Scanner( System.in );
        String linea = entrada.nextLine();
        
        /* Crea un arbol para codificar el mensaje ingresado */
        arbol = new Huffman(linea);
        
        /* Imprime el menú en pantalla */
        boolean continuar = true;
        while( continuar ){
            System.out.println("");
            mostrarMenu();
            
            try {
                int opcion = entrada.nextInt();
                entrada.nextLine();
                
                /* Switch case para el menu */
                switch( opcion ){
                    /* Opción para codificar mensaje */
                    case 1:
                        codificarFrase();
                        break;
                    /* Opción para decodificar mensaje */
                    case 2:
                        decodificarFrase();
                        break;
                    /* Opción para mostar la frecuencia de cada caracter en el mensaje */
                    case 3:
                        mostrarFrecuencias();
                        break;
                    /* Opción para salir del programa */
                    case 4:
                        continuar = false;
                        break;
                }
                
                /* tecla enter para continuar con el menu */
                System.out.print("\nPara continuar presione ENTER ");
                entrada.nextLine();
                
            } 
            catch (Excepcion e){
                System.out.println("¡Error!" + e.getMessage() );
                entrada.nextLine();
            }
            catch (Exception e) {
                System.out.println("¡Error! Ingrese nuevamente un numero");
                entrada.nextLine();
            }
        }
    }

    /* Metodo para el menu que se imprimira en pantalla */
    private static void mostrarMenu() {
        
        System.out.println("Eliga una opcíon: ");
        System.out.println("1. Codificar una frase");
        System.out.println("2. Decodificar una frase");
        System.out.println("3. Mostrar frecuencias de cada caracter.");
        System.out.println("4. Salir");
    }

    /* Codificará el mensaje ingresado por el usuario */
    private static void codificarFrase() throws Excepcion{
        // Pide la frase
        System.out.println("\nCodificar mensaje: ");
        String codificado = arbol.codificarFrase( entrada.nextLine() );
        System.out.println("\tMensaje codificado: " + codificado);
    }

    /* Decodificará el mensaje ingresado por el usuario */
    private static void decodificarFrase() throws Excepcion{
        System.out.println("\nDecodificar mensaje: ");
        String decodificado = arbol.decodificarFrase( entrada.nextLine() );
        System.out.println("\tMensaje decodificado: " + decodificado );
    }

    /* Mostrara la frecuencia con que se repite cada caracter en el mensaje */
    private static void mostrarFrecuencias() {
        ArbolHuffman arbolHuffman = arbol.obtenerArbol();
        arbolHuffman.print();
    }
}