/**
 * 题目三十六：二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * 比如，输入图4.15中左边的二叉搜索树，则输出转换之后的排序双向链表。
 *
 * @author Jackie Ke
 * @date 2019/8/20
 */
public class Code_36_ConvertBinarySearchTree {

    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node convert(Node root){
        if(root==null)
            return null;
        Node[] result = convertCore(root);
        return result[0];
    }
    public static Node[] convertCore(Node node){
        //java不支持泛型数组，所以声明为这种形式
        Node[] result = new Node[2];
        if(node.left==null&&node.right==null){
            result[0] = node;
            result[1] = node;
        }
        else if(node.right==null){
            result = convertCore(node.left);
            node.left = result[1];
            result[1].right = node;
            result[1] = node;
        }
        else if(node.left==null){
            result = convertCore(node.right);
            node.right = result[0];
            result[0].left = node;
            result[0] = node;
        }
        else{
            Node[] resultLeft = convertCore(node.left);
            Node[] resultRight = convertCore(node.right);
            resultLeft[1].right = node;
            node.left = resultLeft[1];
            resultRight[0].left = node;
            node.right = resultRight[0];
            result[0] = resultLeft[0];
            result[1] = resultRight[1];
        }
        return result;

    }

    public static void main(String[] args){
        Node root = new Node(10);
        root.left = new Node(6);
        root.right = new Node(14);
        root.left.left = new Node(4);
        root.left.right = new Node(8);
        root.right.left = new Node(12);
        root.right.right = new Node(16);
        Node head = convert(root);

        while (head != null) {
            System.out.print(head.value + " ");
            head = head.right;
        }
    }

}
