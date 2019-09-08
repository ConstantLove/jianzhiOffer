import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 题目六十八：求两个树中节点的最低公共祖先
 *
 * @author Jackie Ke
 * @date 2019/9/8
 */
public class Code_68_CommonParentInTree {

    private static class Node {
        int value;
        Node left;
        Node right;
        Node parent;

        public Node(int value) {
            this.value = value;
        }
    }

    private static class CommonTreeNode{
        public char val;
        public List<CommonTreeNode> children;
        public CommonTreeNode(char val){
            this.val = val;
            children = new LinkedList<>();
        }
        public void addChildren(CommonTreeNode... children){
            for(CommonTreeNode child:children)
                this.children.add(child);
        }
    }

    /**
     * 情景一：该树是二叉搜索树
     * 利用二叉搜索树的特性，只要找到值在节点1和节点2之间的节点即可
     *
     * @param head
     * @param node1
     * @param node2
     * @return
     */
    private static Node getLastCommonNode1(Node head, Node node1, Node node2) {
        if (head == null || node1 == null || node2 == null) {
            return null;
        }

        Node node = head;
        while (node != null) {
            if (node.value > node1.value && node.value > node2.value) {
                node = node.left;
            } else if (node.value < node1.value && node.value < node2.value) {
                node = node.right;
            } else if ((node.value > node1.value && node.value < node2.value)
                    || (node.value < node1.value && node.value > node2.value)) {
                return node;
            }
        }

        return null;
    }

    /**
     * 情景二：该树不是二叉搜索树，但是节点有指向父节点的指针
     * 可以转换角度理解为寻找两个链表的第一个共同节点
     *
     * @param node1
     * @param node2
     * @return
     */
    private static Node getLastCommonNode2(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return null;
        }

        int length1 = 0;
        int length2 = 0;
        Node head1 = node1;
        Node head2 = node2;
        while (head1 != null) {
            length1++;
            head1 = head1.parent;
        }
        while (head2 != null) {
            length2++;
            head2 = head2.parent;
        }

        if (length1 > length2) {
            for (int i = 0; i < length1 - length2; i++) {
                node1 = node1.parent;
            }
        } else if (length2 > length1) {
            for (int i = 0; i < length2 - length1; i++) {
                node2 = node2.parent;
            }
        }

        while (node1 != null && node2 != null) {
            if (node1.value == node2.value) {
                return node1;
            }
            node1 = node1.parent;
            node2 = node2.parent;
        }

        return null;
    }

    /**
     * 情景三：该树是普通的树，没有指向父节点的指针
     * 使用两个链表作为辅助空间分别记录两个节点的路径，再遍历找到最后一个共同父节点
     *
     * @param root
     * @param node1
     * @param node2
     * @return
     */
    private static CommonTreeNode getLastParent(CommonTreeNode root, CommonTreeNode node1, CommonTreeNode node2) {
        List<CommonTreeNode> path1 = new ArrayList<>();
        List<CommonTreeNode> path2 = new ArrayList<>();
        getPath(root, node1, path1);
        getPath(root, node2, path2);
        CommonTreeNode lastParent = null;
        for (int i = 0; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) == path2.get(i))
                lastParent = path1.get(i);
            else
                break;
        }
        return lastParent;
    }
    private static boolean getPath(CommonTreeNode root,CommonTreeNode node,List<CommonTreeNode> curPath){
        if(root==node)
            return true;
        curPath.add(root);
        for(CommonTreeNode child:root.children){
            if(getPath(child,node,curPath))
                return true;
        }
        curPath.remove(curPath.size()-1);
        return false;
    }

    public static void main(String[] args){
        Node head = new Node(9);
        head.left = new Node(5);
        head.right = new Node(13);
        head.left.left = new Node(2);
        head.left.right = new Node(7);
        head.left.left.left = new Node(1);
        head.left.left.right = new Node(3);
        head.left.right.left = new Node(6);
        head.left.right.right = new Node(8);

        System.out.println(getLastCommonNode1(head, head.left.left.left, head.left.right.left).value);

        head.left.parent = head;
        head.right.parent = head;
        head.left.left.parent = head.left;
        head.left.right.parent = head.left;
        head.left.left.left.parent = head.left.left;
        head.left.left.right.parent = head.left.left;
        head.left.right.left.parent = head.left.right;
        head.left.right.right.parent = head.left.right;
        System.out.println(getLastCommonNode2(head.left.left.left, head.left.right.left).value);

        CommonTreeNode root = new CommonTreeNode('A');
        CommonTreeNode b = new CommonTreeNode('B');
        CommonTreeNode c = new CommonTreeNode('C');
        CommonTreeNode d = new CommonTreeNode('D');
        CommonTreeNode e = new CommonTreeNode('E');
        CommonTreeNode f = new CommonTreeNode('F');
        CommonTreeNode g = new CommonTreeNode('G');
        CommonTreeNode h = new CommonTreeNode('H');
        CommonTreeNode i = new CommonTreeNode('I');
        CommonTreeNode j = new CommonTreeNode('J');
        root.addChildren(b,c);
        b.addChildren(d,e);
        d.addChildren(f,g);
        e.addChildren(h,i,j);
        System.out.println(getLastParent(root,f,h).val);
    }

}
