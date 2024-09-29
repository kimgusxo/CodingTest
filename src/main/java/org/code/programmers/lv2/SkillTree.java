package org.code.programmers.lv2;

public class SkillTree {
    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        System.out.println(solution(skill, skill_trees));
    }

    public static int solution(String skill, String[] skill_trees) {
        int answer = -1;
        int cnt = 0;

        // indexOf로 뽑아서 숫자비교 작아지면 컷, 크거나 같으면 노상관
        for(int i=0; i<skill_trees.length; i++) {
            int max = -1;

            String str = skill_trees[i];

            for(int j=0; j<skill.length(); j++) {
                int cur = str.indexOf(skill.charAt(j));

                if(cur == -1) {
                    cur = 100;
                    max = 100;
                }

                if(cur >= max) {
                    max = cur;
                } else {
                    break;
                }

                if(j == skill.length()-1) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
