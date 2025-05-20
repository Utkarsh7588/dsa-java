package Sorting.Easy;

public class MaxProduct {
    public static void main(String[] args) {
        System.out.println(maximumProduct(new int[] {1,2,3,2}));
    }
    public static int maximumProduct(int[] nums) {
        int max1=Integer.MIN_VALUE;
        int max2=Integer.MIN_VALUE;
        int max3=Integer.MIN_VALUE;
        int min1=Integer.MAX_VALUE;
        int min2=Integer.MAX_VALUE;

        for(int num:nums)
        {
            if(num>max1)
            {
                max1=num;
                if(num>max2)
                {
                    max1=max2;
                    max2=num;
                    if(num>max3)
                    {
                        max2=max3;
                        max3=num;
                    }
                }
            }

            if(num<min1)
            {
                min1=num;

                    if(num<min2)
                    {
                        min1=min2;
                        min2=num;
                    }

            }
        }

        return Math.max(max3*max2*max1,max3*min1*min2);
    }

}
