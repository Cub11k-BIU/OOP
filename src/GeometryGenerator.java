import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * GeometryGenerator.
 *
 * @author Konstantin Ostashenko
 * © 2025
 */
public class GeometryGenerator {
    private final int pointsNumber;
    private final int lineSegmentsNumber;
    private final Random rand = new Random();

    /**
     * Default constructor.
     *
     * @param pointsNumber       number of points to generate
     * @param lineSegmentsNumber number of line segments to generate
     */
    public GeometryGenerator(int pointsNumber, int lineSegmentsNumber) {
        this.pointsNumber = pointsNumber;
        this.lineSegmentsNumber = lineSegmentsNumber;
    }

    /**
     * Generate GeometryRecord instance.
     *
     * @param min minimal allowed point
     * @param max maximal allowed point
     * @return geometry record
     */
    public GeometryRecord generate(Point min, Point max) {
        List<Point> points = this.generatePoints(min, max);
        List<LineSegment> lineSegments = this.generateLineSegments(min, max);
        List<Point> middles = this.calculateMiddles(lineSegments);
        List<Point> intersections = this.calculateIntersections(points, lineSegments);
        List<Point> singles = this.calculateSingles(points, intersections);
        return this.composeGeometryRecord(middles, intersections, singles, lineSegments);
    }

    private Point generateRandomPoint(Point min, Point max) {
        return new Point(
                rand.nextDouble(min.getX(), max.getX()),
                rand.nextDouble(min.getY(), max.getY())
        );
    }

    private LineSegment generateRandomLineSegment(Point min, Point max) {
        Point start = this.generateRandomPoint(min, max);
        Point end = this.generateRandomPoint(min, max);
        return new LineSegment(start, end);
    }

    private List<Point> generatePoints(Point min, Point max) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < this.pointsNumber; i++) {
            points.add(this.generateRandomPoint(min, max));
        }
        return points;
    }

    private List<LineSegment> generateLineSegments(Point min, Point max) {
        List<LineSegment> lineSegments = new ArrayList<>();
        for (int i = 0; i < this.lineSegmentsNumber; i++) {
            lineSegments.add(this.generateRandomLineSegment(min, max));
        }
        return lineSegments;
    }

    private List<Point> calculateMiddles(List<LineSegment> lineSegments) {
        List<Point> middles = new ArrayList<>();
        for (int i = 0; i < this.lineSegmentsNumber; i++) {
            middles.add(lineSegments.get(i).middle());
        }
        return middles;
    }

    private List<Point> calculateIntersections(List<Point> points, List<LineSegment> lineSegments) {
        List<Point> intersections = new ArrayList<>();
        for (Point point : points) {
            for (int i = 0; i < this.lineSegmentsNumber; i++) {
                if (point.belongsTo(lineSegments.get(i))) {
                    intersections.add(point);
                    break;
                }
            }
        }
        return intersections;
    }

    private List<Point> calculateSingles(List<Point> points, List<Point> intersections) {
        List<Point> singles = new ArrayList<>(points);
        singles.removeAll(intersections);
        return singles;
    }

    private GeometryRecord composeGeometryRecord(List<Point> middles,
                                                 List<Point> intersections,
                                                 List<Point> singles,
                                                 List<LineSegment> lineSegments) {
        return new GeometryRecord(middles, intersections, singles, lineSegments);
    }
}
