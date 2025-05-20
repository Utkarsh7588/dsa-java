package binarySearch.easy;

import java.util.Arrays;

public class FairCandySwap {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int length=Math.max(aliceSizes.length,bobSizes.length);
        int aliceSum=0;
        int bobSum=0;
        for(int i=0;i<length;i++){
            if(i<aliceSizes.length){
                aliceSum+=aliceSizes[i];
            }
            if(i<bobSizes.length){
                bobSum+=bobSizes[i];
            }
        }
        int average=(aliceSum+bobSum)/2;
       return new int[]{};
    }
}
