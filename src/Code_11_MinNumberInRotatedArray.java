/**
 * 题目十一：旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，
 * 输出旋转数组的最小元素。例如，数组{3，4，5，1，2} 为{1，2，3，4，5}的一个旋转，该数组的最小值为1.
 *
 * @author Jackie Ke
 * @date 2019/8/5
 */
public class Code_11_MinNumberInRotatedArray {

    /**
     * 二分查找
     *
     * @param arr
     * @param min
     * @return
     */
    public static int findMinNumber(int[] arr, int min) {
        if (arr == null || arr.length < 2) {
            return -1;
        }

        int start = 0;
        int end = arr.length - 1;
        int mid = start;
        while (arr[mid] >= min) {
            if (end - start == 1) {
                mid = end;
                break;
            }

            mid = (end + start) / 2;

            //如果下标为start、end和mid指向的三个数字相等，则只能顺序查找
            if (arr[start] == arr[end] && arr[mid] == arr[start]) {
                return minInOrder(arr, start, end);
            }

            if (arr[mid] >= arr[start]) {
                start = mid;
            } else if (arr[mid] <= arr[end]){
                end = mid;
            }
        }

        return arr[mid];
    }

    /**
     * 顺序查找
     *
     * @param arr
     * @param start
     * @param end
     * @return
     */
    public static int minInOrder(int[] arr, int start, int end) {
        int result = arr[start];
        for (int i = start + 1; i <= end; i++) {
            if (result > arr[i]) {
                result = arr[i];
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[] arr = {3, 4, 5, 1, 2};
        System.out.print(findMinNumber(arr, 1));
    }

}
