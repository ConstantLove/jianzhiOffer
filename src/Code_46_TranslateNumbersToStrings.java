/**
 * 题目四十六：把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译成字符串：0翻译成“a”，1翻译成“b”，······
 * 11翻译成“l”，25翻译成“z”。一个数字可能有多个翻译。例如，12258有5种不同的翻译，分别是“bccfi”
 * “bwfi”、“bczi”、“mcfi”、和“mzi”
 *
 * @author Jackie Ke
 * @date 2019/8/24
 */
public class Code_46_TranslateNumbersToStrings {

    private static int getTranslateCount(int number) {
        if (number <= 0) {
            return 0;
        }
        if (number == 1) {
            return 1;
        }

        String sNumber = Integer.toString(number);
        return getTranslateCountCore(sNumber);
    }

    private static int getTranslateCountCore(String number) {
        int f1 = 1, f2 = 1, g = 0;
        int temp;
        for (int i = number.length() - 2; i >= 0; i--) {
            if (Integer.parseInt(number.charAt(i) + "" + number.charAt(i + 1)) < 26) {
                g = 1;
            } else {
                g = 0;
            }

            temp = f2;
            f2 = f2 + f1 * g;
            f1 = temp;
        }

        return f2;
    }

    public static void main(String[] args){
        System.out.println(getTranslateCount(-10));
        System.out.println(getTranslateCount(12258));
        System.out.println(getTranslateCount(12228));
        System.out.println(getTranslateCount(1234));
    }

}
