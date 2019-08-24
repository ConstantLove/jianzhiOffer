/**
 * 题目四十七：礼物的最大价值
 * 在一个m*n的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于0）.
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格，直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物，请计算你最多能拿到多少价值的礼物？
 *
 * @author Jackie Ke
 * @date 2019/8/25
 */
public class Code_47_MaxValueOfGifts {

    private static int getMaxValue(int[][] gifts) {
        if (gifts == null || gifts.length == 0 || gifts[0].length == 0) {
            return 0;
        }

        int total = gifts[0][0];
        int row = 0;
        int col = 0;
        while (row != gifts.length - 1 && col != gifts[0].length - 1) {
            if (gifts[row + 1][col] > gifts[row][col + 1]) {
                total += gifts[++row][col];
            } else {
                total += gifts[row][++col];
            }
        }

        while (row < gifts.length - 1) {
            total += gifts[++row][col];
        }
        while (col < gifts.length - 1) {
            total += gifts[row][++col];
        }

        return total;
    }

    public static void main(String[] args){
        int[][] gifts = {
                {1, 10, 3, 8},
                {12, 2, 9, 6},
                {5, 7, 4, 11},
                {3, 7, 16, 5},
        };
        System.out.print(getMaxValue(gifts));
    }

}
