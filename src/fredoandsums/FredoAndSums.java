package fredoandsums;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 *
 * @author Eftim
 */
public class FredoAndSums {
    
    public static void main(String[] args) {
        
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int test = Integer.parseInt(br.readLine());
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < test; i++) {
                int num = Integer.parseInt(br.readLine());
                String[] line = br.readLine().split(" ");
                int[] arr = new int[num];
                for (int j = 0; j < num; j++) {
                    arr[j] = Integer.parseInt(line[j]);
                }
                Arrays.sort(arr);
                long max = 0;
                long min = 0;
                int k = 0;
                for (int j = 0; j < num/2; j++) {
                    max += Math.abs(arr[num-j-1] - arr[j]);
                    min += Math.abs(arr[k] - arr[k+1]);
                    k +=2;
                }
                sb.append(min).append(" ").append(max).append("\n");
            }
            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }catch(Exception e){
            System.out.println("Error");
        }
    }
}
