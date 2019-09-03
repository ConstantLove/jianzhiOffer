/**
 * 题目五十八：翻转字符串
 * 题目一：翻转单词顺序
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，
 * 标点符号和普通字母一样处理。例如输入字符串“I am a student.”，则输出“student. a am I”。
 *
 * @author Jackie Ke
 * @date 2019/9/3
 */
public class Code_58_ReverseWordsInSentence {

    /**
     * 方法三：先调转整个字符串，再调转每个单词的每个字母
     * 不使用额外空间
     *
     * @param str
     * @return
     */
    private static String reverseWordsInSentence3(String str){
        StringBuilder stringBuilder = new StringBuilder(str);
        reverseSubString(stringBuilder,0,stringBuilder.length()-1);
        int start = 0,end = stringBuilder.indexOf(" ");
        while (start<stringBuilder.length()&&end!=-1){
            reverseSubString(stringBuilder,start,end-1);
            start = end+1;
            end = stringBuilder.indexOf(" ",start);
        }
        if(start<stringBuilder.length())
            reverseSubString(stringBuilder,start,stringBuilder.length()-1);
        return stringBuilder.toString();
    }

    //翻转stringBuilder[start,end]
    private static void reverseSubString(StringBuilder stringBuilder,int start,int end){
        for(int i=start;i<=start+(end-start)/2;i++){
            char temp = stringBuilder.charAt(i);
            stringBuilder.setCharAt(i,stringBuilder.charAt(end-i+start));
            stringBuilder.setCharAt(end-i+start,temp);
        }
    }

    /**
     * 方法二：先调转整个字符串，再调转每个单词的每个字母
     * @param str
     * @return
     */
    private static String reverseWordsInSentence2(String str) {
        if (str == null) {
            return null;
        }

        String reverseStr = reverse(str);
        String[] words = reverseStr.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(reverse(word)).append(" ");
        }

        return result.toString().substring(0, result.toString().length() - 1);
    }

    /**
     * 方法一：直接调转每个单词
     * @param str
     * @return
     */
    private static String reverseWordsInSentence1(String str) {
        if (str == null) {
            return null;
        }

        StringBuilder stringBuilder = new StringBuilder();
        String[] words = str.split(" ");
        for (int i = words.length - 1; i >= 0; i--) {
            stringBuilder.append(words[i]).append(" ");
        }

        return stringBuilder.toString();
    }

    private static String reverse(String str) {
        StringBuilder result = new StringBuilder();
        char[] chars = str.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            result.append(chars[i]);
        }

        return result.toString();
    }

    public static void main(String[] args){
        System.out.println(reverseWordsInSentence1("I am a student."));
        System.out.println(reverseWordsInSentence2("I am a student."));
        System.out.println(reverseWordsInSentence3("I am a student."));
    }

}
