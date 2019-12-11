
import java.util.Scanner;

public class Equazione {

    public static void main(String[] args)
    {
        int x = 0;
        int z = x +4;
        double k = z * Math.PI;
        double t = Math.sin(k);
        
        Scanner input = new Scanner(System.in);
        double a, b, c;
        a = input.nextDouble();
        b = input.nextDouble();
        c = input.nextDouble();
        double delta = b*b-4*a*c;
        if (delta > 0) {
            double x1 = (-b + Math.sqrt(delta))/(2*a);
            double x2 = (-b - Math.sqrt(delta))/(2*a);
            System.out.println("Le soluzioni dell'equazione di coefficienti");
            System.out.println(a+"x^2 "+b+"x "+c+" sono ");
            System.out.println("x1 = "+x1+", x2= "+x2);
        } 
        else {
            System.out.println("mi spiace. discriminante negativo");
        }
        
    }

}