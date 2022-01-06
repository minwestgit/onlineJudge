import java.util.*;
import java.util.regex.Pattern;

class 뉴스클러스터링 {
    public int solution(String str1, String str2) {
        String pattern = "^[a-zA-Z]*$"; // 정규표현식
        
        ArrayList<String> list1 = new ArrayList<>();
        String[] strList = str1.split("");
        for(int i=0;i<strList.length-1;i++) {
            String tmp = strList[i] + strList[i+1];
            // 영문자만 list에 추가
            if(Pattern.matches(pattern, tmp)) {
                list1.add(tmp.toUpperCase());
            }
        }
        
        // str2도 반복해서 구해줌
        ArrayList<String> list2 = new ArrayList<>();
        strList = str2.split("");
        for(int i=0;i<strList.length-1;i++) {
            String tmp = strList[i] + strList[i+1];
            if(Pattern.matches(pattern, tmp)) {
                list2.add(tmp.toUpperCase());
            }
        }
        
        ArrayList<String> interList = new ArrayList<>(); // 교집합
        ArrayList<String> unionList = new ArrayList<>(); // 합집합
        for(String l : list1) {
            // list2에 list1 원소가 포함된다면 => 교집합
            // list2에서는 제거
            if(list2.remove(l)){
                interList.add(l);
            }
        }
        
        unionList.addAll(list1);
        unionList.addAll(list2); // 남은 list2 원소도 추가(중복이 제거된 상태)
        
        double intersect = interList.size();
        double union = unionList.size();
        
        if(intersect == 0 && union == 0) return 65536;
        int answer = (int) (intersect/union*65536);

        return answer;
    }
}