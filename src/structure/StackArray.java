// An implementation of stacks, using vectors.
// (c) 1998, 2001 duane a. bailey

package structure;
import java.util.Iterator;

/**
 * An implementation of a stack, based on array.  The head of the
 * stack is stored in the first position of the array, allowing the stack to grow
 * and shrink in constant time. This stack implementation is ideal for 
 * applications that require a stack with a known maximum size that expands 
 * in constant time.
 * <P>
 * Example usage:
 * <P>
 * To reverse a string, we would use the following:
 * <pre>
 * public static void main(String[] arguments)
 * {
 *     if(arguments.length > 0){
 *         {@link StackArray} reverseStack = new {@link #StackArray(int) StackArray(arguments[0].length())};
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
 * @see AbstractStack
 * @version $Id: StackList.java,v 4.0 2000/12/27 21:21:47 bailey Exp bailey $
 * @author, 2001 duane a. bailey
 */
public class StackArray extends AbstractStack implements Stack
{
    /**
     * An index to the top element of the stack.
     */
    protected int top;
    /**
     * The array of value references.  Top of the stack
     * is higher in array.
     */
    protected Object data[];
    /**
     * Construct a stack capable of holding at least size elements.
     *
     * @post an empty stack with initial capacity of size is created
     * 
     * @param size The maximum size of the stack.
     */
    public StackArray(int size)
    {
 	data = new Object[size];
	clear();
    }

    /**
     * Remove all elements from the stack.
     *
     * @post removes all elements from stack
     */
    public void clear()
    {
	top = -1;
    }

    /**
     * Add a value to the top of the stack.
     *
     * @post adds an element to stack;
     *       Will be next element popped if no intervening push
     * 
     * @param item The value to be added.
     * @see #push
     */
    public void add(Object item)
    {
	Assert.pre(!isFull(),"Stack is not full.");
	top++;
	data[top] = item;
    }	 

    /**
     * Remove a value from the top of the stack.
     *
     * @pre stack is not empty
     * @post removes and returns the top element from stack;
     * 
     * @return The value removed from the top of the stack.
     * @see #pop
     */
    public Object remove()
    {
	Assert.pre(!isEmpty(),"Stack is not empty.");
	Object result = data[top];
	data[top] = null;
	top--;
	return result;
    }

    /**
     * Get a reference to the top value in the stack.
     *
     * @pre stack is not empty
     * @post returns the top element (most recently pushed) from stack
     * 
     * @return A reference to the top element of the top of the stack.
     */
    public Object get()
    {
	// raise an exception if stack is already empty
	Assert.pre(!isEmpty(),"Stack is not empty.");
	return data[top];
    }

    public Iterator iterator()
    {
	return new ArrayIterator(data,0,size());
    }

    /**
     * Determine the number of elements in the stack.
     *
     * @post returns the size of the stack
     * 
     * @return The number of values within the stack.
     */
    public int size()
    {
	return top+1;
    }

    /**
     * Determine if the stack is empty.
     *
     * @post returns true iff the stack is empty
     * 
     * @return True iff the stack is empty.
     * @see #empty
     */
    public boolean isEmpty()
    {
        return size() == 0;
    }

    /**
     * Determine if the stack is full.
     *
     * @post returns true iff the stack is empty
     * 
     * @return True iff there is no more room in the stack.
     */
    public boolean isFull()
    {
        return top == (data.length-1);
    }

    /**
     * Construct a string representation of the stack.
     *
     * @post returns a string representation of stack
     * 
     * @return A string representing the stack.
     */
    public String toString()
    {
	StringBuffer sb = new StringBuffer();
	int i;
	sb.append("<StackArray: ");
	for (i = top; i >= 0; i--)
	{
	    sb.append(" "+data[i]);
	}
	sb.append(">");
	return sb.toString();
    }
}
