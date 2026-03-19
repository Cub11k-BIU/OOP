/**
 * FeeStrategy.
 *
 * @author [Author Name]
 * © [YYYY]
 */
public interface FeeStrategy {
    /**
     * Calculates the final parking fee.
     * The hourly rate is defined as a constant within each implementation.
     *
     * @param billableTime billable time units
     * @return parking fee
     */
    int calculateFee(int billableTime);
}
