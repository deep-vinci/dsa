import java.util.Scanner;

class Matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();

        int[][] a = new int[s][s];  
        int[][] b = new int[s][s];
        int[][] r = new int[s][s];
        System.out.println("Enter matrix A");

        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter matrix B");

        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                b[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                for (int k = 0; k < s; k++) {
                    r[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                System.out.printf("%d ", r[i][j]);
            }
            System.out.println();
        }

        
        sc.close();
    }
}