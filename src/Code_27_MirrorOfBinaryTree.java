/**
 * 题目二十七：二叉树的镜像
 * 请完成一个函数，输入一棵二叉树，该函数输出它的镜像。
 *
 * @author Jackie Ke
 * @date 2019/8/17
 */
public class Code_27_MirrorOfBinaryTree {

    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private static void mirrorRecusively(Node root) {
        if (root == null) {
            return;
        }

        if (root.left != null && root.right != null) {
            swap(root);
        }

        mirrorRecusively(root.left);
        mirrorRecusively(root.right);
    }

    private static void preOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.value + " ");

        preOrder(root.left);
        preOrder(root.right);
    }

    private static void swap(Node node) {
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    public static void main(String[] args){
        Node root = new Node(8);
        root.left = new Node(6);
        root.right = new Node(10);
        root.left.left = new Node(5);
        root.left.right = new Node(7);
        root.right.left = new Node(9);
        root.right.right = new Node(11);
        mirrorRecusively(root);
        preOrder(root);
    }

}
