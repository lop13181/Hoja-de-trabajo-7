// An abstract implementation of stacks.
// (c) 1998,2001 duane a. bailey

package structure;

/**
 * An abstract structure implementing features common to all 
 * Last-In, First-Out structures in this package.
 * Stacks are typically used to store the state of a recursively
 * solved problem.
 * The structure package provides several extensions of the AbstractStack class, 
 * each of which has its particular strengths and weaknesses.
 * <P>
 * Example usage:
 * <P>
 * To reverse a string using a stack, we would use the following:
 * <pre>
 * public static void main(String[] arguments)
 * {
 *     if(arguments.length > 0){
 *	   {@link AbstractStack} reverseStack = new {@link structure.StackList#StackList() StackList()};
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
 * @see Stack 
 * @see StackVector 
 * @see StackList 
 * @see StackArray
 * 
 * @version $Id: Stack.java,v 4.0 2000/12/27 21:21:47 bailey Exp bailey $
 * @author, 2001 duane a. bailey
 */
public abstract class AbstractStack extends AbstractLinear implements Stack 
{
    /**
     * Add an element from the top of the stack.
     *
     * @post item is added to stack
     *       will be popped next if no intervening add
     * 
     * @param item The element to be added to the stack top.
     */
    public void push(Object item)
    {
	add(item);
    }

    /**
     * Remove an element from the top of the stack.
     *
     * @pre stack is not empty
     * @post most recently added item is removed and returned
     * 
     * @return The item removed from the top of the stack.
     */
    public Object pop()
    {
	return remove();
    }

    /**
     * Fetch a reference to the top element of the stack.
     * @pre stack is not empty
     * @post top value (next to be popped) is returned
     * @deprecated Please use method get, rather than getFirst!
     * @return A reference to the top element of the stack.
     */
    public Object getFirst()
    {
	return get();
    }

    /**
     * Fetch a reference to the top element of the stack.
     * Provided for compatibility with java.util.Stack.
     * @pre stack is not empty
     * @post top value (next to be popped) is returned
     * 
     * @return A reference to the top element of the stack.
     */
    public Object peek()
    {
	return get();
    }
}
