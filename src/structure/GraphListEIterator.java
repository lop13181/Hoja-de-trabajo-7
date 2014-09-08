package structure;
import java.util.Iterator;
/**
 * An iterator over all edges.  Every directed/undirected
 * edge is considered exactly once.  Order is not guaranteed.
 * <P>
 * Typical use:
 * <P>
 * <pre>
 *      Graph g = new GraphList();
 *      // ...list gets built up...
 *      Iterator ei = g.edges();
 *      while (ei.{@link #hasNext() hasNext()})
 *      {
 *          System.out.println(ei.{@link #next() next()});
 *      }
 * </pre>
 *
 * @version $Id: GraphListEIterator.java,v 4.0 2000/12/29 02:43:28 bailey Exp bailey $
 * @author, 2001 duane a. bailey
 */
class GraphListEIterator extends AbstractIterator
{
    protected Iterator edges;

    /**
     * @post constructs a new iterator across edges of
     *       vertices within dictionary
     * 
     * @param dict 
     */
    public GraphListEIterator(Map dict)
    {
	List l = new DoublyLinkedList();
	Iterator dictIterator = dict.values().iterator();
	while (dictIterator.hasNext())
	{
	    GraphListVertex vtx =
		(GraphListVertex)dictIterator.next();
	    Iterator vtxIterator = vtx.adjacentEdges();
	    while (vtxIterator.hasNext())
	    {
		Edge e = (Edge)vtxIterator.next();
		if (vtx.label().equals(e.here())) l.addLast(e);
	    }
	}
	edges = l.iterator();
    }

    /**
     * @post resets the iterator to first edge
     * 
     */
    public void reset()
    {
	((AbstractIterator)edges).reset();
    }

    /**
     * @post returns true iff current element is valid
     * 
     * @return True iff current element is valid
     */
    public boolean hasNext()
    {
	return edges.hasNext();
    }

    /**
     * @pre hasNext()
     * @post returns the current element
     * 
     * @return The current element
     */
    public Object get()
    {
	return ((AbstractIterator)edges).get();
    }

    /**
     * @pre hasNext()
     * @post returns current value and increments iterator
     * 
     * @return Current value and increments iterator
     */
    public Object next()
    {
	return edges.next();
    }
}

