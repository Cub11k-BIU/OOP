import biuoop.DrawSurface;
import biuoop.GUI;

import java.awt.Color;

/**
 * GeometryRenderer.
 *
 * @author [Author Name]
 * © [YYYY]
 */
public class GeometryRenderer {
    private static final int DEFAULT_POINT_RADIUS = 4;

    private static final Color DEFAULT_LINE_SEGMENT_COLOR = Color.RED;
    private static final Color DEFAULT_SINGLE_POINT_COLOR = Color.BLACK;
    private static final Color DEFAULT_MIDDLE_POINT_COLOR = Color.BLUE;
    private static final Color DEFAULT_INTERSECTION_POINT_COLOR = Color.GREEN;

    private final GUI gui;

    /**
     * Default constructor.
     *
     * @param windowWidth  width of the window to render
     * @param windowHeight height of the window to render
     */
    public GeometryRenderer(int windowWidth, int windowHeight) {
        this.gui = new GUI("Random Lines and Intersections", windowWidth, windowHeight);
    }

    /**
     * Render GeometryRecord.
     *
     * @param geometryRecord data to render
     */
    public void render(GeometryRecord geometryRecord) {
        DrawSurface d = this.gui.getDrawSurface();
        this.drawGeometryRecord(d, geometryRecord);
        this.gui.show(d);
    }

    /**
     * Close GUI.
     */
    public void close() {
        this.gui.close();
    }

    private void drawPoint(Point p, DrawSurface d, Color c) {
        int x = (int) Math.round(p.getX());
        int y = (int) Math.round(p.getY());
        d.setColor(c);
        d.fillCircle(x, y, DEFAULT_POINT_RADIUS);
    }

    private void drawLine(LineSegment line, DrawSurface d, Color c) {
        int x1 = (int) Math.round(line.getP1().getX());
        int y1 = (int) Math.round(line.getP1().getY());
        int x2 = (int) Math.round(line.getP2().getX());
        int y2 = (int) Math.round(line.getP2().getY());
        d.setColor(c);
        d.drawLine(x1, y1, x2, y2);
    }

    private void drawGeometryRecord(DrawSurface d, GeometryRecord geometryRecord) {
        for (LineSegment lineSegment : geometryRecord.lineSegments()) {
            this.drawLine(lineSegment, d, DEFAULT_LINE_SEGMENT_COLOR);
        }
        for (Point middle : geometryRecord.middles()) {
            this.drawPoint(middle, d, DEFAULT_MIDDLE_POINT_COLOR);
        }
        for (Point intersection : geometryRecord.intersections()) {
            this.drawPoint(intersection, d, DEFAULT_INTERSECTION_POINT_COLOR);
        }
        for (Point single : geometryRecord.singles()) {
            this.drawPoint(single, d, DEFAULT_SINGLE_POINT_COLOR);
        }
    }
}
