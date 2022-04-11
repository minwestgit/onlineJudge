import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        // Set을 이용해 중복 제거(동일한 유저에 대한 신고 횟수는 1회로 처리)
        Set<String> set = new HashSet<>(Arrays.asList(report));
        report = set.toArray(new String[0]);
        
        // 신고당한 이용자의 수 count해 map에 저장
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < report.length; i++) {
            String[] id = report[i].split(" ");
            map.put(id[1], map.getOrDefault(id[1], 0)+1);
        }
        
        // k번 이상 신고당한 이용자만 list에 저장
        List<String> list = new ArrayList<>();
        for (String key : map.keySet()) {
            if(map.get(key) >= k) {
                list.add(key);
            }
        }
        
        // report에서 k번 이상 신고당한 이용자 신고했으면 resmap에 저장(몇 명 신고했는지 count)
        Map<String, Integer> resmap = new HashMap<>();
        for(int i = 0; i < report.length; i++) {
            String[] id = report[i].split(" ");
            if(list.contains(id[1])) {
                resmap.put(id[0], resmap.getOrDefault(id[0], 0)+1);
            }
        }
        
        // id_list 순서대로 결과 저장
        for(int i = 0; i < id_list.length; i++) {
            if(resmap.containsKey(id_list[i])) {
                answer[i] = resmap.get(id_list[i]);
            }
        }
        
        return answer;
    }
}