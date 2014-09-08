package structure;
/**
 * This error is thrown by the Assert class in the event of any failed
 * assertion test. Errors are thrown rather than exceptions because
 * failed assertions are assumed to be an indication of such
 * an egregious program failure that recovery is impossible.
 *
 * @version $Id: Assert.java,v 4.0 2000/12/27 20:57:33 bailey Exp bailey $
 * @author, 2001 duane a. bailey
 * @see Assert#fail
 */
class FailedAssertion extends Error
{
    /**
     * Constructs an error indicating failure to meet condition.
     *
     * @post Constructs a new failed assertion error
     * 
     * @param reason String describing failed condition.
     */
    public FailedAssertion(String reason)
    {
	super("\nAssertion that failed: " + reason);
    }
}
