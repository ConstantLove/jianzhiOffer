/**
 * 题目四十二：连续子数组的最大和
 * 输入一个整型数组，数组里有正数也有负数。数组中的一个货连续多个整数组成一个子数组。
 * 求所有子数组的和的最大值。要求时间复杂度O(N)
 *
 * @author Jackie Ke
 * @date 2019/8/22
 */
public class Code_42_GreatestSumOfSubarrays {

    /**
     * 遍历数组，记录最大和
     *
     * @param arr
     * @return
     */
    private static int findGreatestSumOfSubarrays1(int[] arr) {
        if (arr == null || arr.length < 1) {
            return -1;
        }

        int curSum = 0;
        int greatestSum = Integer.MIN_VALUE;

        for (int i : arr) {
            if (curSum <= 0) {
                curSum = i;
            } else {
                curSum += i;
            }

            if (curSum > greatestSum) {
                greatestSum = curSum;
            }
        }

        return greatestSum;
    }

    public static void main(String[] args){
        int[] arr = {1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println(findGreatestSumOfSubarrays1(arr));
    }

}
