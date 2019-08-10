/**
 * 题目十五：二进制中 1 的个数
 * 请实现一个函数，输入一个整数，输入该数二进制表示中1的个数。例如，把9表示成二进制是1001，有2位是1.
 * 因此，如果输入9，则该函数输出2。
 *
 * @author Jackie Ke
 * @date 2019/8/10
 */
public class Code_15_NumberOf1InBinary {

    /**
     * 计算二进制中 1 的个数
     *
     * @param n
     * @return
     */
    private static int numberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }

    /**
     * 用一条语句判断一个整数是不是2的整数次方。
     *
     * @param n
     * @return
     */
    private static boolean isPowerOfTwo(int n) {
        return ((n - 1) & n) == 0;
    }

    /**
     * 输入两个整数m和n，计算需要改变n的二进制表示中的多少位才能得到n。
     *
     * @param m
     * @param n
     * @return
     */
    private static int compare(int m, int n) {
        return numberOf1(m ^ n);
    }

    public static void main(String[] args){
        System.out.println(numberOf1(9));
        System.out.println(isPowerOfTwo(4));
        System.out.println(isPowerOfTwo(9));
        System.out.println(compare(15, 2));
    }

}
