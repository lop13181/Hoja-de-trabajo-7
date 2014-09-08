// A set implemented using lists.  Fairly slow, but works on non-Comparables.
// (c) 1998, 2001 duane a. bailey

package structure;
import java.util.Iterator;

/**
 * Implementation of a set of elements using a list as the underlying
 * storage mechanism.
 * As with the mathematical object, the elements of the set are
 * not duplicated.  No order is implied or enforced in this structure, but
 * simple set operations such as intersection, union, difference, and subset
 * are provided. 
 * <P>
 * Example Usage:
 * Given a list of students who completed a computer science thesis in the
 * 2001-2002 academic year at Williams College and a list of graduating 
 * computer science majors who are continuing on to graduate school, we could
 * determine which thesis students are planning to attend graduate school
 * as follows:
 * <P>
 * <pre>
 * public static void main(String[] argv){
 *	//thesis students in the class of '02
 *	String[] thesis = new String[]{"Doug", "Evan", "Feng"};
 *	
 *	//students continuing on to grad school
 *	String[] grad = new String[]{"Doug", "Feng", "Lida"};
 *
 *	//instantiate our sets
 *	Set thesisSet = new {@link #SetList()}, 
 *	    gradSet = new {@link #SetList()};
 *		
 *	//build sets up
 *	for(int i = 0; i < thesis.length; i++) thesisSet.{@link #add(Object) add(thesis[i])};
 *	for(int i = 0; i < grad.length; i++) gradSet.{@link #add(Object) add(grad[i])};
 *	
 *	//calculate the intersection of the two sets
 *	thesisSet.{@link #retainAll(Structure) retainAll(gradSet)};
 *	System.out.println(thesisSet);
 * }
 * </pre>
 * @version $Id: SetVector.java,v 4.0 2000/12/27 21:21:47 bailey Exp bailey $
 * @author, 2001 duane a. bailey
 */
public class SetList extends AbstractSet
{
    /**
     * The underlying structure --- a list.
     */
    protected List data;

    /**
     * Construct a new set list.
     *
     * @post constructs a new, empty set
     */
    public SetList()
    {
	data = new SinglyLinkedList();
    }

    /**
     * Remove all the elements from the set.
     *
     * @post elements of set are removed
     */
    public void clear()
    {
	data = new SinglyLinkedList();
    }

    /**
     * Determine if the set is empty.
     *
     * @post returns true iff set is empty
     * 
     * @return True iff there are no elements in set.
     */
    public boolean isEmpty()
    {
	return data.isEmpty();
    }

    /**
     * Add an element to set, if not already present.
     *
     * @pre e is non-null object
     * @post adds element e to interface
     * 
     * @param e The new value to be added to set.
     */
    public void add(Object e)
    {
	if (!data.contains(e)) data.add(e);
    }

    /**
     * Remove an element from the set.
     *
     * @pre e is non-null object
     * @post e is removed from set, value returned
     * 
     * @param e The element of the set to be removed.
     * @return The value actually removed.
     */
    public Object remove(Object e)
    {
	return data.remove(e);
    }

    /**
     * Returns true if value is an element of the set.
     *
     * @pre e is non-null
     * @post returns true iff e is in set
     * 
     * @param e The element sought in set.
     * @return True iff the element is in the set.
     */
    public boolean contains(Object e)
    {
        return data.contains(e);
    }

    /**
     * Determine if this set is a subset of other.
     *
     * @pre other is non-null reference to set
     * @post returns true iff this set is subset of other
     * 
     * @param other The potential superset.
     */
    public boolean containsAll(Structure other)
    {
	Iterator myElements = data.iterator();
	while (myElements.hasNext())
	{
	    if (!other.contains(myElements.next())) return false;
	}
	return true;
    }
    
    /**
     * Returns a shallow clone of this set.
     *
     * @post returns a copy of set
     * 
     * @return A new set with same values.
     */
    public Object clone()
    {
	Set result = new SetList();
	Iterator myElements = iterator();
	while (myElements.hasNext()) {
	    result.add(myElements.next());
	}
	return result;
    }

    /**
     * Compute the union of this set with other.
     * This set not modified.
     *
     * @pre other is non-null reference to set
     * @post returns new set containing union of this and other
     * 
     * @param other The set to be unioned with this.
     * @return Union of this and other.
     */
    public void addAll(Structure other)
    {
	Iterator yourElements = other.iterator();
	while (yourElements.hasNext())
	{
	    add(yourElements.next());
	}
    }

    /**
     * Compute the intersection of this set and other.
     * Members of result are in both this and other.
     *
     * @pre other is non-null reference to set
     * @post returns new set containing intersection of this and other
     * 
     * @param other The other set to be intersected with this.
     * @return Intersection of this and other.
     */
    public void retainAll(Structure other)
    {
	Set temp = new SetList();
	Iterator myElements = data.iterator();
	while (myElements.hasNext())
	{
	    Object v = myElements.next();
	    if (other.contains(v))
	    {
		temp.add(v);
	    }
	}
	clear();
	addAll(temp);
    }
    
    /**
     * Compute the difference between two sets.
     * Values of the result are members of this, but not other.
     * @pre other is non-null reference to set
     * @post returns new set containing difference of this and other
     * 
     * @param other The set whose values are to be eliminated from this.
     * @return Difference between this and other.
     */
    public void removeAll(Structure other)
    {
	Iterator yourElements = other.iterator();
	while (yourElements.hasNext())
	{
	    remove(yourElements.next());
	}
    }

    /**
     * Construct an traversal to traverse the elements of the set.
     * Elements will not appear in any particular order.
     *
     * @post returns traversal to traverse the elements of set
     * 
     * @return An traversal for inspecting members of the set.
     */
    public Iterator iterator()
    {
	return data.iterator();
    }

    /**
     * Determine the number of elements in the set.
     *
     * @post returns number of elements in set
     * 
     * @return The number of elements in the set.
     */
    public int size()
    {
	return data.size();
    }

    /**
     * Construct a string representation of the set.
     *
     * @post returns a string representation of set
     * 
     * @return A string representing the set.
     */
    public String toString()
    {
	return "<SetList: "+data+">";
    }
}
