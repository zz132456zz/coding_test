// 백준 1302 - 베스트셀러

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class boj_1302 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N  = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String book = br.readLine();

            if (map.containsKey(book)) {
                map.put(book, map.get(book) + 1);
            } else {
                map.put(book, 1);
            }
        }

        int max = 0;
        String maxBook = "";

        for(Object bookName : map.keySet().toArray()) {
            int num = map.get(bookName);
            if (num > max) {
                max = num;
                maxBook = bookName.toString();
            } else if (num == max) {
                maxBook = maxBook.compareTo(bookName.toString()) > 0 ? bookName.toString() : maxBook;
            }
        }

        System.out.println(maxBook);
    }

}
