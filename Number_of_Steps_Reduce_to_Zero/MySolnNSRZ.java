package Number_of_Steps_Reduce_to_Zero;

public class MySolnNSRZ {
    /*
     * Given an integer num, return the number of steps to reduce it to zero.

    In one step, if the current number is even, you have to divide it by 2, 
    otherwise, you have to subtract 1 from it.
     */
    public static void main(String[] args) {
        int num = 14;
        System.out.println(numberOfSteps(num));
    }

    //better than 100 run, 90 memory
    public static int numberOfSteps(int num) {
        int count = 0;
        while (num != 0) {
            num = (num % 2 == 0) ? num/2 : num-1;
            count++;
        }
        return count;
    }
}
