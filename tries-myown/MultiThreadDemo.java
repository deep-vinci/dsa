import java.util.Random;

public class MultiThreadDemo {
    public static void main(String[] args) {
        Thread generator = new Thread(() -> {
            Random rand = new Random();

            while (true) {
                int num = rand.nextInt(100);
                System.out.println("Generated: " + num);

                if (num % 2 == 0) {
                    // Even -> square thread
                    Thread squareThread = new Thread(() -> {
                        System.out.println("Square of " + num + " = " + (num * num));
                    });
                    squareThread.start();
                } else {
                    // Odd -> cube thread
                    Thread cubeThread = new Thread(() -> {
                        System.out.println("Cube of " + num + " = " + (num * num * num));
                    });
                    cubeThread.start();
                }

                try {
                    Thread.sleep(1); // wait 1 second before next number
                } catch (InterruptedException e) {
                    System.out.println("Interrupted: " + e.getMessage());
                }
            }
        });

        generator.start();
    }
}
