// 백준 2628 - 종이자르기

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class boj_2628 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		List<Integer> widthList = new ArrayList<>();
		List<Integer> heightList = new ArrayList<>();
		widthList.add(0);
		heightList.add(0);
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			if (type == 0) {
				heightList.add(num);
			} else {
				widthList.add(num);
			}
		}
		widthList.add(width);
		heightList.add(height);
		
		Collections.sort(widthList);
		Collections.sort(heightList);
		
		int maxWidth = 0;
		int maxHeight = 0;
		
		for (int i = 0; i < widthList.size() - 1; i++) {
			if (widthList.get(i + 1) - widthList.get(i) > maxWidth) {
				maxWidth = widthList.get(i + 1) - widthList.get(i);
			}
		}
		for (int i = 0; i < heightList.size() - 1; i++) {
			if (heightList.get(i + 1) - heightList.get(i) > maxHeight) {
				maxHeight = heightList.get(i + 1) - heightList.get(i);
			}
		}
		
		bw.write(maxWidth * maxHeight + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
