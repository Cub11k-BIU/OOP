/**
 * HourlyRoundUpTimingStrategy.
 *
 * @author [Author Name]
 * © [YYYY]
 */
public class HourlyRoundUpTimingStrategy implements TimingStrategy {

    /**
     * Calculate billable units from raw parked minutes.
     *
     * @param durationInMinutes total minutes parked
     * @return billable units
     */
    @Override
    public int calculateBillableTime(int durationInMinutes) {
        return 0;
    }
}
