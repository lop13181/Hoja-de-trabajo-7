package structure;
/**
 * This error is thrown by the Assert class in the event of a failed
 * invariant test. Errors are thrown rather than exceptions because
 * failed invariants are assumed to be an indication of such
 * an egregious program failure that recovery is impossible.
 *
 *
 * @version $Id: Assert.java,v 4.0 2000/12/27 20:57:33 bailey Exp bailey $
 * @author, 2001 duane a. bailey
 * @see Assert#fail
 */
class FailedInvariant extends FailedAssertion
{
    /**
     * Constructs an error indicating failure to meet an invariant
     *
     * @post Constructs a new failed invariant error
     * @param reason String describing failed condition.
     */
    public FailedInvariant(String reason)
    {
	super("\nInvariant that failed: " + reason);
    }
}
