import java.util.*;
class 방금그곡 {
    public String solution(String m, String[] musicinfos) {
        List<String> list = new ArrayList<>();
        List<Integer> musicTimeList = new ArrayList<>();
        String answer = "(None)";
        int maxTime = 0; // 최대 재생시간 저장용
        // #이 붙은 음을 처리하기 쉽도록 치환
        m = m.replaceAll("C#", "H");
        m = m.replaceAll("D#", "I");
        m = m.replaceAll("F#", "J");
        m = m.replaceAll("G#", "K");
        m = m.replaceAll("A#", "L");
        
        for(int i=0;i<musicinfos.length;i++) {
            // 재생시간 계산
            String[] musicinfo = musicinfos[i].split(",");
            int startTime = Integer.parseInt(musicinfo[0].substring(0,2))*60 + Integer.parseInt(musicinfo[0].substring(3,5));
            int endTime = Integer.parseInt(musicinfo[1].substring(0,2))*60 + Integer.parseInt(musicinfo[1].substring(3,5));
            int musicTime = endTime - startTime;
            
            // #이 붙은 음을 처리하기 쉽도록 치환
            musicinfo[3] = musicinfo[3].replaceAll("C#", "H");
            musicinfo[3] = musicinfo[3].replaceAll("D#", "I");
            musicinfo[3] = musicinfo[3].replaceAll("F#", "J");
            musicinfo[3] = musicinfo[3].replaceAll("G#", "K");
            musicinfo[3] = musicinfo[3].replaceAll("A#", "L");
            
            String musicNote = ""; // 재생 악보
            int idx = 0;
            for(int j=0;j<musicTime;j++) {
                // 악보 정보보다 긴 시간이 재생되면 처음으로 돌아감
                if(idx == musicinfo[3].length()) {
                    idx = 0;
                }
                musicNote += musicinfo[3].charAt(idx++);
            }
            
            // 멜로디가 일치한다면
            if(musicNote.contains(m)) {
                // 재생시간이 가장 긴 음악 저장
                if(maxTime < musicTime) {
                    maxTime = musicTime;
                    answer = musicinfo[2];
                }
            }
        }
        
        return answer;
    }
}