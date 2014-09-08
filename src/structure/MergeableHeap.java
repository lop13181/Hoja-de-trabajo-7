package structure;
/**
 * Interface describing mergeable min heaps.  
 * Min heaps are collections of Comparable data that guarantee
 * efficient access to the smallest element in the structure.
 * Mergeable Min heaps, also provide an efficient technique for
 * merging two mergeable heaps of the same type.
 * Mergeable heaps are quite similar to {@link structure.PriorityQueue}.
 * <P>
 * Example Usage: 
 * </P>
 * <pre>
 * public static void main(String[] argv){
 *	//initialize a new fib heap
 *	MergeableHeap programmers = new {@link structure.FibHeap#FibHeap() FibHeap()};
 *
 *	//add programmers and their ages to heap
 *	//ages current of 7/22/2002
 *        programmers.{@link #add(Comparable) add(new ComparableAssociation(new Integer(22), "Evan"))};
 *	programmers.add(new ComparableAssociation(new Integer(19), "Chris"));
 *	programmers.add(new ComparableAssociation(new Integer(20), "Shimon"));
 *	programmers.add(new ComparableAssociation(new Integer(21), "Diane"));
 *	programmers.add(new ComparableAssociation(new Integer(21), "Lida"));	
 *	programmers.add(new ComparableAssociation(new Integer(20), "Rob"));	
 *	programmers.add(new ComparableAssociation(new Integer(20), "Sean"));	
 *
 *	//print out programmers 
 *	while(!programmers.{@link #isEmpty()}){
 *	    ComparableAssociation p = (ComparableAssociation)programmers.{@link #remove()};
 *	    System.out.println(p.getValue() + " is " + p.getKey() + " years old.");
 *	}
 * }
 * </pre>
 *
 * @version $Id: PriorityQueue.java,v 4.0 2000/12/27 21:21:47 bailey Exp bailey $
 * @author, 2001 duane a. bailey
 */
public interface MergeableHeap extends PriorityQueue{
    /**
     * Merge this heap with <code>otherHeap</code>, destroying
     * <code>otherHeap</code> in the process.
     *
     * @param otherHeap Heap to be merged into this heap.
     * @post This heap contains all of the elements formerly contained
     * by <code>otherHeap</code>. <code>otherHeap</code> is destroyed in
     * in the process.
     */
    public void merge(MergeableHeap otherHeap);

    /**
     * Add an item to this heap.
     *
     * @param value The value to be added to the heap
     * @pre value is non-null
     * @post value is added to the heap.
     */
    public void add(Comparable value);
    
    /**
     * Returns the minimum value in the heap and deletes this value from
     * the heap.
     * 
     * @return The minumum value in the heap, or null if the heap is empty.
     * @post Heap no longer contains the minimum value.
     */
    public Comparable remove();    
    
    /**
     * Return the minimum value in the heap.
     * 
     * @return The minimum value in the heap.
     * @post The minimum value is returned.
     */
    public Comparable getFirst();
}


