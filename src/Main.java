import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Main — demonstrates loading a board, playing a full game, and saving history.
 *
 * @author Konstantin Ostashenko
 * © 2025
 */
public final class Main {
    private Main() {
    }

    /**
     * Entry point. Without arguments, prints usage and returns. With one
     * argument, treats it as a board configuration file path, plays a full
     * game with two players using {@link RandomDice}, and writes the history
     * to {@code match_history.txt}.
     *
     * @param args optional path to a board configuration file
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java Main <board.txt>");
            return;
        }
        Board board;
        try {
            board = loadBoard(args[0]);
        } catch (IOException e) {
            System.err.println("Failed to read board file: " + e.getMessage());
            return;
        }
        List<Player> players = new ArrayList<>();
        players.add(GameFactory.player("Alice"));
        players.add(GameFactory.player("Bob"));
        GameEngine engine = GameFactory.engine(board, players, RandomDice.getInstance());
        while (!engine.isGameOver()) {
            engine.playTurn();
        }
        engine.saveHistory("match_history.txt");
        System.out.println("Winner: " + engine.getWinner().getName());
    }

    /**
     * Parse a board configuration file in the format
     * {@code <size>\n[<S|L> <start> <end>\n]...}.
     *
     * @param path path to the configuration file
     * @return a {@link Board} described by the file
     * @throws IOException if the file cannot be read
     */
    private static Board loadBoard(String path) throws IOException {
        List<BoardEntity> entities = new ArrayList<>();
        int size;
        try (BufferedReader reader = Files.newBufferedReader(Path.of(path))) {
            size = Integer.parseInt(reader.readLine().trim());
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }
                String[] parts = line.split("\\s+");
                int start = Integer.parseInt(parts[1]);
                int end = Integer.parseInt(parts[2]);
                if ("S".equals(parts[0])) {
                    entities.add(GameFactory.snake(start, end));
                } else if ("L".equals(parts[0])) {
                    entities.add(GameFactory.ladder(start, end));
                }
            }
        }
        return GameFactory.board(size, entities);
    }
}
