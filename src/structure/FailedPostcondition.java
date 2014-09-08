package structure;
/**
 * This error is thrown by the Assert class in the event of a failed
 * postcondition. Errors are thrown rather than exceptions because
 * failed postconditions are assumed to be an indication of such
 * an egregious program failure that recovery is impossible.
 *
 * @version $Id: Assert.java,v 4.0 2000/12/27 20:57:33 bailey Exp bailey $
 * @author, 2001 duane a. bailey
 */
class FailedPostcondition extends FailedAssertion
{
    /**
     * Constructs an error indicating failure to meet a postcondition.
     *
     * @post Constructs a new failed postcondition
     * 
     * @param reason String describing postcondition.
     */
    public FailedPostcondition(String reason)
    {
	super("\nA postcondition: " + reason);
    }
}
