/**
 * 题目三十九：数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如，输入一个长度为9的数组{1，2，3，2，2，2，5，4，2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 *
 * @author Jackie Ke
 * @date 2019/8/20
 */
public class Code_39_MoreThanHalfNumber {

    /**
     * 方法一：基于快排的partition分区函数求中位数
     *
     * @param numbers
     * @return
     */
    private static int moreThanHalfNumber(int[] numbers) {
        if (numbers == null || numbers.length < 2) {
            return 0;
        }

        int middle = numbers.length >> 1;
        int start = 0;
        int end = numbers.length - 1;
        swap(numbers, (start + (int)(Math.random() * (end - start + 1))), end);
        int index = partition(numbers, start, end);
        while (index != middle) {
            if (index > middle) {
                index = partition(numbers, start, index - 1);
            } else {
                index = partition(numbers, index + 1, end);
            }
        }

        return numbers[middle];
    }

    /**
     * 分区函数
     *
     * @param numbers
     * @param start
     * @param end
     * @return
     */
    private static int partition(int[] numbers, int start, int end) {
        int less = start - 1;
        int more = end;

        while (start < more) {
            if (numbers[start] < numbers[end]) {
                swap(numbers, ++less, start++);
            } else if (numbers[start] > numbers[end]) {
                swap(numbers, start, --more);
            } else {
                start++;
            }
        }

        swap(numbers, more, end);
        return end;
    }

    /**
     * 步骤1： 缓存值value，命中次数count均初始化为0。
     * 步骤2： 从头到尾依次读取数组中的元素，判断该元素是否等于缓存值：
     *      步骤2.1：如果该元素等于缓存值，则命中次数加一。
     *      步骤2.2：如果该元素不等于缓存值，判断命中次数是否大于1：
     *               步骤2.2.1：如果命中次数大于1，将命中次数减去1。
     *               步骤2.2.2：如果命中次数小于等于1，则令缓存值等于元素值，命中次数设为1
     * 步骤3： 最终的缓存值value即为数组中出现次数超过一半的数字。
     *
     * @param numbers
     * @return
     */
    private static int moreThenHalfNum(int[] numbers) {
        if (numbers == null || numbers.length < 2) {
            return -1;
        }

        int value = numbers[0];
        int count = 1;

        for (int i = 1; i < numbers.length; i++) {
            //如果下一个数字不等于之前保存的数字，次数减一
            //当次数为0时，保存下一个数字，并把次数设为1
            if (numbers[i] != value) {
                count--;
                if (count == 0) {
                    value = numbers[i];
                    count = 1;
                }
            } else {
                //如果下一个数字等于之前保存的数字，次数加一
                count++;
            }
        }

        return value;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args){
        int[] numbers = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(moreThanHalfNumber(numbers));
        System.out.println(moreThenHalfNum(numbers));
    }

}
