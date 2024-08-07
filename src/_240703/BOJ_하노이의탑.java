package _240703;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// hanoi(n) = 2*hanoi(n-1)+1
// hanoi(n-1) = 2*hanoi(n-2)+1
public class BOJ_하노이의탑 {
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        stringBuilder.append((int)Math.pow(2, N) - 1).append("\n"); // 하노이 수행수
        top(N, 1, 2,3);
        System.out.println(stringBuilder);
        stringBuilder.setLength(0);
        top(N, 1, 3);
        System.out.println(stringBuilder);

    }

    // from( 1번째 파라미터 ) 자리에서 to ( 3번째 파라미터 )로 n개 이동하려고 할 때,
    // (1) from 자리의 n-1개를 temp로 옮기고
    // (2) from 자리에 남은 1개(n)를 to로 옮기고 (출력으로 표현)
    // (3) temp로 옮겼던 n-1개를 to로 옮긴다.
    // 옮기는 작업은 첫번재 파라미터 자리에서 세번째 파라미터 자리
    static void top(int n, int from, int temp, int to){
        // 기저조건
        if(n == 0) return;

        // (1)
        top(n-1, from, to, temp);

        // (2)
        stringBuilder.append(from).append(" ").append(to).append("\n"); //to로 옮겼다

        // (3)
        top(n-1, temp, from, to);
    }

    static void top(int n, int from, int to){
        // 기저조건
        if(n == 0) return;

        // (1)
        top(n-1, from, 6 - from - to);

        // (2)
        stringBuilder.append(from).append(" ").append(to).append("\n"); //to로 옮겼다

        // (3)
        top(n-1, 6 - from - to, to);
    }
}
