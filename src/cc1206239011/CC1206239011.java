/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc1206239011;

import java.util.*;
/**
 *
 * @author Haris Dwi Prakoso
 */
public class CC1206239011 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] inline1 = input.nextLine().split(" ");
        int n = Integer.parseInt(inline1[0]);
        int k = Integer.parseInt(inline1[1]);
        String[] inline2 = input.nextLine().split(" ");
        int[] coinlist = new int[inline2.length];
        for(int i = 0; i < coinlist.length; i++){
            coinlist[i] = Integer.parseInt(inline2[i]);
        }
        int[] numcoins = new int[n+1];
        int[] lastcoin = new int[n+1];
        getChange(coinlist, n, k, numcoins, lastcoin);
        int answersum = 0;
        String answer = "";
        int sum = n;
        while(n > 0){
            answersum += lastcoin[n];
            answer += (lastcoin[n] + " ");
            n -= lastcoin[n];
        }
        if(sum < answersum) System.out.println("-1 " + answersum);
        if(sum == answersum){
            String[] fin = answer.substring(0, answer.lastIndexOf(" ")).split(" ");
            for(int i = 0; i < fin.length; i++) System.out.println(fin[i]);
        }
        System.out.println();
    }
    
    private static void getChange(int[] coinlist, int n, int k, int[] numcoins, int[] lastcoin){
        numcoins[0] = 0;
        lastcoin[0] = 0;
        for(int i = 1; i <= n; i++){
            int coins = i;
            int denom = coinlist[0];
            for(int j = 0; j < k; j++){
                if(coinlist[j] > i) continue;
                if(numcoins[i - coinlist[j]] + 1 < coins){
                    coins  = numcoins[i - coinlist[j]] + 1;
                    denom = coinlist[j];
                }
            }
            numcoins[i] = coins;
            lastcoin[i] = denom;
        }
    }
    
    
}
