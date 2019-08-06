/**
 * 题目十二：矩阵中的路径
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，
 * 每一步可以在矩阵中向左、右、上、下异动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 * 例如，在下面的3*4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用下画线标出）。但矩阵中不包含字符串“abfb”的路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 *
 * @author Jackie
 * @date 2019/8/6
 */
public class Code_12_StringPathInMatrix {

    public static boolean hasPath(char[][] matrix, char[] str) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1 || str == null) {
            return false;
        }

        boolean[][] visited = new boolean[matrix.length][matrix[0].length]; //声明同样大小的矩阵，记录格子是否走过

        int pathLength = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (hasPathCore(matrix, row, col, pathLength, str, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean hasPathCore(char[][] matrix, int row, int col, int pathLength, char[] str, boolean[][] visited) {
        //结束条件
        if (pathLength >= str.length) {
            return true;
        }

        boolean hasPath = false;
        //递归
        if (row >= 0 && col >= 0 && row < matrix.length && col < matrix[0].length && matrix[row][col] == str[pathLength]
                && !visited[row][col]) {
            //如果未被访问，且匹配字符串，标记当前位置为已访问，分别访问上下左右四个位置
            pathLength++;
            visited[row][col] = true;

            hasPath = hasPathCore(matrix, row, col - 1, pathLength, str, visited)
                    || hasPathCore(matrix, row - 1, col, pathLength, str, visited)
                    || hasPathCore(matrix, row, col + 1, pathLength, str, visited)
                    || hasPathCore(matrix, row + 1, col, pathLength, str, visited);

            //当前递归的路线求解失败了，要把该路线的标记清楚掉，其他路径可以继续访问此路线的节点
            if (!hasPath) {
                --pathLength;
                visited[row][col] = false;
            }
        }

        return hasPath;
    }

    public static void main(String[] args){
        char[][] matrix = {
                {'a', 'b', 't', 'g'},
                {'c', 'f', 'c', 's'},
                {'j', 'd', 'e' ,'h'}
        };
        char[] str1 = {'b', 'f', 'c', 'e'};
        char[] str2 = {'a', 'b', 'f', 'b'};
//        System.out.println(matrix.length + " " + matrix[0].length);
        System.out.println(hasPath(matrix, str1) ? "包含该字符串" : "不包含该字符串");
        System.out.println(hasPath(matrix, str2) ? "包含该字符串" : "不包含该字符串");
    }

}
