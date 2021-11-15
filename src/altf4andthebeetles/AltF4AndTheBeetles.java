package altf4andthebeetles;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Eftim
 */
public class AltF4AndTheBeetles {
    
    public static class Beetle{
        
        private int value;
        private int time;

        public Beetle(int value, int time) {
            this.value = value;
            this.time = time;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        } 
        public int beetleSortValue(){
            return this.value * 2 + this.time;
        }

        
    }
    
    public static class BeetleComp implements Comparator<Beetle>{

        @Override
        public int compare(Beetle b1, Beetle b2) {
            return b1.beetleSortValue() - b2.beetleSortValue();
        }
        
    }
   
    public static void main(String[] args) {
        
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int numberGames = Integer.parseInt(br.readLine());
            for (int i = 0; i < numberGames; i++) {
                String[] spl = br.readLine().split(" ");
                long bees = Integer.parseInt(spl[0]);
                long aPoint = Integer.parseInt(spl[1]);
                long bPoint = Integer.parseInt(spl[2]);
                long cPoint = Integer.parseInt(spl[3]);
                List<Beetle> bList = new ArrayList<>();
                for (int j = 0; j < bees; j++) {
                    String[] pq = br.readLine().split(" ");
                    bList.add(new Beetle(Integer.parseInt(pq[0]),0));
                    bList.add(new Beetle(Integer.parseInt(pq[1]),1));
                }
                bList.sort(new BeetleComp());
                long result = bees * aPoint;
                long maxRes = result;
                long pTime = bPoint - aPoint;
                long qTime = cPoint - bPoint;
                for (Beetle beetle : bList) {
                    if(beetle.getTime() == 0){
                        result += pTime;
                    }else{
                        result += qTime;
                    }
                    if(result>maxRes){
                        maxRes = result;
                    }
                }
                System.out.println(maxRes);
            }
        }catch(Exception e){
            System.out.println("Error");
        }
        
    }
    
}
