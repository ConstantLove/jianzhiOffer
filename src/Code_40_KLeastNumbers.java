import java.util.Arrays;

/**
 * 题目四十：最小的k个数
 * 输入n个整数,找出其中最小的k个数。例如,输入4,5,1,6,2,7,3,8这8个数字,
 * 则最小的4个数字是1,2,3,4
 *
 * @author Jackie Ke
 * @date 2019/8/21
 */
public class Code_40_KLeastNumbers {

    /**
     * 方法一：基于快排的partition分区函数实现，前提是可以修改输入的数组
     * @param arr
     * @param k
     * @return
     */
    private static int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length < 2) {
            return null;
        }

        int start = 0;
        int end = arr.length - 1;
        swap(arr, k - 1, arr.length - 1);
        int index = partition(arr, start , end);

        while (index != (k - 1)) {
            if (index > k - 1) {
                index = partition(arr, start, index - 1);
            } else {
                index = partition(arr, index + 1, end);
            }
        }

        return Arrays.copyOf(arr, k);
    }

    /**
     * 分区函数
     *
     * @param arr
     * @param start
     * @param end
     * @return
     */
    private static int partition(int[] arr, int start, int end) {
        int less = start - 1;
        int more = end;

        while (start < more) {
            if (arr[start] < arr[end]) {
                swap(arr, ++less, start++);
            } else if (arr[start] > arr[end]) {
                swap(arr, start, --more);
            } else {
                start++;
            }
        }

        swap(arr, more, end);
        return more;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void main(String[] args){
        int[] arr = {4,5,1,6,2,7,3,8};
        for (int number : getLeastNumbers(arr, 4)) {
            System.out.print(number + " ");
        }
    }

}
