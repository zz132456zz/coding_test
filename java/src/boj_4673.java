// 백준 4673 - 셀프 넘버

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class boj_4673 {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] answer = new boolean[10001];

        for (int i = 1; i <= 10000; i++) {
            int selfnum = i;
            int temp = i;
            while (temp != 0) {
                selfnum += temp % 10;
                temp /= 10;
            }
            if (selfnum <= 10000) {
                answer[selfnum] = true;
            }
        }

        for (int i = 1; i <= 10000; i++) {
            if (!answer[i]) {
                bw.write(i + "\n");
            }
        }

        bw.flush();
        bw.close();
    }

}
