import java.util.Stack;

/**
 * 题目五十二：两个链表中的第一个公共节点
 * 输入两个链表，找出它们的第一个公共节点，链表的节点定义如下：
 *
 * @author Jackie Ke
 * @date 2019/8/28
 */
public class Code_52_FirstCommonNodesInLists {

    private static class Node{
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 方法一：先比较两个链表的长度，让长的链表先走（长链表长度-短链表长度）步，
     * 再让两个链表同时走，当找到第一个相同的节点就是我们想要的结果
     * 时间复杂度O(m+n), 无需额外辅助空间
     *
     * @param head1
     * @param head2
     * @return
     */
    private static Node firstCommonNode1(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }

        int length1 = getListLength(head1);
        int length2 = getListLength(head2);
        int lengthDif = length1 - length2;

        Node listHeadLong = head1;
        Node listHeadShort = head2;
        if (length2 > length1) {
            listHeadLong = head2;
            listHeadShort = head1;
            lengthDif = length2 - length1;
        }

        for (int i = 0; i < lengthDif; i++) {
            listHeadLong = listHeadLong.next;
        }

        while (listHeadLong != listHeadShort) {
            listHeadLong = listHeadLong.next;
            listHeadShort = listHeadShort.next;
        }

        return listHeadLong;
    }

    /**
     * 获取一个链表的长度
     *
     * @param head
     * @return
     */
    private static int getListLength(Node head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    /**
     * 方法二：利用堆的后进先出特性。如果两个链表有交集，那末尾的节点一定是相同的。
     * 从末尾开始遍历，当遇到栈顶不相等的情况时，上一个弹出的节点就是两个链表的第一个公共节点
     * 时间复杂度O(m+n)，空间复杂度O(m+n)
     *
     * @param head1
     * @param head2
     * @return
     */
    private static Node firstCommonNode2(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }

        Stack<Node> list1 = new Stack<>();
        Stack<Node> list2 = new Stack<>();

        while (head1 != null) {
            list1.add(head1);
            head1 = head1.next;
        }
        while (head2 != null) {
            list2.add(head2);
            head2 = head2.next;
        }

        while (!list1.isEmpty() && !list2.isEmpty()) {
            //如果两个链表有交集，那弹出的第一个节点一定是相等的
            Node last = list1.pop();
            list2.pop();
            if (list1.peek() != list2.peek()) {
                return last;
            }
        }

        return null;
    }

    public static void main(String[] args){
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        Node head2 = new Node(4);
        head2.next = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        head1.next.next.next = node6;
        head1.next.next.next.next = node7;
        head2.next.next = node6;
        head2.next.next.next = node7;
        System.out.println(firstCommonNode1(head1, head2).value);
        System.out.println(firstCommonNode2(head1, head2).value);
    }

}
