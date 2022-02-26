// 백준 7785 - 회사에 있는 사람

import java.io.*;
import java.util.*;

public class boj_7785 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        Set<String> treeSet = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String check = st.nextToken();

            if (treeSet.contains(name)) {
                treeSet.remove(name);
            } else {
                treeSet.add(name);
            }
        }

        String[] temp = new String[treeSet.size()];
        treeSet.toArray(temp);
        Arrays.sort(temp, Collections.reverseOrder());

        for (int i = 0, size = temp.length; i < size; i++) {
            sb.append(temp[i]).append("\n");
        }

        System.out.print(sb.toString());
    }

}
