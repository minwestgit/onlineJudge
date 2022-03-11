import java.util.*;
class Structure implements Comparable<Structure>{
    int x, y;

    public Structure(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Structure s) {
        if(x > s.x) return 1;
        return -1;
    }

}

// 틀린 코드 입니다 ^^*
public class K번째수 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Structure> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int num = sc.nextInt();
            list.add(new Structure(num, i+1));
        }

        Collections.sort(list);

        for(int i = 0;i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int k = sc.nextInt();

            int cnt = 0;
            for(int j = 0; j < n; j++) {
                if(list.get(j).y >= start && list.get(j).y <= end) {
                    cnt += 1;
                }
                if(cnt == k) {
                    System.out.println(list.get(j).x);
                    break;
                }
            }
        }
        return;
    }
}
