/**
 * ParkingRecord.
 *
 * @author [Author Name]
 * © [YYYY]
 */
public interface ParkingRecord {

    /**
     * Return the vehicle associated with this record.
     *
     * @return the parked vehicle
     */
    Vehicle getVehicle();

    /**
     * Return the spot occupied by the vehicle.
     *
     * @return the parking spot
     */
    ParkingSpot getSpot();
}
