package bennyandgifts;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author Eftim
 */
public class BennyAndGifts {
    
    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
        
    }
    
    static class CompPoints implements Comparator<Point>{

        @Override
        public int compare(Point p1, Point p2) {
            if(p1.getX() == p2.getX()){
                return p1.getY() - p2.getY();
            }
            return p1.getX() - p2.getX();
        }
    }
    
    public static void main(String[] args) {
        
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String line = br.readLine();
            int x = 0;
            int y = 0;
            Point[] path = new Point[line.length() + 1];
            for (int i = 0; i < line.length(); i++) {
                switch(line.charAt(i)){
                    case 'L' -> path[i] = new Point(x, --y);
                    case 'R' -> path[i] = new Point(x, ++y);
                    case 'U' -> path[i] = new Point(--x, y);
                    case 'D' -> path[i] = new Point(++x, y); 
                }
            }
            path[path.length - 1] = new Point(0, 0);
            Arrays.sort(path, new CompPoints());
            x = path[0].getX();
            y = path[0].getY();
            int result = 0;
            for (int i = 1; i < path.length; i++) {
                if (path[i].getX() == x && path[i].getY() == y){
                    result++;
                }else{
                    x = path[i].getX();
                    y = path[i].getY();
                }
            }
            System.out.println(result);
        }catch(Exception e){
            System.out.println("Error");
        }
    } 
}
