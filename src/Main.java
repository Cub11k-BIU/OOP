/**
 * Main.
 *
 * @author [Author Name]
 * © [YYYY]
 */
public class Main {
    /**
     * Demonstrate vector addition visually.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Vector a = new Vector(3, 2);
        Vector b = new Vector(1, 3);
        VectorRenderer renderer = new VectorRenderer(800, 600);
        renderer.render(a, b);
    }
}
