import java.util.Stack;

/**
 * 题目三十一：栈的压入、弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如，序列{1，2，3，4，5}是某栈的压栈顺序，
 * 序列{4，5，3，2，1}是该压栈序列对应的一个弹出序列，但{4，3，5，1，2}就不可能是该压栈序列的弹出序列
 *
 * @author Jackie Ke
 * @date 2019/8/18
 */
public class Code_31_StackPushPopOrder {

    private static boolean isPopOrder(int[] push, int[] pops) {
        if (push == null || pops == null || push.length != pops.length) {
            return false;
        }

        Stack<Integer> stack = new Stack<>();
        int pushIndex = 0;
        int popIndex = 0;
        while (pushIndex < push.length) {
            if (push[pushIndex] == pops[popIndex]) {
                pushIndex++;
                popIndex++;
            } else {
                stack.push(push[pushIndex++]);
            }
        }

        for (int i = popIndex; i < pops.length; i++) {
            if (stack.pop() != pops[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        int[] push = {1, 2, 3, 4, 5};
        int[] pops1 = {4, 5, 3, 2, 1};
        int[] pops2 = {4, 3, 5, 1, 2};
        int[] test1 = {4};
        int[] test2 = {4};
        int[] test3 = {3};
        System.out.println(isPopOrder(push, pops1));  //输入两个数组含有多个数字且第二个数组是第一个数组的弹出序列
        System.out.println(isPopOrder(push, pops2));  //输入两个数组含有多个数字且第二个数组不是第一个数组的弹出序列
        System.out.println(isPopOrder(test1, test2)); //输入两个数组只含有一个数字且第二个数组是第一个数组的弹出序列
        System.out.println(isPopOrder(test1, test3)); //输入两个数组只含有一个数字且第二个数组不是第一个数组的弹出序列
        System.out.println(isPopOrder(null, null)); //特殊输入测试：输入两个null指针
    }

}
