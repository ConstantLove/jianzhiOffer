/**
 * 题目五十八：翻转字符串
 * 题目二：左旋转字符串
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串“abcdefg”和数字2，
 * 该函数将返回左旋转两位得到的结果“cdefgab”。
 *
 * @author Jackie Ke
 * @date 2019/9/3
 */
public class Code_58_LeftRotateString {

    private static String leftRotareString(String str, int num) {
        if (str == null) {
            return null;
        }

        StringBuilder stringBuilder = new StringBuilder(str.substring(num));
        int end = num;
        for (int i = 0; i < num; i++) {
            stringBuilder.append(str.charAt(i));
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args){
        String str = "abcdefg";
        System.out.println(leftRotareString(str, 2));
    }

}
