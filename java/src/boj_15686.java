// 백준 15686 - 치킨 배달

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_15686 {

    static class Location {
        int r;
        int c;

        public Location(int r, int c) {
            super();
            this.r = r;
            this.c = c;
        }
    }

    static int M;
    static int[] comb;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        List<Location> house = new ArrayList<>();
        List<Location> chicken = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == 1) {
                    house.add(new Location(i, j));
                } else if (temp == 2) {
                    chicken.add(new Location(i, j));
                }
            }
        }

        int[][] data = new int[house.size()][chicken.size()];
        for (int i = 0; i < house.size(); i++) {
            for (int j = 0; j < chicken.size(); j++) {
                data[i][j] = calc(house.get(i), chicken.get(j));
            }
        }

        int[] numbers = new int[chicken.size()];
        comb = new int[M];
        for (int i = 0; i < chicken.size(); i++) {
            numbers[i] = i;
        }

        min = Integer.MAX_VALUE;
        combination(0, 0, numbers, data);
        System.out.println(min);
    }

    public static void combination (int cnt, int start, int[] numbers, int[][] data) {
        if (cnt == M) {
            int d = distance(comb, data);
            if(d < min) min = d;
            return;
        }

        for (int i = start; i < numbers.length; i++) {
            comb[cnt] = numbers[i];
            combination(cnt + 1, i + 1, numbers, data);
        }
    }

    public static int calc(Location a, Location b) {
        return Math.abs(a.r - b.r) + Math.abs(a.c - b.c);
    }

    public static int distance(int[] comb, int[][] data) {
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int is : comb) {
                if (min > data[i][is]) min = data[i][is];
            }
            sum += min;
        }
        return sum;
    }

}
