public class DualNumber {
    public double u;
    public double uprime;
    public DualNumber(double u, double uprime){
        this.u = u;
        this.uprime = uprime;
    }

    public String toString(){

        return "<"+String.valueOf(this.u)+","+String.valueOf(this.uprime)+">";
    }

}
