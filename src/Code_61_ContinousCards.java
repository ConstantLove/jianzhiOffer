import java.util.Arrays;

/**
 * 题目六十一：扑克牌中的顺子
 * 从扑克牌中随机抽出5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2~10为数字本身，A为1，j为11，q为12，k为13，
 * 而大、小王可以视为任何数字。
 *
 * @author Jackie Ke
 * @date 2019/9/5
 */
public class Code_61_ContinousCards {

    private static boolean isContinuous(int[] arr) {
        if (arr == null) {
            return false;
        }

        Arrays.sort(arr);

        int sumOf0 = 0;
        for (int i : arr) {
            if (i == 0) {
                sumOf0++;
            }
        }

        int miss = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0 || (i == 1 && arr[0] == 0)) {
                continue;
            }

            if (arr[i] == arr[i - 1]) {
                return false;
            }

            miss += arr[i] - arr[i - 1] - 1;
        }

        return miss <= sumOf0;
    }

    public static void main(String[] args){
        int[] arr = {1, 2, 5, 0, 3};
        System.out.println(isContinuous(arr));
    }

}
