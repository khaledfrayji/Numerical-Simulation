
import java.util.Scanner;

/*
 *
 * @author khaled frayji
 */
public class Chapter3 {

    // x' = x , you can implement your own function.
    public static double FPrime(double x) {
        return x; 
    }

    // Second derivative of x 
    public static double FSecond(double x) {
        return 1;
    }

    public static double Euler(double xi, double step, int iteration) {
        double x1 = xi; 
        for (int i = 0; i < iteration; i++) {
            x1 = x1 + (step * FPrime(x1));
        }
        return x1;
    }

    public static double Taylor(double xi, double step, int iteration) {
        double x1 = xi; 
        for (int i = 0; i < iteration; i++) {
            x1 = x1 + (step * FPrime(x1) + (step * step * FSecond(x1)) / 2);
        }
        return x1;
    }

    public static double EulerMidpoint(double xk, double step, int iteration) {
        double x1 = xk; 
        for (int i = 0; i < iteration; i++) {
            double xHalf = x1 + (step / 2) * FPrime(x1);
            x1 = x1 + step * FPrime(xHalf);
        }
        return x1;
    }

    public static double RungeKutta(double xi, double step, int iteration) {
        double x1 = xi; 
        for (int i = 0; i < iteration; i++) {
            double k0 = FPrime(x1);
            double k1 = FPrime(x1 + (step / 2) * k0);
            double k2 = FPrime(x1 + (step / 2) * k1);
            double k3 = FPrime(x1 + step * k2);
            x1 = x1 + step / 6 * (k0 + 2 * k1 + 2 * k2 + k3);
        }
        return x1;
    }

    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

        System.out.print("Enter initial value (xi): ");
        double xi = scanner.nextDouble();

        System.out.print("Enter step size (step): ");
        double step = scanner.nextDouble();

        System.out.print("Enter number of iterations: ");
        int iteration = scanner.nextInt();

        double eulerResult = Euler(xi, step, iteration);
        double taylorResult = Taylor(xi, step, iteration);
        double eulerMidpointResult = EulerMidpoint(xi, step, iteration);
        double rungeKuttaResult = RungeKutta(xi, step, iteration);

        System.out.println("Euler method result: " + eulerResult);
        System.out.println("Taylor method result: " + taylorResult);
        System.out.println("Euler Midpoint method result: " + eulerMidpointResult);
        System.out.println("Runge-Kutta method result: " + rungeKuttaResult);

        scanner.close();
    }
}

