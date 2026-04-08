/**
 * RiggedDice — deterministic dice that returns a fixed cycling sequence.
 *
 * @author [Author Name]
 * © [YYYY]
 */
public class RiggedDice implements Dice {
    /**
     * Construct with a fixed sequence; {@code roll()} cycles through it.
     *
     * @param sequence the rigged sequence
     */
    public RiggedDice(int[] sequence) {
    }

    @Override
    public int roll() {
        return 0;
    }
}
