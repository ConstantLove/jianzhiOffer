/**
 * 面试题五：替换空格
 * 请实现一个函数，把字符串中的每个空格替换成"%20"，
 * 例如，输入"We are happy."， 则输出"We%20are%20happy."
 *
 * @author Jackie Ke
 * @date 2019/7/27
 */
public class Code_06_ReplaceSpaces {

    /**
     * 从字符串的后面开始复制和替换。
     *
     * @param str
     * @return
     * @description 时间复杂度O(N)
     */
    private static String replaceSpaces(String str) {
        if (str == null || str.equals("") || str.trim().equals("")) {
            return null;
        }

        char[] chars = str.toCharArray();
        int spaces = 0;
        for (char c : chars) {
            if (c == ' ') {
                spaces++;
            }
        }
        if (spaces == 0) return str;

        char[] result = new char[chars.length + (2 * spaces)];
        int p1 = chars.length - 1;
        int p2 = result.length - 1;
        for (int i = p1; i >= 0; i--) {
            if (chars[i] == ' ') {
                result[p2--] = '0';
                result[p2--] = '2';
                result[p2--] = '%';
            } else {
                result[p2--] = chars[i];
            }
        }
        return String.valueOf(result);
    }

    public static void main(String[] args){
        System.out.println(replaceSpaces(" hello world"));  //空格位于字符串最前面
        System.out.println(replaceSpaces("hello world "));  //空格位于字符串的最后面
        System.out.println(replaceSpaces("hello world"));   //空格位于字符串的中间
        System.out.println(replaceSpaces("hello   world")); //字符串中有连续多个空格
        System.out.println(replaceSpaces("edith"));         //字符串中没有空格

        System.out.println("-------特殊测试-------");
        String str = null;
        System.out.println(replaceSpaces(str));   //字符串是一个null指针
        str = "";
        System.out.println(replaceSpaces(str));   //字符串是一个空字符串
        str = " ";
        System.out.println(replaceSpaces(str));   //字符串只有一个空格字符
        str = "     ";
        System.out.println(replaceSpaces(str));   //字符串中有连续多个空格

    }

}
