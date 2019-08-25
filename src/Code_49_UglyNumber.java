/**
 * 题目四十九：丑数
 * 我们把只包含因子2、3、和5的数称作丑数。求按从小到大的顺序的第1500个丑数。
 * 例如，6、8是丑数，但14不是，因为他包含因子7.习惯上我们把1当作第一个丑数。
 *
 * @author Jackie Ke
 * @date 2019/8/25
 */
public class Code_49_UglyNumber {

    /**
     * 方法一：逐个判断每个整数是不是丑数，直观但不够高效
     *
     * @param index
     * @return
     */
    private static int getUglyNumber1(int index) {
        if (index <= 0) {
            return 0;
        }

        int num = 0;
        int uglyFound = 0;
        while (uglyFound < index) {
            num++;

            if (isUgly(num)) {
                uglyFound++;
            }
        }

        return num;
    }

    private static int getUglyNumber2(int index) {
        if (index <= 0) {
            return 0;
        }

        int[] uglys = new int[index];
        uglys[0] = 1;
        int uglyIndex = 0, multiply2 = 0, multiply3 = 0, multiply5 = 0;

        while (uglyIndex + 1 < index) {
            uglys[++uglyIndex] = min(uglys[multiply2] * 2, uglys[multiply3] * 3, uglys[multiply5] * 5);
            if (uglys[multiply2] * 2 == uglys[uglyIndex]) {
                multiply2++;
            }
            if (uglys[multiply3] * 3 == uglys[uglyIndex]) {
                multiply3++;
            }
            if (uglys[multiply5] * 5 == uglys[uglyIndex]) {
                multiply5++;
            }
        }

        return uglys[index - 1];
    }

    private static int min(int x, int y, int z) {
        int temp = x > y ? y : x;
        return temp > z ? z : temp;
    }

    private static boolean isUgly(int num) {
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }

        return num == 1;
    }

    public static void main(String[] args){
        System.out.println(getUglyNumber1(10));
        System.out.println(getUglyNumber2(10));
    }

}
