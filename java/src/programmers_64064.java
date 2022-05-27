// 프로그래머스 64064 - 불량 사용자

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class programmers_64064 {

    static Set<String> set = new HashSet<>();
    static int userLen;
    static int bannedLen;
    static List<List<Integer>> bannedList;

    public static int solution(String[] user_id, String[] banned_id) {
        userLen = user_id.length;
        bannedLen = banned_id.length;

        bannedList = new ArrayList<>();
        for (int i = 0; i < bannedLen; i++) {
            bannedList.add(new ArrayList<>());
        }

        for (int i = 0; i < bannedLen; i++) {
            for (int j = 0; j < userLen; j++) {
                if (check(user_id[j], banned_id[i])) {
                    bannedList.get(i).add(j);
                }
            }
        }

        dfs(0, new boolean[userLen]);

        return set.size();
    }

    public static void dfs(int depth, boolean[] visited) {
        if (depth == bannedList.size()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < userLen; i++) {
                if (visited[i]) sb.append(1);
                else sb.append(0);
            }
            set.add(sb.toString());
            return;
        }

        List<Integer> curList = bannedList.get(depth);
        for (int i = 0; i < curList.size(); i++) {
            if (visited[curList.get(i)]) continue;
            visited[curList.get(i)] = true;
            dfs(depth + 1, visited);
            visited[curList.get(i)] = false;
        }
    }

    public static boolean check(String userId, String bannedId) {
        if (userId.length() != bannedId.length()) return false;

        for (int i = 0; i < userId.length(); i++) {
            if (bannedId.charAt(i) == '*') continue;
            if (bannedId.charAt(i) != userId.charAt(i)) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
//        String[] banned_id = {"fr*d*", "abc1**"};
        String[] banned_id = {"fr*d*", "*rodo", "******", "******"};
        int result = solution(user_id, banned_id);

        System.out.println(result);
    }

}
