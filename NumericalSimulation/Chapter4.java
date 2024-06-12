


import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author khaled
 */
public class Chapter4 {

    // Function f(x) = x^2
    public static double f(double x) {
        return x * x;
    }

    // Method 1: Integral using f(ti) = f(xi-1)
    public static double method1(double a, double b, int n) {
        double step = (b - a) / n;
        double integral = 0;
        for (int i = 1; i <= n; i++) {
            double xi_1 = a + (i - 1) * step;
            integral += f(xi_1) * step;
        }
        return integral;
    }

    // Method 2: Integral using f(ti) = f(xi)
    public static double method2(double a, double b, int n) {
        double step = (b - a) / n;
        double integral = 0;
        for (int i = 1; i <= n; i++) {
            double xi = a + i * step;
            integral += f(xi) * step;
        }
        return integral;
    }

    // Method 3: Integral using f(ti) = f(midpoint((xi-1 + xi)/2))
    public static double method3(double a, double b, int n) {
        double step = (b - a) / n;
        double integral = 0;
        for (int i = 1; i <= n; i++) {
            double xi_1 = a + (i - 1) * step;
            double xi = a + i * step;
            double midpoint = (xi_1 + xi) / 2;
            integral += f(midpoint) * step;
        }
        return integral;
    }

    // Method 4: Integral using f(ti) = max(f(xi-1), f(xi))
    public static double method4(double a, double b, int n) {
        double step = (b - a) / n;
        double integral = 0;
        for (int i = 1; i <= n; i++) {
            double xi_1 = a + (i - 1) * step;
            double xi = a + i * step;
            integral += Math.max(f(xi_1), f(xi)) * step;
        }
        return integral;
    }

    // Method 5: Integral using f(ti) = min(f(xi-1), f(xi))
    public static double method5(double a, double b, int n) {
        double step = (b - a) / n;
        double integral = 0;
        for (int i = 1; i <= n; i++) {
            double xi_1 = a + (i - 1) * step;
            double xi = a + i * step;
            integral += Math.min(f(xi_1), f(xi)) * step;
        }
        return integral;
    }

    // Method 6: Integral using f(ti) = (f(xi-1) + f(xi)) / 2 (Trapezoid rule)
    public static double method6(double a, double b, int n) {
        double step = (b - a) / n;
        double integral = 0;
        for (int i = 1; i <= n; i++) {
            double xi_1 = a + (i - 1) * step;
            double xi = a + i * step;
            integral += (f(xi_1) + f(xi)) / 2 * step;
        }
        return integral;
    }
    //Monte Carlo methode:
     public static double monteCarlo(double a, double b, int numPoints) {
        Random random = new Random();
        double sum = 0;
        for (int i = 0; i < numPoints; i++) {
          sum+=f(random.nextDouble(a,b));
        }
        return ((b - a)/numPoints) * sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the lower bound (a): ");
        double a = scanner.nextDouble();

        System.out.print("Enter the upper bound (b): ");
        double b = scanner.nextDouble();

        System.out.print("Enter the number of subdivisions (n): ");
        int n = scanner.nextInt();
        
        System.out.print("Enter the number of random points: ");
        int numPoints = scanner.nextInt();

       

      
        double result1 = method1(a, b, n);
        double result2 = method2(a, b, n);
        double result3 = method3(a, b, n);
        double result4 = method4(a, b, n);
        double result5 = method5(a, b, n);
        double result6 = method6(a, b, n);
        double monteCarloResult = monteCarlo(a, b, numPoints);
        System.out.println("Method 1 (f(ti) = f(xi-1)) result: " + result1);
        System.out.println("Method 2 (f(ti) = f(xi)) result: " + result2);
        System.out.println("Method 3 (f(ti) = f(midpoint)) result: " + result3);
        System.out.println("Method 4 (f(ti) = max(f(xi-1), f(xi))) result: " + result4);
        System.out.println("Method 5 (f(ti) = min(f(xi-1), f(xi))) result: " + result5);
        System.out.println("Method 6 (f(ti) = (f(xi-1) + f(xi)) / 2) result: " + result6);
        System.out.println("Monte Carlo method result: " + monteCarloResult);
        scanner.close();
    }
}
