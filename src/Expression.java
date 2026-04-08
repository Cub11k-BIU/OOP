import java.util.Map;
import java.util.Set;

/**
 * Expression — the root interface of the logic-expression composite.
 *
 * @author [Author Name]
 * © [YYYY]
 */
public interface Expression {
    /**
     * Evaluate the expression using the provided variable assignments.
     *
     * @param assignment map of variable name to boolean value
     * @return the boolean result of evaluation
     * @throws Exception if the expression contains an unassigned variable
     */
    Boolean evaluate(Map<String, Boolean> assignment) throws Exception;

    /**
     * Convenience overload — evaluate with an empty assignment.
     * Use only when the expression contains no variables.
     *
     * @return the boolean result of evaluation
     * @throws Exception if any variable is encountered
     */
    Boolean evaluate() throws Exception;

    /**
     * Return the set of unique variable names in this expression.
     *
     * @return set of variable names (unordered, unique)
     */
    Set<String> getVariables();

    /**
     * Return a readable string representation of this expression
     * using the operator symbols defined in Part 3 of the spec.
     *
     * @return the string form of this expression
     */
    String toString();

    /**
     * Return a new expression with all occurrences of {@code var}
     * replaced by {@code expression}.
     *
     * @param var        the variable name to replace
     * @param expression the expression to substitute in its place
     * @return a new expression tree
     */
    Expression assign(String var, Expression expression);

    /**
     * Return an equivalent expression built only from Nand, Var, and Val nodes.
     *
     * @return a new expression equivalent to this one, using only NAND
     */
    Expression nandify();

    /**
     * Return an equivalent expression built only from Nor, Var, and Val nodes.
     *
     * @return a new expression equivalent to this one, using only NOR
     */
    Expression norify();

    /**
     * Return a simplified equivalent expression.
     *
     * @return a new, simplified expression
     */
    Expression simplify();
}
