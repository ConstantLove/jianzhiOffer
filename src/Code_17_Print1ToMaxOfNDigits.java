/**
 * 题目十七：打印从1到最大的n位数
 * 输入数字n，按顺序打印出从1到最大的n位十进制数。比如输入3，则打印出1、2、3一直到最大的3位数999.
 *
 * @author Jackie Ke
 * @date 2019/8/11
 */
public class Code_17_Print1ToMaxOfNDigits {

    /**
     * 考虑到大数的问题，所以使用字符串模拟加法
     *
     * @param num
     */
    private static void print1ToMaxOfDigits(int num) {
        if (num < 0) {
            return;
        }

        StringBuilder number = new StringBuilder();
        for (int i = 0; i < num; i++) {
            number.append('0');
        }

        while (increment(number)) {
            printNumber(number);
        }
    }

    private static boolean increment(StringBuilder number) {

        for (int i = number.length() - 1; i >= 0; i--) {
            if (number.charAt(i) < '9' && number.charAt(i) >= '0') {
                number.setCharAt(i, (char) (number.charAt(i) + 1));
                return true;
            } else if (number.charAt(i) == '9') {
                number.setCharAt(i, '0');
            } else {
                return false;
            }
        }

        return false;
    }

    private static void printNumber(StringBuilder number) {
        boolean flag = false;
        for (int i = 0; i < number.length(); i++) {
            if (flag) {
                System.out.print(number.charAt(i));
            } else {
                if (number.charAt(i) != '0') { //从第一位数开始读取，如果不为零，所以后面都可以输出；如果为0，说明该位无值，跳过。
                    flag = true;
                    System.out.print(number.charAt(i));
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args){
        print1ToMaxOfDigits(3);
    }

}
