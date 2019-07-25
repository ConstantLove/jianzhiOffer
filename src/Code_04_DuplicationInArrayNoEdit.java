import java.util.HashMap;
import java.util.HashSet;

/**
 * 题目二：不修改数组找出重复的数字
 * 在一个长度为n+1的数组里的所有数字都在1~n的范围内。所以数组中至少有一个数字是重复的。
 * 请找出数组中任意一个重复的数字，但不能修改输入的数组。例如，如果输入长度为8的数组{2，3，5，4，3，2，6，7}，
 * 那么对应的输出是重复的数字2或者3.
 *
 * @author Jackie Ke
 * @date 2019/7/25
 */
public class Code_04_DuplicationInArrayNoEdit {

    /**
     * 方法一：利用Hash表，遍历数组，判断每一个数是否在Hash表中存在，若已存在，说明该数字在数组中重复，直接返回该数字；若不存在，添加到Hash表中，继续遍历。
     *
     * @param arr 必定包含重复数字的数组
     * @return int 正常情况下返回重复的数字。若传入的数组为null或者数组中无重复值，则返回-1。若数组中包含1~n以外的数字，返回-2.
     * @description 时间复杂度O(N), 空间复杂度O(N).
     */
    private static int duplicationByHash(int[] arr) {
        if (arr == null || arr.length < 2) {
            return -1;
        }

        //判断长度为n的数组中是否包含1~n以外的数字
        for (int i : arr) {
            if (i < 1 || i > arr.length) {
                return -2;
            }
        }

        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(arr[num])) {
                return arr[num];
            }
            set.add(arr[num]);
        }

        return -1;
    }

    /**
     * 方法二：创建一个长度为n+1的辅助数组，然后逐一把原数组的每个数组复制到辅助数组。如果原数组中被复制的数字是m，
     * 则把它复制到辅助数组中下标为m的位置，当辅助数组中下标为m的位置已存在值，说明数字重复。
     *
     * @param arr 必定包含重复数字的数组
     * @return int 正常情况下返回重复的数字。若传入的数组为null或者数组中无重复值，则返回-1。若数组中包含1~n以外的数字，返回-2.
     * @description 时间复杂度O(N), 空间复杂度O(N).
     */
    private static int duplicationByArray(int[] arr) {
        if (arr == null || arr.length < 2) {
            return -1;
        }

        //判断长度为n的数组中是否包含1~n以外的数字
        for (int i : arr) {
            if (i < 1 || i > arr.length) {
                return -2;
            }
        }

        int[] help = new int[arr.length];
        for (int i : arr) {
            if (help[i] == i) {
                return i;
            } else {
                help[i] = i;
            }
        }

        return -1;
    }

    /**
     * 方法三：按照二分查找的思路，以长度为8的数组{2，3，5，4，3，2，6，7}为例，这个长度为8的数组，所有数字都在1-7的范围内。
     * 中间的数字4把1-7的范围分为两段，一段是1-4，一段是5-7。接下来我们统计1-4这个4个数字在数组中出现的次数，它们一共出现了5次，
     * 因此这4个数字中一定有重复的数字。接下来把1-4的范围一分为二，一段是1、2两个数字，另一段是3、4两个数字。数字1或2在数组中一共出现了3次。
     * 这意味着3、4两个数字中一定有一个重复了。我们再分别统计这两个数字在数组中出现的次数。接着我们发现数字3出现了两次，是一个重复的数字。
     *
     * @param arr 必定包含重复数字的数组
     * @return int 正常情况下返回重复的数字。若传入的数组为null或者数组中无重复值，则返回-1。若数组中包含1~n以外的数字，返回-2.
     * @description 时间复杂度O(N * log(N)), 空间复杂度O(1).
     */
    private static int duplicationByBinary(int[] arr) {
        if (arr == null || arr.length < 2) {
            return -1;
        }

        //判断长度为n的数组中是否包含1~n以外的数字
        for (int i : arr) {
            if (i < 1 || i > arr.length) {
                return -2;
            }
        }

        int start = 1;
        int end = arr.length - 1;
        while (end >= start) {
            int mid = ((end - start) >> 1) + start;
            int count = countRange(arr, start, mid);
            if (end == start) {
                if (count > 1) {
                    return start;
                } else {
                    break;
                }
            }
            if (count > (mid - start + 1)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    private static int countRange(int[] arr, int start, int end) {
        if (arr == null) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= start && arr[i] <= end) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args){
        int[] arr = {2, 3, 1, 4, 2, 5, 3};
//        System.out.println(duplicationByHash(arr));
//        System.out.println(duplicationByArray(arr));
        System.out.println(duplicationByBinary(arr));
    }

}
