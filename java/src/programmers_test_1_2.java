import java.util.HashMap;
import java.util.Map;

public class programmers_test_1_2 {

    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = discount.length;

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], i);
        }

        int[][] cnt = new int[want.length][discount.length];
        for (int i = 0; i < discount.length; i++) {
            Integer idx = map.get(discount[i]);

            if (idx != null) {
                for (int j = i; j < i + 10 && j < discount.length; j++) {
                    cnt[idx][j]++;
                }
            }
        }

        for (int i = 0; i < discount.length; i++) {
            for (int j = 0; j < want.length; j++) {
                if (cnt[j][i] != number[j]) {
                    answer--;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] want = {"apple"};
        int[] number = {10};
        String[] discount = {"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"};
        int result = solution(want, number, discount);

        System.out.println(result);
    }

}
