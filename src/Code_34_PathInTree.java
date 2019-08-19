import java.util.Stack;

/**
 * 题目三十四：二叉树中和为某一值的路径
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 * 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 *
 * @author Jackie Ke
 * @date 2019/8/19
 */
public class Code_34_PathInTree {

    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private static void findPath(Node root, int expectedSum) {
        if (root == null) {
            return;
        }

        Stack<Integer> path = new Stack<>();
        int currentSum = 0;
        findPath(root, expectedSum, path, currentSum);
    }

    private static void findPath(Node root, int expectedSum, Stack<Integer> path, int currentSum) {
        currentSum += root.value;
        path.push(root.value);

        //如果是叶节点，并且路径上的节点值的和等于输入的值，打印这条路径
        boolean isLeaf = root.left == null && root.right == null;
        if (currentSum == expectedSum && isLeaf) {
            System.out.print("A path is found : ");
            for (Integer i : path) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        //如果不是叶节点，继续遍历子节点
        if (root.left != null) {
            findPath(root.left, expectedSum, path, currentSum);
        }
        if (root.right != null) {
            findPath(root.right, expectedSum, path, currentSum);
        }

        //如果是叶节点，并且路径上的节点值不等于输入的值，返回之前弹出该叶节点
        path.pop();
    }

    public static void main(String[] args){
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(12);
        root.left.left = new Node(4);
        root.left.right = new Node(7);
        findPath(root, 22);
    }

}
