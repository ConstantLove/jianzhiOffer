import java.util.HashSet;
import java.util.Set;

/**
 * 题目三十八：字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 例如，输入字符串abc，则打印出由字符a、b、c所能排列出来的所有字符串abc、acb、bac、bca、cab和cba
 *
 * @author Jackie Ke
 * @date 2019/8/20
 */
public class Code_38_StringPermutation {

    private static void permutation(char[] str) {
        if (str == null && str.length < 2) {
            return;
        }

        permutationCore(str, 0);
    }

    private static void permutationCore(char[] str, int begin) {
        if (begin == str.length) {
            for (int i = 0; i < str.length; i++) {
                System.out.print(str[i]);
            }
            System.out.print(" ");
        }

        Set<Character> set = new HashSet<>();
        for (int i = begin; i < str.length; i++) {
            if (set.add(str[i])) {
                swap(str, begin, i);
                permutationCore(str, begin + 1);
                swap(str, begin, i);
            }
        }
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args){
        char[] str = {'a', 'b', 'c'};
        permutation(str);
    }

}
