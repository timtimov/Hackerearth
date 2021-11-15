package findthenext;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 *
 * @author Eftim
 */
public class FindTheNext {
    
    public static int getRes(int[] array, int x, int left, int right){
        
        if(right >= left){
            int mid = left + (right - left) / 2;
            if(array[mid] == x){
                return mid;
            }
            if(array[mid] > x){
                return getRes(array, x, left, mid-1);
            }
            return getRes(array, x, mid+1, right);
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String[] firstLine = br.readLine().split(" ");
            int arraySize = Integer.parseInt(firstLine[0]);
            int qNum = Integer.parseInt(firstLine[1]);
            String[] arrayS = br.readLine().split(" ");
            int[] arrayInt = new int[arraySize];
            for (int i = 0; i < arraySize; i++) {
                arrayInt[i] = Integer.parseInt(arrayS[i]);
            }
            int[] array = Arrays.stream(arrayInt).distinct().toArray();
            int arrayNum = array.length;
            Arrays.sort(array);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
            for (int i = 0; i < qNum; i++) {
                int x = Integer.parseInt(br.readLine());
                int target = x+1;
                if(target > array[arrayNum-1]){
                    bw.write(target + "\n");
                }else if(target == array[arrayNum-1]){
                    bw.write(target+1 + "\n");
                }else if (target < array[0]){
                    bw.write(target + "\n");
                }else{
                    int res = getRes(array, target, 0, arrayNum - 1);
                    if(res == -1){
                        bw.write(target + "\n");
                    }else{
                        target +=1;
                        boolean check = false;
                        for (int j = res+1; j < arrayNum; j++) {
                            if(target == array[j]){
                                target +=1;
                            }else{
                                bw.write(target + "\n");
                                check = true;
                                break;
                            }
                        }
                        if(check == false){
                            bw.write(target + "\n");
                        }
                    }
                }  
            }
            bw.flush();
            bw.close();
        }catch(Exception e){
            System.out.println("Error");
        }
    }
}
