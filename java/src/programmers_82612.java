// 프로그래머스 82612 - 부족한 금액 계산하기

public class programmers_82612 {

    public static long solution(int price, int money, int count) {
        long answer = 0;

        long needMoney = 0;
        for (int i = 1; i <= count; i++) {
            needMoney += price * i;
        }

        if (needMoney > money) {
            answer = needMoney - money;
        }

        return answer;
    }

    public static void main(String[] args) {
        int price = 3;
        int money = 20;
        int count = 4;
        long result = solution(price, money, count);

        System.out.println(result);
    }

}
