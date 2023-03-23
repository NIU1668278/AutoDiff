public class Constant implements Expression{
    private double value;
    public Constant(Double value){
        this.value = value;
    }
    public DualNumber evaluate(DualNumber dn){
        return new DualNumber(this.value, 0);
    }

}