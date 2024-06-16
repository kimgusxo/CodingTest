package org.code.expertsw.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1284 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(bf.readLine());

        for(int i=1; i<=cnt; i++) {

            StringTokenizer st = new StringTokenizer(bf.readLine());

            int Aprice = Integer.parseInt(st.nextToken());

            int Bprice = Integer.parseInt(st.nextToken());
            int BlimitLiter = Integer.parseInt(st.nextToken());
            int BperPrice = Integer.parseInt(st.nextToken());

            int useWater = Integer.parseInt(st.nextToken());

            int Aresult = useWater*Aprice;
            int Bresult = 0;

            if(useWater <= BlimitLiter) {
                Bresult = Bprice;
            } else {
                Bresult = Bprice + (useWater-BlimitLiter)*BperPrice;
            }

            int min = 0;
            if(Aresult <= Bresult) {
                min = Aresult;
            } else {
                min = Bresult;
            }

            System.out.println("#"+i+" "+min);

        }
    }

}

