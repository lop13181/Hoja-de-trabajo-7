// The interface for stacks.
// (c) 1998, 2001 duane a. bailey
package structure;
/**
 * An interface describing a Last-In, First-Out structure.
 * Stacks are typically used to store the state of a recursively
 * solved problem.
 * The structure package provides several implementations of the Stack interface, 
 * each of which has its particular strengths and weaknesses.
 *  
 * <P>
 * Example usage:
 * <P>
 * To reverse a string using a stack, we would use the following:
 * <pre>
 * public static void main(String[] arguments)
 * {
 *     if(arguments.length > 0){
 *	   {@link Stack} reverseStack = new {@link structure.StackList#StackList() StackList()};
 *	   String s = arguments[0];
 *	    
 *	   for(int i=0; i < s.length(); i++){
 *	       reverseStack.{@link #push(Object) push(new Character(s.charAt(i)))};
 *	   }
 *
 *	   while(!reverseStack.{@link #empty()}){
 *	       System.out.print(reverseStack.{@link #pop()});
 *	   }
 *
 *	   System.out.println();
 *     }
 * }
 * </pre>
 * @version $Id: Stack.java,v 4.0 2000/12/27 21:21:47 bailey Exp bailey $
 * @author, 2001 duane a. bailey
 */
public interface Stack extends Linear
{
    /**
     * Add an element from the top of the stack.
     *
     * @post item is added to stack
     *       will be popped next if no intervening add
     * 
     * @param item The element to be added to the stack top.
     * @see #push
     */
    public void add(Object item);

    /**
     * Add an element to top of stack.
     *
     * @post item is added to stack
     *       will be popped next if no intervening push
     * 
     * @param item The value to be added to the top of the stack.
     */
    public void push(Object item);

    /**
     * Remove an element from the top of the stack.
     *
     * @pre stack is not empty
     * @post most recently added item is removed and returned
     * 
     * @return The item removed from the top of the stack.
     * @see #pop
     */
    public Object remove();

    /**
     * Remove an element from the top of the stack.
     *
     * @pre stack is not empty
     * @post most recently pushed item is removed and returned
     * 
     * @return A reference to the removed element.
     */
    public Object pop();

    /**
     * Fetch a reference to the top element of the stack.
     *
     * @pre stack is not empty
     * @post top value (next to be popped) is returned
     * 
     * @return A reference to the top element of the stack.
     */
    public Object get();

    /**
     * Fetch a reference to the top element of the stack.
     *
     * @pre stack is not empty
     * @post top value (next to be popped) is returned
     * 
     * @return A reference to the top element of the stack.
     */
    public Object getFirst();

    /**
     * Fetch a reference to the top element of the stack.
     *
     * @pre stack is not empty
     * @post top value (next to be popped) is returned
     * 
     * @return A reference to the top element of the stack.
     */
    public Object peek();

    /**
     * Returns true iff the stack is empty.  Provided for
     * compatibility with java.util.Vector.empty.
     *
     * @post returns true if and only if the stack is empty
     * 
     * @return True iff the stack is empty.
     */
    public boolean empty();

    /**
     * Returns the number of elements in the stack.
     *
     * @post returns the number of elements in the stack
     * @return number of elements in stack.
     */
    public int size();
}
