import java.io.*;
import java.util.*;

//https://www.acmicpc.net/problem/18110

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] level = new int[n];
    for (int i = 0; i < n; i++) {
      level[i] = Integer.parseInt(br.readLine());
    }
    int x = (int) Math.round(n * 0.15);
    Arrays.sort(level);
    int sum = 0;
    for (int i = x; i < n - x; i++) {
      sum += level[i];
    }
    System.out.println((int) Math.round(sum / (double) (n - (x * 2))));
  }
}
