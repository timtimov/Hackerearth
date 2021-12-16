package pairsums;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 *
 * @author Eftim
 */
public class PairSums {
    
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] ak = br.readLine().split(" ");
            int size = Integer.parseInt(ak[0]);
            int target = Integer.parseInt(ak[1]);
            String[] line = br.readLine().split(" ");
            HashMap<Integer, Integer> map = new HashMap<>();
            String result = "NO";
            int num = 0;
            for (int i = 0; i < size; i++) {
                num = Integer.parseInt(line[i]);
                if (map.containsKey(num)){
                    result = "YES";
                    break;
                }
                map.put(target - num, num);
            }
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Error");
        }
 
    }
}
