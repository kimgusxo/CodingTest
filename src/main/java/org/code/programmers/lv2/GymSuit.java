package org.code.programmers.lv2;

import java.util.*;
import java.util.stream.Collectors;

public class GymSuit {
    public static void main(String[] args) {
        int[] lost = {3};
        int[] reserve = {3};
        System.out.println(solution(2, lost, reserve));
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        List<Integer> lostList = Arrays.stream(lost).boxed().collect(Collectors.toList());
        List<Integer> reserveList = Arrays.stream(reserve).boxed().collect(Collectors.toList());

        Collections.sort(lostList);
        Collections.sort(reserveList);

        for(Iterator<Integer> iter1 = lostList.iterator(); iter1.hasNext();) {
            int l = iter1.next();
            for(Iterator<Integer> iter2 = reserveList.iterator(); iter2.hasNext();) {
                int r = iter2.next();
                if(l == r) {
                    iter1.remove();
                    iter2.remove();
                    break;
                }
            }
        }

        if(lostList.size() <= reserveList.size()) {
            for(Iterator<Integer> iter1 = lostList.iterator(); iter1.hasNext();) {
                int l = iter1.next();
                for(Iterator<Integer> iter2 = reserveList.iterator(); iter2.hasNext();) {
                    int r = iter2.next();
                    if(Math.abs(l-r) == 1) {
                        iter1.remove();
                        break;
                    }
                }
            }
        } else {
            for(Iterator<Integer> iter1 = reserveList.iterator(); iter1.hasNext();) {
                int r = iter1.next();
                for(Iterator<Integer> iter2 = lostList.iterator(); iter2.hasNext();) {
                    int l = iter2.next();
                    if(Math.abs(r-l) == 1) {
                        iter2.remove();
                        break;
                    }
                }
            }
        }



        answer = n-lostList.size();

        return answer;
    }
}
