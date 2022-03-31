public class Solution {
    public int splitArray(int[] nums, int m) {
        int maxNo = 0;
        long total = 0;

        for (int el : nums) {
            maxNo = Math.max(el, maxNo);
            total += el;
        }


        long low = maxNo;
        long high = total;
        while (low< high) {
            long mid = (low) + (high-low)/2;
            //System.out.println(low + " "+ mid + " "+ high);
            if (validDivisionPossible(mid, nums, m)) {

                high = mid ;
            } else {
                low = mid + 1;
            }
        }
        return (int)low;
    }
    public boolean validDivisionPossible(long maxPossibleSum, int[] nums, int m) {
        int totalSubsetCount = 1;
        long totalRunningSum = 0;
        for(int num : nums) {
            totalRunningSum += num;
            //System.out.println( " Count "+count + " total "+ total);
            if (totalRunningSum > maxPossibleSum) {
                totalRunningSum = 0;
                totalRunningSum += num;


                //System.out.println( " Reseting subset" + total + " "+ count);
                // Going for next subset
                totalSubsetCount++;

                if (totalSubsetCount > m) {
                    return false;
                }
            }
        }
        return true;
    }
}