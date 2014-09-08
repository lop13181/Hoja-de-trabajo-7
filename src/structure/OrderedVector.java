// An implementation of and ordered structure, based on vectors.
// (c) 1998, 2001 duane a. bailey

package structure;
import java.util.Iterator;

/**
 * Implementation of an ordered structure implemented using a vector.
 * Values are stored within this vector in increasing order. All values
 * stored within an ordered vector must implement comparable.
 * <P>
 * Example Usage:
 * <P>
 * To determine the effect of the original Starwars&trade; movie on the careers
 * of its stars, we could place ComparableAssociations between each star's
 * name and the number of movies they have been in since Starwars&trade;
 * into an ordered vector and print our the results.
 * <pre>
 * public static void main(String[] argv){
 *	//instantiate an ordered vector
 *	OrderedVector v = new {@link #OrderedVector()};
 *	
 *	//add the cast members of the original star wars along with
 *	//the number of films in which the have subsequently appeared
 *	v.{@link #add(Object) add(new ComparableAssociation(new Integer(12),"Sir Alec Guiness"))};
 *	v.{@link #add(Object) add(new ComparableAssociation(new Integer(24),"Carrie Fisher"))};
 *	v.{@link #add(Object) add(new ComparableAssociation(new Integer(28),"Harrison Ford"))}; 
 *	v.{@link #add(Object) add(new ComparableAssociation(new Integer(28),"Mark Hamill"))};
 *
 *	//print out the results
 *	for(Iterator i = v.{@link #iterator()}; i.hasNext();){
 *	    ComparableAssociation actor = (ComparableAssociation)i.next();
 *	    System.out.println(actor.getValue() + " has been in " + 
 *			       actor.getKey() + " movies since Star Wars"); 
 *	}
 *   }
 * </pre>
 * @see structure.Vector
 * @version $Id: OrderedVector.java,v 4.0 2000/12/27 20:57:33 bailey Exp bailey $
 * @author, 2001 duane a. bailey
 */
public class OrderedVector extends AbstractStructure implements OrderedStructure
{
    /**
     * The vector of values.  Values are stored in increasing order
     */
    protected Vector data;
    /**
     * Construct an empty ordered vector
     *
     * @post constructs an empty, ordered vector
     */
    public OrderedVector()
    {
	data = new Vector();
    }

    /**
     * Add a comparable value to an ordered vector
     *
     * @pre value is non-null
     * @post inserts value, leaves vector in order
     * 
     * @param value The comparable value to be added to the ordered vector
     */
    public void add(Object value)
    {
	int position = indexOf((Comparable)value);
	data.add(position,value);
    }

    /**
     * Determine if a comparable value is a member of the ordered vector
     *
     * @pre value is non-null
     * @post returns true if the value is in the vector
     * 
     * @param value The comparable value sought
     * @return True if the value is found within the ordered vector
     */
    public boolean contains(Object value)
    {
	int position = indexOf((Comparable)value);
	return (position < size()) &&
	       data.get(position).equals(value);
    }

    /**
     * Remove a comparable value from an ordered vector
     * At most one value is removed
     *
     * @pre value is non-null
     * @post removes one instance of value, if found in vector
     * 
     * @param value The comparable value to be removed
     * @return The actual comparable removed
     */
    public Object remove(Object value)
    {
	if (contains(value)) {
	    // we know value is pointed to by indexOf
	    int position = indexOf((Comparable)value);
	    // since vector contains value, position < size()
	    // keep track of the value for return
	    Object target = data.get(position);
	    // remove the value from the underlying vector
	    data.remove(position);
	    return target;
	}
        return null;
    }

    /**
     * Determine if the ordered vector is empty.	
     *
     * @post returns true if the OrderedVector is empty
     * 
     * @return True iff the ordered vector is empty
     */
    public boolean isEmpty()
    {
	return data.size() == 0;
    }

    /**
     * Removes all the values from a an ordered vector
     *
     * @post vector is emptied
     */
    public void clear()
    {
	data.setSize(0);
    }

    /**
     * Determine the number of elements within the ordered vector
     *
     * @post returns the number of elements in vector
     * 
     * @return The number of elements within the ordered vector
     */
    public int size()
    {
	return data.size();
    }

    /**
     * Construct an iterator to traverse the ordered vector in ascending
     * order
     *
     * @post returns an iterator for traversing vector
     * 
     * @return An iterator to traverse the ordered vector
     */
    public Iterator iterator()
    {
	return data.iterator();
    }

    protected int indexOf(Comparable target)
    {
	Comparable midValue;
	int low = 0;  // lowest possible location
	int high = data.size(); // highest possible location
	int mid = (low + high)/2; // low <= mid <= high
	// mid == high iff low == high
	while (low < high) {
	    // get median value
	    midValue = (Comparable)data.get(mid);
	    // determine on which side median resides:
	    if (midValue.compareTo(target) < 0) {
		low = mid+1;
	    } else {
		high = mid;
	    }
	    // low <= high
	    // recompute median index
	    mid = (low+high)/2;
	}
	return low;
    }
    
    /**
     * Construct a string representation of an ordered vector
     *
     * @pre returns string representation of ordered vector
     * 
     * @return The string representing the ordered vector
     */
    public String toString()
    {
	return "<OrderedVector: "+data+">";
    }
}
