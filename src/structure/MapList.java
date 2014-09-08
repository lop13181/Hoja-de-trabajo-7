package structure;
import java.util.Map.Entry;
import java.util.Iterator;

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
 * This implementation is based on a list, so performance for most
 * operations is linear.
 * <P>
 * Example Usage:
 * <P>
 * To create a dictionary by reading a collection of words and 
 * definitions from System.in we could use the following!
 * <P> 
 * <pre>
 * public static void main (String[] argv){
 *	Map dict = new {@link #MapList()};
 *	ReadStream r = new ReadStream();
 *	String word, def;
 *	System.out.println("Enter a word: ");
 *	while(!r.eof()){
 *	    word = r.readLine();
 *	    System.out.println("Enter a definition: ");
 *	    def = r.readLine();
 *	    dict.{@link #put(Object,Object) put(word,def)};
 *	    System.out.println("Enter a word: ");
 *	}
 *	System.out.println(dict);
 * }
 * </pre>
 */
public class MapList implements Map
{
    /** 
     * List for storing the entries in this map
     */
    protected List data;
    
    /**
     * Construct an empty map, based on a list
     * @post constructs an empty map, based on a list
     */
    public MapList()
    {
	data = new SinglyLinkedList();
    }

    /**
     * Construct a map with values found in source
     * @post constructs a map with values found in source
     */
    public MapList(Map source)
    {
	this();
	putAll(source);
    }

    /**
     * Returns the number of entries in the map
     * @post returns the number of entries in the map
     */
    public int size()
    {
	return data.size();
    }

    /**
     * @post returns true iff this map does not contains any entries
     */
    public boolean isEmpty()
    {
	return data.isEmpty();
    }

    /**
     * @pre k is non-null
     * @post returns true iff k is a key that is mapped to a value;
     *  that is, k is in the domain of the map
     */
    public boolean containsKey(Object k)
    {
	return data.contains(new Association(k,null));
    }

    /**
     * @pre v is non-null
     * @post returns true iff v is the target of at least one map entry;
     * that is, v is in the range of the map
     */
    public boolean containsValue(Object v)
    {
	Iterator i = new ValueIterator(data.iterator());
	while (i.hasNext())
	{
	    Object value = i.next();
	    if (value != null &&
		v.equals(value)) return true;
	}
	return false;
    }

    /**
     * @pre k is a key, possibly in the map
     * @post returns the value mapped to from k, or null
     */
    public Object get(Object k)
    {
	int i = data.indexOf(new Association(k,null));
	if (i >= 0) return ((Association)data.get(i)).getValue();
	return null;
    }

    /**
     * @pre k and v are non-null
     * @post inserts a mapping from k to v in the map
     */
    public Object put(Object k, Object v)
    {
	Association temp = new Association(k,v);
	Association result = (Association)data.remove(temp);
	data.add(temp);
	if (result == null) return null;
	else return result.getValue();
    }
    
    /**
     * @pre k is non-null
     * @post removes any mapping from k to a value, from the mapping
     */
    public Object remove(Object k)
    {
	Association v = (Association)data.remove(new Association(k,null));
	if (v == null) return null;
	else return v.getValue();
    }

    /**
     * @pre other is non-null
     * @post all the mappings of other are installed in this map,
     * overriding any conflicting maps
     */
    public void putAll(Map other)
    {
	Iterator i = other.entrySet().iterator();
	while (i.hasNext())
	{
	    Association e = (Association)i.next();
	    put(e.getKey(),e.getValue());
	}
    }

    /**
     * @post removes all map entries associated with this map
     */
    public void clear()
    {
	data.clear();
    }

    /**
     * @post returns a set of all keys associated with this map
     */
    public Set keySet()
    {
	Set result = new SetList();
	Iterator i = data.iterator();
	while (i.hasNext())
	{
	    Association a = (Association)i.next();
	    result.add(a.getKey());
	}
	return result;
    }

    /**
     * @post returns a structure that contains the range of the map
     */
    public Structure values()
    {
	Structure result = new SinglyLinkedList();
	Iterator i = new ValueIterator(data.iterator());
	while (i.hasNext())
	{
	    result.add(i.next());
	}
	return result;
    }

    /**
     * @post returns a set of (key-value) pairs, generated from this map
     */
    public Set entrySet()
    {
	Set result = new SetList();
	Iterator i = data.iterator();
	while (i.hasNext())
	{
	    Association a = (Association)i.next();
	    result.add(a);
	}
	return result;
    }

    /**
     * @pre other is non-null
     * @post returns true iff maps this and other are entry-wise equal
     */
    public boolean equals(Object other)
    {
	MapList that = (MapList)other;
	return data.equals(that.data);
    }
    
    /**
     * @post returns a hash code associated with this structure
     */
    public int hashCode()
    {
	return data.hashCode();
    }
}
