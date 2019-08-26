import java.util.Map;
import java.util.TreeMap;

/**
 * 题目五十：第一个只出现一次的字符
 * 问题一：字符串中第一个只出现一次的字符
 * 在字符串中找出第一个只出现一次的字符。如输入“abaccdeff”，则输出‘b’
 *
 * @author Jackie Ke
 * @date 2019/8/26
 */
public class Code_50_FirstNotRepeatingChar {

    private static char firstNotRepeatingChar1(String str) {
        if (str == null || str.length() == 0) {
            return ' ';
        }

        int[] times = new int[256];
        for (int i = 0; i < str.length(); i++) {
            times[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (times[str.charAt(i)] == 1) {
                return str.charAt(i);
            }
        }

        return ' ';
    }

    private static char firstNotRepeatingChar2(String str) {
        if (str == null || str.length() == 0) {
            return ' ';
        }

        Map<Character, Integer> map = new TreeMap<>();
        for (char c : str.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        for (char c : map.keySet()) {
            if (map.get(c) == 1) {
                return c;
            }
        }

        return ' ';
    }

    public static void main(String[] args){
        System.out.println(firstNotRepeatingChar1("abaccdeff"));
    }

}
