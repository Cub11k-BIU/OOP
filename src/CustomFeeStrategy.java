/**
 * CustomFeeStrategy.
 *
 * @author [Author Name]
 * © [YYYY]
 */
public class CustomFeeStrategy implements FeeStrategy {

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
