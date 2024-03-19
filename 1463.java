import java.io.*;
import java.util.*;

//https://www.acmicpc.net/problem/1463

public class Main {
  static int[] dp;
  static int recur(int n, int count){
    if(n<2){
      return count;
    }
    return Math.min(recur(n/2, count+1+(n%2)), recur(n/3, count+1+(n%3)));
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int x = Integer.parseInt(br.readLine());
    dp=new int[x+1];
    dp[0]=dp[1]=0;
    System.out.println(recur(x, 0));
  }
}
