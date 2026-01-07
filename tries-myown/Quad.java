import java.util.Scanner;

class Quad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double a, b, c, d, r1, r2;

        System.out.println("Enter a: ");
        a = sc.nextDouble();
        System.out.println("Enter b: ");
        b = sc.nextInt();
        System.out.println("Enter c: ");
        c = sc.nextInt();

        d = b * b - 4 * a * c;

        if (d > 0) {
            r1 = (-b + Math.sqrt(d)/2*a);
            r2 = (-b - Math.sqrt(d)/2*a);
            System.out.printf("two real root %.2f %.2f\n", Math.abs(r1), Math.abs(r2));
        } else if (d == 0) {
            r1 = -b / 2*a;
            System.out.println("One root");
        } else {
            System.out.println("No real sol");
        }
    }
}