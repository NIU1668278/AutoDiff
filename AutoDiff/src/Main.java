public class Main {
    private static double f(double x) {
        return Math.sin(Math.PI/2.0 + x*x)+3*x*x;
    }
    private static double df(double x) {
        return Math.cos(Math.PI/2.0 + x*x)*2*x+6*x;
    }
    private static double g_desc_asc(double xn, double h, int k, int d_a){
        Expression x = new X();
        Expression expr = new Multiply(new Pow(x, 2), new Add(new Pow(new Sin(x), 2), new Cos(x)));

        for(int i=0; i<k; i++){
            xn = xn + d_a*h*expr.evaluate(new DualNumber(xn, 1.0)).uprime;
        }
        return xn;
    }


    public static void main(String[] args) {
        Expression x = new X();
        Expression expr = new Add(new Sin(new Add(new Constant(Math.PI/2.0),
                new Multiply(x,x))), new Multiply(new Constant(3.0), new Pow(x, 2)));

        double x0 = 2.0;
        DualNumber res = expr.evaluate(new DualNumber(x0, 1.0));
        double valorReal = f(x0);
        double derivadaReal = df(x0);



        System.out.println("sin(pi/2 + x^2) + 3x^2, x0 = 2.0");
        System.out.println("real");
        System.out.println("f(" + x0 +") = "+valorReal);
        System.out.println("f'(" + x0 + ") = "+derivadaReal);
        System.out.println("calculat");
        System.out.println("f(" + x0 + ") = "+res.u);
        System.out.println("f'(" + x0 + ") = "+res.uprime);
        System.out.println("diferencia valor "
                + (valorReal - res.u));
        System.out.println("diferencia derivada "
                + (derivadaReal - res.uprime));

        System.out.println("derivada per diferencies finites");
        final double[] epsilons = {1e-6, 1e-8, 1e-10, 1e-12};
        for (int i=0; i<epsilons.length; i++) {
            double derivadaDifFinites = (f(x0+epsilons[i])-f(x0)) / epsilons[i];
            System.out.println("per epsilon "+epsilons[i] + ","+derivadaDifFinites+", " + "diferencia " + (derivadaReal - derivadaDifFinites));
        }

        //Local maximum and minimum gradient ascent/descent

        //using x0 = 2.0
        double x1 = 2.0;
        double h = 0.001;
        int k = 1000;
        int d_a = 1;


        System.out.println("\nMàxims i mínims de f(x)=x^2(sin(x)^2+cos x):");

        double res1 = g_desc_asc(x1, h, k, d_a);
        System.out.println("Màxim proper a x=2: x=" + String.valueOf(res1));

        d_a = -1;
        double res2 = g_desc_asc(x1, h, k, d_a);
        System.out.println("Mínim proper a x=2: x=" + String.valueOf(res2));

        x1=10.0;
        d_a=1;
        double res3 = g_desc_asc(x1, h, k, d_a);
        System.out.println("Màxim proper a x=10: x=" + String.valueOf(res3));

        d_a = -1;
        double res4 = g_desc_asc(x1, h, k, d_a);
        System.out.println("Mínim proper a x=10: x=" + String.valueOf(res4));
    }


}
