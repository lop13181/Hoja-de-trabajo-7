package structure;
/**
 * A private implementation of a vertex for use in graphs that
 * are internally represented as a Matrix.  A vertex
 * is capable of holding a label and has a flag that can be set  
 * to mark it as visited.   
 * <P>
 * Typical Usage:
 * <P>
 * <pre>
 *     Vertex v = new {@link #GraphMatrixVertex(Object, int) Vertex(someLabel)};
 *     //...several graph related operations occur
 *     if(!v.{@link #isVisited() isVisited()}){
 *         Object label = v.label();
 *         v.{@link #visit() visit()};
 *     }
 * </pre>
 * @see GraphListVertex
 * @see Vertex
 * @version $Id: GraphMatrix.java,v 4.0 2000/12/27 20:57:33 bailey Exp bailey $
 * @author, 2001 duane a. bailey
 */
class GraphMatrixVertex extends Vertex 
{
    protected int index;

    /**
     * @post constructs a new augmented vertex
     * 
     * @param label 
     * @param idx 
     */
    public GraphMatrixVertex(Object label, int idx)
    {
	super(label);
	index = idx;
    }

    /**
     * @post returns index associated with vertex
     * 
     * @return 
     */
    public int index()
    {
	return index;
    }

    /**
     * @post returns string representation of vertex
     * 
     * @return 
     */
    public String toString()
    {
	return "<GraphMatrixVertex: "+label()+">";
    }
}
