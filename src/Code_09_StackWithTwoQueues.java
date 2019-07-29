import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目九-2：用两个队列实现栈
 *
 * @author Jackie
 * @date ${date}
 */
public class Code_09_StackWithTwoQueues {

    private static class Stack<T> {
        Queue<T> queue;
        Queue<T> help;

        public Stack() {
            queue = new LinkedList<>();
            help = new LinkedList<>();
        }

        public void appendTail(T t) {
            if (t == null) {
                throw new RuntimeException("The param is null !!!");
            }
            queue.add(t);
        }

        public T deleteHead() {
            if (queue.isEmpty()) {
                throw new RuntimeException("The Stack is empty !!!");
            }
            while (queue.size() > 1) {
                help.add(queue.poll());
            }
            T result = queue.poll();
            turn();
            return result;
        }

        private void turn() {
            Queue<T> temp = queue;
            queue = help;
            help = temp;
        }
    }

    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        stack.appendTail(3);
        stack.appendTail(5);
        stack.appendTail(2);
        stack.appendTail(7);
        System.out.println(stack.deleteHead());
        System.out.println(stack.deleteHead());
        System.out.println(stack.deleteHead());
        System.out.println(stack.deleteHead());
        System.out.println(stack.deleteHead()); // 特殊测试，对空栈进行弹出操作
    }

}
