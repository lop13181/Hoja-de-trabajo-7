/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package structure;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Jorge Luis Martínez
 */
public class BinaryTreeTest {
    BinaryTree<Integer> raíz, izq, der;
    int tamaño, altura, valorRaiz = 10;
    
    /**
     * Inicializa los elementos a utilizar antes de cada prueba.
     */
    @Before
    public void before(){
        izq = new BinaryTree<Integer>( 30 );
        der = new BinaryTree<Integer>( 50 );
        raíz = new BinaryTree<Integer>( valorRaiz, izq, der );
        tamaño = 3;
        altura = 1;
    }

    /**
     * Comprueba el método left.
     */
    @Test
    public void testLeft() {
        System.out.println("left");
        BinaryTree expResult = izq;
        BinaryTree result = raíz.left();
        assertEquals(expResult, result);
    }

    /**
     * Comprueba el método right.
     */
    @Test
    public void testRight() {
        System.out.println("right");
        BinaryTree expResult = der;
        BinaryTree result = raíz.right();
        assertEquals(expResult, result);
    }

    /**
     * Comprueba el método parent.
     */
    @Test
    public void testParent() {
        System.out.println("parent");
        BinaryTree expResult = raíz;
        BinaryTree result = izq.parent();
        assertEquals(expResult, result);
    }

    /**
     * Comprueba el método setLeft.
     */
    @Test
    public void testSetLeft() {
        System.out.println("setLeft");
        BinaryTree<Integer> newLeft = new BinaryTree<Integer>(100);
        raíz.setLeft(newLeft);
        
        assertNotSame(newLeft, izq);
    }

    /**
     * Comprueba el método setRight.
     */
    @Test
    public void testSetRight() {
        System.out.println("setRight");
        BinaryTree<Integer> newRight = new BinaryTree<Integer>(100);
        raíz.setLeft(newRight);
        
        assertNotSame(newRight, der);
    }

    /**
     * Comprueba el método size.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        int expResult = tamaño;
        int result = raíz.size();
        assertEquals(expResult, result);
    }

    /**
     * Comprueba el método root.
     */
    @Test
    public void testRoot() {
        System.out.println("root");
        BinaryTree expResult = raíz;
        BinaryTree result = der.root();
        assertEquals(expResult, result);
    }

    /**
     * Comprueba el método height.
     */
    @Test
    public void testHeight() {
        System.out.println("height");
        int expResult = altura;
        
        // Comprueba raíz
        int result = raíz.height();
        assertEquals(expResult, result);
    }

    /**
     * Test of depth method, of class BinaryTree.
     */
    @Test
    public void testDepth() {
        System.out.println("depth");
        int expResult = altura;
        int result = izq.depth();
        assertEquals(expResult, result);
    }

    /**
     * Comprueba el método isFull.
     */
    @Test
    public void testIsFull() {
        System.out.println("isFull");
        boolean expResult = true;
        
        // .. la raíz tiene que estar llena.
        boolean result = raíz.isFull();
        assertEquals(expResult, result);
    }

    /**
     * Comprueba el método isEmpty.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        boolean expResult = false;
        
        // .. la raíz no está vacía
        boolean result = raíz.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Comprueba el método isComplete.
     */
    @Test
    public void testIsComplete() {
        System.out.println("isComplete");
        
        // El árbol está completo
        boolean expResult = true;
        boolean result = raíz.isComplete();
        assertEquals(expResult, result);
    }

    /**
     * Comprueba el método isBalanced.
     */
    @Test
    public void testIsBalanced() {
        System.out.println("isBalanced");
        
        // El árbol está balanceado.
        boolean expResult = true;
        boolean result = raíz.isBalanced();
        assertEquals(expResult, result);
    }

    /**
     * Comprueba el método isLeftChild.
     */
    @Test
    public void testIsLeftChild() {
        System.out.println("isLeftChild");
        boolean expResult = true;
        boolean result = izq.isLeftChild();
        assertEquals(expResult, result);
    }

    /**
     * Comprueba el método isRightChild.
     */
    @Test
    public void testIsRightChild() {
        System.out.println("isRightChild");
        boolean expResult = true;
        boolean result = der.isRightChild();
        assertEquals(expResult, result);
    }

    /**
     * Comprueba el método value.
     */
    @Test
    public void testValue() {
        System.out.println("value");
        Object expResult = valorRaiz;
        Object result = raíz.value();
        assertEquals(expResult, result);
    }

    /**
     * Test of setValue method, of class BinaryTree.
     */
    @Test
    public void testSetValue() {
        System.out.println("setValue");
        Integer value = 12;
        raíz.setValue(value);
        assertNotSame(value, valorRaiz);
    }
}
