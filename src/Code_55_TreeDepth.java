/**
 * 题目五十五：二叉树的深度
 * 题目一：二叉树的深度
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）
 * 形成树的一条路径，最长路径的长度为树的深度
 *
 * @author Jackie Ke
 * @date 2019/8/31
 */
public class Code_55_TreeDepth {

    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private static int treeDepth(Node head) {
        if (head == null) {
            return 0;
        }

        int leftDepth = treeDepth(head.left);
        int rightDepth = treeDepth(head.right);

        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
    }

    public static void main(String[] args){
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.right = new Node(6);
        head.left.right.left = new Node(7);

        System.out.print(treeDepth(head));
    }

}
