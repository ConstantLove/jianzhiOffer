/**
 * 题目五十三：在排序数组中查找数字
 * 问题二：0~n-1中缺失的数字。
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0~n-1之内。
 * 在范围0~n-1内的n个数字有且只有一个数字不在该数组中，请找出这个数字。
 *
 * @author Jackie Ke
 * @date 2019/8/30
 */
public class Code_53_MissingNumber {

    private static int getMissingNumber(int[] arr, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = left + ((right - left) / 2);
        if (arr[mid] > mid) {
            if (mid == 0 || mid - 1 == arr[mid - 1]) {
                return mid;
            }
            right = mid - 1;
        } else {
            left = mid + 1;
        }

        return getMissingNumber(arr, left, right);
    }

    public static void main(String[] args){
        int[] arr = {0, 1, 2, 3, 4, 6, 7, 8, 9};
        System.out.println(getMissingNumber(arr, 0, arr.length - 1));
    }

}
