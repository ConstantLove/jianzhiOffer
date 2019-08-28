/**
 * 题目五十三：在排序数组中查找数字
 * 问题一：数字在排序数组中出现的次数。
 * 统计一个数字在排序数组中出现的次数。例如，输入排序数组{1，2，3，3，3，3，4，5}，和数字3
 * 由于3在这个数组中出现了4次，所以输出4
 *
 * @author Jackie Ke
 * @date 2019/8/29
 */
public class Code_53_NumberOfK {

    private static int getNumberOfK(int[] arr, int k) {
        if (arr == null) {
            return 0;
        }

        int num = 0;

        int firstK = getFirstK(arr, 0, arr.length - 1, k);
        int lastK = getLastK(arr, 0, arr.length - 1, k);
        if (firstK > -1 && lastK > -1) {
            num = lastK - firstK + 1;
        }
        return num;
    }

    private static int getFirstK(int[] arr, int start, int end, int k) {
        if (start > end) {
            return -1;
        }

        int mid = start + ((end - start) / 2);
        int midData = arr[mid];
        if (midData == k) {
            if (mid > 0 && arr[mid - 1] != k || mid == 0) {
                return mid;
            } else {
                end = mid - 1;
            }
        } else if (midData > k) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }

        return getFirstK(arr, start, end, k);
    }

    private static int getLastK(int[] arr, int start, int end, int k) {
        if (start > end) {
            return -1;
        }

        int mid = start + ((end - start) / 2);
        int midData = arr[mid];
        if (midData == k) {
            if (mid < arr.length - 1 && arr[mid + 1] != k || mid == arr.length - 1) {
                return mid;
            } else {
                start = mid + 1;
            }
        } else if (midData < k) {
            start = mid + 1;
        } else {
            end = mid - 1;
        }

        return getLastK(arr, start, end, k);
    }

    public static void main(String[] args){
        int[] arr = {1, 2, 3, 3, 3, 3, 4, 5};
        System.out.println(getNumberOfK(arr, 3));
    }

}
