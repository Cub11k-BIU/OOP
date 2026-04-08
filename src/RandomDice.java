/**
 * RandomDice — production singleton dice that returns a random value 1..6.
 *
 * @author [Author Name]
 * © [YYYY]
 */
public final class RandomDice implements Dice {
    private RandomDice() {
    }

    /**
     * Return the singleton instance.
     *
     * @return the singleton
     */
    public static RandomDice getInstance() {
        return null;
    }

    @Override
    public int roll() {
        return 0;
    }
}
