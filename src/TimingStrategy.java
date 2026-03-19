/**
 * TimingStrategy.
 *
 * @author [Author Name]
 * © [YYYY]
 */
public interface TimingStrategy {
    /**
     * Calculates the number of billable units (e.g., hours)
     * based on the total minutes parked.
     *
     * @param durationInMinutes total minutes parked
     * @return number of billable units
     */
    int calculateBillableTime(int durationInMinutes);
}
