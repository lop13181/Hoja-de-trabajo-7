// Interface for container classes that manipulated ordered structures.
// (c) 1998, 2001 duane a. bailey

package structure;

/**
 * An interface that supports a Collection whose values are kept
 * in increasing order.  Values stored within ordered structures
 * should implement Comparable; ie. they should have an implemented
 * compareTo method.
 * 
 * @see java.lang.Comparable
 * @see java.lang.Comparable#compareTo
 * @version $Id: OrderedStructure.java,v 4.0 2000/12/27 21:21:47 bailey Exp bailey $
 * @author, 2001 duane a. bailey
 */
public interface OrderedStructure extends Structure
{
}
