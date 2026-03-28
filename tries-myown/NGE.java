import java.util.*;

class NGE {

    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        int arr[] = { 6, 8, 0, 1, 3 };
        int nge[] = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                stack.push(arr[i]);
                nge[i] = -1;
            } else {
                if (arr[i] < stack.peek()) {
                    nge[i] = stack.peek();
                    stack.push(arr[i]);
                } else if (arr[i] > stack.peek()) {
                    while (!stack.isEmpty() && stack.peek() < arr[i]) {
                        stack.pop();
                    }

                    if (stack.isEmpty()) {
                        nge[i] = -1;
                    } else {
                        nge[i] = stack.peek();
                    }
                    stack.push(arr[i]);
                }
            }
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(nge));
    }
}
