public class Exp implements Expression{
    private Expression expr;
    public Exp(Expression expr){
        this.expr = expr;
    }
    public DualNumber evaluate(DualNumber dn){
        dn = expr.evaluate(dn);
        return new DualNumber(Math.exp(dn.u), dn.uprime*Math.exp(dn.u));
    }

}