package structure;
/**
 * This error is thrown by the Assert class in the event of a failed
 * precondition. Errors are thrown rather than exceptions because
 * failed preconditions are assumed to be an indication of such
 * an egregious program failure that recovery is impossible.
 *
 * @version $Id: Assert.java,v 4.0 2000/12/27 20:57:33 bailey Exp bailey $
 * @author, 2001 duane a. bailey
 * @see Assert#pre
 */
class FailedPrecondition extends FailedAssertion
{
    /**
     * Constructs an error indicating failure to meet a precondition.
     *
     * @post Constructs a new failed precondition
     * 
     * @param reason String describing precondition.
     */
    public FailedPrecondition(String reason)
    {
	super("\nA precondition: " + reason);
    }
}

