/**
 * 题目六十五：不用加减乘除做加法
 * 写一个函数，求两个整数之和，要求在函数体内不得使用"+"、"-"、"*"、"/"四则运算符号
 *
 * @author Jackie Ke
 * @date 2019/9/6
 */
public class Code_65_AddTwoNumber {

    private static int add(int a, int b) {
        int sum = a ^ b;
        int carry = (a & b) << 1;
        int temp;
        while (carry != 0) {
            temp = sum;
            sum = sum ^ carry;
            carry = (carry & temp) << 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(add(3, 5)); //8
        System.out.println(add(3, -5)); //-2
        System.out.println(add(0, 1));  //1
    }

}