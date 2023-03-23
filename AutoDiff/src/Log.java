public class Log implements Expression {
    private Expression expr;

    public Log(Expression expr) {
        this.expr = expr;
    }

    public DualNumber evaluate(DualNumber dn) {
        dn = expr.evaluate(dn);
        return new DualNumber(Math.log(dn.u), dn.uprime * dn.u);
    }
}
