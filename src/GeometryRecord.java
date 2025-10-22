import java.util.List;

/**
 * GeometryRecord.
 *
 * @param middles       middle points of line segments
 * @param intersections point-segment intersections
 * @param singles       single points with no intersections
 * @param lineSegments  line segments
 * @author Konstantin Ostashenko
 * © 2025
 */
public record GeometryRecord(List<Point> middles, List<Point> intersections, List<Point> singles,
                             List<LineSegment> lineSegments) {
}
