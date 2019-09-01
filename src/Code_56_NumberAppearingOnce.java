/**
 * 题目五十六：数组中数字出现的次数
 * 问题二：数组中唯一只出现一次的数字
 * 在一个数组中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 *
 * @author Jackie Ke
 * @date 2019/9/1
 */
public class Code_56_NumberAppearingOnce {

    public static int findNumberAppearOnce(int[] data){
        if(data==null ||data.length<3)
            return 0; //为了方便返回0，但其实并不能区分异常
        // 存储一个int(长度32bit)的每个bit的状态
        int[] bitSum = new int[32];
        int k = 3;
        for(int i=0;i<data.length;i++){
            int indexOfBit1 = 1;
            for(int j=31;j>=0;j--){
                if((data[i]&indexOfBit1)!=0)
                    bitSum[j] += 1;
                indexOfBit1<<=1;
            }
        }
        int result = 0;
        for(int i=0;i<32;i++){
            result<<=1; //先移位
            result+=bitSum[i]%k;
        }
        return result;
    }

    public static void main(String[] args){
        int[] data1 = new int[]{10,4,5,3,5,4,3,3,4,5};
        int[] data2 = new int[]{0,-4,5,3,5,-4,3,3,-4,5};
        int[] data3 = new int[]{-10,-4,5,3,5,-4,3,3,-4,5};
        System.out.println(findNumberAppearOnce(data1));
        System.out.println(findNumberAppearOnce(data2));
        System.out.println(findNumberAppearOnce(data3));
    }

}
