/**
 * 题目五十：第一个只出现一次的字符
 * 问题二：字符流中第一个只出现一次的字符
 *
 * @author Jackie Ke
 * @date 2019/8/26
 */
public class Code_50_FirstCharacterInStream {

    private static class CharStatistics {
        private int[] times;
        private int index;

        public CharStatistics() {
            index = 0;
            this.times = new int[256];
            init(times);
        }

        private void insert(char c) {
            if (times[c] == -1) {
                times[c] = index;
            } else {
                times[c] = -2;
            }
            index++;
        }

        private char find() {
            int minIndex = 256;
            char result = '\77';//若没有只出现一次的字符，显示\77，即？
            for (int i = 0; i < 256; i++) {
                if (times[i] >= 0 && times[i] < minIndex) {
                    minIndex = times[i];
                    result = (char) i;
                }
            }

            return result;
        }

        private void init(int[] times) {
            //-1表示未出现，>=0表示出现的位置且仅出现一次，-2表示出现两次及以上
            for (int i = 0; i < times.length; i++) {
                times[i] = -1;
            }
        }
    }

    public static void main(String[] args){
        String str = "google";
        CharStatistics charStatistics = new CharStatistics();
        for (char c : str.toCharArray()) {
            charStatistics.insert(c);
            System.out.print(charStatistics.find());
        }
    }

}
