package algo;

/**
 * @Author Administrator
 * @Date 2024/4/20 23:48
 * @Version 1.0
 */
public class BagPro {

    public static void main(String[] args) {
        int[] wgt = new int[]{1,2,3};
        int[] val = new int[]{5,11,15};
        int i = knapsackDP(wgt, val, 4);
        System.out.println(i);
    }

    private static int knapsackDP(int[] wgt,int[] val,int cap){
        int n = wgt.length;
        int[][] dp = new int[n+1][cap+1];
        for (int i = 1; i <= n ; i++) {
            for (int c = 1; c <= cap ; c++) {
                if (wgt[i-1] > c){
                    dp[i][c] = dp[i-1][c];
                }else {
                    int a = dp[i-1][c];
                    int b = dp[i-1][c-wgt[i-1]];
                    System.out.println("i-1:"+(i-1)+",c:"+c+"--->"+a);
                    System.out.println("i-1:"+(i-1)+",c:"+(c-wgt[i-1])+"--->"+b+" val[i-1]"+(val[i-1]));
                    dp[i][c] = Math.max(a,b+val[i-1]);
                }
//                System.out.println("i:"+(i)+",c:"+c+"--->"+(dp[i][c]));
            }
        }
        return dp[n][cap];
    }

}
