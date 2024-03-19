import java.io.*;
import java.util.*;

//https://www.acmicpc.net/problem/15474

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int A = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());
    int D = Integer.parseInt(st.nextToken());
    int temp1,temp2;
    if(N%A!=0){
      temp1 = N-(N%A);
      temp1 = (temp1/A)+1;
    }else{
      temp1 = N/A;
    }
    if(N%C!=0){
      temp2 = N-(N%C);
      temp2 = (temp2/C)+1;
    }else{
      temp2 = N/C;
    }
    System.out.println(Math.min(temp1*B, temp2*D));
  }
}
