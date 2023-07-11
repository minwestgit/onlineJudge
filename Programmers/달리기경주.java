import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> playerMap = new HashMap<>();
        int idx = 0;
        for(String player : players) {
            playerMap.put(player, idx);
            idx += 1;
        }
        for(String callingPlayer : callings) {
            int callRank = playerMap.get(callingPlayer);
            String beforePlayer = players[callRank-1];
            
            players[callRank-1] = callingPlayer;
            players[callRank] = beforePlayer;
            
            playerMap.replace(callingPlayer, callRank-1);
            playerMap.replace(beforePlayer, callRank);
        }
        
        return players;
    }
}