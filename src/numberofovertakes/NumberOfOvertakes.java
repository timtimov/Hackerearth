package numberofovertakes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author Eftim
 */
public class NumberOfOvertakes {
    
    public static int overtakes = 0;
    
    static class Horse {
        
        private int vel;
        private int pos;

        public Horse(int vel, int pos) {
            this.vel = vel;
            this.pos = pos;
        }

        public int getVel() {
            return vel;
        }

        public void setVel(int vel) {
            this.vel = vel;
        }

        public int getPos() {
            return pos;
        }

        public void setPos(int pos) {
            this.pos = pos;
        }
        
    }
    
    static class CompHorse implements Comparator<Horse>{

        @Override
        public int compare(Horse h1, Horse h2) {
            return h1.getPos() - h2.getPos();
        }
        
    }
    
    public static Horse[] mergeSort(Horse[] arr){
        
        if(arr.length <= 1){
            return arr;
        }
        int mid = (arr.length - 1) /2;
        
        Horse[] leftArr = new Horse[mid+1];
        System.arraycopy(arr, 0, leftArr, 0, mid+1);
        Horse[] left = mergeSort(leftArr);
        
        Horse[] rightArr = new Horse[arr.length-1-mid];
        System.arraycopy(arr, mid+1, rightArr, 0, arr.length-1-mid);
        Horse[] right = mergeSort(rightArr);
        return merge(left, right);
    }
    
    public static Horse[] merge(Horse[] left, Horse[] right){
        
        Horse[] mergeArr = new Horse[left.length+right.length];
        int l = 0;
        int r = 0;
        int m = 0;
        int over = 0;
        while(l < left.length && r < right.length){
            if(left[l].getVel() <= right[r].getVel()){
                mergeArr[m++] = left[l++];
                NumberOfOvertakes.overtakes += over;
            }else{
                mergeArr[m++] = right[r++];
                over++;
            }
        }
        
        while(l < left.length){
            mergeArr[m++] = left[l++];
            NumberOfOvertakes.overtakes += over;
        }
        
        while(r < right.length){
            mergeArr[m++] = right[r++];
        }
        
        return mergeArr;
    }
    
    public static void main(String[] args) {
        
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){ 
            int numH = Integer.parseInt(br.readLine());
            String[] velocity = br.readLine().split(" ");
            String[] position = br.readLine().split(" ");
            Horse[] horses = new Horse[numH];
            for (int i = 0; i < numH; i++) {
                horses[i] = new Horse(Integer.parseInt(velocity[i]), Integer.parseInt(position[i]));
            }
            Arrays.sort(horses, new CompHorse());
            horses = mergeSort(horses);
            System.out.println(overtakes);
        }catch(Exception e){
            System.out.println("Error");
        }
    }
}
