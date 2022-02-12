// 백준 10163 - 색종이

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj_10163 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] data = new int[1001][1001];
		
		for (int n = 1; n <= N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			for (int i = x; i < x + w; i++) {
				for (int j = y; j < y + h; j++) {
					data[i][j] = n;
				}
			}
		}

		int[] cnt = new int[N + 1];
		for (int i = 0; i < 1001; i++) {
			for (int j = 0; j < 1001; j++) {
				cnt[data[i][j]]++;
			}
		}
		
		for (int i = 1; i <= N; i++) {
			bw.write(cnt[i] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
