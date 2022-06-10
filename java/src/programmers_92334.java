// 프로그래머스 92334 - 신고 결과 받기

import java.util.*;

public class programmers_92334 {

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Map<String, Integer> idToNum = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            idToNum.put(id_list[i], i);
        }

        ArrayList<Set<String>> report_list = new ArrayList<>();
        for (int i = 0; i < id_list.length; i++) {
            report_list.add(new HashSet<>());
        }

        for (int i = 0; i < report.length; i++) {
            String user_id = report[i].split(" ")[0];
            String report_id = report[i].split(" ")[1];
            report_list.get(idToNum.get(user_id)).add(report_id);
        }

        int[] report_count = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            for (String id : report_list.get(i)) {
                report_count[idToNum.get(id)]++;
            }
        }

        List<String> ban_id = new ArrayList<>();

        for (int i = 0; i < id_list.length; i++) {
            if (report_count[i] >= k) {
                ban_id.add(id_list[i]);
            }
        }

        for (int i = 0; i < id_list.length; i++) {
            for (String id : report_list.get(i)) {
                if (ban_id.contains(id)) {
                    answer[i]++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        int[] result = solution(id_list, report, k);

        System.out.println(Arrays.toString(result));
    }

}
