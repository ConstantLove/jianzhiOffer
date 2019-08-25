/**
 * 题目四十八：最长不含重复字符的子字符串
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 *
 * @author Jackie Ke
 * @date 2019/8/25
 */
public class Code_48_LongestSubstringWithoutDup {

    private static int longestSubstringWithoutDup(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        int[] dp = new int[str.length()];
        dp[0] = 1;
        int maxdp = 1;
        for (int dpIndex = 1; dpIndex < str.length(); dpIndex++) {
            int i = dpIndex - 1;
            for (; i >= dpIndex - dp[dpIndex - 1]; i--) {
                if (str.charAt(dpIndex) == str.charAt(i)) {
                    break;
                }
            }
            dp[dpIndex] = dpIndex - i;
            if (dp[dpIndex] > maxdp) {
                maxdp = dp[dpIndex];
            }
        }

        return maxdp;
    }

    public static void main(String[] args){
        System.out.println(longestSubstringWithoutDup("arabcacfr"));
        System.out.println(longestSubstringWithoutDup("abcdefaaa"));
    }

}
