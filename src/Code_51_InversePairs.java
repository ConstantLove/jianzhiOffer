/**
 * 题目五十一：数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字、则这两个数字组成一个逆序对。
 * 输入一个数组，求出这个数组中的逆序对的总数。例如，在数组{7，5，6，4}中，一共存在5个逆序对，
 * 分别是(7,6)、(7,5)、(7,4)、(6,5)、(6,4)
 *
 * @author Jackie Ke
 * @date 2019/8/26
 */
public class Code_51_InversePairs {

    private static int inversePairs(int[] arr) {
        if (arr == null || arr.length < 1) {
            return 0;
        }

        return mergeSort(arr, 0, arr.length - 1);
    }

    private static int mergeSort(int[] arr, int left, int right) {
        if (left == right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        int leftCount = mergeSort(arr, left, mid);
        int rightCount = mergeSort(arr, mid + 1, right);
        int count = merge(arr, left, mid, right);
        return leftCount + rightCount + count;
    }

    private static int merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int i = help.length - 1;
        int p1 = mid;
        int p2 = right;
        int count = 0;
        while (p1 >= left && p2 >= mid + 1) {
            if (arr[p1] > arr[p2]) {
                count += p2 - mid;
                help[i--] = arr[p1--];
            } else {
                help[i--] = arr[p2--];
            }
        }

        while (p1 >= left) {
            help[i--] = arr[p1--];
        }
        while (p2 >= mid + 1) {
            help[i--] = arr[p2--];
        }

        for (i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }

        return count;
    }

    public static void main(String[] args){
        int[] arr = {7, 5, 6, 4};
        System.out.println(inversePairs(arr));
        System.out.println(inversePairs(new int[]{5,6,7,8,1,2,3,4}));
    }

}
