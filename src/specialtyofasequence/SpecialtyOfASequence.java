package specialtyofasequence;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 * @author Eftim
 */
public class SpecialtyOfASequence {
    
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String[] fLine = br.readLine().split(" ");
            int len = Integer.parseInt(fLine[0]);
            int seq = Integer.parseInt(fLine[1]);
            String[] numbers = br.readLine().split(" ");
            int[] num = new int[len];
            for (int i = 0; i < len; i++) {
                num[i] = Integer.parseInt(numbers[i]);
            }
            Arrays.sort(num);
            long result = 0;
            for (int i = 0; i < len - seq; i++) {
                result += num[i];
            }
            System.out.println(result);
        }catch(Exception e){
             System.out.println("Error");
        }
    }
}
