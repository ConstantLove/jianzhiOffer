/**
 * 题目十：斐波那契数列
 * 问题一：求斐波那契数列的第n项
 * 写一个函数，输入n，求斐波那契数列的第n项，斐波那契数列的定义如下
 *        {0              n = 0}
 * f(n) = |1              n = 1|
 *        {f(n-1) + f(n-2)  n>1}
 *
 * @author Jackie Ke
 * @date 2019/7/29
 */
public class Code_10_Fabonacci {

    /**
     * @param n 求斐波那契数列的第n项
     * @return 斐波那契数列的第n项
     * @description 时间复杂度O(N)
     */
    private static int fabonacci(int n) {
        int[] zeroAndOne = {0, 1};
        if (n < 2) {
            return zeroAndOne[n];
        }

        int fibNMinusOne = 0;
        int fibNMinusTwo = 1;
        int fibN = 0;
        for (int i = 2; i <= n; i++) {
            fibN = fibNMinusOne + fibNMinusTwo;
            fibNMinusTwo = fibNMinusOne;
            fibNMinusOne = fibN;
        }

        return fibN;
    }

}
