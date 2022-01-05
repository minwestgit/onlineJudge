import java.util.*;
class 캐시 {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if(cacheSize == 0) return 5*(cities.length);
        LinkedList<String> list = new LinkedList<>();
        
        for(int i=0;i<cities.length;i++) {
            String city = cities[i].toUpperCase();
            // list가 비어있는 경우
            if(list.isEmpty()) {
                answer += 5;
                list.addFirst(city);
                continue;
            }
            // cache hit 의 경우 : 해당 도시를 가장 앞으로 add 해준다(가장 최근 사용).
            if(list.contains(city)) {
                list.remove(city);
                list.addFirst(city);
                answer += 1;
            }
            // cache miss
            else {
                answer += 5;
                // 캐시가 가득차 있다면 최근에 사용하지 않은 마지막 도시를 remove 해준다.
                if(list.size() == cacheSize) {
                    list.removeLast();
                }
                list.addFirst(city);
            }
        }
        return answer;
    }
}