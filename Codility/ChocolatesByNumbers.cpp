#include <algorithm>

 int gcd(int a, int b) {
    while(b!=0) {
        int r = a%b;
        a = b;
        b = r;
    }
    return a;
}

int solution(int N, int M) {
    int tmp = gcd(N, M);
    return N/tmp;
}