/**
 * 题目八：二叉树的下一个节点
 * 给定一棵二叉树和其中的一个节点，如何找出中序遍历序列的下一个节点？
 * 树中的节点分别指向左、右子节点，还有一个指向父节点
 *
 * @author Jackie Ke
 * @date 2019/7/28
 */
public class Code_08_NextNodeInBinaryTrees {

    private static class Node {
        String value;
        Node parent;
        Node left;
        Node right;

        public Node(String value) {
            this.value = value;
        }
    }

    /**
     * 在二叉树的中序遍历中，如果一个节点有右子节点，那么这个节点的下一节点是右子节点的最左子节点。
     * 如果这个节点没有右子节点，那么从这个的父节点开始往上遍历，直到遇到一个是它父节点的左子节点的节点。
     * 如果这样的节点存在，那么这个节点的父节点就是我们要找的下一个节点。
     *
     * @param node 二叉树中的某一个节点
     * @return 传入节点的下一个节点
     */
    private static Node findNextNode(Node node) {
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            return getLeftMost(node);
        }

        Node parent = node.parent;
        while (parent != null && node != parent.left) {
            node = parent;
            parent = node.parent;
        }

        return parent;
    }

    /**
     * 找到传入节点的最左子节点，如果没有左子节点，则返回它自己
     *
     * @param node 二叉树中的某一个节点
     * @return 传入节点的最左子节点或其本身
     */
    private static Node getLeftMost(Node node) {
        if (node == null) {
            return null;
        }

        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

}
