import java.util.*;

class 오픈채팅방 {
    public String[] solution(String[] record) {
        ArrayList<String> list = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        // 아이디 별 마지막 닉네임 저장
        for(String re : record) {
            String[] str = re.split(" ");
            if("Enter".equals(str[0]) || "Change".equals(str[0])) {
                // 이미 저장된 아이디라면 replace
                if(map.get(str[1]) != null)
                    map.replace(str[1], str[2]);
                else 
                    map.put(str[1], str[2]);
            }
        }
        
        for(String re : record) {
            String[] str = re.split(" ");
            if("Enter".equals(str[0])) {
                list.add( map.get(str[1]) + "님이 들어왔습니다." );
            }
            
            else if("Leave".equals(str[0])) {
                list.add( map.get(str[1]) + "님이 나갔습니다." );
            }
            
        }
        
        String[] answer = new String[list.size()];
        for(int i=0;i<list.size();i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}