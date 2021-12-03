package promnight;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 * @author Eftim
 */
public class PromNight {
    
    public static void main(String[] args) {
        
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int test = Integer.parseInt(br.readLine());
            for (int i = 0; i < test; i++) {
                String[] nums = br.readLine().split(" ");
                int mNum = Integer.parseInt(nums[0]);
                int nNum = Integer.parseInt(nums[1]);
                String[] lineM = br.readLine().split(" ");
                String[] lineN = br.readLine().split(" ");
                int[] mVal = new int[mNum];
                int[] nVal = new int[nNum];
                for (int j = 0; j < mNum; j++) {
                    mVal[j] = Integer.parseInt(lineM[j]);
                }
                for (int j = 0; j < nNum; j++) {
                    nVal[j] = Integer.parseInt(lineN[j]);
                }
                Arrays.sort(mVal);
                Arrays.sort(nVal);
                boolean result = true;
                for (int j = 0; j < mNum; j++) {
                    if(mVal[j] <= nVal[j]){
                        result = false;
                        break;
                    }
                }
                System.out.println(result == true ? "YES" : "NO");
            }
        }catch(Exception e){
            System.out.println("Error");
        }
    }
}
