// 백준 13300 - 방 배정

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj_13300 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] data = new int[13];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			data[Y + S * 6]++;
		}
		
		int answer = 0;
		for (int i = 1; i < 13; i++) {
			answer += data[i] % K == 0 ? data[i] / K : data[i] / K + 1;
		}
		
		bw.write(answer + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
