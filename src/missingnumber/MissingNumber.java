package missingnumber;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 *
 * @author Eftim
 */
public class MissingNumber {
 
    
    public static void main(String[] args) {
        
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int test = Integer.parseInt(br.readLine());
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            for (int i = 0; i < test; i++) {
                int len = Integer.parseInt(br.readLine());
                String[] line = br.readLine().split(" ");
                int[] num = new int[len];
                for (int j = 0; j < len; j++) {
                    num[j] = Integer.parseInt(line[j]);
                }
                Arrays.sort(num);
                int result = 2;
                for (int j = 0; j < len; j++) {
                    if (num[j] >= result){
                        result += 2;
                    }
                }
                bw.write(result + "\n");
            }
            bw.flush();
            bw.close();
        }catch(Exception e){
            System.out.println("Error");
        }
    }
}
