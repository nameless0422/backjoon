import java.io.*;
import java.util.*;

//15975
public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    ArrayList<int[]> p = new ArrayList<int[]>();
    int colorSize[] = new int[N + 1];
    for (int i = 0; i < N; i++) {
      int pos = sc.nextInt();
      int color = sc.nextInt();
      p.add(new int[] { pos, color });
      colorSize[color]++;
    }
    Collections.sort(p, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]); // 정렬
    long result = 0;

    for (int i = 0; i < p.size(); i++) {
      if (colorSize[p.get(i)[1]] > 0) {
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        int ldx = i - 1;
        int rdx = i + 1;
        if (ldx >= 0 && p.get(ldx)[1] == p.get(i)[1]) { // 왼쪽에 같은 색깔의 원소가 있을 때
          left = p.get(i)[0] - p.get(ldx)[0];
        }
        if (rdx < p.size() && p.get(rdx)[1] == p.get(i)[1]) { // 오른쪽에 같은 색깔의 원소가 있을 때
          right = p.get(rdx)[0] - p.get(i)[0];
        }
        int v = Math.min(left, right);
        result += v != Integer.MAX_VALUE ? v : 0;
      }
    }
    System.out.println(result);
  }
}
