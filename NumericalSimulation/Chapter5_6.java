
import java.util.Scanner;

/**
 *
 * @author khaled
 */
public class Chapter5_6 {
    //F(x)=x^3 - 6x^2 + 11x -61.
    public static double f(double x){
        return x*x*x - 6*x*x +11*x-61;
    }
     public static double fPrime(double x){
        return 2*x*x - 12*x +11;
    }
     
   //Find the Root.
   // Newton's method to find the root
    public static double newtonMethod(double initialGuess, double epsilon, int maxIterations) {
        double x = initialGuess;
        for (int i = 0; i < maxIterations; i++) {
            double fx = f(x);
            double fpx = fPrime(x);
            if (Math.abs(fx) < epsilon) {
                return x;
            }
            if (fpx == 0) {
                System.out.println("Derivative is zero. No solution found.");
                return Double.NaN;
            }
            x = x - fx / fpx;
        }
        System.out.println("Maximum iterations reached. No solution found.");
        return Double.NaN;
    }

    public static double bisectionMethod(double a, double b, double epsilon, int maxIterations) {
    if (f(a) * f(b) >= 0) {
        System.out.println("The function must have different signs at the endpoints a and b.");
        return Double.NaN;
    }
    double c = a;
    for (int i = 0; i < maxIterations; i++) {
        c = (a + b) / 2;
        if (Math.abs(f(c)) < epsilon || (b - a) / 2 < epsilon) {
            return c;
        }
        if (f(c) * f(a) < 0) {
            b = c;
        } else {
            a = c;
        }
    }
    System.out.println("Maximum iterations reached. No solution found.");
    return c;
}


public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the start point (a): ");
    double a = scanner.nextDouble();

    System.out.print("Enter the end point (b): ");
    double b = scanner.nextDouble();

    System.out.print("Enter epsilon:  ");
    double epsilon = scanner.nextDouble();

    System.out.print("Enter the number of iterations: ");
    int maxIterations = scanner.nextInt();
    
     System.out.print("Enter the initial guess for Newton's method: ");
    double initialGuess = scanner.nextDouble();
    
      
    double newtonResult = newtonMethod(initialGuess, epsilon, maxIterations);
    System.out.println("Newton's method result: " + newtonResult);
        
    double bisectionResult = bisectionMethod(a, b, epsilon, maxIterations);
    System.out.println("Bisection method result: " + bisectionResult);

    scanner.close();
}

}
