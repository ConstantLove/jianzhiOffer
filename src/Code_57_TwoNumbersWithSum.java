/**
 * 题目五十七：和为s的数字
 * 题目一：和为s的两个数字
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和刚好是s。
 * 如果有多对数字的和等于s，则输出任意一对即可。
 *
 * @author Jackie Ke
 * @date 2019/9/1
 */
public class Code_57_TwoNumbersWithSum {

    private static void findNumbersWithSum(int[] arr, int s) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int start = 0;
        int end = arr.length - 1;
        int result = arr[start] + arr[end];
        while (result != s && start < end) {
            if (result > s) {
                result = arr[start] + arr[--end];
            } else {
                result = arr[++start] + arr[end];
            }
        }

        if (result == s) {
            System.out.println("(" + arr[start] + "," + arr[end] + ")");
        }
    }

    public static void main(String[] args){
        int[] arr = {1, 2, 4, 7, 11, 15};
        findNumbersWithSum(arr, 15);
    }

}
