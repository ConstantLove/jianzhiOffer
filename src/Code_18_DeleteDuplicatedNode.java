/**
 * 题目十八：删除链表的节点
 * 问题二：删除链表中重复的节点。
 * 在一个排序的链表中，如何删除重复的节点？
 *
 * @author Jackie Ke
 * @date 2019/8/12
 */
public class Code_18_DeleteDuplicatedNode {

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private static Node deleteDuplication(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        Node pre = null;
        Node cur = head;
        Node next = cur.next;
        boolean needDelete = false;
        while (next != null) {
            if (cur.value == next.value) {
                needDelete = true;
                next = next.next;
            } else if (needDelete) {
                if (pre == null) {
                    head = next;
                } else {
                    pre.next = next;
                }
                cur = next;
                next = next.next;
                needDelete = false;
            } else {
                pre = cur;
                cur = next;
                next = next.next;
            }
        }

        if (needDelete && pre != null) {
            pre.next = null;
        } else if (needDelete && pre == null) {
            head = null;
        }

        return head;
    }

    public static void main(String[] args){
        Node node1 = new Node(1);
        Node node2 = new Node(1);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node1 = deleteDuplication(node1);
        while (node1 != null) {
            System.out.print(node1.value + " ");
            node1= node1.next;
        }
        System.out.println();

    }

}
