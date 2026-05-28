/**
 * ParkingLotListener.
 *
 * <p>Observer notified of events from a {@link ParkingLot}.
 *
 * @author [Author Name]
 * © [YYYY]
 */
public interface ParkingLotListener {
    /**
     * Called after a vehicle is successfully parked.
     *
     * @param record the record of the parked vehicle and its spot
     */
    void onVehicleParked(ParkingRecord record);

    /**
     * Called after a vehicle is successfully unparked.
     *
     * @param record the record of the unparked vehicle and its spot
     * @param fee    the fee returned by unparkVehicle
     */
    void onVehicleUnparked(ParkingRecord record, int fee);

    /** Called the moment the lot becomes completely full. */
    void onLotFull();

    /** Called the moment the lot stops being full (a spot frees up). */
    void onSpotAvailable();
}
