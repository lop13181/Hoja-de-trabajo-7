package structure;
/**
 * Associations establish a link between a key and a value.  
 * An associative array or map is a structure that allows a disjoint
 * set of keys to become associated with an arbitrary set of values.  
 * The convenience of an associative array is that the values used to 
 * index the elements need not be comparable and their range need not 
 * be known ahead of time.  Furthermore, there is no upper bound on 
 * the size of the structure.  It is able to maintain an arbitrary number 
 * of different pieces of information simultaneously.  Maps are sometimes 
 * called dictionaries because of the uniqueness of the association of
 * words and definitions in a household dictionary.  
 * <P>
 * Example Usage:
 * <P>
 * To create a dictionary by reading a collection of words and 
 * definitions from System.in we could use the following!
 * <P> 
 * <pre>
 * public static void main (String[] argv){
 *	Map dict = new {@link structure.MapBST#MapBST()};
 *	ReadStream r = new ReadStream();
 *	String word, def;
 *	System.out.println("Enter a word: ");
 *	while(!r.eof()){
 *	    word = r.readLine();
 *	    System.out.println("Enter a definition: ");
 *	    def = r.readLine();
 *	    dict.{@link structure.MapBST#put(Object,Object) put(word,def)};
 *	    System.out.println("Enter a word: ");
 *	}
 *	System.out.println(dict);
 * }
 * </pre>
 */
public interface Map 
{
    /**
     * @post returns the number of entries in the map
     */
    public abstract int size();

    /**
     * @post returns true iff this map does not contain any entries
     */
    public abstract boolean isEmpty();

    /**
     * @pre k is non-null
     * @post returns true iff k is in the domain of the map
     */
    public abstract boolean containsKey(Object k);

    /**
     * @pre v is non-null
     * @post returns true iff v is the target of at least one map entry;
     * that is, v is in the range of the map
     */
    public abstract boolean containsValue(Object v);

    /**
     * @pre k is a key, possibly in the map
     * @post returns the value mapped to from k, or null
     */
    public abstract Object get(Object k);

    /**
     * @pre k and v are non-null
     * @post inserts a mapping from k to v in the map
     */
    public abstract Object put(Object k, Object v);
    
    /**
     * @pre k is non-null
     * @post removes any mapping from k to a value, from the mapping
     */
    public abstract Object remove(Object k);

    /**
     * @pre other is non-null
     * @post all the mappings of other are installed in this map,
     * overriding any conflicting maps
     */
    public abstract void putAll(Map other);

    /**
     * @post removes all map entries associated with this map
     */
    public abstract void clear();

    /**
     * @post returns a set of all keys associated with this map
     */
    public abstract Set keySet();

    /**
     * @post returns a structure that contains the range of the map
     */
    public abstract Structure values();

    /**
     * @post returns a set of (key-value) pairs, generated from this map
     */
    public abstract Set entrySet();

    /**
     * @pre other is non-null
     * @post returns true iff maps this and other are entry-wise equal
     */
    public abstract boolean equals(Object other);
    
    /**
     * @post returns a hash code associated with this structure
     */
    public abstract int hashCode();
}
