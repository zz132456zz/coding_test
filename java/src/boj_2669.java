// 백준 2669 - 직사각형 네개의 합집합의 면적 구하기

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj_2669 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[][] data = new int[101][101];
		for (int n = 0; n < 4; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int leftX = Integer.parseInt(st.nextToken());
			int leftY = Integer.parseInt(st.nextToken());
			int rightX = Integer.parseInt(st.nextToken());
			int rightY = Integer.parseInt(st.nextToken());

			for (int i = leftX; i < rightX; i++) {
				for (int j = leftY; j < rightY; j++) {
					data[i][j] = 1;
				}
			}
		}
		
		int answer = 0;
		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= 100; j++) {
				if (data[i][j] == 1) {
					answer++;
				}
			}
		}
		
		bw.write(answer + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
