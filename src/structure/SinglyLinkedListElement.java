// Implementation of a node of a singly linked list.
// (c) 1998, 2001 duane a. bailey
package structure;

/**
 * A class supporting a singly linked list element.  Each element
 * contains a value and maintains a single reference to the next 
 * node in the list.
 *
 * @version $Id: SinglyLinkedListElement.java,v 4.1 2000/12/29 02:48:13 bailey Exp bailey $
 * @author, 2001 duane a. bailey
 */
public class SinglyLinkedListElement
{
    /**
     * The data value stored in this node.
     */
    protected Object data; // value stored in this element
    /**
     * Reference to the next node in the list.
     */
    protected SinglyLinkedListElement nextElement; // ref to next

    /**
     * Construct a singly linked list element.
     *
     * @pre v is a value, next is a reference to remainder of list
     * @post an element is constructed as the new head of list
     * @param v The value to be referenced by this element.
     * @param next A reference to the next value in the list.
     */
    public SinglyLinkedListElement(Object v,
			           SinglyLinkedListElement next)
    {
	data = v;
	nextElement = next;
    }

    /**
     * Constructs a singly linked list element not associated with
     * any list.  next reference is set to null.
     *
     * @post constructs a new tail of a list with value v
     * 
     * @param v The value to be inserted into the singly linked list element.
     */
    public SinglyLinkedListElement(Object v)
    {
	this(v,null);
    }

    /**
     * @post returns reference to next value in list
     * 
     */
    public SinglyLinkedListElement next()
    {
	return nextElement;
    }

    /**
     * Update the next element.
     *
     * @post sets reference to new next value
     * 
     * @param next The new value of the next element reference.
     */
    public void setNext(SinglyLinkedListElement next)
    {
	nextElement = next;
    }

    /**
     * Fetch the value associated with this element.
     *
     * @post returns value associated with this element
     * 
     * @return Reference to the value stored within this element.
     */
    public Object value()
    {
	return data;
    }

    /**
     * Set the value associated with this element.
     *
     * @post sets value associated with this element
     * 
     * @param value The new value to be associated with this element.
     */
    public void setValue(Object value)
    {
	data = value;
    }

    /**
     * Construct a string representation of element.
     *
     * @post returns string representation of element
     * 
     * @return The string representing element.
     */
    public String toString()
    {
	return "<SinglyLinkedListElement: "+value()+">";
    }
}

