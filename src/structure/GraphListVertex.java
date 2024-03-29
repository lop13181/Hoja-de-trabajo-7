package structure;
import java.util.Iterator;

/**
 * A private implementation of a vertex for use in graphs that
 * are internally represented as a list.  A vertex
 * is capable of holding a label and has a flag that can be set  
 * to mark it as visited.   
 * <P>
 * Typical Usage:
 * <P>
 * <pre>
 *     Vertex v = new {@link #GraphListVertex(Object) Vertex(someLabel)};
 *     //...several graph related operations occur
 *     if(!v.{@link #isVisited() isVisited()}){
 *         Object label = v.label();
 *         v.{@link #visit() visit()};
 *     }
 * </pre>
 * @see GraphListVertex
 * @see Vertex
 * @version $Id: GraphListVertex.java,v 4.0 2000/12/29 02:43:29 bailey Exp bailey $
 * @author, 2001 duane a. bailey
 */
class GraphListVertex extends Vertex
{
    protected Structure adjacencies; // adjacent edges
    /**
     * @post constructs a new vertex, not incident to any edge
     * 
     * @param key 
     */
    public GraphListVertex(Object key)
    {
	super(key); // init Vertex fields
	adjacencies = new SinglyLinkedList(); // new list
    }

    /**
     * @pre e is an edge that mentions this vertex
     * @post adds edge to this vertex's adjacency list
     * 
     * @param e 
     */
    public void addEdge(Edge e)
    {
	if (!containsEdge(e)) adjacencies.add(e);
    }

    /**
     * @post returns true if e appears on adjacency list
     * 
     * @param e 
     * @return 
     */
    public boolean containsEdge(Edge e)
    {
	return adjacencies.contains(e);
    }

    /**
     * @post removes and returns adjacent edge "equal" to e
     * 
     * @param e 
     * @return 
     */
    public Edge removeEdge(Edge e)
    {
	return (Edge)adjacencies.remove(e);
    }

    /**
     * @post returns the edge that "equals" e, or null
     * 
     * @param e 
     * @return 
     */
    public Edge getEdge(Edge e)
    {
	Iterator edges = adjacencies.iterator();
	while (edges.hasNext())
	{
	    Edge adjE = (Edge)edges.next();
	    if (e.equals(adjE)) return adjE;
	}
	return null;
    }

    /**
     * @post returns the degree of this node
     * 
     * @return 
     */
    public int degree()
    {
	return adjacencies.size(); 
    }

    /**
     * @post returns iterator over adj. vertices
     * 
     * @return 
     */
    public Iterator adjacentVertices()
    {
	return new GraphListAIterator(adjacentEdges(), label());
    }

    /**
     * @post returns iterator over adj. edges
     * 
     * @return 
     */
    public Iterator adjacentEdges()
    {
	return adjacencies.iterator();
    }

    /**
     * @post returns string representation of vertex
     * 
     * @return String representation of vertex
     */
    public String toString()
    {
	return "<GraphListVertex: "+label()+">";
    }
}

