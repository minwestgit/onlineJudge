import java.util.*;
class 순위검색 {
    private static Map<String, ArrayList<Integer>> map = new HashMap<>();
    private static ArrayList<Integer> score;
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        // info에 대해 가능한 경우의 수를 모두 만듦
        for(String i : info) {
            dfs("", 0, i.split(" "));
        }
        
        // 가능한 info에 해당하는 점수들을 정렬
        List<String> infoList = new ArrayList<>(map.keySet());
        for(int i=0;i<infoList.size();i++) {
            List<Integer> scoreList = map.get(infoList.get(i));
            Collections.sort(scoreList);
        }
        
        // query에 해당하는 갯수 계산
        for(int i=0;i<query.length;i++) {
            query[i] = query[i].replaceAll(" and ", ""); // 문자와 점수 분리
            String[] strArr = query[i].split(" ");
            answer[i] = binarySearch(strArr[0], Integer.parseInt(strArr[1])); // 이진탐색
        }
        
        return answer;
    }
    
    public void dfs(String str, int depth, String[] info) {
        // (점수 제외)마지막 조건인 소울푸드까지 다 고려했다면 경우의수 추가
        if(depth == 4) {
            if(!map.containsKey(str)) {
                score = new ArrayList<>();
                score.add(Integer.parseInt(info[4]));
                map.put(str, score);
            }
            else { // 이미 존재하는 info면 점수만 추가
                map.get(str).add(Integer.parseInt(info[4]));
            }
            return;
        }
        dfs(str+"-", depth+1, info); // '-'(모든 조건 고려)
        dfs(str+info[depth], depth+1, info); // 특정 조건 고려
    }
    
    public int binarySearch(String str, int score) {
        if(!map.containsKey(str)) return 0;
        
        List<Integer> scoreList = map.get(str);
        int start = 0, end = scoreList.size()-1;
        while(start <= end) {
            int mid = (start+end) / 2;
            if(scoreList.get(mid) < score) start = mid + 1;
            else end = mid - 1;
        }
        return scoreList.size()-start; // score이상인 갯수
    }
}