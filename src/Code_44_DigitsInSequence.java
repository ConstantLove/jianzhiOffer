/**
 * 题目四十四：数字序列中某一位的数字
 * 数字以0123456789101112131415···的格式序列化到一个字符序列中。在这个序列中，
 * 第5位（从0开始计数）是5，第13位是1，第19位是4.等等。请写一个函数，求任意n位对应的数字。
 *
 * @author Jackie Ke
 * @date 2019/8/24
 */
public class Code_44_DigitsInSequence {

    public static int digitAtIndex(int index){
        if(index<0)
            return -1;
        if(index<10)
            return index;
        int curIndex = 10,length = 2;
        int boundNum = 10;
        while (curIndex+lengthSum(length)<index){
            curIndex+=lengthSum(length);
            boundNum*=10;
            length++;
        }
        int addNum = (index-curIndex)/length;
        int curNum = boundNum + addNum;
        return Integer.toString(curNum).charAt(index-curIndex-addNum*length)-'0';
    }

    public static int lengthSum(int length){
        int count = 9;
        for(int i=1;i<length;i++)
            count*=10;
        return count*length;
    }

    public static void main(String[] args){
        for(int i=9;i<16;i++)
            System.out.println(digitAtIndex(i));
        System.out.println(digitAtIndex(1001));

    }

}
