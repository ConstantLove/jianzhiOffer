import java.util.Stack;

/**
 * 题目六：从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来打印出每个节点的值
 *
 * @author Jackie Ke
 * @date 2019/7/28
 */
public class Code_06_PrintListInReversedOrder {

    private static class Node{
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 方法一：利用栈先进后出的特性，实现逆向打印
     *
     * @param head 头节点
     */
    private static void printByStack(Node head) {
        if (head == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        while (head != null) {
            stack.add(head);
            head = head.next;
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop().value + " ");
        }
    }

    /**
     * 方法二：利用递归的特性，实现逆向打印
     * @param head
     */
    private static void printByRecur(Node head) {
        if (head == null) {
            return;
        }

        printByRecur(head.next);
        System.out.print(head.value + " ");
    }

    public static void main(String[] args){
        Node head = new Node(1);   //链表为 1-3-5-7-9
        head.next = new Node(3);
        head.next.next = new Node(5);
        head.next.next.next = new Node(7);
        head.next.next.next.next = new Node(9);
        printByStack(head);   //应该输出9-7-5-3-1
        System.out.println();
        printByRecur(head);   //应该输出9-7-5-3-1
        //特殊测试
        head = null;
        printByStack(head);
    }
}
