/**
 * AbstractPlayer — provided immutable-player contract.
 *
 * <p>A player exposes its name and current position, and produces a
 * <em>new</em> instance via {@link #moveTo(int)} rather than mutating itself.
 * Both the student {@code Player} and the grader's canonical player share this
 * type so they are interchangeable through {@code GameFactory}.
 *
 * @author Konstantin Ostashenko
 * © 2025
 */
public abstract class AbstractPlayer {
    /**
     * Return the player's name.
     *
     * @return the name
     */
    public abstract String getName();

    /**
     * Return the player's current position.
     *
     * @return the position
     */
    public abstract int getPosition();

    /**
     * Return a new player at the given position; the original is unchanged.
     *
     * @param newPosition the new position
     * @return a new player at {@code newPosition}
     */
    public abstract AbstractPlayer moveTo(int newPosition);
}
