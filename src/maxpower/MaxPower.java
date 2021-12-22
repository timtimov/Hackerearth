package maxpower;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 * @author Eftim
 */
public class MaxPower {
    
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
            StringBuilder sb = new StringBuilder();
            int test = Integer.parseInt(br.readLine());
            for (int i = 0; i < test; i++) {
                int num = Integer.parseInt(br.readLine());
                String[] line = br.readLine().split(" ");
                if(num == 2){
                    int result = Math.abs(Integer.parseInt(line[0])-Integer.parseInt(line[1]));
                    sb.append(result).append("\n");
                    continue;
                }
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                int secMax = max;
                int secMin = min;
                for (int j = 1; j < num-1; j++) {
                    int in = Integer.parseInt(line[j]);
                    if(in > max){
                        max = in;
                    }
                    if(in < min){
                        min = in;
                    }
                }
                max = Integer.parseInt(line[line.length-1]) > max ? 
                      Integer.parseInt(line[line.length-1]) : max;
                if(Integer.parseInt(line[0])> max){
                    secMax = max;
                    max = Integer.parseInt(line[0]);
                }
                min = Integer.parseInt(line[0]) < min ? 
                      Integer.parseInt(line[0]) : min;
                if(Integer.parseInt(line[line.length-1]) < min){
                    secMin = min;
                    min = Integer.parseInt(line[line.length-1]);
                }
                int result = 0;
                if(max == Integer.parseInt(line[0]) && 
                   min == Integer.parseInt(line[line.length-1])){
                    result = secMax - min > max - secMin ? secMax - min : max - secMin;
                }else{
                    result = max - min;
                }
                sb.append(result).append("\n");
            }
            bw.write(sb.toString());
            bw.flush();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
