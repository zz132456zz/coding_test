import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class programmers_test_1_3 {

    public static int solution(int[] order) {
        int idx = 0; // 지금넣어야할것

        List<Integer> truck = new ArrayList<>();

        Stack<Integer> subContainer = new Stack<>();

        int now = 1; // 컨베이너벨트

        while (true) {
            if (!subContainer.isEmpty() && subContainer.peek() == order[idx]) {
                truck.add(subContainer.pop());
                idx++;
            } else if (now == order[idx]) {
                truck.add(now);
                now++;
                idx++;
            } else {
                subContainer.add(now);
                now++;
            }

            if (now == order.length + 1) {
                if (!subContainer.isEmpty() && subContainer.peek() == order[idx]) {
                    continue;
                } else {
                    break;
                }
            }
        }

        return truck.size();
    }

    public static void main(String[] args) {
        int[] order = {4,3,1,2,5};
        int result = solution(order);

        System.out.println(result);
    }

}
