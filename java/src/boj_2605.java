// 백준 2605 - 줄 세우기

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_2605 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Integer> line = new LinkedList<>();
		
		for (int i = 1; i <= N; i++) {
			int num = Integer.parseInt(st.nextToken());
			line.add(i - num - 1, i);
		}
		
		for (int i = 0; i < line.size(); i++) {
			bw.write(line.get(i) + " ");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
