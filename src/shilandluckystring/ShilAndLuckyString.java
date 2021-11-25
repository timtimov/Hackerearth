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
            int aLeft = 0;
            int aRight = 0;
            int zLeft = 0;
            int zRight = 0;
            for (int i = 0; i < len; i++) {
                left[i] = str.charAt(i);
                right[i] = str.charAt(i+len);
                if(left[i] == 'a'){
                    aLeft++;
                }else if(left[i] == 'z'){
                    zLeft++;
                }
                if(right[i] == 'a'){
                    aRight++;
                }else if(right[i] == 'z'){
                    zRight++;
                }
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
            big = len - big;
            small = len - small;
            equal = len - equal;
            if(big - aLeft < zRight){
                big += zRight - (big - aLeft);
            }
            if(small - zLeft < aRight){
                small += aRight - (small - zLeft);
            }
            int result = Math.min(big, Math.min(small,equal));
            System.out.println(result);
        }catch(Exception e){
            System.out.println("Error");
        }
    }
}
