#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// 최대공약수
int gcd(int a, int b){
    while(b!=0) {
    	int r = a%b;
    	a = b;
    	b = r;
    }
    return a;
}

int solution(int arr[], size_t arr_len) {
    int answer = arr[0];
    for(int i=1;i<arr_len;i++) {
        answer = (answer*arr[i]) / gcd(answer, arr[i]); // 최소공배수 = a*b/최대공약수
    }
    return answer;
}