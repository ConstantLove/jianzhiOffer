/**
 * 题目二十八：对称的二叉树
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * @author Jackie Ke
 * @date 2019/8/17
 */
public class Code_28_SymmetricalBinaryTree {

    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private static boolean isSymmetrical(Node root) {
        if (root == null) {
            return false;
        }
        return isSymmetrical(root, root);
    }

    private static boolean isSymmetrical(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.value != root2.value) {
            return false;
        }

        return isSymmetrical(root1.left, root2.right)
                && isSymmetrical(root1.right, root2.left);
    }

    public static void main(String[] args){
        Node root = new Node(8);
        root.left = new Node(6);
        root.right = new Node(6);
        root.left.left = new Node(5);
        root.left.right = new Node(7);
        root.right.left = new Node(7);
        root.right.right = new Node(5);

        System.out.println(isSymmetrical(root));
        System.out.print(isSymmetrical(null));
    }

}
