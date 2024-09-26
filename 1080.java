/*
1080번 행렬
문제
0과 1로만 이루어진 행렬 A와 행렬 B가 있다. 
이때, 행렬 A를 행렬 B로 바꾸는데 필요한 연산의 횟수의 최솟값을 구하는 프로그램을 작성하시오.

행렬을 변환하는 연산은 어떤 3×3크기의 부분 행렬에 있는 모든 원소를 뒤집는 것이다. (0 → 1, 1 → 0)

입력
첫째 줄에 행렬의 크기 N M이 주어진다. N과 M은 50보다 작거나 같은 자연수이다. 
둘째 줄부터 N개의 줄에는 행렬 A가 주어지고, 그 다음줄부터 N개의 줄에는 행렬 B가 주어진다.

출력
첫째 줄에 문제의 정답을 출력한다. 만약 A를 B로 바꿀 수 없다면 -1을 출력한다.
*/

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
/*
미해결 18111번 

왼쪽 상단 위부터 쭉쭉 돌려보면 됨
*/

public class Main {

    public static void main(String[] args) throws IOException {
       
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
		int M = in.nextInt();
		
		int[][] arrA = new int[N][M];
		int[][] arrB = new int[N][M];
		int count = 0;
		
		for(int i = 0; i < N; i++){ // 행렬 A 입력받기
			String temp = in.next();
			for(int j = 0; j < M; j++){
				arrA[i][j] = (int)(temp.charAt(j) - '0');
			}
		}
		
		for(int i = 0; i < N; i++){ // 행렬 B 입력받기
			String temp = in.next();
			for(int j = 0; j < M; j++){
				arrB[i][j] = (int)(temp.charAt(j) - '0');
			}
		}
		
		if(N < 3 || M < 3){
			for(int i = 0; i < N; i++){ // 연산 불가임으로 동일 체크
				for(int j = 0; j < M; j++){
					if(arrA[i][j] != arrB[i][j]){ // 동일하지 않다면
						System.out.println(-1);
						return;
					}
				}
			}
		}
			
		

		for(int i = 0; i < N-2; i++){ // 행렬의 좌상단 요소가 다를때 3x3연산 실행
			for(int j = 0; j < M-2; j++){
				if(arrA[i][j] != arrB[i][j]){
					count++;
					for(int x = i; x < i+3; x++){
						for(int y = j; y < j+3; y++){
							if(arrA[x][y]==0){
								arrA[x][y] = 1;
							}else if(arrA[x][y]==1){
								arrA[x][y] = 0;
							}
						}
					}
				}
			}
		}

		for(int i = 0; i < N; i++){ // 연산 후 동일한지 체크
			for(int j = 0; j < M; j++){
				if(arrA[i][j] != arrB[i][j]){ // 동일하지 않다면
					System.out.println(-1);
					return;
				}
			}
		}
		
		System.out.println(count);
		return;
		
    }

}
