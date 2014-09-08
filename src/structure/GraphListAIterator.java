package structure;
import java.util.Iterator;
/**
 * An adjacent vertex iterator.   Adjacent vertices
 * (those on destination of edge, if directed) are considered,
 * but not in any guaranteed order.
 * Typical use:
 * <P>
 * <pre>
 *      Graph g = new GraphList();
 *      // ...list gets built up...
 *      Iterator ai = g.neighbors(someVertex);
 *      while (ai.{@link #hasNext() hasNext()})
 *      {
 *          System.out.println(ai.{@link #next() next()});
 *      }
 * </pre>
 * @version $Id: GraphListAIterator.java,v 4.0 2000/12/29 02:43:22 bailey Exp bailey $
 * @author, 2001 duane a. bailey
 */
class GraphListAIterator extends AbstractIterator
{
    protected Iterator edges;
    protected Object vertex;

    /**
     * @pre i is an edge iterator
     * @post returns iterator over vertices adjacent to v
     * 
     * @param i 
     * @param v 
     */
    public GraphListAIterator(Iterator i, Object v)
    {
	edges = i;
	vertex = v;
    }

    /**
     * @post resets iterator
     * 
     */
    public void reset()
    {
	((AbstractIterator)edges).reset();
    }

    /**
     * @post returns true if more adj. vertices to traverse
     * 
     * @return True if more adj. vertices to traverse
     */
    public boolean hasNext()
    {
	return edges.hasNext();
    }

    /**
     * @pre hasNext
     * @post returns the next adjacent vertex
     * 
     * @return The next adjacent vertex
     */
    public Object next()
    {
	Edge e = (Edge)edges.next();
	if (vertex.equals(e.here())) 
	{
	    return e.there();
	} else { // N.B could be vertex if self-loop edge
	    return e.here();
	}
    }

    /**
     * @pre hasNext
     * @post returns the current adj. vertex
     * 
     * @return The current adj. vertex
     */
    public Object get()
    {
	Edge e = (Edge)((AbstractIterator)edges).get();
	if (vertex.equals(e.here())) 
	{
	    return e.there();
	} else { // NB. could be vertex if self-loop edge
	    return e.here();
	}
    }
}
