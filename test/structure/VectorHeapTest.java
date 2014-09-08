/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package structure;
import java.util.Random;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Jorge Luis Martínez
 */
public class VectorHeapTest {
    VectorHeap<Integer> heap;
    int tamañoInicial = 10;
    int menor;
    
    /**
     * Crea la instancia del heap y la rellena con valores de prueba.
     */
    @Before
    public void before(){
        Random generador = new Random();
        heap = new VectorHeap<Integer>();
        menor = Integer.MAX_VALUE;
        
        for( int n = 0; n != tamañoInicial; ++n ){
            int numero = generador.nextInt();
            menor = menor < numero ? menor : numero;
            heap.add(menor);
        }
    }
    
    /**
     * Prueba de getFirst. Comprueba que un objeto insertado y eliminado
     * del principio sea el mismo.
     */
    @Test
    public void testGetFirst() {
        System.out.println("getFirst");
        Object expResult = menor;
        
        Object result = heap.getFirst();
        assertEquals(expResult, result);
    }

    /**
     * Prueba que se retiren elementos con Remove.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        Object expResult = menor;
        
        Object result = heap.remove();
        assertEquals(expResult, result);
    }

    /**
     * Comprueba que se agreguen elementos con el método add.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Integer valor = Integer.MIN_VALUE;
        heap.add(valor);
        
        Integer primero = heap.remove();
        assertEquals( primero, valor );
    }

    /**
     * Comprueba el funcionamiento de isEmpty.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        
        // Se vacía el heap
        for( int n = 0; n != tamañoInicial; ++n )
            heap.remove();
        
        // Se comprueba que esté vacío
        boolean expResult = true;
        boolean result = heap.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Comprueba el uso de size.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        int expResult = tamañoInicial;
        int result = heap.size();
        assertEquals(expResult, result);
    }

    /**
     * Comprueba el método clear.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
         // Se vacía el heap
        heap.clear();
        
        // Se comprueba que esté vacío
        boolean expResult = true;
        boolean result = heap.isEmpty();
        assertEquals(expResult, result);
    }
}