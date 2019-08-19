import java.util.Stack;

/**
 * 题目三十二：上从到下打印二叉树
 * 题目三：之字形打印二叉树
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推
 *
 * @author Jackie Ke
 * @date 2019/8/19
 */
public class Code_32_PrintTreesInZigzag {

    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private static void print(Node root) {
        if (root == null) {
            return;
        }

        Stack<Node> odd =  new Stack<>();
        Stack<Node> even = new Stack<>();
        odd.push(root);

        while (!odd.isEmpty() || !even.isEmpty()) {
            if (!odd.isEmpty()) {
                while (!odd.isEmpty()) {
                    Node node = odd.pop();
                    System.out.print(node.value + " ");
                    if (node.left != null) {
                        even.push(node.left);
                    }
                    if (node.right != null) {
                        even.push(node.right);
                    }
                }
                System.out.println();
            } else {
                while (!even.isEmpty()) {
                    Node node = even.pop();
                    System.out.print(node.value + " ");
                    if (node.right != null) {
                        odd.push(node.right);
                    }
                    if (node.left != null) {
                        odd.push(node.left);
                    }
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args){
        //完全二叉树
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(11);
        root.right.left.left = new Node(12);
        root.right.left.right = new Node(13);
        root.right.right.left = new Node(14);
        root.right.right.right = new Node(15);
        print(root);

//        所有节点只有左节点的二叉树
//        Node root = new Node(7);
//        root.left = new Node(8);
//        root.left.left = new Node(6);
//        root.left.left.left = new Node(10);
//        print(root);
//        所有节点只有右节点的二叉树
//        Node root = new Node(7);
//        root.right = new Node(8);
//        root.right.right = new Node(6);
//        root.right.right.right = new Node(10);
//        print(root);

//        特殊输入测试
//        print(null);
//
//        Node root = new Node(7);
//        print(root);
    }

}
