/**
 * 题目十四：剪绳子
 * 给你一根长度为n的绳子，请把绳子剪成m段（m，n都是整数，n>1并且m>1），每段绳子的长度记为k[0],k[1],...,k[m]。
 * 请问k[0]*k[1]*...*k[m]可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18.
 *
 * @author Jackie Ke
 * @date 2019/8/10
 */
public class Code_14_CuttingRope {

    /**
     * 动态规划
     *
     * @param length 绳子长度
     * @return 最大乘积
     */
    private static int cut1(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }

        int[] products = new int[length + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        int max = 0;
        for (int i = 4; i <= length; i++) {
            max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int product = products[j] * products[i - j];
                if (max < product) {
                    max = product;
                }
                products[i] = max;
            }
        }

        max = products[length];
        return max;
    }

    /**
     * 贪婪算法
     *
     * @param length 绳子长度
     * @return 最大乘积
     */
    private static int cut2(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }

        int timeOf3 = length / 3;
        if (length - timeOf3 * 3 == 1) {
            timeOf3 -= 1;
        }
        int timeOf2 = (length - timeOf3 * 3) / 2;
        return (int) (Math.pow(3, timeOf3) * Math.pow(2, timeOf2));
    }

    public static void main(String[] args){
        System.out.println(cut1(8));
        System.out.println(cut2(8));
        System.out.println(cut2(0));
        System.out.println(cut2(1));
        System.out.println(cut2(2));
        System.out.println(cut2(3));
        System.out.println(cut2(4));
    }

}
