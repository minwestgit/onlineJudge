public class 보석도둑 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int num = sc.nextInt();
            list.add(i-num, i+1);
        }
        
        for(int i = 0; i < n; i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
