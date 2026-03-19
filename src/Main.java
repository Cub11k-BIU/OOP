/**
 * Main.
 *
 * @author [Author Name]
 * © [YYYY]
 */
public class Main {
    /**
     * Main method.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        GeometryGenerator generator = new GeometryGenerator(50, 20);
        GeometryRenderer renderer = new GeometryRenderer(800, 600);
        renderer.render(generator.generate(new Point(50, 50), new Point(750, 550)));
    }
}
