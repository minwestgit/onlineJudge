import java.util.*;

class Node {
    long x;
    long y;
 
    public Node(long x, long y) {
        this.x = x;
        this.y = y;
    }
}

class 교점에별만들기 {
    ArrayList<Node> list = new ArrayList<Node>();
    public static long mx = Long.MIN_VALUE, nx = Long.MAX_VALUE;
    public static long my = Long.MIN_VALUE, ny = Long.MAX_VALUE;
    
    // 교점에 해당되는지 Check
    boolean chkDot(long x, long y){
        for(int i=0;i<list.size();i++){
            if(list.get(i).x == x && list.get(i).y == y) {
                return true;
            }
        }
        return false;
    }
    
    public String[] solution(int[][] line) {
        // 교점 좌표 구하기
        for(int i=0;i<line.length-1;i++) {
            for(int j=i+1;j<line.length;j++) {
            	long A = line[i][0], B = line[i][1], E = line[i][2];
                long C = line[j][0], D = line[j][1], F = line[j][2];
                if(A*D-B*C == 0) 
                    break;
                double x = (double) (B*F-E*D) / (A*D-B*C);
                double y = (double) (E*C-A*F) / (A*D-B*C);
                // 교점 좌표가 정수인지 Check
                if(x == (long) x && y == (long) y) {
                    // x,y 최소/최대값 구하기 
                    mx = Math.max(mx, (long)x);
                    my = Math.max(my, (long)y);
                    nx = Math.min(nx, (long)x);
                    ny = Math.min(ny, (long)y);
                    list.add(new Node((long)x,(long)y));
                }
            }
        }
        
        String[] answer = new String[(int)(my-ny+1)];
        int idx = 0; // answer index
        for(long i=my;i>=ny;i--) { // y는 최대->최소
            String s = "";
            for(long j=nx;j<=mx;j++) { // x는 최소->최대
                // 교점에 해당하면 "*"
                if(chkDot(j,i)) {
                    s += "*";
                    continue;
                }
                // 해당하지 않으면 "."
                s += ".";
            }
            answer[idx] = s;
            idx++;
        }
        return answer;
    }
}