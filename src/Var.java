import java.util.Map;
import java.util.Set;

/**
 * Var — a named variable leaf expression.
 *
 * @author [Author Name]
 * © [YYYY]
 */
public class Var extends BaseExpression {
    /**
     * Construct with a variable name.
     *
     * @param name the variable name
     */
    public Var(String name) {
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
