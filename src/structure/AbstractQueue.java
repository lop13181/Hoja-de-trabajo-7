// The interface for stacks.
// (c) 1998, 2001 duane a. bailey

package structure;

/**
 * An abstract structure implementing features common to all first-in, first-out
 * structures in this package.  
 * Queues are typically used to process values in the order that they appear 
 * and to store the state of buffered objects.
 * The structure package provides several implementations of the Queue interface, 
 * each of which has its particular strengths and weaknesses.
 * <P>
 * Example usage:
 * <P>
 * To compute the sum of the unicode value of every character in the standard input
 * we could use the following:
 * <P>
 * <pre>
 * public static void main(String[] arguments)
 * {
 *     {@link AbstractQueue} q = new {@link QueueList#QueueList() QueueList()};
 *     int unicodeSum = 0;
 *
 *     if(arguments.length > 0){
 *         for(int i=0; i < arguments.length; i++){
 *	       for(int j=0; j < arguments[i].length(); j++){
 *		   q.{@link #enqueue(Object) enqueue(new Character(arguments[i].charAt(j)))};
 *	       }
 *	   }
 *     }
 *
 *     while(!q.{@link #empty()}){
 *	  char c = ((Character)q.{@link #dequeue()}).charValue();
 *	  unicodeSum+=Character.getNumericValue(c);
 *     }
 *
 *     System.out.println("Total Value: " + unicodeSum);
 * }
 * </pre>
 * @see QueueArray
 * @see QueueVector
 * @see QueueList
 * @version $Id: Queue.java,v 4.0 2000/12/27 21:21:47 bailey Exp bailey $
 * @author, 2001 duane a. bailey
 */
public abstract class AbstractQueue
    extends AbstractLinear implements Queue 
{
    /**
     * Add a value to the tail of the queue.
     *
     * @post the value is added to the tail of the structure
     * 
     * @param value The value added.
     */
    public void enqueue(Object item)
    {
	add(item);
    }

    /**
     * Remove a value form the head of the queue.
     *
     * @pre the queue is not empty
     * @post the head of the queue is removed and returned
     * 
     * @return The value actually removed.
     */
    public Object dequeue()
    {
	return remove();
    }

    /**
     * Fetch the value at the head of the queue.
     *
     * @pre the queue is not empty
     * @post the element at the head of the queue is returned
     * 
     * @return Reference to the first value of the queue.
     */
    public Object getFirst()
    {
	return get();
    }

    /**
     * Fetch the value at the head of the queue.
     *
     * @pre the queue is not empty
     * @post the element at the head of the queue is returned
     * 
     * @return Reference to the first value of the queue.
     */
    public Object peek()
    {
	return get();
    }
}
