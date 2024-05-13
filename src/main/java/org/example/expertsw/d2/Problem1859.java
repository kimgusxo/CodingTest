package org.example.expertsw.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem1859 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(bf.readLine());

        for (int i = 1; i <= count; i++) {
            int day = Integer.parseInt(bf.readLine());

            Map<Integer, Integer> map = new HashMap<>();
            StringTokenizer st = new StringTokenizer(bf.readLine());

            for (int j = 1; j <= day; j++) {
                map.put(j, Integer.parseInt(st.nextToken()));
            }

            List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
            entries.sort(Map.Entry.<Integer, Integer>comparingByValue().reversed());

            Map<Integer, Integer> sortedMap = new LinkedHashMap<>();
            for (Map.Entry<Integer, Integer> entry : entries) {
                sortedMap.put(entry.getKey(), entry.getValue());
            }

            int startDay = 1;
            long money = 0;

            for (Integer o : sortedMap.keySet()) {
                int maxDay = o;

                for (int k = startDay; k < maxDay; k++) {
                    long buy = map.get(k);
                    long sell = map.get(maxDay);

                    money += sell - buy;
                }

                if (startDay < maxDay + 1) startDay = maxDay + 1;
            }

            System.out.println("#" + i + " " + money);
        }
    }
}
