import java.io.*;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger p = new BigInteger(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        
        boolean[] primes = new boolean[k + 1];
        primes[1] = true;
              
        for(int i = 2 ; i < k ; i++){
            if(primes[i]) continue;
            BigInteger now = new BigInteger(Integer.toString(i));
            if(p.mod(now).compareTo(BigInteger.ZERO) == 0) {
                System.out.println("BAD " + now);
                return;
            }
            for(int j = i + i ; j <= k ; j += i){
                primes[j] = true;
            }
        }
        System.out.println("GOOD");
    }
}










//이거는 왜 틀린거임 진짜 모름;
import java.io.*;
import java.util.*;

//https://www.acmicpc.net/problem/1837

public class Main {
  static int[] prime = new int[1000001];

  static void makePrime(int[] prime) {
    Arrays.fill(prime, 0);
    for (int i = 2; i * i < 1000000; i++) {
      if (prime[i] == 1)
        continue;
      for (int j = i + i; j < 1000000; j += i)
        prime[j] = 1;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    String P = st.nextToken();
    int K = Integer.parseInt(st.nextToken());
    int result = 0x3f3f3f3f;
    makePrime(prime);
    for (int i = 2; i <= K; i++) {
      int ret = 0;
      if (prime[i] == 1) continue;
      for (int j = 0; j < P.length(); j++) ret = (ret * 10 + P.charAt(j) - '0') % i;
      if (ret == 0) {
        result = i;
        break;
      }
    }
    System.out.print((result < K) ? "Bad " + result : "Good");
  }
}
