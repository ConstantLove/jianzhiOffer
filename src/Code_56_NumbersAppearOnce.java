/**
 * 题目五十六：数组中数字出现的次数
 * 问题一：数组中只出现一次的两个数字
 * 一个整型数组里除了两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * 要求时间复杂度为O(N)，空间复杂度为O(1)
 *
 * @author Jackie Ke
 * @date 2019/9/1
 */
public class Code_56_NumbersAppearOnce {

    private static int[] findNumsAppearOnce(int[] arr) {
        if (arr == null) {
            return null;
        }

        int result = 0;
        for (int i : arr) {
            result ^= i;
        }
        int indexOf1 = findFirstBit1(result);
        int[] ret = new int[]{0, 0};
        if (indexOf1 < 0) {
            return ret;
        }

        for (int i : arr) {
            if ((i & indexOf1) == 0) {
                ret[0] ^= i;
            } else {
                ret[1] ^= i;
            }
        }

        return ret;
    }

    private static int findFirstBit1(int num) {
        if (num < 0) {
            return -1;
        }

        int indexOf1 = 1;
        while (num != 0) {
            if ((num & 1) == 1) {
                return indexOf1;
            } else {
                num = num >> 1;
                indexOf1 *= 2;
            }
        }

        return -1;
    }

    public static void main(String[] args){
        int[] data = new int[]{2,4,3,6,3,2,5,5};
        int[] result = findNumsAppearOnce(data); // 4,6
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

}
