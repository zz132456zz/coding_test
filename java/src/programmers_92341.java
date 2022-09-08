// 프로그래머스 92341 - 주차 요금 계산

import java.util.*;

public class programmers_92341 {

    public static int[] solution(int[] fees, String[] records) {
        StringTokenizer st = null;

        Map<String, String> inMap = new HashMap<>();
        Map<String, Integer> total = new HashMap<>();

        for (int i = 0; i < records.length; i++) {
            st = new StringTokenizer(records[i]);
            String time = st.nextToken();
            String carNum = st.nextToken();
            String io = st.nextToken();

            if (io.equals("IN")) {
                inMap.put(carNum, time);
            } else {
                String inTime = inMap.get(carNum);
                inMap.remove(carNum);

                int minute = timeToMinute(time) - timeToMinute(inTime);
                if (total.containsKey(carNum)) {
                    total.put(carNum, total.get(carNum) + minute);
                } else {
                    total.put(carNum, minute);
                }
            }
        }

        for (String carNum : inMap.keySet()) {
            String inTime = inMap.get(carNum);
            int minute = timeToMinute("23:59") - timeToMinute(inTime);
            if (total.containsKey(carNum)) {
                total.put(carNum, total.get(carNum) + minute);
            } else {
                total.put(carNum, minute);
            }
        }

        List<String> list = new ArrayList<>();
        for (String carNum : total.keySet()) {
            list.add(carNum);
        }
        Collections.sort(list);

        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            String carNum = list.get(i);
            int totalMinute = total.get(carNum);
            int fee = fees[1];
            if (totalMinute > fees[0]) {
                int a = (totalMinute - fees[0]) / fees[2];
                int b = (totalMinute - fees[0]) % fees[2];
                if (b > 0) a++;
                fee += fees[3] * a;
            }
            answer[i] = fee;
        }

        return answer;
    }

    public static int timeToMinute(String time) {
        StringTokenizer st = new StringTokenizer(time, ":");
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        return h * 60 + m;
    }

    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        int[] result = solution(fees, records);

        System.out.println(Arrays.toString(result));
    }

}
