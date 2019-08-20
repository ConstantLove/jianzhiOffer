/**
 * 题目三十七：序列化二叉树
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 *
 * @author Jackie Ke
 * @date 2019/8/20
 */
public class Code_37_SerializeBinaryTrees {

    private static class Node {
        String value;
        Node left;
        Node right;

        public Node(String value) {
            this.value = value;
        }
    }

    private static void serialize(Node root, StringBuilder stream) {
        if (root == null) {
            stream.append("$,");
            return;
        }

        stream.append(root.value).append(",");
        serialize(root.left, stream);
        serialize(root.right, stream);
    }

    private static Node deserialize(StringBuilder stream) {
        if (stream == null || stream.length() == 0) {
            return null;
        }

        String num = stream.substring(0, stream.indexOf(","));
        stream.delete(0, stream.indexOf(","));
        stream.deleteCharAt(0);
        if (num.equals("$")) {
            return null;
        }

        Node node = new Node(num);
        node.left = deserialize(stream);
        node.right = deserialize(stream);
        return node;
    }

    public static void main(String[] args){
        Node root = new Node("1");
        root.left = new Node("2");
        root.right = new Node("3");
        root.left.left = new Node("4");
        root.right.left = new Node("5");
        root.right.right = new Node("6");
        print(root); //原始树
        System.out.println();

        StringBuilder stream = new StringBuilder();
        serialize(root, stream);
        System.out.println(stream.toString()); //序列化后的树

        root = deserialize(stream);
        print(root); //反序列化后的树
    }

    private static void print(Node head) {
        if (head == null) {
            return;
        }

        System.out.print(head.value + " ");
        print(head.left);
        print(head.right);
    }

}
