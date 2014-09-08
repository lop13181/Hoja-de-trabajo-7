/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package huffman;

import java.util.HashMap;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Jorge Luis Martínez
 */
public class HuffmanTest {
    
    public HuffmanTest() {
    }

    /**
     * Prueba la correcta codificación y decodificación de una frase.
     */
    @Test
    public void testCodificarFrase_Bien() throws Exception {
        System.out.println("codificarFrase_Bien");
        String frase = "Esta es una frase de prueba para codificar.";
        Huffman huffman = new Huffman( frase );
        
        String codificado = huffman.codificarFrase(frase);
        String decodificado = huffman.decodificarFrase(codificado);
        
        assertEquals(decodificado, frase);
    }
    
    /**
     * Prueba la correcta codificación y decodificación de una frase.
     * Sin embargo, la frase es generada usando el mapa de codificación.
     */
    @Test
    public void testCodificarFraseGenerada_Bien() throws Exception {
        System.out.println("codificarFraseGenerada_Bien");
        String frase = "Esta es una frase de prueba para codificar.";
        Huffman huffman = new Huffman( frase );
        
        // Se genera una frase a partir del árbol de codificación
        String codificado = "";
        String fraseGenerada = "";
        HashMap<Character, String> diccionario = huffman.obtenerCodificacion();
        for (Character caracter : diccionario.keySet()) {
            fraseGenerada += caracter;
            codificado += diccionario.get(caracter);
        }
        
        String decodificado = huffman.decodificarFrase(codificado);
        assertEquals(decodificado, fraseGenerada);
    }
    
    /**
     * Comprueba que una frase que no se codifique con los caracteres del
     * árbol falle.
     */
    @Test(expected=Excepcion.class)
    public void testCodificarFrase_Mal() throws Exception {
        System.out.println("codificarFrase_Mal");
        String frase = "Esta es una frase de prueba para codificar.";
        Huffman huffman = new Huffman( frase );
        
        String frasePrueba = "El caracter z no aparece en la frase";
        String codificado = huffman.codificarFrase( frasePrueba );
        String decodificado = huffman.decodificarFrase(codificado);
        
        assertEquals(decodificado, frasePrueba);
    }
    
    /**
     * Comprueba que no se pueda codificar una frase mal codificada.
     */
    @Test(expected=Excepcion.class)
    public void testCodificarFraseGenerada_Mal() throws Exception {
        System.out.println("codificarFraseGenerada_Mal");
        String frase = "Esta es una frase de prueba para codificar.";
        Huffman huffman = new Huffman( frase );
        
        // Se genera una frase a partir del árbol de codificación
        String codificado = "";
        String fraseGenerada = "";
        HashMap<Character, String> diccionario = huffman.obtenerCodificacion();
        for (Character caracter : diccionario.keySet()) {
            fraseGenerada += caracter;
            codificado += diccionario.get(caracter);
        }
        
        // .. agrega un caracter extra al codificado para que esté mal generada
        codificado += '1';
        
        String decodificado = huffman.decodificarFrase(codificado);
        assertEquals(decodificado, fraseGenerada);
    }
}
