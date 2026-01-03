import java.util.*;

class StackQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        queue.add(2);   
        queue.add(3);
        queue.add(4);

        // 1 2 3 4 in queue the first element is removed or FIFO

        System.out.println(queue.poll());

        System.out.println(queue);

        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        // 1 2 3 4 in stack LIFO the last in first out so basically last elemetn isremoved first

        System.out.println(stack.pop());
    }
}