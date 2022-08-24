public class programmers_test_3_2 {

    public static int solution(int[] ingredient) {
        int answer = 0;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ingredient.length; i++) {
            if (ingredient[i] == 1 && sb.length() >= 3) {
                if (sb.lastIndexOf("123") == sb.length() - 3) {
                    sb.setLength(sb.length() - 3);
                    answer++;
                } else {
                    sb.append(ingredient[i]);
                }
            } else {
                sb.append(ingredient[i]);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        int result = solution(ingredient);

        System.out.println(result);
    }

}
