/**
 * FlatRateFeeStrategy.
 *
 * @author [Author Name]
 * © [YYYY]
 */
public class FlatRateFeeStrategy implements FeeStrategy {

    /** Hourly rate, in currency units per billable unit. Value is up to you. */
    public static final int HOURLY_RATE = 10;

    /**
     * Compute the fee for the given billable time.
     *
     * @param billableTime billable units
     * @return computed fee
     */
    @Override
    public int calculateFee(int billableTime) {
        return 0;
    }
}
