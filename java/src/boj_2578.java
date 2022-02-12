// 백준 2578 - 빙고

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj_2578 {

	static int[][] data;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		data = new int[5][5];
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] call = new int[25];
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				call[i * 5 + j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < 25; i++) {
			int now = call[i];
			
			change(now);
			
			if (check() >= 3) {
				bw.write((i + 1) + "\n");
				break;
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

	public static void change(int now) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (data[i][j] == now) {
					data[i][j] = 0;
					return;
				}
			}
		}
	}
	
	public static int check() {
		int cnt = 0;
		int bingo = 0;
		for (int i = 0; i < 5; i++) {
			cnt = 0;
			for (int j = 0; j < 5; j++) {
				if (data[i][j] == 0) {
					cnt++;
				}
			}
			if (cnt == 5) {
				bingo++;
			}
		}
		for (int j = 0; j < 5; j++) {
			cnt = 0;
			for (int i = 0; i < 5; i++) {
				if (data[i][j] == 0) {
					cnt++;
				}
			}
			if (cnt == 5) {
				bingo++;
			}
		}
		cnt = 0;
		for (int i = 0; i < 5; i++) {
			if (data[i][i] == 0) {
				cnt++;
			}
		}
		if (cnt == 5) {
			bingo++;
		}
		cnt = 0;
		for (int i = 0; i < 5; i++) {
			if (data[i][4 - i] == 0) {
				cnt++;
			}
		}
		if (cnt == 5) {
			bingo++;
		}
		
		return bingo;
	}
	
}
