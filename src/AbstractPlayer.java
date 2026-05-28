/**
 * AbstractPlayer — provided immutable-player base.
 *
 * <p>Holds the name and position and supplies {@link #getName()} /
 * {@link #getPosition()} (both {@code final}); a player produces a
 * <em>new</em> instance via {@link #moveTo(int)} rather than mutating itself.
 * Both the student {@code Player} and the grader's canonical player extend this
 * type so they are interchangeable through {@code GameFactory}.
 *
 * @author Konstantin Ostashenko
 * © 2025
 */
public abstract class AbstractPlayer {
    private final String name;
    private final int position;

    /**
     * Construct a player.
     *
     * @param name     the player name
     * @param position the player's position
     */
    protected AbstractPlayer(String name, int position) {
        this.name = name;
        this.position = position;
    }

    /**
     * Return the player's name.
     *
     * @return the name
     */
    public final String getName() {
        return name;
    }

    /**
     * Return the player's current position.
     *
     * @return the position
     */
    public final int getPosition() {
        return position;
    }

    /**
     * Return a new player at the given position; the original is unchanged.
     *
     * @param newPosition the new position
     * @return a new player at {@code newPosition}
     */
    public abstract AbstractPlayer moveTo(int newPosition);
}
