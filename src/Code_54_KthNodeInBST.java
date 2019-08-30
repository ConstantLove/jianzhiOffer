import java.util.Stack;

/**
 * 题目五十四：二叉搜索树的第k大节点
 * 给定一个二叉搜索树，请找出其中第k大的节点。例如，在图6.1中的二叉搜索树里，
 * 按节点数值大小排序，第三大节点的值是4。
 *
 * @author Jackie Ke
 * @date 2019/8/30
 */
public class Code_54_KthNodeInBST {

    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private static Node kthNode(Node head, int k) {
        if (head == null || k < 0) {
            return null;
        }

        Stack<Node> stack = new Stack<>();
        Node cur = head;
        int count = 0;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                count++;
                if (count == k) {
                    return cur;
                }
                cur = cur.right;
            }
        }

        return null;
    }

    public static void main(String[] args){
        Node head = new Node(5);
        head.left = new Node(3);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.right = new Node(7);
        head.right.left = new Node(6);
        head.right.right = new Node(8);
        System.out.println(kthNode(head, 3).value);
    }
}
