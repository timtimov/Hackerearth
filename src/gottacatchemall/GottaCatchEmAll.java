package gottacatchemall;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 * @author Eftim
 */
public class GottaCatchEmAll {
    
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int num = Integer.parseInt(br.readLine());
            String[] line = br.readLine().split(" ");
            int[] days = new int[num];
            for (int i = 0; i < num; i++) {
                days[i] = Integer.parseInt(line[i]);
            }
            Arrays.sort(days);
            for (int i = 0; i < num; i++) {
                days[i] += num - i;
            }
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < num; i++) {
                if(days[i] > max){
                    max = days[i];
                }
            }
            System.out.println(max+1);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
