// Implementation of value- iterators for driving Association iterators.
// (c) 1998, 2001 duane a. bailey
package structure;
import java.util.Iterator;
/**
 * A private master iterator for filtering the value fields from
 * an Association-returning iterator.This iterator returns
 * objects of the {@link java.lang.Object} type, and is
 * publically available throught the {@link structure.Hashtable#iterator()} 
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
 * @version $Id: ValueIterator.java,v 4.1 2000/12/29 02:05:54 bailey Exp bailey $
 * @author, 2001 duane a. bailey
 */
class ValueIterator extends AbstractIterator
{
    /**
     * The underlying iterator.
     * The slave iterator provides the value iterator values which
     * are Associations.  The value iterator returns only the value-portion
     * of the Associations.	
     */
    protected Iterator slave;

    /**
     * Construct a new value iterator that filters the slave iterator,
     * an Association-returning iterator.
     *
     * @pre slave is an iterator returning Association elements
     * @post creates a new iterator returning associated values
     * 
     * @param slave The slave iterator.
     */
    public ValueIterator(Iterator slave)
    {
	this.slave = slave;
    }

    /**
     * Resets the slave iterator (and thus the value iterator) to the
     * first association in the structure.
     *
     * @post resets iterator to point to first value
     */
    public void reset()
    {
	((AbstractIterator)slave).reset();
    }

    /**
     * Returns true if an association is available for generating a value.
     *
     * @post returns true if current element is valid
     * 
     * @return True if a valid value can be generated.
     */
    public boolean hasNext()
    {
	return slave.hasNext();
    }

    /**
     * Returns the current value, and increments the iterator.	
     *
     * @pre hasNext()
     * @post returns current value and increments iterator
     * 
     * @return The current value, before iterator is incremented.
     */
    public Object next()
    {
	Association pair = (Association)((AbstractIterator)slave).next();
	return pair.getValue();
    }

    /**
     * Returns the current value from the slave iterator.
     *
     * @pre current value is valid
     * @post returns current value
     * 
     * @return The current value associated with the iterator.
     */
    public Object get()
    {
	Association pair = (Association)((AbstractIterator)slave).get();
	return pair.getValue();
    }
}
