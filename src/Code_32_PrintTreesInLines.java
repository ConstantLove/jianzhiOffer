import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目三十二：上从到下打印二叉树
 * 题目二：分行从上到下打印二叉树
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 *
 * @author Jackie Ke
 * @date 2019/8/18
 */
public class Code_32_PrintTreesInLines {

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

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int balance = 1;
        int nextLevel = 0;

        while (!queue.isEmpty()) {
            Node node =  queue.poll();
            System.out.print(node.value + " ");
            balance--;

            if (node.left != null) {
                queue.add(node.left);
                nextLevel++;
            }
            if (node.right != null) {
                queue.add(node.right);
                nextLevel++;
            }

            if (balance == 0) {
                System.out.println();
                balance = nextLevel;
                nextLevel = 0;
            }
        }
    }

    public static void main(String[] args){
        //完全二叉树
        Node root = new Node(8);
        root.left = new Node(6);
        root.right = new Node(10);
        root.left.left = new Node(5);
        root.left.right = new Node(7);
        root.right.left = new Node(9);
        root.right.right = new Node(11);
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
