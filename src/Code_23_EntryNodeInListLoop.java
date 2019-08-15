/**
 * 题目二十三：链表中环的入口节点
 * 如果一个链表中包含环，如何找出环的入口节点？例如，在如图3.8所示的链表中，环的入口节点是节点3.
 *
 * @author Jackie Ke
 * @date 2019/8/15
 */
public class Code_23_EntryNodeInListLoop {

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private static Node entryNodeOfLoop(Node head) {
        if (head == null) {
            return null;
        }

        Node fast = head;
        Node slow = head;
        //声明一个快指针一个慢指针，快指针每次走两步，慢指针每次走一步
        //如果链表中存在环，那么两个指针一定会相遇。
        while (fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }

        if (fast == slow) { //链表中存在环
            int count = 1;
            while (fast.next != slow) { //获取形成环的节点数
                fast = fast.next;
                count++;
            }

            fast = head;
            slow = head;
            //让快指针先走环的节点数，再让快指针和慢指针同步走
            //当快指针与慢指针再次相遇时，它们相遇的节点就是环的入口节点
            for (int i = 0; i < count; i++) {
                fast = fast.next;
            }
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }

            return fast;
        }

        return null;
    }

    public static void main(String[] args){
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = head.next.next.next;
        System.out.print(entryNodeOfLoop(head).value);
    }

}
