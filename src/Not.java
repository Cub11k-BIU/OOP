import java.util.Map;
import java.util.Set;

/**
 * Not — logical negation.
 *
 * @author [Author Name]
 * © [YYYY]
 */
public class Not extends UnaryExpression {
    /**
     * Construct with an operand.
     *
     * @param operand the expression to negate
     */
    public Not(Expression operand) {
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
