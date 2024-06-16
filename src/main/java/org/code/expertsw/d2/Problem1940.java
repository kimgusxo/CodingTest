package org.code.expertsw.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1940 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(bf.readLine());

        for(int i=1; i<=cnt; i++) {
            int sec = Integer.parseInt(bf.readLine());

            int speed = 0;
            int distance = 0;
            int accel = 0;

            for(int j=0; j<sec; j++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());

                int command = Integer.parseInt(st.nextToken());

                if(command!=0) {
                    accel = Integer.parseInt(st.nextToken());
                }

                switch (command) {
                    case 0:
                        distance += speed;
                        break;
                    case 1:
                        speed += accel;
                        distance += speed;
                        break;
                    case 2:
                        speed -= accel;
                        if(speed<0) speed=0;
                        distance += speed;
                        break;
                    }
                }

            System.out.println("#"+i+" "+distance);

        }
    }
}
