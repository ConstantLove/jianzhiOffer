import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 题目四十一：数据流中的中位数
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *
 * @author Jackie Ke
 * @date 2019/8/21
 */
public class Code_41_StreamMedian {

    /**
     * 使用一个大根堆和一个小根堆实现一个实时获取中位数的数据结构
     */
    private static class MedianHolder {
        private static PriorityQueue<Integer> max = new PriorityQueue<>(new MaxComparator());
        private static PriorityQueue<Integer> min = new PriorityQueue<>(new MinComparator());

        private static void modifyTwoHeapSize() {
            if (max.size() == min.size() + 2) {
                min.add(max.poll());
            }
            if (min.size() == max.size() + 2) {
                max.add(min.poll());
            }
        }

        public static void addNumber(int num) {
            if (max.isEmpty()) {
                max.add(num);
                return;
            }

            if (max.peek() >= num) {
                max.add(num);
            } else {
                if (min.isEmpty()) {
                    min.add(num);
                    return;
                }
                if (min.peek() > num) {
                    max.add(num);
                } else {
                    min.add(num);
                }
            }
            modifyTwoHeapSize();
        }

        public static Integer getMedian() {
            int maxSize= max.size();
            int minSize = min.size();
            if ((maxSize + minSize) == 0) {
                return null;
            }

            Integer maxNum = max.peek();
            Integer minNum = min.peek();
            if (maxNum != null && minNum != null && ((maxSize + minSize) & 1) == 0) {
                return (maxNum + minNum) / 2;
            }
            //只会有一个条件生效，或者两个都不生效
            if (maxNum == null) {
                return minNum;
            }
            if (minNum == null) {
                return maxNum;
            }

            return maxSize > minSize ? maxNum : minNum;
        }

    }

    private static class MaxComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    private static class MinComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }

    public static void main(String[] args){
        int[] nums = {3,5,7,4,2,1,9,8,6,12,14};
        MedianHolder medianHolder = new MedianHolder();
        for (int num : nums) {
            medianHolder.addNumber(num);
        }

        System.out.println(medianHolder.getMedian());
    }

}
