/**
 * 题目十八：删除链表的节点
 * 问题一：在 O(1) 时间内删除链表节点
 * 给定单向链表的头指针和一个节点指针，定义一个函数在O(1)时间内删除该节点。
 *
 * @author Jackie Ke
 * @date 2019/8/11
 */
public class Code_18_DeleteNodeInList {

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private static Node deleteNodeInList(Node head, Node deleteNode) {
        if (head == null || deleteNode == null) {
            return null;
        }
        //如果链表只有一个节点，删除的是头节点（也是尾节点）
        if (head.next == null && head == deleteNode) {
            return null;
        }

        if (deleteNode.next != null) {
            deleteNode.value = deleteNode.next.value;
            deleteNode.next = deleteNode.next.next;
        } else {
            while (head != null && head.next != deleteNode) {
                head = head.next;
            }
            head.next = null;
        }

        return head;
    }

    public static void main(String[] args){
        Node node1 = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(7);
        Node node4 = new Node(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Node node = deleteNodeInList(node1, node1); //从有多个节点的链表中删除头节点
        //Node node = deleteNodeInList(node1, node3); //从有多个节点的链表中删除中间节点
        //Node node = deleteNodeInList(node1, node4); //从有多个节点的链表中删除尾节点
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }

        System.out.println();

        node = new Node(2);
        node = deleteNodeInList(node, node); //从只有一个节点的链表中删除唯一的节点
        System.out.print(node);

        deleteNodeInList(null , null); //特殊输入测试
    }

}
