import java.util.List;

/**
 * GeometryRecord.
 *
 * @param middles                middle points of line segments
 * @param pointIntersections     point-segment intersections
 * @param singles                single points with no intersections
 * @param lineSegments           line segments
 * @param segmentIntersections   segment-segment intersections
 * @author [Author Name]
 * © [YYYY]
 */
public record GeometryRecord(List<Point> middles, List<Point> pointIntersections, List<Point> singles,
                             List<LineSegment> lineSegments, List<LineSegment> segmentIntersections) {
}
