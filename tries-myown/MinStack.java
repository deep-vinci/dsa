import java.util.*;

class MinStack {

    public static void main(String[] args) {
        Stack<int[]> stack = new Stack<>();

        Scanner sc = new Scanner(System.in);
        while (true) {
            int code = sc.nextInt();
            if (code == 1) {
                // push
                int element = sc.nextInt();

                if (stack.isEmpty()) {
                    stack.push(new int[] { element, element });
                } else {
                    int topElement = stack.peek()[1];
                    int currMin = Math.min(element, topElement);

                    stack.push(new int[] { element, currMin });
                }
            } else if (code == 2) {
                // pop
                System.out.println(stack.pop());
            } else if (code == 3) {
                // peek
                System.out.println(stack.peek()[0]);
                System.out.println(stack.peek()[1]);
            } else if (code == 4) {
                // min display
                System.out.println(stack.peek()[0]);
                System.out.println(stack.peek()[1]);
            } else {
                System.out.println("Exiting..");
                break;
            }
        }
    }
}
