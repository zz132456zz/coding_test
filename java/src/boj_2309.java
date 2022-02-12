// 백준 2309 - 일곱 난쟁이

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class boj_2309 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int[] data = new int[9];
		int remain = -100;
		for (int i = 0; i < 9; i++) {
			data[i] = Integer.parseInt(br.readLine());
			remain += data[i];
		}
		
		Arrays.sort(data);
		
		finish : for (int i = 0; i < 8; i++) {
			for (int j = i; j < 9; j++) {
				if (data[i] + data[j] == remain) {
					for (int k = 0; k < 9; k++) {
						if (k != i && k != j) {
							bw.write(data[k] + "\n");
						}
					}
					break finish;
				}
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}	

}
