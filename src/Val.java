import java.util.Map;
import java.util.Set;

/**
 * Val — a constant boolean leaf expression.
 *
 * @author [Author Name]
 * © [YYYY]
 */
public class Val extends BaseExpression {
    /**
     * Construct with a boolean constant.
     *
     * @param value the constant boolean value
     */
    public Val(boolean value) {
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
