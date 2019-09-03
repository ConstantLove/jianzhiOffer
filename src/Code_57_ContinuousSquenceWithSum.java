/**
 * 题目五十七：和为s的数字
 * 题目二：和为s的连续正数序列
 * 输入一个整数s，打印出所有和为s的连续正数序列（至少含有两个数）。
 * 例如，输入15，由于1+2+3+4+5=4+5+6=7+8=15，所以打印出3个序列1-5，4-6，7-8
 *
 * @author Jackie Ke
 * @date 2019/9/3
 */
public class Code_57_ContinuousSquenceWithSum {

    private static void findContinuousSquence(int s) {
        if (s < 3) {
            return;
        }

        int start = 1;
        int mid = (1 + s) / 2;
        int end = 2;
        int curSum = start + end;

        while (start < mid) {
            if (curSum == s) {
                print(start, end);
            }

            while (curSum > s && start < mid) {
                curSum -= start++;

                if (curSum == s) {
                    print(start, end);
                }
            }

            curSum += ++end;
        }
    }

    private static void print(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        findContinuousSquence(15);
    }

}
