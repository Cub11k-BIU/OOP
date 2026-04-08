import java.util.List;

/**
 * TurnSnapshot — immutable record of the state at the end of a turn.
 *
 * @author [Author Name]
 * © [YYYY]
 */
public class TurnSnapshot {
    /**
     * Construct a snapshot.
     *
     * @param name    name of the player who just moved
     * @param rolled  value they rolled
     * @param players list of all players (in player-list order) at end of turn
     */
    public TurnSnapshot(String name, int rolled, List<Player> players) {
    }

    /**
     * Return the rolling player's name.
     *
     * @return the name
     */
    public String getName() {
        return null;
    }

    /**
     * Return the rolled value.
     *
     * @return the dice value
     */
    public int getRolled() {
        return 0;
    }

    /**
     * Return the player list at end of turn (in player-list order).
     *
     * @return the players
     */
    public List<Player> getPlayers() {
        return null;
    }
}
