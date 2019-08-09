/**
 * 题目十三：机器人的运动范围
 * 地上有一个m行n列的方格。一个机器人从坐标（0，0）的格子开始移动，它每次可以向左、右、上、下移动一格，但不能进入行坐标和列坐标
 * 的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格（35，37）。因为3+5+3+7=18.但它不能进入方格（35，38），因为3+5+3+8=19。
 * 请问该机器人能够到达多少个格子。
 *
 * @author Jackie Ke
 * @date 2019/8/9
 */
public class Code_13_RobotMove {

    private static int move(int[][] matrix, int k) {
        if (matrix == null || matrix.length <= 1 || matrix[0].length <= 1 || k <= 0) {
            return 0;
        }

        boolean[][] visited = new boolean[matrix.length][matrix[0].length]; //记录格子是否走过

        return moveCore(matrix, k, visited, 0 ,0);
    }

    private static int moveCore(int[][] matrix, int k, boolean[][] visited, int row, int col) {
        int count = 0;

        if (row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length && !visited[row][col]
                && judge(row, col) <= k) {
            visited[row][col] = true;
            count = 1 + moveCore(matrix, k, visited, row - 1, col)
                    + moveCore(matrix, k, visited, row + 1, col)
                    + moveCore(matrix, k, visited, row, col - 1)
                    + moveCore(matrix, k, visited, row, col + 1);
        }

        return count;
    }

    /**
     * 计算行坐标和列坐标的数位之和
     *
     * @param p1 行坐标
     * @param p2 列坐标
     * @return 行坐标和列坐标的数位之和
     */
    private static int judge(int p1, int p2) {
        int result = 0;
        while (p1 > 0) {
            result += p1 % 10;
            p1 /= 10;
        }
        while (p2 > 0) {
            result += p2 % 10;
            p2 /= 10;
        }
        return result;
    }

    public static void main(String[] args){
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11 , 12}
        };
        System.out.println(move(matrix, 3));   //功能测试：方格为多行多列：k为正数
        System.out.println(move(matrix, -1));  //特殊测试：k为负数

        int[][] matrix2 = {
                {1, 2, 3, 4}
        };
        System.out.print(move(matrix2, 0));    //边界值测试：方格只有一行或者只有一列；k等于0
    }

}
