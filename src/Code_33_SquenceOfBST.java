/**
 * 题目三十三：二叉搜索树的后续遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后续遍历结果。如果是则返回true，否则返回false。
 * 假设输入的数组的任意两个数字都互不相同。例如，输入数组{5，7，6，9，11，10，8}，则返回true。
 *
 * @author Jackie Ke
 * @date 2019/8/19
 */
public class Code_33_SquenceOfBST {

    private static boolean verifySquenceOfBST(int[] squence) {
        if (squence == null || squence.length <= 0) {
            return false;
        }
        return verifySquenceOfBST(squence, 0, squence.length - 1);
    }

    private static boolean verifySquenceOfBST(int[] squence, int start, int end) {
        //数组长度为2，一定能够组成BST
        if (end - start <= 1) {
            return true;
        }

        int root = squence[end];

        //找到右子树开始的位置
        int rightStart = 0;
        for (int i = 0; i < end; i++) {
            if (squence[i] > root) {
                rightStart = i;
                break;
            }
        }

        //判断右子树是否是二叉搜索树
        for (int i = rightStart; i < end; i++) {
            if (squence[i] < root) {
                return false;
            }
        }

        return verifySquenceOfBST(squence, start, rightStart - 1)
                && verifySquenceOfBST(squence, rightStart, end - 1);
    }

    public static void main(String[] args){
        int[] squence = {5, 7, 6, 9, 11, 10, 8};
        int[] squence2 = {7, 4, 6, 5};
        System.out.println(verifySquenceOfBST(squence));
        System.out.println(verifySquenceOfBST(squence2));
    }

}
