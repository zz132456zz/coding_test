// 소프티어 626 - [21년 재직자 대회 예선] 회의실 예약

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class softeer_626 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<String> meetingRoom = new ArrayList<>();
        boolean[][] reservation = new boolean[N][24];

        for (int i = 0; i < N; i++) {
            meetingRoom.add(br.readLine());
        }
        Collections.sort(meetingRoom);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String r = st.nextToken();
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            int idx = meetingRoom.indexOf(r);

            for (int j = s; j < t; j++) {
                reservation[idx][j] = true;
            }
        }

        for (int i = 0; i < N; i++) {
            answer.append("Room ").append(meetingRoom.get(i)).append(":\n");
            StringBuilder temp = new StringBuilder();
            Deque<Integer> deque = new ArrayDeque<>();
            int available = 0;

            for (int j = 9; j < 18; j++) {
                if (reservation[i][j]) {
                    if (!deque.isEmpty()) {
                        available++;
                        if (deque.peek() == 9) {
                            temp.append("09");
                        } else {
                            temp.append(deque.poll());
                        }
                        temp.append("-").append(j).append("\n");
                        deque.clear();
                    }
                } else {
                    deque.add(j);
                }
            }
            if (!deque.isEmpty()) {
                available++;
                if (deque.peek() == 9) {
                    temp.append("09");
                } else {
                    temp.append(deque.poll());
                }
                temp.append("-").append(18).append("\n");
                deque.clear();
            }

            if (available == 0) {
                answer.append("Not available\n-----\n");
            } else {
                answer.append(available).append(" available:\n").append(temp).append("-----\n");
            }
        }

        answer.setLength(answer.length() - 6);

        System.out.print(answer);
    }

}
