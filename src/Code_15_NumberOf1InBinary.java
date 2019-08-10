/**
 * 题目十五：二进制中 1 的个数
 * 请实现一个函数，输入一个整数，输入该数二进制表示中1的个数。例如，把9表示成二进制是1001，有2位是1.
 * 因此，如果输入9，则该函数输出2。
 *
 * @author Jackie Ke
 * @date 2019/8/10
 */
public class Code_15_NumberOf1InBinary {

    private static int numberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }

    public static void main(String[] args){
        System.out.print(numberOf1(9));
    }

}
