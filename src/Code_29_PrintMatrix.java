/**
 * 题目二十九：顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 * @author Jackie Ke
 * @date 2019/8/17
 */
public class Code_29_PrintMatrix {

    private static void printMatrix(int[][] matrix) {
        if (matrix == null) {
            return;
        }

        int row1 = 0;
        int col1 = 0;
        int row2 = matrix.length - 1;
        int col2 = matrix[0].length - 1;
        while (row1 <= row2 && col1 <= col2) {
            printEdge(matrix, row1++, col1++, row2--, col2--);
        }
    }

    private static void printEdge(int[][] matrix, int row1, int col1, int row2, int col2) {
        if (row1 == row2) {
            for (int i = 0; i <= col2; i++) {
                System.out.print(matrix[row1][i] + " ");
            }
        } else if (col1 == col2) {
            for (int i = 0; i <= row2; i++) {
                System.out.print(matrix[i][col1] + " ");
            }
        } else {
            int curC = row1;
            int curR = col1;

            while (curC != col2) {
                System.out.print(matrix[curR][curC++] + " ");
            }
            while (curR != row2) {
                System.out.print(matrix[curR++][curC] + " ");
            }
            while (curC != col1) {
                System.out.print(matrix[curR][curC--] + " ");
            }
            while (curR != row1) {
                System.out.print(matrix[curR--][curC] + " ");
            }
        }

    }

    public static void main(String[] args){
        int[][] matrix = {
                {1,  2,  3,  4},
                {5,  6,  7,  8},
                {9,  10, 11, 12},
                {13, 14, 15, 16}
        };
        printMatrix(matrix);
    }

}
