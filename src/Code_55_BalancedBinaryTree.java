/**
 * 题目五十五：二叉树的深度
 * 题目二：平衡二叉树
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左、右子树的深度相差不超过1，
 * 那么它就是一棵平衡二叉树。
 *
 * @author Jackie Ke
 * @date 2019/9/1
 */
public class Code_55_BalancedBinaryTree {

    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private static boolean isBalanced(Node head) {
        if (head == null) {
            return true;
        }

        return isBalancedCore(head, new int[]{0});
    }

    private static boolean isBalancedCore(Node node, int[] depth) {
        if (node == null) {
            depth[0] = 0;
            return true;
        }

        int[] left = new int[]{0};
        int[] right = new int[]{0};

        if (isBalancedCore(node.left, left) && isBalancedCore(node.right, right)) {
            int diff = left[0] - right[0];
            if (diff <= 1 && diff >= -1) {
                depth[0] = (left[0] > right[0] ? left[0] : right[0]) + 1;
                return true;
            } else {
                return false;
            }
        }

        return false;
    }

    public static void main(String[] args){
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        head.right.right.right = new Node(8);
        head.right.right.right.right = new Node(9);

        System.out.print(isBalanced(head));
    }

}
