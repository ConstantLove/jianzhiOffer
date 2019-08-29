/**
 * 题目五十三：在排序数组中查找数字
 * 问题三：数组中数值和下标相等的元素。
 * 假设一个单调递增的数组里的每个元素都是整数并且是唯一的。请编程实现一个函数，
 * 找出数组中任意一个数值等于其下标的元素。例如，在数组{-3，-1，1，3，5}中，数字3和它的下标相等
 *
 *
 * @author Jackie Ke
 * @date 2019/8/30
 */
public class Code_53_IntegerIdenticalToIndex {

    private static int getNumberSameAsIndex(int[] arr, int left, int right) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;
        if (arr[mid] == mid) {
            return mid;
        } else if (arr[mid] > mid) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }

        return getNumberSameAsIndex(arr, left, right);
    }

    public static void main(String[] args){
        int[] arr = {-3, -1, 1, 3, 5};
        System.out.println(getNumberSameAsIndex(arr, 0, arr.length));
    }

}
