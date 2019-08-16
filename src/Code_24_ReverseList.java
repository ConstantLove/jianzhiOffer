/**
 * 题目二十四：反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点
 *
 * @author Jackie
 * @date 2019/8/16
 */
public class Code_24_ReverseList {

    private static class Node {
        int key;
        Node next;

        public Node(int key) {
            this.key = key;
        }
    }

    private static Node reverseList(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        Node reverseHead = null;
        Node cur = head;
        Node pre = null;
        while (cur != null) {
            Node next = cur.next;

            if (next == null) {
                reverseHead = cur;
            }

            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return reverseHead;
    }

    private static Node recursionReverseList(Node head, Node pre) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            head.next = pre;
            return head;
        }

        Node next = head.next;
        head.next = pre;
        pre = head;
        return recursionReverseList(next, pre);
    }

    public static void main(String[] args){
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head = reverseList(head);              //普通解法
        head = recursionReverseList(head, null); //递归解法
        while (head != null) {
            System.out.print(head.key + " ");
            head = head.next;
        }
    }

}