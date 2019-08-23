/**
 * 题目四十三：1~n整数中1出现的次数
 * 输入一个整数n，求1~n这n个整数的十进制标识中1出现的次数。
 * 例如，输入12，1~12这些整数中包含1的数字有1、10、11、12。1一共出现了5次。
 *
 * @author Jackie Ke
 * @date 2019/8/23
 */
public class Code_43_NumberOf1 {

    private static int numberOf1Between1AndN(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n < 10) {
            return 1;
        }

        String nString = Integer.toString(n);
        char firstChar = nString.charAt(0);
        String apartFirstString = nString.substring(1);

        //计算other~n中1出现的次数，递归计算apartFirstString
        int countFirst = 0;
        if (firstChar > '1') {
            countFirst = power10(nString.length() - 1);
        } else {
            countFirst = Integer.parseInt(apartFirstString) + 1;
        }

        int countOther = (firstChar - '0') * power10(nString.length() - 2) * (nString.length() - 1);
        return countFirst + countOther + numberOf1Between1AndN(Integer.parseInt(apartFirstString));
    }

    private static int power10(int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result *= 10;
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(numberOf1Between1AndN(12));
    }

}
