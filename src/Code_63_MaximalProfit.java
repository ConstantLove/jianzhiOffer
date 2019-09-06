/**
 * 题目六十三：股票的最大利润
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * 例如，一只股票在某些时间节点的价格为{9,11,8,5,7,12,16,14}。如果我们能在价格为5的时候买入并
 * 在价格为16时卖出，则能收获最大的利润11。
 *
 * @author Jackie Ke
 * @date 2019/9/6
 */
public class Code_63_MaximalProfit {

    private static int maxDiff(int[] arr) {
        if (arr == null || arr.length < 2) {
            return -1;
        }

        int min = arr[0];
        int maxDiff = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > min) {
                maxDiff = arr[i] - min > maxDiff ? arr[i] - min : maxDiff;
            } else {
                min = arr[i];
            }
        }

        return maxDiff;
    }

    public static void main(String[] args){
        int[] arr = {9, 11, 8, 5, 7, 12, 16, 14};
        System.out.println(maxDiff(arr));
    }

}
