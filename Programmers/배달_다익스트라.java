import java.util.*;
class 배달_다익스트라 {
    private static ArrayList<Node>[] graph; // 도시 인접리스트
    private static int[] d;
    
    private static class Node implements Comparable<Node> {
        private int index;
        private int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        // 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }
    
    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        d[1] = 0;
        while(!pq.isEmpty()) {
       	    // 최단 시간 Node 꺼내기
            Node node = pq.poll();
            int dist = node.distance;
            int now = node.index;
            if(d[now] < dist) continue; // 현재 노드가 이미 처리된 적이 있는 노드라면 pass
            for(int i=0;i<graph[now].size();i++) { // 연결 노드 모두 Check
                int nextIndex = graph[now].get(i).index;
                int nextDist = graph[now].get(i).distance + dist;
                // 현재 노드를 거쳐서 다른 노드로 가는 것이 더 빠르다면
                if(nextDist < d[nextIndex]) {
                    d[nextIndex] = nextDist;
                    pq.add(new Node(nextIndex, nextDist));
                }
            }
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        graph = new ArrayList[N+1];
        d = new int[N+1];
        Arrays.fill(d, 500001);
        
        // 그래프 초기화
        for(int i=1;i<=N;i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 배달 시간 기록
        for(int i=0;i<road.length;i++) {
            graph[road[i][0]].add(new Node(road[i][1], road[i][2]));
            graph[road[i][1]].add(new Node(road[i][0], road[i][2]));
        }
        
        dijkstra();
        
        for(int i=0;i<d.length;i++) {
            if(d[i] <= K) answer++;
        }
        
        return answer;
    }
}