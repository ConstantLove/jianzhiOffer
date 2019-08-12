/**
 * 题目十九：正则表达式匹配
 * 请实现一个函数用来匹配包含'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ab*a", 但与"aa.a"和"ab*a"均不匹配
 *
 * @author Jackie Ke
 * @date 2019/8/12
 */
public class Code_19_RegularExpressionsMatching {

    private static boolean match(String str, String pattern) {
        if (str == null || str.equals("") || pattern == null || pattern.equals("")) {
            return false;
        }

        return matchCore(new StringBuilder(str), 0, new StringBuilder(pattern), 0);
    }

    private static boolean matchCore(StringBuilder str, int strIndex, StringBuilder pattern, int patternIndex) {
        // 如果匹配串和模式串都匹配结束
        if (strIndex == str.length() && patternIndex == pattern.length()) {
            return true;
        }
        if (strIndex != str.length() && patternIndex == pattern.length()) {
            return false;
        }
        if (strIndex == str.length() && patternIndex != pattern.length()) {
            if (patternIndex + 1 < pattern.length() && pattern.charAt(patternIndex + 1) == '*') {
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            } else {
                return false;
            }
        }

        // 如果模式字符串的第二个字符不是*或者只剩下最后一个字符
        if (patternIndex == pattern.length() - 1 || pattern.charAt(patternIndex + 1) != '*') {
            if (pattern.charAt(patternIndex) == '.' || pattern.charAt(patternIndex) == str.charAt(strIndex)) {
                return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
            } else {
                return false;
            }
        } else {
            //如果模式字符串的第二个字符是*
            if (pattern.charAt(patternIndex) == '.' || pattern.charAt(patternIndex) == str.charAt(strIndex)) {
                return matchCore(str, strIndex + 1, pattern, patternIndex)
                        || matchCore(str, strIndex + 1, pattern, patternIndex + 2)
                        || matchCore(str, strIndex, pattern, patternIndex + 2);
            } else {
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            }
        }
    }

    public static void main(String[] args){
        System.out.println(match("aaa","a.a"));//true
        System.out.println(match("aaa","ab*ac*a"));//true
        System.out.println(match("aaa","aa.a"));//false
        System.out.println(match("aaa","ab*a"));//false
    }

}
