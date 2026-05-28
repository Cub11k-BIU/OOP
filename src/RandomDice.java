import java.util.Random;

/**
 * RandomDice — production singleton dice that returns a random value 1..6.
 *
 * @author Konstantin Ostashenko
 * © 2025
 */
public final class RandomDice implements Dice {
    private static final RandomDice INSTANCE = new RandomDice();

    private final Random random;

    private RandomDice() {
        this.random = new Random();
    }

    /**
     * Return the singleton instance.
     *
     * @return the singleton
     */
    public static RandomDice getInstance() {
        return INSTANCE;
    }

    @Override
    public int roll() {
        return random.nextInt(6) + 1;
    }
}
