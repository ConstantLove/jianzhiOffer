/**
 * 题目十六：数值的整数次方
 * 实现函数 double power (double base, int exponent), 求base的exponent次方。不得使用库函数。同时不需要考虑大数问题。
 *
 * @author Jackie Ke
 * @date 2019/8/11
 */
public class Code_16_Power {

    /**
     * 方法二：递归实现对小数取整数次方的值
     *
     * @param base 小数
     * @param exponent 平方or次方数值
     * @return
     */
    private static double powerWithUnsignedExponent(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }

        double result = powerWithUnsignedExponent(base, exponent >> 1);
        result *= result;
        if (exponent % 2 != 0) { //如果为奇数
            result *= base;
        }

        return result;
    }

    /**
     * 方法一：考虑指数为负数且对0求倒数的情况，使用遍历实现对小数取多次方值。
     *
     * @param base 小数
     * @param exponent 平方or次方数值
     * @return
     */
    private static double power(double base, int exponent) {
        if (Double.compare(base, 0.0) == 0 && exponent < 0) {
            throw new RuntimeException("The input is invalid !!!");
        }

        if (exponent < 0) {
            exponent = -exponent;
        }

        double result = powerWithUnsignedExponent1(base, exponent);
        if (exponent < 0) {
            result = 1.0 / result;
        }

        return result;
    }

    private static double powerWithUnsignedExponent1(double base, int exponent) {
        double result = 1.0;
        for (int i = 1; i <= exponent; i++) {
            result *= base;
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(power(2.2, 2));
        System.out.println(powerWithUnsignedExponent(2.2, 2));
    }

}
