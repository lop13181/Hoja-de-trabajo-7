package structure;
/**
 * An extension of the circular list class that provides 
 * an operation for merging an object of this type with
 * a CircularList in constant time.  This is accomplished
 * through pointer manipulation rather than by iterating through
 * the structure and copying each element as it appears. 
 * In the context of fibonacci heaps, this constant time merge method
 * facilitates the effecient implementation of the merge and remove 
 * methods.
 */
public class AppendableList extends CircularList{
    /**
     * Provides a constant time function that merges the contents
     * of two lists by appending l to this list.  The lists are
     * merged by appending the contents of l to the contents of this
     * list.
     * 
     * @param l The list to be merged into this list
     * @post This list contains all of the elements previously
     *       contained by l.
     *       l is destroyed.
     */
    public void merge(AppendableList l){
	if (l.size() > 0){
	    if(this.size() > 0){
		//get the neccessary heads and tails
		SinglyLinkedListElement h1 = tail.next();
		SinglyLinkedListElement h2 = l.tail.next();
		SinglyLinkedListElement t2 = l.tail;
		
		//do the swapping
		tail.setNext(h2);
		tail = t2;
		t2.setNext(h1);
	    } else {
		tail = l.tail;
	    }
	    count += l.count;
	}
    }
}
    
