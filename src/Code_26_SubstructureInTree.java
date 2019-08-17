/**
 * 题目二十六：树的子结构
 * 输入两棵二叉树A和B，判断B是不是A的子结构。
 *
 * @author Jackie Ke
 * @date 2019/8/17
 */
public class Code_26_SubstructureInTree {

    private static class Node {
        double value;
        Node left;
        Node right;

        public Node(double value) {
            this.value = value;
        }
    }

    private static boolean hasSubtree(Node root1, Node root2) {
        boolean result = false;

        if (root1 != null && root2 != null) {
            if (Double.compare(root1.value, root2.value) == 0) {
                result = doseTree1HaveTree2(root1, root2);
            }

            if (!result) {
                result = hasSubtree(root1.left, root2) || hasSubtree(root1.right, root2);
            }
        }

        return result;
    }

    private static boolean doseTree1HaveTree2(Node root1, Node root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }

        if (Double.compare(root1.value, root2.value) != 0) {
            return false;
        }

        return doseTree1HaveTree2(root1.left, root2.left) && doseTree1HaveTree2(root1.right, root2.right);
    }

    /**
     * 中序遍历：左，中，右
     * @param root 树的根节点
     */
    private static void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.value + " ");
        inorder(root.right);
    }

    public static void main(String[] args){
        Node root1 = new Node(8);
        root1.left = new Node(8);
        root1.right = new Node(7);
        root1.left.left = new Node(9);
        root1.left.right = new Node(2);
        root1.left.right.left = new Node(4);
        root1.left.right.right = new Node(7);
        Node root2 = new Node(8);
        root2.left = new Node(9);
        root2.right = new Node(2);

        System.out.println(hasSubtree(root1, root2));
    }

}
