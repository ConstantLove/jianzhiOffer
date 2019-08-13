/**
 * 题目二十：表示数值的字符串
 * 请事先一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"及"-1E-16"
 * 都表示数值，但"12e"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 *
 * @author Jackie Ke
 * @date 2019/8/13
 */
public class Code_20_NumericStrings {

    private static boolean isNumeric(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }

        int index;

        if (str.charAt(0) != '.') {
            index = scanInteger(str, 0);
            if (index == -1) {
                return false;
            }
            if (index == str.length()) {
                return true;
            }
            if (str.charAt(index) == '.') {
                if (index == str.length() - 1) {
                    return true;
                }
                index = scanInteger(str, index + 1);
                if (index == str.length()) {
                    return true;
                }
            }
            if (str.charAt(index) == 'e' || str.charAt(index) == 'E') {
                index = scanInteger(str, index + 1);
                return index == str.length();
            }
            return false;
        } else {
            index = scanInteger(str, 1);
            if (index == -1) {
                return false;
            }
            if (index == str.length()) {
                return true;
            }
            if (str.charAt(index) == 'e' || str.charAt(index) == 'E') {
                index = scanInteger(str, index + 1);
                return index == str.length();
            }
            return false;
        }
    }

    private static int scanInteger(String str, int index) {
        if (index >= str.length()) {
            return -1;
        } else if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            return scanUnsignedInteger(str, index + 1);
        } else {
            return scanUnsignedInteger(str, index);
        }
    }

    private static int scanUnsignedInteger(String str, int index) {
        int origin = index;
        while (str.charAt(index) >= '0' && str.charAt(index) <= '9') {
            index++;
            if (index == str.length()) {
                return index;
            }
        }

        if (origin == index) {
            index = -1;
        }
        return index;
    }

    public static void main(String[] args){
        System.out.println(isNumeric("+100"));//true
        System.out.println(isNumeric("5e2")); //true
        System.out.println(isNumeric("-123"));//true
        System.out.println(isNumeric("3.1416"));//true
        System.out.println(isNumeric("-1E-16"));//true
        System.out.println(isNumeric(".6"));//true
        System.out.println(isNumeric("6."));//true
        System.out.println(isNumeric("12e"));//false
        System.out.println(isNumeric("1a3.14"));//false
        System.out.println(isNumeric("1.2.3"));//false
        System.out.println(isNumeric("+-5"));//false
        System.out.println(isNumeric("12e+5.4"));//false
    }

}
