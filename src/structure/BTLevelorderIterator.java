// Level-order iterator for binary trees.
// (c) 1998, 2001 duane a. bailey
package structure;

/**
 * An iterator for traversing binary trees constructed from
 * BinaryTrees.  The iterator performs minimal work before
 * traversal.  Every node is considered after every non-trivial
 * ancestor or left cousin, and before any non-trivial descendant or
 * right cousin.
 * LevelOrderIterator finishes when
 * all descendants of the start node have been considered.
 * <P>
 * Example usage:
 * <pre>
 *      {@link structure.BinaryTree BinaryTree} t = new {@link structure.BinaryTree#BinaryTree() BinaryTree()};
 *      // ...tree is grown
 *      {@link java.util.Iterator Iterator} ti = t.{@link structure.BinaryTree#levelorderIterator() levelorderIterator()};
 *      while (ti.{@link #hasNext() hasNext()})
 *      {
 *          System.out.println(ti.{@link #next() next()});
 *      }
 *      ti.{@link #reset() reset()};
 *      while (ti.{@link #hasNext() hasNext()})
 *      { .... }
 * </pre>
 *
 * @version $Id: BTLevelorderIterator.java,v 4.0 2000/12/27 20:57:33 bailey Exp bailey $
 * @author, 2001 duane a. bailey
 */
class BTLevelorderIterator extends AbstractIterator
{
    /**
     * The root of the subtree being traversed.
     */
    protected BinaryTree root; // root of traversed subtree
    /** 
     * Queue of nodes that maintain the state of the iterator.
     */
    protected Queue todo;  // queue of unvisited relatives

    /**
     * Construct a new level-order iterator of a tree.
     *
     * @post Constructs an iterator to traverse in level order
     * 
     * @param root The root of the subtree to be traversed.
     */
    public BTLevelorderIterator(BinaryTree root)
    {
	todo = new QueueList();
	this.root = root;
	reset();
    }	

    /**
     * Reset iterator to beginning of traversal.
     *
     * @post Resets the iterator to root node
     */
    public void reset()
    {
	todo.clear();
	// empty queue, add root
	if (!root.isEmpty()) todo.enqueue(root);
    }

    /**
     * Return true if more nodes are to be considered.
     *
     * @post Returns true iff iterator is not finished
     * 
     * @return True if more nodes are to be considered.
     */
    public boolean hasNext()
    {
	return !todo.isEmpty();
    }

    /**
     * Returns the value of the currently considered node.
     *
     * @pre hasNext()
     * @post Returns reference to current value
     * 
     * @return The value of the node currently referenced by iterator.
     */
    public Object get()
    {	
	return ((BinaryTree)todo.getFirst()).value();
    }

    /**
     * Returns currently considered value and increments iterator.
     *
     * @pre hasNext();
     * @post Returns current value, increments iterator
     * 
     * @return Value considered before iterator is incremented.
     */
    public Object next()
    {
	BinaryTree current = (BinaryTree)todo.dequeue();
	Object result = current.value();
	if (!current.left().isEmpty())
	    todo.enqueue(current.left());
	if (!current.right().isEmpty())
	    todo.enqueue(current.right());
	return result;
    }
}

