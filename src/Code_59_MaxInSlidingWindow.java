import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 题目五十九：队列的最大值
 * 题目一：滑动窗口的最大值
 * 给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值。例如，如果输入数组{2，3，4，2，6，2，5，1}，
 * 及滑动窗口的大小3，那么一共存在6个滑动窗口，它们的最大值分别为{4，4，6，6，6，5}
 *
 * @author Jackie Ke
 * @date 2019/9/4
 */
public class Code_59_MaxInSlidingWindow {

    //把可能会成为最大值的下标存储下来，从而降低扫描次数
    public static int[] maxInWindows(int[] arr, final int size){
        if (arr == null || arr.length == 0 || arr.length < size) {
            return new int[0];
        }

        int[] result = new int[arr.length - size + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < size - 1; i++) {
            while (!deque.isEmpty() && arr[i] >= arr[deque.getLast()]) {
                deque.removeLast();
            }
            deque.add(i);
        }

        for (int i = size - 1; i < arr.length; i++) {
            while (!deque.isEmpty() && arr[deque.getLast()] <= arr[i] ) {
                deque.removeLast();
            }
            while (!deque.isEmpty() && i - deque.getFirst() + 1 > size) {
                deque.removeFirst();
            }
            deque.add(i);
            result[i - (size - 1)] = arr[deque.getFirst()];
        }

        return result;
    }

    public static void main(String[] args){
        int[] arr = {2, 3, 4, 2, 6, 2, 5, 1};
        arr = maxInWindows(arr, 3);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

}
