import java.io.*;
import java.util.*;

//https://www.acmicpc.net/problem/1864

public class Main {
  static int[] a;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // '-', '\', '(', '@', '?', '>', '&', "%", '/'
    a = new int[] { '-', 92, '(', '@', '?', '>', '&', '%', '/' };
    while (true) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String s = st.nextToken();
      if (s.equals("#"))
        return;
      int result = 0;
      for (int i = 0; i < s.length(); i++) {
        for (int j = 0; j < a.length; j++) {
          if (s.charAt(i) == a[j] && j != 8) {
            result += j * Math.pow(8, s.length() - i - 1);
          } else if (s.charAt(i) == a[j] && j == 8) {
            result += (-1) * Math.pow(8, s.length() - i - 1);
          }
        }
      }
      System.out.println(result);
    }
  }
}
