class 스킬트리 {
    public int solution(String skill, String[] skill_trees) {
        int answer = skill_trees.length;
        String[] s = skill.split("");
        // 스킬 순서 각각의 위치를 비교
        for(int i=0;i<skill_trees.length;i++){
            int idx = skill_trees[i].indexOf(s[0]);
            boolean chk = true;
            for(int j=1;j<s.length;j++){
                int tmp = skill_trees[i].indexOf(s[j]);
                // 해당 순서의 스킬이 존재하며, 이전 스킬 인덱스가 더 큰 경우 false
                // 해당 순서의 스킬 인덱스가 존재하는데 이전 스킬 인덱스는 존재하지 않는다면 false
                if((idx > tmp && tmp != -1) || (idx == -1 && tmp != -1)) {
                    chk = false;
                }
                idx = tmp;
            }
            if(chk == false) answer -= 1;  // false면 answer 감소
        }
        return answer;
    }
}