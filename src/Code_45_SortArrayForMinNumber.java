/**
 * 题目四十五：把数组排成最小的数
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如，输入数组{3，32，321}，则打印出这3个数字能排成的最小数字321323
 *
 * @author Jackie Ke
 * @date 2019/8/24
 */
public class Code_45_SortArrayForMinNumber {

    private static void printMinNumber(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (bigger(arr[j], arr[j+1])) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static boolean bigger(int a,int b){
        String temp1 = a+""+b;
        String temp2 = b+""+a;
        if(temp1.compareTo(temp2)>0)
            return true;
        else
            return false;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args){
        printMinNumber(new int[]{3,32,321});
    }

}
