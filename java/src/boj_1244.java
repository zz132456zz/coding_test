// 백준 1244 - 스위치 켜고 끄기

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj_1244 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int switchNum = Integer.parseInt(br.readLine());

        int[] data = new int[switchNum];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < switchNum; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        int studentNum = Integer.parseInt(br.readLine());
        for (int s = 0; s < studentNum; s++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (gender == 1) {
                man(data, num);
            } else if (gender == 2) {
                woman(data, num);
            }
        }

        int cnt = 0;
        while(cnt < switchNum) {
            bw.write(data[cnt++] + " ");
            if (cnt % 20 == 0) {
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void man(int[] data, int num) {
        int x = 1;
        for (int i = 0; i < data.length / num; i++) {
            data[num * x - 1] = (data[num * x - 1] + 1) % 2;
            x++;
        }
    }

    public static void woman(int[] data, int num) {
        data[num - 1] = (data[num - 1] + 1) % 2;
        int left = num - 1;
        int right = num + 1;
        while (true) {
            if (left - 1 >= 0 && right - 1 < data.length) {
                if (data[left - 1] == data[right - 1]) {
                    data[left - 1] = (data[left - 1] + 1) % 2;
                    data[right - 1] = (data[right - 1] + 1) % 2;
                } else {
                    break;
                }
            } else {
                break;
            }
            left--;
            right++;
        }
    }

}
