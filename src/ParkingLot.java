import java.util.Collection;

/**
 * ParkingLot.
 *
 * @author [Author Name]
 * © [YYYY]
 */
public class ParkingLot {

    /**
     * Default constructor. Initializes an empty lot
     * with the original Assignment 3 behaviors as default strategies.
     */
    public ParkingLot() {
    }

    /**
     * Construct a ParkingLot with the given strategies.
     *
     * @param parkingStrategy strategy for finding parking spots
     * @param timingStrategy  strategy for calculating billable time
     * @param feeStrategy     strategy for calculating parking fees
     */
    public ParkingLot(ParkingStrategy parkingStrategy,
                      TimingStrategy timingStrategy,
                      FeeStrategy feeStrategy) {
    }

    /**
     * Return the collection of floors in the parking lot.
     *
     * @return collection of floors
     */
    public Collection<ParkingFloor> getFloors() {
        return null;
    }

    /**
     * Add a floor to the parking lot.
     *
     * @param floor floor to add
     */
    public void addFloor(ParkingFloor floor) {
    }

    /**
     * Attempt to park the provided vehicle in the parking lot.
     *
     * @param v vehicle to park
     * @return `true` if successful, `false` otherwise
     */
    public boolean parkVehicle(Vehicle v) {
        return false;
    }

    /**
     * Unpark the vehicle associated with the given license plate.
     * Return the calculated parking fee, or `-1` if not found.
     *
     * @param licensePlate      license plate of the vehicle to unpark
     * @param durationInMinutes duration the vehicle was parked
     * @return parking fee, or `-1` if not found
     */
    public int unparkVehicle(String licensePlate, int durationInMinutes) {
        return -1;
    }

    /**
     * Return the current parking records.
     *
     * @return parking records
     */
    public Collection<?> getRecords() {
        return null;
    }
}
