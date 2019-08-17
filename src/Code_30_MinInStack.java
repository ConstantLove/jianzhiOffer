import java.util.Stack;

/**
 * 题目三十：包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min函数。
 * 在该栈中，调用min、push及pop的时间复杂度都是O(1).
 *
 * @author Jackie Ke
 * @date 2019/8/17
 */
public class Code_30_MinInStack {

    private static class MyStack {
        private int[] arr;
        private int[] mins;
        private int index;
        private int min;

        public MyStack(int initsize) {
            if (initsize < 0) {
                throw new IllegalArgumentException("初始化大小不能小于0");
            }
            arr = new int[initsize];
            mins = new int[initsize];
            min = Integer.MIN_VALUE;
            index = 0;
        }

        public int peek() {
            if (index == 0) {
                throw new ArrayIndexOutOfBoundsException("栈为空");
            }
            return arr[index - 1];
        }

        public void push(int obj) {
            if (index == arr.length) {
                throw new ArrayIndexOutOfBoundsException("栈已满");
            }

            if (index == 0) {
                min = obj;
            } else {
                min = obj < mins[index - 1] ? obj : mins[index - 1];
            }

            arr[index] = obj;
            mins[index] = min;
            index++;
        }

        public int pop() {
            if (index == 0) {
                throw new ArrayIndexOutOfBoundsException("栈为空");
            }

            return arr[--index];
        }

        public int getMin() {
            if (index == 0) {
                throw new ArrayIndexOutOfBoundsException("栈为空");
            }

            return mins[index - 1];
        }
    }

    private static class MyStack2{
        private Stack<Integer> stack;
        private Stack<Integer> mins;

        public MyStack2() {
            stack = new Stack<>();
            mins = new Stack<>();
        }

        public int peek() {
            if (!stack.isEmpty()) {
                throw new ArrayIndexOutOfBoundsException("栈为空");
            }

            return stack.peek();
        }

        public void push(int obj) {
            stack.push(obj);
            if (mins.isEmpty()) {
                mins.push(obj);
            } else {
                mins.push(obj < mins.peek() ? obj : mins.peek());
            }
        }

        public int pop() {
            if (stack.isEmpty()) {
                throw new ArrayIndexOutOfBoundsException("栈为空");
            }

            mins.pop();
            return stack.pop();
        }

        public int getMin() {
            if (mins.isEmpty()) {
                throw new ArrayIndexOutOfBoundsException("栈为空");
            }

            return mins.peek();
        }
    }

    public static void main(String[] args){
        MyStack stack = new MyStack(2);
        stack.push(1);
        stack.push(2);
        System.out.println(stack.getMin());
        System.out.println(stack.pop());
        System.out.println(stack.getMin());

        MyStack2 stack2 = new MyStack2();
        stack2.push(3);
        stack2.push(4);
        System.out.println(stack2.getMin());
        System.out.println(stack2.pop());
        System.out.println(stack2.getMin());
    }

}
