import java.util.HashSet;

/**
 * 题目一：找出数组中重复的数字
 * 在一个长度为n的数组里的所有数字都在0~n-1的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
 * 也不知道每个数字重复了几次。清找出数组中任意一个重复的数字。例如，如果输入长度为7的数组{2，3，1，0，2，5，3}，
 * 那么对应的输出是重复的数字2或者3.
 *
 * 最优解：时间复杂度为O(N), 空间复杂度为O(1)。
 *
 * @author Jackie Ke
 * @date 2019/7/24
 */
public class Code_03_FindRepeatNumberInArray {

    /**
     * 方法一：先将传入的数组排序，再从排序后的数组中找出重复的数字。
     *
     * @param arr 传入的数组
     * @return int 正常情况下返回重复的数字。若传入的数组为null或者数组中无重复值，则返回-1。若数组中包含0~n-1以外的数字，返回-2.
     * @description 时间复杂度O(N * log(N)), 若使用归并排序，空间复杂度O(N).
     */
    private static int findRepeatNumberBySort(int[] arr) {
        if (arr == null) {
            return -1;
        }

        //判断长度为n的数组中是否包含0~n-1以外的数字
        for (int i : arr) {
            if (i < 0 || i > arr.length - 1) {
                return -2;
            }
        }

        sort(arr, 0, arr.length - 1); // 归并排序

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                return arr[i - 1];
            }
        }

        return -1;
    }

    /**
     * 方法二：利用Hash表，遍历数组，判断每一个数是否在Hash表中存在，若已存在，说明该数字在数组中重复，直接返回该数字；若不存在，添加到Hash表中，继续遍历。
     *
     * @param arr 必定包含重复数字的数组
     * @return int 正常情况下返回重复的数字。若传入的数组为null或者数组中无重复值，则返回-1。若数组中包含0~n-1以外的数字，返回-2.
     * @description 时间复杂度O(N), 空间复杂度O(N).
     */
    private static int findRepeatNumberByHash(int[] arr) {
        if (arr == null) {
            return -1;
        }

        //判断长度为n的数组中是否包含0~n-1以外的数字
        for (int i : arr) {
            if (i < 0 || i > arr.length - 1) {
                return -2;
            }
        }

        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }

        return -1;
    }

    /**
     * 方法三：从头到尾依次扫描这个数组的每个数字，当扫描到下标为i的数字时，首先比较这个数字（用m表示）是不是等于i。
     * 如果是，则接着扫描下一个数字；如果不是，则再拿它和第m个数字进行比较。如果它和第m个数字相等，就找到了一个重复的数字；
     * 如果它和第m个数字不相等，就把第i个数字和第m个数字交换，把m放到属于它的位置。接下来重复这个比较，直到出现重复的数字。
     *
     * @param arr 传入的数组
     * @return int 正常情况下返回重复的数字。若传入的数组为null或者数组中无重复值，则返回-1。若数组中包含0~n-1以外的数字，返回-2.
     * @description 时间复杂度为O(N), 空间复杂度为O(1)。最优解！！！
     */
    private static int findRepeatNumber(int[] arr) {
        if (arr == null) {
            return -1;
        }

        //判断长度为n的数组中是否包含0~n-1以外的数字
        for (int i : arr) {
            if (i < 0 || i > arr.length - 1) {
                return -2;
            }
        }

        int i = 0;
        while (i < arr.length) {
            if (i == arr[i]) {
                i++;
            } else {
                if (arr[i] == arr[arr[i]]) {
                    return arr[i];
                } else {
                    swap(arr, i, arr[i]);
                }
            }
        }

        return -1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 归并排序
     * 时间复杂度O(N*log(N)) 空间复杂度O(N)
     *
     * @param arr 需要排序的数组
     * @param left 数组的左边界
     * @param right 数组的右边界
     */
    private static void sort(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }

        int mid = left + ((right - left) / 2);
        sort(arr, left, mid);
        sort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    /**
     * 归并操作
     *
     * @param arr 需要排序的数组
     * @param left 传入的数组的左边界
     * @param mid 传入的数组的中间值
     * @param right 传入的数组的有边界
     */
    private static void merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= right) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];  
        }
        //有且只有一个while执行
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= right) {
            help[i++] = arr[p2++];
        }

        for (i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }
    }

    public static void main(String[] args){
        int[] arr = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber(arr));
        System.out.println(findRepeatNumberBySort(arr));
        System.out.println(findRepeatNumberByHash(arr));
    }

}
