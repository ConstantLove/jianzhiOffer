import java.util.Stack;

/**
 * 题目九：用两个栈实现队列
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数appendTail和deleteHead，
 * 分别完成在队列尾部插入节点和在队列头部删除节点的功能
 *
 * @author Jackie Ke
 * @date 2019/7/28
 */
public class Code_09_QueueWithTwoStacks {

    /**
     * 用两个栈实现队列结构，队列先进先出，栈后进先出，先把所有压到一个栈里的值倒到另一个辅助栈中，
     * 再弹出辅助栈的栈顶，实现先进先出。
     *
     * @param <T>
     */
    private static class Queue<T> {
        private Stack<T> stack;
        private Stack<T> help;

        public Queue() {
            stack = new Stack<>();
            help = new Stack<>();
        }

        public void appendTail(T t) {
            if (t == null) {
                throw new IllegalArgumentException("The parameter is null !!!");
            }
            stack.add(t);
        }

        public T deleteHead() {
            if (help.isEmpty() && stack.isEmpty()) {
                throw new RuntimeException("The Queue is empty !!!");
            } else if (help.isEmpty()) {
                infunde();
            }
            return help.pop();
        }

        private void infunde() {
            while (!stack.isEmpty()) {
                help.add(stack.pop());
            }
        }
    }

    public static void main(String[] args){
        Queue<Integer> queue = new Queue<>();
        queue.appendTail(4);
        queue.appendTail(1);
        queue.appendTail(3);
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
    }

}
