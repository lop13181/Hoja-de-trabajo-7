// Implementation of key- iterators for driving Association iterators.
// (c) 1998, 2001 duane a. bailey
package structure;
import java.util.Iterator;

/**
 * A private master iterator for filtering the key fields from
 * an Association-returning iterator. This iterator returns
 * objects of the {@link java.lang.Comparable} type, and is
 * publically available throught the {@link structure.Hashtable#keys()} 
 * method.
 * <P>
 * Typical use:
 * <P>
 * <pre>
 *      Hashtable h = new Hashtable();
 *      // ...hashtable gets built up...
 *      Iterator hi = h.keys();
 *      while (hi.{@link #hasNext() hasNext()})
 *      {
 *          System.out.println(ai.{@link #next() next()});
 *      }
 * </pre>
 * 
 * @version $Id: KeyIterator.java,v 4.0 2000/12/27 21:21:47 bailey Exp bailey $
 * @author, 2001 duane a. bailey
 */
class KeyIterator extends AbstractIterator
{
    /**
     * The underlying iterator.
     * The slave iterator provides the key iterator values which
     * are Associations.  The key iterator returns only the key-portion
     * of the Associations.	
     */
    protected Iterator slave;

    /**
     * Construct a new key iterator that filters the slave iterator,
     * an Association-returning iterator.
     *
     * @pre slave is a fully reset iterator over Association elements
     * @post creates a new iterator that returns keys of slave iterator
     * 
     * @param slave The slave iterator.
     */
    public KeyIterator(Iterator slave)
    {
	this.slave = slave;
    }

    /**
     * Resets the slave iterator (and thus the key iterator) to the
     * first association in the structure.
     *
     * @post resets iterator to point to first key
     */
    public void reset()
    {
	((AbstractIterator)slave).reset();
    }

    /**
     * Returns true if an association is available for generating a key.
     *
     * @post returns true if current element is valid
     * 
     * @return True if a valid key can be generated.
     */
    public boolean hasNext()
    {
	return slave.hasNext();
    }

    /**
     * Returns the current key, and increments the iterator.	
     *
     * @pre hasNext()
     * @post returns current value and increments iterator
     * 
     * @return The current key, before iterator is incremented.
     */
    public Object next()
    {
	Association pair = (Association)slave.next();
	return pair.getKey();
    }

    /**
     * Returns the current key from the slave iterator.
     *
     * @pre current value is valid
     * @post returns current value
     * 
     * @return The current key associated with the iterator.
     */
    public Object get()
    {
	Association pair = (Association)((AbstractIterator)slave).get();
	return pair.getKey();
    }
}
 
