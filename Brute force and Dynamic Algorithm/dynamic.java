import java.util.Scanner;
import java.util.concurrent.TimeUnit;
public class dynamic{
    public void longestRepeatedSubSeq(String str) { 
        int n = str.length(), flag=0; 
        int[][] dp=new int[n+1][n+1];
        for (int i=0; i<=n; i++) 
            for (int j=0; j<=n; j++) 
                dp[i][j] = 0; 
        for (int i=1; i<=n; i++) {
            flag = 0;
            for (int j=1; j<=n; j++) 
                if(String.valueOf(str.charAt(i-1)).equals(String.valueOf(str.charAt(j-1))) && i != j) {
                    if(flag == 0)
                    dp[i][j] = 1 + dp[i-1][j-1]; 
                    else
                        dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                    flag = 1;
                }
                else
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]); 
        }
        String res = ""; String result="";
        int i = n, j = n; 
        while (i > 0 && j > 0) 
        { 
            if (dp[i][j] == dp[i-1][j-1] + 1) 
            { 
                res = res + String.valueOf(str.charAt(i-1)); 
                i--; 
                j--; 
            } 
            else if (dp[i][j] == dp[i-1][j]) 
                i--; 
            else
                j--; 
        } 
        StringBuilder sb = new StringBuilder(res);
        result = sb.reverse().toString();
        if(result == " " || result == null || result.length() < 1)
            System.out.print("The input is considered to be as: Invalid input");
        else
            System.out.print("Longest Repeated Sequence using Dynamic Programming Technique: "+result); 
    }
    public static void main(String args[]) 
    { 
        dynamic c=new dynamic();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the input to sort using Dynamic Programming: ");
        String str=sc.nextLine();
        //long starttime = System.nanoTime(); // start time of performing algorithm
        c.longestRepeatedSubSeq(str); 
        //long endtime = System.nanoTime(); // end time of performing algorithm
        //long totaltime = TimeUnit.NANOSECONDS.toMillis(endtime) - TimeUnit.NANOSECONDS.toMillis(starttime); // total time taken by algorithm for sorting
        //System.out.println("\n\nTime taken by the algorithm running above is: "+totaltime+" ms");
        
    }
} 
