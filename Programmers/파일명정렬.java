import java.util.*;
class 파일명정렬 {
    public String[] solution(String[] files) {
        String[] answer = {};
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String h1 = "", h2 = ""; // HEAD
                String n1 = "", n2 = ""; // NUMBER
                int i = 0;
                //s1 HEAD 구하기
                for(i=0;i<s1.length();i++) {
                    if(s1.charAt(i) >= '0' && s1.charAt(i) <= '9') {
                        h1 = s1.substring(0, i);
                        break;
                    }
                }
                //s1 NUMBER 구하기(HEAD 끝부터 시작)
                for(int j=i;j<s1.length();j++) {
                    if(s1.charAt(j) >= '0' && s1.charAt(j) <= '9' && n1.length() < 5) {
                        n1 += s1.charAt(j);
                    } 
                    else {
                        break;
                    }
                }
                //s2 HEAD 구하기
                for(i=0;i<s2.length();i++) {
                    if(s2.charAt(i) >= '0' && s2.charAt(i) <= '9') {
                        h2 = s2.substring(0, i);
                        break;
                    }
                }
                //s2 NUMBER 구하기(HEAD 끝부터 시작)
                for(int j=i;j<s2.length();j++) {
                    // NUMBER는 최대 다섯 글자
                    if(s2.charAt(j) >= '0' && s2.charAt(j) <= '9' && n2.length() < 5) {
                        n2 += s2.charAt(j);
                    } 
                    else {
                        break;
                    }
                }
                
                int ans = h1.toLowerCase().compareTo(h2.toLowerCase()); // HEAD 기준 정렬
                // HEAD 같으면 NUMBER 기준 정렬
                if(ans == 0) {
                    ans = Integer.parseInt(n1) - Integer.parseInt(n2);
                }
                return ans;
            }
            
        });
        return files;
    }
}