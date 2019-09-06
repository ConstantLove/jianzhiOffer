/**
 * 题目六十四：求1+2+···+n
 * 求1+2+···+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 *
 * @author Jackie Ke
 * @date 2019/9/6
 */
public class Code_64_Accumulate {

    private static int acccumulate(int n) {
        int sum = 0;
        boolean flag = (n > 0) && ((sum = n + acccumulate(n - 1)) > 0);
        return sum;
    }

    public static void main(String[] args){
        System.out.println(acccumulate(10));
    }

}
