package org.example.sw.expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main2 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int testCase = Integer.parseInt(bf.readLine());

        // 1. 테스트 케이스만큼 반복
        for(int i = 1; i <= testCase; i++) {

            int agentNum = Integer.parseInt(bf.readLine());

            // 2. 요원 수 만큼 반복
            System.out.println("#" + i + " " + galaxy(agentNum));
        }
    }

    public static int galaxy(int agentNum) throws IOException {

        int result = 0;

        // 4. 값 생성하기
        ArrayList<Agent> agentList = new ArrayList<>();

        for(int i = 0; i < agentNum; i++) {
            String ability = bf.readLine();

            StringTokenizer st = new StringTokenizer(ability);

            int str = Integer.parseInt(st.nextToken());
            int intel = Integer.parseInt(st.nextToken());
            int dex = Integer.parseInt(st.nextToken());

            // 4-1. 계산하기 쉽게 손실값으로 배열에 적용
            int strLoss = intel+dex;
            int intelLoss = str+dex;
            int dexLoss = str+intel;

            Agent agent = new Agent(strLoss, intelLoss, dexLoss);
            agentList.add(agent);

        }

        // 3. 가동할 수 없을 때 -1 리턴
        if(agentNum < 3) {
            return -1;
        }

        // 5. 각각 정렬본 필요
        ArrayList<Agent> strLossList = new ArrayList<>(agentList);
        ArrayList<Agent> intelLossList = new ArrayList<>(agentList);
        ArrayList<Agent> dexLossList = new ArrayList<>(agentList);

        strLossList.sort(Comparator.comparingInt(o -> o.strLoss));
        intelLossList.sort(Comparator.comparingInt(o -> o.intelLoss));
        dexLossList.sort(Comparator.comparingInt(o -> o.dexLoss));

        // 6. 6가지의 경우의 수를 구해서 최소를 구한 뒤 나머지는 최솟값만 고르기
        int[] losses = new int[6];
        losses[0] = calculateLoss(strLossList, intelLossList, dexLossList);
        losses[1] = calculateLoss(strLossList, dexLossList, intelLossList);
        losses[2] = calculateLoss(intelLossList, strLossList, dexLossList);
        losses[3] = calculateLoss(intelLossList, dexLossList, strLossList);
        losses[4] = calculateLoss(dexLossList, strLossList, intelLossList);
        losses[5] = calculateLoss(dexLossList, intelLossList, strLossList);

        result = Arrays.stream(losses).min().getAsInt();

        // 7. 3명 이상의 요원이 있는 경우, 남은 요원들 중 손실이 가장 적은 요원의 능력치를 선택
        if(agentNum > 3) {
            for(int i = 3; i < agentNum; i++) {
                    int minLoss = Math.min(Math.min(agentList.get(i).strLoss, agentList.get(i).intelLoss), agentList.get(i).dexLoss);
                    result += minLoss;
            }
        }

        return result;
    }

    public static int calculateLoss(ArrayList<Agent> firstList, ArrayList<Agent> secondList, ArrayList<Agent> thirdList) {
        Agent firstAgent = firstList.get(0);
        Agent secondAgent = secondList.stream().filter(agent -> agent.live).findFirst().get();
        Agent thirdAgent = thirdList.stream().filter(agent -> agent.live).findFirst().get();

        return firstAgent.strLoss + secondAgent.intelLoss + thirdAgent.dexLoss;
    }

}

class Agent {
    int strLoss;
    int intelLoss;
    int dexLoss;
    boolean live;
    public Agent(int strLoss, int intelLoss, int dexLoss) {
        this.strLoss = strLoss;
        this.intelLoss = intelLoss;
        this.dexLoss = dexLoss;
        this.live = true;
    }

}