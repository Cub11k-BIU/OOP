/**
 * RiggedDice — deterministic dice that returns a fixed cycling sequence.
 *
 * @author Konstantin Ostashenko
 * © 2025
 */
public class RiggedDice implements Dice {
    private final int[] sequence;
    private int index;

    /**
     * Construct with a fixed sequence; {@code roll()} cycles through it.
     *
     * @param sequence the rigged sequence
     */
    public RiggedDice(int[] sequence) {
        this.sequence = sequence.clone();
        this.index = 0;
    }

    @Override
    public int roll() {
        int value = sequence[index];
        index = (index + 1) % sequence.length;
        return value;
    }
}
