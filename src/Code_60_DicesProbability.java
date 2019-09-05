/**
 * 题目六十：n个骰子的点数
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 *
 * @author Jackie Ke
 * @date 2019/9/5
 */
public class Code_60_DicesProbability {

    private static void printProbability(int number){
        if(number<=0)
            return;
        int result[][] = new int[2][6*number+1];
        for(int i=1;i<=6;i++)
            result[1][i] = 1;
        for (int num=2;num<=number;num++){
            for(int i=num;i<6*num+1;i++){
                for(int j=i-6;j<i;j++)
                    if(j>0)
                        result[num%2][i] += result[(num-1)%2][j];
            }
        }
        double sum = 0;
        for(int i=number;i<6*number+1;i++)
            sum += result[number%2][i];
        System.out.println("number = "+number);
        for(int i=number;i<6*number+1;i++)
            System.out.println("probability "+i+":"+result[number%2][i]/sum);
    }

    public static void main(String[] args){
        printProbability(2);
        printProbability(0);
        printProbability(11);
    }

}
