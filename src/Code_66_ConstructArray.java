/**
 * 题目六十六：构建乘积数组
 * 给定一个数组A[0,1,···,n-1]，请构建一个数组B[0,1,···,n-1]，
 * 其中B中的元素B[i]=A[0]*A[1]*···*A[i-1]*···*A[n-1]。不能使用除法。
 *
 * @author Jackie Ke
 * @date 2019/9/6
 */
public class Code_66_ConstructArray {

    private static int[] multiply(int[] arr) {
        if (arr == null || arr.length < 2) {
            return null;
        }

        int[] result = new int[arr.length];
        result[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            result[i] = result[i - 1] * arr[i - 1];
        }

        int temp = 1;
        for (int i = arr.length - 2; i >= 0; i--) {
            temp = temp * arr[i + 1];
            result[i] = result[i] * temp;
        }

        return result;
    }

    public static void main(String[] args){
        int[] data = new int[]{1,2,3,4,5};
        int[] result = multiply(data);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]);
            System.out.print("  ");
        }
    }

}
