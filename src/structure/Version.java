// The version of this release.
// (c) 2001,2002 duane a. bailey
package structure;
/**
 * A utility class that can be used to determine the version of software
 * currently being used. 
 * Simply run this class from the command prompt to see the version info.
 */
public class Version
{
    public final static int major = 5;
    public final static String minor = "23-Aug-2002-13:16";
    public final static String name = "structure";
    public final static String author = "duane a. bailey";
    public final static String info = "package "+name+", version "+major+", release "+minor+", (c) 1997-2002 "+author;

    public static void main(String args[])
    {
	if (args.length != 0)
	{
	    if (args[0].equals("-m")) System.out.println(minor);
	    else if (args[0].equals("-M")) System.out.println(major);
	    else if (args[0].equals("-p")) System.out.println(name);
	    else if (args[0].equals("-a")) System.out.println(author);
	} else System.out.println(info);
    }
}





