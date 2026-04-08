import java.util.Map;
import java.util.Set;

/**
 * Nor — logical NOR (not-or).
 *
 * @author [Author Name]
 * © [YYYY]
 */
public class Nor extends BinaryExpression {
    /**
     * Construct with two operands.
     *
     * @param left  the left operand
     * @param right the right operand
     */
    public Nor(Expression left, Expression right) {
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return false;
    }

    @Override
    public Boolean evaluate() throws Exception {
        return false;
    }

    @Override
    public Set<String> getVariables() {
        return null;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return null;
    }

    @Override
    public Expression nandify() {
        return null;
    }

    @Override
    public Expression norify() {
        return null;
    }

    @Override
    public Expression simplify() {
        return null;
    }
}
