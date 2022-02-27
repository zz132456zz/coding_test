// 백준 2116 - 주사위 쌓기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_2116 {

    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> data = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            data.add(new ArrayList<>());
            for (int j = 0; j < 6; j++) {
                data.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 5);
        map.put(5, 0);
        map.put(1, 3);
        map.put(3, 1);
        map.put(2, 4);
        map.put(4, 2);

        int max = 0;
        for (int i = 1; i <= 6; i++) {
            int bottomNum = i;
            sum = 0;

            for (int j = 0; j < N; j++) {
                bottomNum = build(data.get(j), bottomNum, map);
            }

            if (max < sum) max = sum;
        }

        System.out.println(max);
    }

    public static int build(List<Integer> data, int bottomNum, Map<Integer, Integer> map) {
        int topNum = data.get(map.get(data.indexOf(bottomNum)));

        for (int i = 6; i > 0; i--) {
            if (i != bottomNum && i != topNum) {
                sum += i;
                break;
            }
        }

        return topNum;
    }

}
