/**
 * 题目二十一：调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有基数位于数组的前半部分，所有偶数位于数组的后半部分
 *
 * @author Jackie Ke
 * @date 2019/8/13
 */
public class Code_21_ReorderArray {

    /**
     * 维护两个指针，第一个指针初始化时指向数组的第一个数字，只向后移动；第二个指针初始化时指向数组的第二个数字，只向前移动；
     * 在两个指针相遇前，第一个指针总是大于第二个指针，当第一个指针指向偶数，第二个指针指向奇数时，交换两个指针指向的数字
     * @param arr
     */
    private static void reorderOddEvent(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int begin = 0;
        int end = arr.length - 1;

        while (begin < end) {
            while (begin < end && !isEven(arr[begin])) {
                begin++;
            }
            while (begin < end && isEven(arr[begin])) {
                end--;
            }

            if (begin < end) {
                swap(arr, begin, end);
            }
        }
    }

    private static boolean isEven(int n) {
        return (n & 1) == 0;
    }

    private static void swap(int[] arr, int p1, int p2) {
        int temp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = temp;
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5};
        reorderOddEvent(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

}
