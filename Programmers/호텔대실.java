import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        Booktime[] books = new Booktime[book_time.length];
        for(int i = 0; i < book_time.length; i++) {
            books[i] = new Booktime(toMinutes(book_time[i][0]), toMinutes(book_time[i][1]));
        }
        
        Arrays.sort(books, (a, b) -> a.start - b.start); //대실 시작시간 기준 오름차순 정렬
        
        PriorityQueue<Booktime> room = new PriorityQueue<>((a, b) -> a.end - b.end); //퇴실시간 기준 오름차순 정렬. 그래야 차례대로 퇴실 가능
        for(Booktime book : books) {
            //그 전 방 만료시간+10(청소) < 새 대실 시작시간이면 퇴실처리
            while(!room.isEmpty() && room.peek().end+10 <= book.start) {
                room.poll();
            }
            room.add(book);
            answer = Math.max(answer, room.size()); //max값 = 필요한 객실 수
        }
        
        return answer;
    }
    
    public int toMinutes(String time) {
        String[] times = time.split(":");
        return Integer.parseInt(times[0])*60 + Integer.parseInt(times[1]);
    }
}

class Booktime {
    int start;
    int end;
    
    public Booktime(int start, int end) {
        this.start = start;
        this.end = end;
    }
    
}