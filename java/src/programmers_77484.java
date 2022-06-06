// 프로그래머스 77484 - 로또의 최고 순위와 최저 순위

import java.util.Arrays;

public class programmers_77484 {

    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        int zero = 0;
        int cnt = 0;

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (lottos[i] == win_nums[j]) {
                    cnt++;
                }
            } 
        }

        for (int i = 0; i < 6; i++) {
            if (lottos[i] == 0) {
                zero++;
            }
        }

        answer[0] = ranking(cnt + zero);
        answer[1] = ranking(cnt);

        return answer;
    }

    public static int ranking(int cnt) {
        switch (cnt) {
            case 6: return 1;
            case 5: return 2;
            case 4: return 3;
            case 3: return 4;
            case 2: return 5;
            default: return 6;
        }
    }

    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        int[] result = solution(lottos, win_nums);

        System.out.println(Arrays.toString(result));
    }

}
