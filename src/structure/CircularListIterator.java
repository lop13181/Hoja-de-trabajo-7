// A private iterator for circular lists.
// (c) 1998, 2001 duane a. bailey

package structure;
/**
 * An iterator for traversing the elements of a circular list.
 * The iterator traverses the list beginning at the head, and heads toward
 * tail.
 * <P>
 * Typical use:
 * <P>
 * <pre>
 *      List l = new CircularList();
 *      // ...list gets built up...
 *      Iterator li = l.iterator();
 *      while (li.hasNext())
 *      {
 *          System.out.println(li.get());
 *          li.next();
 *      }
 *      li.reset();
 *      while (li.hasNext())
 *      { .... }
 * </pre>
 * @version $Id: SinglyLinkedListIterator.java,v 4.0 2000/12/27 20:57:33 bailey Exp bailey $
 * @author, 2001 duane a. bailey
 */
class CircularListIterator extends AbstractIterator
{
    /**
     * The tail of the traversed list.
     */
    protected SinglyLinkedListElement tail;
    /**
     * The current value of the iterator.
     */
    protected SinglyLinkedListElement current;

    /**
     * Constructs an iterator over circular list whose tail is t
     *
     * @pre t is a reference to a circular list element
     * @post constructs an iterator for traversing circular list
     * 
     * @param t The tail of the list to be traversed.
     */
    public CircularListIterator(SinglyLinkedListElement t)
    {
	tail = t;
	reset();
    }

    /**
     * Resets iterator to consider the head of the list.
     *
     * @post rests iterator to point to head of list
     */
    public void reset()
    {
	if (tail == null) current = null;
	else current = tail.next();
    }

    /**
     * Determine if there are unconsidered elements.
     *
     * @post returns true if some elements not visited
     * 
     * @return True iff some element has not been considered.
     */
    public boolean hasNext()
    {
	return current != null;
    }

    /**
     * Return the current value and increment iterator.
     *
     * @pre hasNext()
     * @post returns current element, increments iterator
     * 
     * @return The current value before incrementing.
     */
    public Object next()
    {
	Object result = current.value();
	if (current == tail) current = null;
	else current = current.next();
	return result;
    }

    /**
     * Determine the current value of iterator.
     *
     * @pre hasNext()
     * @post returns current value
     * 
     * @return The current value of the iterator.
     */
    public Object get()
    {
	return current.value();
    }
}
