import java.util.Collection;

/**
 * ParkingStrategy.
 *
 * @author [Author Name]
 * © [YYYY]
 */
public interface ParkingStrategy {
    /**
     * Finds an appropriate, unoccupied ParkingSpot for the given vehicle.
     * Returns null if no suitable spot is found.
     *
     * @param vehicle the vehicle to park
     * @param floors  the collection of floors in the parking lot
     * @return a suitable ParkingSpot, or null if none found
     */
    ParkingSpot findSpot(Vehicle vehicle, Collection<ParkingFloor> floors);
}
