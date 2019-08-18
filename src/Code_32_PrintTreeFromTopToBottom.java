import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目三十二：上从到下打印二叉树
 * 题目一：不分行从上到下打印二叉树
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印
 *
 * @author Jackie Ke
 * @date 2019/8/18
 */
public class Code_32_PrintTreeFromTopToBottom {

    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private static void printFromTopToBottom(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.value + " ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public static void main(String[] args){
//        完全二叉树
//        Node root = new Node(8);
//        root.left = new Node(6);
//        root.right = new Node(10);
//        root.left.left = new Node(5);
//        root.left.right = new Node(7);
//        root.right.left = new Node(9);
//        root.right.right = new Node(11);
//        printFromTopToBottom(root);

//        所有节点只有左节点的二叉树
//        Node root = new Node(7);
//        root.left = new Node(8);
//        root.left.left = new Node(6);
//        root.left.left.left = new Node(10);
//        printFromTopToBottom(root);

//        所有节点只有右节点的二叉树
//        Node root = new Node(7);
//        root.right = new Node(8);
//        root.right.right = new Node(6);
//        root.right.right.right = new Node(10);
//        printFromTopToBottom(root);

//        特殊输入测试
        printFromTopToBottom(null);

        Node root = new Node(7);
        printFromTopToBottom(root);
    }

}
