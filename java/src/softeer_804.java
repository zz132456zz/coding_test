// 소프티어 804 - [인증평가(3차) 기출] 플레이페어 암호

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class softeer_804 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        String message = br.readLine();
        String key = br.readLine();

        boolean[] used = new boolean[26];
        used[9] = true;

        // 주어진 키를 5x5크기의 표로 변환
        char[][] map = new char[5][5];
        int idx = 0;
        boolean flag = true;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (flag) {
                    while (true) {
                        if (idx == key.length()) {
                            flag = false;
                            j--;
                            break;
                        }
                        char now = key.charAt(idx);
                        if (used[now - 'A']) {
                            idx++;
                        } else {
                            map[i][j] = now;
                            used[now - 'A'] = true;
                            idx++;
                            break;
                        }
                    }
                } else {
                    for (int k = 0; k < 26; k++) {
                        if (!used[k]) {
                            map[i][j] = (char) ('A' + k);
                            used[k] = true;
                            break;
                        }
                    }
                }
            }
        }

        // 암호화하려는 메시지를 두 글자씩 나누기
        List<Character> messageList = new ArrayList<>();
        for (int i = 0; i < message.length(); i++) {
            messageList.add(message.charAt(i));
        }

        for (int i = 0; i < messageList.size() - 1; i++) {
            char first = messageList.get(i);
            char second = messageList.get(i + 1);

            if (first == second) {
                if (first == 'X') {
                    messageList.add(i + 1,'Q');
                } else {
                    messageList.add(i + 1, 'X');
                }
                i--;
            } else {
                i++;
            }
        }
        if (messageList.size() % 2 != 0) {
            messageList.add('X');
        }

        // 암호화하기
        for (int i = 0; i < messageList.size(); i += 2) {
            char first = messageList.get(i);
            char second = messageList.get(i + 1);

            int[] firstLoc = new int[2];
            int[] secondLoc = new int[2];

            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (map[j][k] == first) {
                        firstLoc[0] = j;
                        firstLoc[1] = k;
                    }
                    if (map[j][k] == second) {
                        secondLoc[0] = j;
                        secondLoc[1] = k;
                    }
                }
            }

            if (firstLoc[0] == secondLoc[0]) {
                answer.append(map[firstLoc[0]][(firstLoc[1] + 1) % 5]);
                answer.append(map[secondLoc[0]][(secondLoc[1] + 1) % 5]);
            } else if (firstLoc[1] == secondLoc[1]) {
                answer.append(map[(firstLoc[0] + 1) % 5][firstLoc[1]]);
                answer.append(map[(secondLoc[0] + 1) % 5][secondLoc[1]]);
            } else {
                answer.append(map[firstLoc[0]][secondLoc[1]]);
                answer.append(map[secondLoc[0]][firstLoc[1]]);
            }
        }

        System.out.println(answer);
    }

}
