// A class for structuring associations that may be compared.
// (c) 1998, 2001 duane a. bailey
package structure;

/**
 * A class implementing a comparable key-value pair.  This class associates an 
 * immutable key with a mutable value.  Useful for many other structures.
 * Example usage:
 * <P>
 * To print out a list of professors sorted by the number of classes
 * a particular student took from each, we could use the following:
 * <pre>
 * public static void main(String[] argv){
 *	//initialize a new fib heap
 *	FibHeap classesTaken = new FibHeap();
 *
 *	//add professors and classes taken to a heap
 *	classesTaken.add(new {@link #ComparableAssociation(Comparable, Object) ComparableAssociation(new Integer(5), "Andrea")});
 *	classesTaken.add(new ComparableAssociation(new Integer(1), "Barbara"));
 *	classesTaken.add(new ComparableAssociation(new Integer(3), "Bill"));
 *	classesTaken.add(new ComparableAssociation(new Integer(2), "Duane"));	
 *	classesTaken.add(new ComparableAssociation(new Integer(1), "Tom"));	
 *
 *	//print out classes taken
 *	while(!classesTaken.isEmpty()){
 *	    ComparableAssociation p = (ComparableAssociation)classesTaken.remove();
 *	    System.out.println(p.{@link #getValue() getValue()} + " is " + p.{@link #getKey() getKey()} + " years old.");
 *	}
 * }
 * </pre>  
 * @version $Id: ComparableAssociation.java,v 4.0 2000/12/27 20:57:33 bailey Exp bailey $
 * @author, 2001 duane a. bailey
 */
public class ComparableAssociation extends Association
    implements Comparable
{
    /**
     * Construct an association that can be ordered, from only a key.
     * The value is set to null.
     *
     * @pre key is non-null
     * @post constructs comparable association with null value
     * 
     * @param key The (comparable) key.
     */
    public ComparableAssociation(Comparable key)
    {
	this(key,null);
    }

    /**
     * Construct a key-value association that can be ordered.
     *
     * @pre key is non-null
     * @post constructs association between a comparable key and a value
     * 
     * @param key The (comparable) key.
     * @param value The (possibly comparable) associated value.
     */
    public ComparableAssociation(Comparable key, Object value)
    {
	super(key,value);
    }

    /**
     * Determine the order of two comparable associations, based on key.
     *
     * @pre other is non-null ComparableAssociation
     * @post returns integer representing relation between values
     * 
     * @param other The other comparable association.
     * @return Value less-than equal to or greater than zero based on comparison
     */
    public int compareTo(Object other)
    {
	Assert.pre(other instanceof ComparableAssociation,
		   "compareTo expects a ComparableAssociation");
	ComparableAssociation that = (ComparableAssociation)other;
	Comparable thisKey = (Comparable)this.getKey();
	Comparable thatKey = (Comparable)that.getKey();

	return thisKey.compareTo(thatKey);
    }

    /**
     * Construct a string representation of the ComparableAssociation.
     *
     * @post returns string representation
     * 
     * @return The string representing the ComparableAssociation.
     */
    public String toString()
    {
	StringBuffer s = new StringBuffer();
	s.append("<ComparableAssociation: "+getKey()+"="+getValue()+">");
	return s.toString();
    }
}
