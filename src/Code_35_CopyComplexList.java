/**
 * 题目三十五：复杂链表的复制
 * 请实现函数 Node clone(Node head), 复制一个复杂链表。
 * 在复杂链表中，每个节点除了有一个next指针指向下一个节点，还有一个sibling指针指向链表中的任意节点或者null
 *
 * @author Jackie Ke
 * @date 2019/8/20
 */
public class Code_35_CopyComplexList {

    private static class Node {
        int value;
        Node next;
        Node sibling;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 第一步，复制原始链表的任意节点N并创建新节点N'，再把N'链接到N的后面
     * @param head 链表头节点
     */
    private static void cloneNodes(Node head) {
        Node node = head;
        while (node != null) {
            Node cloned = new Node(node.value);
            cloned.next = node.next;
            cloned.sibling = null;

            node.next = cloned;
            node = cloned.next;
        }
    }

    /**
     * 第二步，复制原始链表节点的sibling。如果原始链表上的节点N的sibling指向S，
     * 则它对应的复制节点N'的sibling指向S的复制节点S'。
     * @param head 链表头节点
     */
    private static void connectSiblingNodes(Node head) {
        Node node = head;
        while (node != null) {
            Node cloned = node.next;
            if (node.sibling != null) {
                cloned.sibling = node.sibling.next;
            }
            node = cloned.next;
        }
    }

    /**
     * 第三部，把第二步得到的链表拆分成两个链表。
     * @param head 链表的头节点
     * @return 复制完成的链表的头节点
     */
    private static Node reconnectNodes(Node head) {
        Node node = head;
        Node clonedHead = null;
        Node clonedNode = null;

        if (node != null) {
            clonedHead = clonedNode = node.next;
            node.next = clonedNode.next;
            node = node.next;
        }

        while (node != null) {
            clonedNode.next = node.next;
            clonedNode = clonedNode.next;
            node.next = clonedNode.next;
            node = node.next;
        }

        return clonedHead;
    }

    /**
     * 整合上面的三步，就是复制链表的完整过程
     * @param head 链表的头节点
     * @return 复制完成的链表的头节点
     */
    private static Node clone(Node head) {
        cloneNodes(head);
        connectSiblingNodes(head);
        return reconnectNodes(head);
    }

    private static void print(Node head) {
        while (head != null) {
            if (head.sibling != null) {
                System.out.print(head.value);
                System.out.print("(" + head.sibling.value + ") ");
            } else {
                System.out.print(head.value + " ");
            }
            head = head.next;
        }
    }

    public static void main(String[] args){
        Node A = new Node(1);
        Node B = new Node(2);
        Node C = new Node(3);
        Node D = new Node(4);
        Node E = new Node(5);
        A.next = B;
        B.next = C;
        C.next = D;
        D.next = E;
        A.sibling = C;
        B.sibling = E;
        D.sibling = B;

        print(clone(A));
    }

}
