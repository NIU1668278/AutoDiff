public class Pow implements Expression {
    private Expression expr;
    private double exponent;

    public Pow(Expression expr, double exponent) {
        this.expr = expr;
        this.exponent = exponent;
    }

    public DualNumber evaluate(DualNumber dn) {
        dn = expr.evaluate(dn);
        return new DualNumber(Math.pow(dn.u, exponent), exponent*Math.pow(dn.u, exponent-1)*dn.uprime);
    }
}