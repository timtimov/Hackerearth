package earthandthemeteorites;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author Eftim
 */
public class EarthAndTheMeteorites {
    
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int test = Integer.parseInt(br.readLine());
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < test; i++) {
                String[] nmq = br.readLine().split(" ");
                int n = Integer.parseInt(nmq[0]);
                int m = Integer.parseInt(nmq[1]);
                int q = Integer.parseInt(nmq[2]);
                SortedSet<Integer> xVal = new TreeSet<>();
                SortedSet<Integer> yVal = new TreeSet<>();
                int xN = 0;
                int yN = 0;
                for (int j = 0; j < q; j++) {
                    String[] xy = br.readLine().split(" ");
                    xN = Integer.parseInt(xy[0]);
                    yN = Integer.parseInt(xy[1]);
                    if(xN !=1 && xN != n){
                        xVal.add(xN);
                    }
                    if(yN !=1 && yN != m){
                        yVal.add(yN);
                    }
                }
                long reg = Long.valueOf(xVal.size()+1) * Long.valueOf(yVal.size()+1);
                sb.append(reg);
                xVal.add(n);
                yVal.add(m);
                long xMin = Long.MAX_VALUE;
                long xMax = Long.MIN_VALUE;
                long yMin = Long.MAX_VALUE;
                long yMax = Long.MIN_VALUE;
                int xTemp = 1;
                int yTemp = 1;
                for (Integer x : xVal) {
                    if(x-xTemp < xMin){
                        xMin = x-xTemp;
                    }
                    if(x-xTemp > xMax){
                        xMax = x-xTemp;
                    }
                    xTemp = x;
                }
                for (Integer y : yVal) {
                    if(y-yTemp < yMin){
                        yMin = y-yTemp;
                    }
                    if(y-yTemp > yMax){
                        yMax = y-yTemp;
                    }
                    yTemp = y;
                }          
                sb.append(" ").append(xMin*yMin).append(" ").append(xMax*yMax).append("\n");
            }
            bw.write(sb.toString());
            bw.flush();
            bw.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
