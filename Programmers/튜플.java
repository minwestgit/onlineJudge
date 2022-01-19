import java.util.*;
class 튜플 {
    public int[] solution(String s) {
        s = s.replace("}", "")
            .replace("{", "");
        String[] array = s.split(","); // 원소 분리
        Map<String, Integer> map = new HashMap<>();
        // 원소 갯수 count해 map에 넣어줌
        for(String str : array) {
            map.put(str, map.getOrDefault(str, 0)+1);
        }
       
        // Value 기준 정렬
        List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> {return o2.getValue().compareTo(o1.getValue());});
        
        int answer[] = new int[list.size()];
        for(int i=0;i<map.size();i++) {
            answer[i] = Integer.parseInt(list.get(i).getKey());
        }
        return answer;
    }
}