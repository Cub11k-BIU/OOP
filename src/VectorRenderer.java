import biuoop.DrawSurface;
import biuoop.GUI;

import java.awt.Color;

/**
 * VectorRenderer.
 *
 * <p>Draws a vector-addition "playground": two base vectors from a shared
 * origin, their sum as the parallelogram diagonal, and a scaled vector.
 *
 * @author [Author Name]
 * © [YYYY]
 */
public class VectorRenderer {
    private static final int ORIGIN_X = 250;
    private static final int ORIGIN_Y = 430;
    private static final double SCALE = 55.0;
    private static final double SCALE_FACTOR = 1.5;
    private static final double HEAD_PIXELS = 12.0;
    private static final double HEAD_SPREAD = Math.toRadians(25);
    private static final int DOT_RADIUS = 4;
    private static final int LABEL_SIZE = 18;
    private static final int LABEL_OFFSET = 8;

    private static final Color COLOR_A = Color.RED;
    private static final Color COLOR_B = Color.BLUE;
    private static final Color COLOR_SUM = Color.GREEN;
    private static final Color COLOR_SCALED = Color.PINK;
    private static final Color COLOR_GUIDE = Color.GRAY;
    private static final Color COLOR_AXIS = Color.LIGHT_GRAY;
    private static final Color COLOR_TEXT = Color.DARK_GRAY;

    private final GUI gui;

    /**
     * Construct a renderer with the given window size.
     *
     * @param windowWidth  window width
     * @param windowHeight window height
     */
    public VectorRenderer(int windowWidth, int windowHeight) {
        this.gui = new GUI("Vector Addition Playground", windowWidth, windowHeight);
    }

    /**
     * Render the vector-addition scene for vectors `a` and `b`.
     *
     * @param a first vector (red)
     * @param b second vector (blue)
     */
    public void render(Vector a, Vector b) {
        DrawSurface d = this.gui.getDrawSurface();
        this.drawAxes(d);

        Vector sum = a.add(b);
        Vector scaled = a.scale(SCALE_FACTOR);

        this.drawArrow(d, scaled, COLOR_SCALED);

        d.setColor(COLOR_GUIDE);
        d.drawLine(this.tipX(a), this.tipY(a), this.tipX(sum), this.tipY(sum));
        d.drawLine(this.tipX(b), this.tipY(b), this.tipX(sum), this.tipY(sum));

        this.drawArrow(d, a, COLOR_A);
        this.drawArrow(d, b, COLOR_B);
        this.drawArrow(d, sum, COLOR_SUM);

        d.setColor(COLOR_TEXT);
        d.drawText(this.tipX(a) + LABEL_OFFSET, this.tipY(a), "a", LABEL_SIZE);
        d.drawText(this.tipX(b) + LABEL_OFFSET, this.tipY(b), "b", LABEL_SIZE);
        d.drawText(this.tipX(sum) + LABEL_OFFSET, this.tipY(sum), "a + b", LABEL_SIZE);

        this.gui.show(d);
    }

    private int tipX(Vector v) {
        return (int) Math.round(ORIGIN_X + v.getX() * SCALE);
    }

    private int tipY(Vector v) {
        return (int) Math.round(ORIGIN_Y - v.getY() * SCALE);
    }

    private void drawAxes(DrawSurface d) {
        d.setColor(COLOR_AXIS);
        d.drawLine(0, ORIGIN_Y, d.getWidth(), ORIGIN_Y);
        d.drawLine(ORIGIN_X, 0, ORIGIN_X, d.getHeight());
    }

    private void drawArrow(DrawSurface d, Vector v, Color color) {
        int tx = this.tipX(v);
        int ty = this.tipY(v);
        d.setColor(color);
        d.drawLine(ORIGIN_X, ORIGIN_Y, tx, ty);
        d.fillCircle(tx, ty, DOT_RADIUS);
        this.drawArrowHead(d, tx, ty, v);
    }

    // Arrowhead wings are built with Vector ops: shrink the reversed vector to
    // a small length, then rotate it by +/- a spread angle via setDirection.
    private void drawArrowHead(DrawSurface d, int tipX, int tipY, Vector v) {
        Vector back = new Vector(-v.getX(), -v.getY());
        back.setLength(HEAD_PIXELS / SCALE);
        double dir = back.getDirection();
        this.drawWing(d, tipX, tipY, back, dir + HEAD_SPREAD);
        this.drawWing(d, tipX, tipY, back, dir - HEAD_SPREAD);
    }

    private void drawWing(DrawSurface d, int tipX, int tipY, Vector back, double direction) {
        Vector wing = new Vector(back.getX(), back.getY());
        wing.setDirection(direction);
        int wx = (int) Math.round(tipX + wing.getX() * SCALE);
        int wy = (int) Math.round(tipY - wing.getY() * SCALE);
        d.drawLine(tipX, tipY, wx, wy);
    }
}
