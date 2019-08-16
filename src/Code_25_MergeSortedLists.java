/**
 * 题目二十五：合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的
 *
 * @author Jackie
 * @date 2019/8/16
 */
public class Code_25_MergeSortedLists {

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 方法一：普通解法
     * @param head1
     * @param head2
     * @return
     */
    private static Node merge(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }

        Node head = null;
        Node result = null;

        while (head1 != null && head2 != null) {
            if (head1.value <= head2.value) {
                if (head == null) {
                    head = head1;
                    result = head;
                    head1 = head1.next;
                } else {
                    head.next = head1;
                    head = head.next;
                    head1 = head1.next;
                }
            } else {
                if (head == null) {
                    head = head2;
                    result = head;
                    head2 = head2.next;
                } else {
                    head.next = head2;
                    head = head.next;
                    head2 = head2.next;
                }
            }
        }

        //两个循环只会有一个生效
        while (head1 != null) {
            head.next = head1;
            head = head.next;
            head1 = head1.next;
        }
        while (head2 != null) {
            head.next = head2;
            head = head.next;
            head2 = head2.next;
        }

        return result;
    }

    /**
     * 方法二：递归解法
     * @param head1
     * @param head2
     * @return
     */
    private static Node recursionMerge(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        Node head = null;

        if (head1.value < head2.value) {
            head = head1;
            head.next = merge(head1.next, head2);
        } else {
            head = head2;
            head.next = merge(head1, head2.next);
        }

        return head;
    }

    private static void print(Node head) {
        if (head == null) {
            return;
        }

        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        //功能测试：输入的两个链表有多个节点；节点的值互不相同或者存在值相等的多个节点
        Node head1 = new Node(1);
        head1.next = new Node(3);
        head1.next.next = new Node(5);
        head1.next.next.next = new Node(7);
        Node head2 = new Node(2);
        head2.next = new Node(3);
        head2.next.next = new Node(3);
        head2.next.next.next = new Node(8);
//        print(merge(head1, head2));
        print(recursionMerge(head1, head2));

        //特殊输入测试：两个链表的一个头节点或者两个头节点为null；两个链表中只有一个节点
        print(merge(null, null));

        head1 = new Node(1);
        head2 = new Node(2);
        print(merge(head1, head2));
    }

}
