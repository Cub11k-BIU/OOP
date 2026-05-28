/**
 * Player — strictly immutable player.
 *
 * <p>The name, position and their getters are provided by {@link AbstractPlayer};
 * implement {@link #moveTo(int)} so it returns a new instance.
 *
 * @author [Author Name]
 * © [YYYY]
 */
public class Player extends AbstractPlayer {
    /**
     * Construct a player at position 0.
     *
     * @param name the player name
     */
    public Player(String name) {
        this(name, 0);
    }

    private Player(String name, int position) {
        super(name, position);
    }

    /**
     * <b>Stub:</b> implement this method.
     *
     * <p>Return a new {@code Player} instance with the updated position;
     * the original instance must remain unchanged.
     *
     * @param newPosition the new position
     * @return a new Player at the given position
     */
    @Override
    public Player moveTo(int newPosition) {
        return null;
    }
}
