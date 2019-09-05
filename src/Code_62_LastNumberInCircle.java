/**
 * 题目六十二：圆圈中最后剩下的数字
 * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。
 * 求出这个圆圈里最后剩下的一个数字。
 *
 * @author Jackie Ke
 * @date 2019/9/5
 */
public class Code_62_LastNumberInCircle {

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private static int lastRemaining(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }

        Node head = new Node(0);
        Node cur = head;
        for (int i = 1; i < n; i++) {
            cur.next = new Node(i);
            cur = cur.next;
        }
        cur.next = head;
        cur = head;

        while (true) {
            if (cur.value == cur.next.value) {
                return cur.value;
            }

            for (int i = 1; i < m; i++) {
                cur = cur.next;
            }

            cur.value = cur.next.value;
            cur.next = cur.next.next;
        }
    }

    public static void main(String[] args){
        System.out.println(lastRemaining(5,3)); //3
        System.out.println(lastRemaining(6,7)); //4
        System.out.println(lastRemaining(0,7)); //-1
    }

}
