// 프로그래머스 64065 - 튜플

import java.util.*;

public class programmers_64065 {

    public static int[] solution(String s) {
        StringTokenizer st = new StringTokenizer(s, "}{");

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int cnt = 0;

        while (st.hasMoreTokens()) {
            String temp = st.nextToken();
            if (temp.equals(",")) continue;

            StringTokenizer st2 = new StringTokenizer(temp, ",");
            list.add(new ArrayList<>());

            while(st2.hasMoreTokens()) {
                int num = Integer.parseInt(st2.nextToken());
                list.get(cnt).add(num);
            }
            cnt++;
        }

        int[] answer = new int[cnt];
        Collections.sort(list, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> l1, ArrayList<Integer> l2) {
                return l1.size() - l2.size();
            }
        });

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < cnt; i++) {
            ArrayList<Integer> tempList = list.get(i);
            for (int j = 0; j < tempList.size(); j++) {
                int tempNum = tempList.get(j);
                if (!set.contains(tempNum)) {
                    answer[i] = tempNum;
                    set.add(tempNum);
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
//        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
//        String s = "{{123}}";
        int[] result = solution(s);

        System.out.println(Arrays.toString(result));
    }

//    public int[] solution(String s) {
//        ArrayList<Integer> _answer = new ArrayList<>();
//
//        String[] str = s.replace("{{","").replace("}}","").split("},\\{");
//
//        int[] sequence = new int[str.length];
//        for(int i = 0; i < str.length; i++) {
//            String[] temp = str[i].split(",");
//            sequence[temp.length - 1] = i;
//        }
//
//        for(int i = 0; i < sequence.length; i++) {
//            String[] temp = str[sequence[i]].split(",");
//            ArrayList<Integer> arr = new ArrayList<>();
//
//            for(int j = 0; j < temp.length; j++) {
//                arr.add(Integer.parseInt(temp[j]));
//            }
//            for(int k = 0; k < _answer.size(); k++) {
//                arr.remove(_answer.get(k));
//            }
//            _answer.add(arr.get(0));
//        }
//
//        int[] answer = new int[_answer.size()];
//        for(int i = 0; i < _answer.size(); i++) {
//            answer[i] = _answer.get(i);
//        }
//
//        return answer;
//    }

}
