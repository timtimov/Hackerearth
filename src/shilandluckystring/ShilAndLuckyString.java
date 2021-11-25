package shilandluckystring;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 * @author Eftim
 */
public class ShilAndLuckyString {
    
    public static void main(String[] args) {
        
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int len = Integer.parseInt(br.readLine()) / 2;
            String str = br.readLine();
            char[] left = new char[len];
            char[] right = new char[len];
            for (int i = 0; i < len; i++) {
                left[i] = str.charAt(i);
                right[i] = str.charAt(i+len);
            }
            Arrays.sort(left);
            Arrays.sort(right);
            int big = 0;
            int small = 0;
            int equal = 0;
            int bCount = 0;
            int sCount = 0;
            int eCount = 0;
            for (int i = 0; i < len; i++) {
                if(left[i] > right[bCount]){
                    big++;
                    bCount++;
                }
                if(sCount < len){
                    if(left[i] < right[sCount]){
                        small++;
                        sCount++;
                    }else{
                        sCount++;
                        while(sCount<len){
                            if(left[i] < right[sCount]){
                                small++;
                                sCount++;
                                break;
                            }
                            sCount++;
                        }
                    }
                }
                if(eCount < len){
                    while(left[i] >= right[eCount]){
                        if(left[i] == right[eCount]){
                            equal++;
                            eCount++;
                            break;
                        }
                        eCount++;
                        if(eCount == len){
                            break;
                        }
                    }  
                }
                  
            }
            int result = Math.max(big, Math.max(small,equal));
            System.out.println(len - result);
        }catch(Exception e){
            System.out.println("Error");
        }
    }
}
