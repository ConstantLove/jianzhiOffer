/**
 * 题目四：二维数组中的查找
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * @author Jackie Ke
 * @date 2019/7/27
 */
public class Code_04_FindInPartiallySortedMatrix {

    /**
     * 方法一：每次都选取数组查找范围内的右上角数字
     *
     * @param matrix 二维数组
     * @param num 需要查找的数字
     * @return 当数组中存在查找的数字，返回true，否则返回false
     */
    private static boolean find(int[][] matrix, int num) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = 0;
        int colomns = matrix[0].length - 1;
        while (rows <= matrix.length - 1 && colomns >= 0) {
            if (matrix[rows][colomns] > num) {
                colomns--;
            } else if (matrix[rows][colomns] < num) {
                rows++;
            } else {
                return true;
            }
        }

        return false;
    }

    /**
     * 方法二：每次都选取数组查找范围内的左下角数字
     *
     * @param matrix 二维数组
     * @param num 需要查找的数字
     * @return 当数组中存在查找的数字，返回true，否则返回false
     */
    private static boolean findByStratAtLeftLowerCorner(int[][] matrix, int num) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length - 1;
        int columns = 0;
        while (rows >= 0 && columns <= matrix[0].length - 1) {
            if (matrix[rows][columns] < num) {
                columns++;
            } else if (matrix[rows][columns] > num) {
                rows--;
            } else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args){
        int[][] matrix = {
                {1, 2, 8,  9},
                {2, 4, 9,  12},
                {4, 7, 10, 13},
                {6, 8, 11, 15},
        };
        System.out.println(find(matrix, 1));   //查找的数字是数组中的最小值
        System.out.println(find(matrix, 15));  //查找的数字是数组中的最大值
        System.out.println(find(matrix, 10));  //查找的数字在数组最大值和最小值之间
        System.out.println(find(matrix, 0));   //查找的数字小于数组中的最小值
        System.out.println(find(matrix, 16));  //查找的数字小于数组中的最大值
        System.out.println(find(matrix, 5));   //查找的数字在数组的最大值和最小值之间，但数组中没有这个数字

        System.out.println("--------------------------");

        System.out.println(findByStratAtLeftLowerCorner(matrix, 1));   //查找的数字是数组中的最小值
        System.out.println(findByStratAtLeftLowerCorner(matrix, 15));  //查找的数字是数组中的最大值
        System.out.println(findByStratAtLeftLowerCorner(matrix, 10));  //查找的数字在数组最大值和最小值之间
        System.out.println(findByStratAtLeftLowerCorner(matrix, 0));   //查找的数字小于数组中的最小值
        System.out.println(findByStratAtLeftLowerCorner(matrix, 16));  //查找的数字小于数组中的最大值
        System.out.println(findByStratAtLeftLowerCorner(matrix, 5));   //查找的数字在数组的最大值和最小值之间，但数组中没有这个数字

        System.out.println("--------------------------");

        matrix = null;
        System.out.println(find(matrix, 7));     //特殊输入测试，输入空指针
        System.out.print(findByStratAtLeftLowerCorner(matrix, 7));     //特殊输入测试，输入空指针
    }

}
