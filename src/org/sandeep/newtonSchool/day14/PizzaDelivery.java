package org.sandeep.newtonSchool.day14;

import java.util.*;

public class PizzaDelivery {

    static int pizzaboycount = 3;
    static int customercount = 3;
    static long[] pizzaboyloc = {20,60,30 };
    static long[] customerloc = {25,10,35 };
    static String[] line1, line2, line3;


    public static void main(String[] args) {
        Arrays.sort(pizzaboyloc);
        Arrays.sort(customerloc);

        long ans = findMinTimeToDeliverPizza();
        System.out.print(ans);
    }

    static long findMinTimeToDeliverPizza(){
        long low = 0;
        long high = Math.abs(pizzaboyloc[0] - customerloc[0]) + Math.abs(customerloc[0] + customerloc[customerloc.length - 1]);
        long ans = high;
        while(low <= high){
            long mid = (low + high)/2;
            boolean result = servesAll(mid);
            if(result){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
    static int i = 0 , j = 0, k = 0;

    static long steps = 0, timeLeft = 0;

    static boolean servesAll(long totalTime){
        k = 0; timeLeft = 0;
        for( i = 0 ; i < pizzaboycount ; i++){
            steps = 0;
            if(customerloc[k] < pizzaboyloc[i]){
                steps = Math.abs(pizzaboyloc[i] - customerloc[k]);
                if(steps > totalTime)
                    return false;
                timeLeft = Math.max((totalTime - 2 * steps),(totalTime - steps)/2);
            }
            else
                timeLeft = totalTime;

            while((pizzaboyloc[i] + timeLeft) >= customerloc[k]){
                if((pizzaboyloc[i] + timeLeft) < customerloc[k])
                    break;
                if((k >= (customercount-1) ))
                    return true;
                k++;

            }
        }
        return k >= (customercount - 1);
    }


}