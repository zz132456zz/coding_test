// 백준 14696 - 딱지놀이

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj_14696 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		for (int n = 0; n < N; n++) {
			int[] A = new int[5];
			int[] B = new int[5];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			for (int i = 0; i < a; i++) {
				A[Integer.parseInt(st.nextToken())]++;
			}
			
			st = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(st.nextToken());
			for (int i = 0; i < b; i++) {
				B[Integer.parseInt(st.nextToken())]++;
			}
			
			StringBuilder sb = new StringBuilder();
			for (int i = 4; i > 0; i--) {
				if (A[i] > B[i]) {
					sb.append("A\n");
					break;
				} else if (A[i] < B[i]) {
					sb.append("B\n");
					break;
				}
			}
			
			if (sb.length() == 0) {
				sb.append("D\n");
			}
			
			bw.write(sb.toString());
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
