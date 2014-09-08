package structure;
/**
 * A traversal of all the elements as they appear in a hashtable.
 * No order is guaranteed.  This iterator is not publically accessable
 * and is used to implement Hashtable's key and value iterators.
 * This iteration returns objects that are instances of {@link Association}.
 * <P>
 * Typical use:
 * <P>
 * <pre>
 *      Hashtable h = new Hashtable();
 *      // ...hashtable gets built up...
 *      Iterator hi = new {@link #HashtableIterator(Association[]) HashtableIterator(h.data)};
 *      while (hi.{@link #hasNext() hasNext()})
 *      {
 *          System.out.println(ai.{@link #next() next()});
 *      }
 * </pre> 
 * @version $Id: HashtableIterator.java,v 4.0 2000/12/29 02:43:29 bailey Exp bailey $
 * @author, 2001 duane a. bailey
 */
class HashtableIterator extends AbstractIterator
{
    /**
     * The current entry being considered.
     */
    protected int current;
    /**
     * Reference to hash table data
     */
    protected Association data[];

    /**
     * Construct a traversal over a hashtable.
     *
     * @post constructs a new hash table traversal
     * 
     * @param table The array of lists to be traversed.
     */
    public HashtableIterator(Association[] table)
    {
	data = table;
	reset();
    }

    /**
     * Resets the traversal to point to the beginning of the table.
     *
     * @post resets traversal to beginning of hash table
     */
    public void reset()
    {
	for (current = 0; current < data.length; current++)
	{
	    if (data[current] != null &&
		data[current] != Hashtable.reserved) break;
	}
	return;
    }

    /**
     * Returns true iff there are unconsidered elements within the table.
     *
     * @post returns true if there are unvisited elements
     * 
     * @return True iff there are elements yet to be considered within table.
     */
    public boolean hasNext()
    {
	return current < data.length;
    }

    /**
     * Returns current value and increments traversal.
     *
     * @pre hasNext()
     * @post returns current element, increments traversal
     * 
     * @return The current value, before incrementing.
     */
    public Object next()
    {
	Object result = data[current];
	for (current++; current < data.length; current++)
	{
	    if (data[current] != null &&
		data[current] != Hashtable.reserved) break;
	}
	return result;
    }

    /**
     * Get current value of traversal.
     *
     * @post returns current element
     * 
     * @return The current value.
     */
    public Object get()
    {
	return data[current];
    }
}
