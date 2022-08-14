package Baseball_Game;
import java.util.*;
public class MySolnBG {
    /*
     * You are keeping score for a baseball game with strange rules. 
     * The game consists of several rounds, where the scores of past 
     * rounds may affect future rounds' scores.

At the beginning of the game, you start with an empty record. 
You are given a list of strings ops, where ops[i] is the ith operation 
you must apply to the record and is one of the following:

    An integer x - Record a new score of x.
    "+" - Record a new score that is the sum of the previous two scores. 
    It is guaranteed there will always be two previous scores.
    "D" - Record a new score that is double the previous score. 
    It is guaranteed there will always be a previous score.
    "C" - Invalidate the previous score, removing it from the record. 
    It is guaranteed there will always be a previous score.

Return the sum of all the scores on the record. The test cases 
are generated so that the answer fits in a 32-bit integer.
     */
    public static void main(String[] args) {
        String[] ops = {"1","C"};
        System.out.println(calPoints(ops));
    }

    public static int calPoints(String[] ops) {
        ArrayList<Integer> oper = new ArrayList<>();
        for (int i = 0; i < ops.length; i++) {
            switch(ops[i]) {
                case "+":
                    oper.add(oper.get(oper.size()-1) + oper.get(oper.size()-2));
                    break;
                case "D":
                    oper.add(oper.get(oper.size()-1) * 2);
                    break;
                case "C":
                    oper.remove(oper.get(oper.size()-1));
                    break;
                default:
                    oper.add(Integer.parseInt(ops[i]));
                    break;
            }
        }
        return oper.stream().reduce(0, (a,b)-> a + b);
    }
}
