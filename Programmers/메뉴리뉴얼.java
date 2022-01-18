import java.util.*;
class 메뉴리뉴얼 {
    private static Map<String, Integer> map = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        for(int i=0;i<orders.length;i++) {
            char[] order = orders[i].toCharArray();
            Arrays.sort(order); // 조합써야하니까 정렬
            // order안에서 가능한 조합 전부 구해줌(course 크기별로)
            for(int j=0;j<course.length;j++) {
                comb(order, 0, 0, course[j], "");
            }
        }
        
        // course 구성 크기별로 조합 중 가장 많이 나온 횟수를 구함.
        int n = course[course.length-1]+1;
        int[] maxCourse = new int[n];
        for(String key : map.keySet()) {
            if(map.get(key) >= 2) { // order 원소는 2이상
                maxCourse[key.length()] = Math.max(map.get(key), maxCourse[key.length()]); // 기존 maxCourse값과 비교해 큰 값으로 Update
            }
        }

        List<String> answerList = new ArrayList<>();
        for(String key: map.keySet()) {
            for(int i=2;i<maxCourse.length;i++) { // 코스 구성 크기별로 반복
                // 주문 최대횟수와 같은 코스를 list에 추가해줌.
                if(key.length() == i && map.get(key) == maxCourse[i]) {
                    answerList.add(key);
                }
            }
        }
        
        Collections.sort(answerList); // 정답 정렬
        
        return answerList.toArray(new String[answerList.size()]);
    }
    
    public void comb(char[] order, int index, int len, int course, String str) {
        if(len == course) {
            map.put(str, map.getOrDefault(str, 0)+1); // 이미 map에 존재하면 +1
            return;
        }
        
        // order의 다음 글자 넣어가며 조합 구함
        for(int i=index;i<order.length;i++) {
            comb(order, i+1, len+1, course, str+order[i]);
        }
    }
}