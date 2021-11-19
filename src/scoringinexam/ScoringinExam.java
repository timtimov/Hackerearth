package scoringinexam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;

/**
 *
 * @author Eftim
 */
public class ScoringinExam {
    
    class Question{
        
        private int score;
        private int time;

        public Question(int time) {
            this.time = time;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }
        
    }
    
    class QuestionComp implements Comparator<Question>{
        
        @Override
        public int compare(Question o1, Question o2) {
            if(o1.getScore()==o2.getScore()){
                return o1.getTime() - o2.getTime();
            }else{
                return o1.getScore() - o2.getScore();
            }
        }
    }
    
    public static void main(String[] args) {
        
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String[] firstLine = br.readLine().split(" ");
            int numQuest = Integer.parseInt(firstLine[0]);
            int queries = Integer.parseInt(firstLine[1]);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
            
        }catch(Exception e){
            System.out.println("Error");
        }
    }
}
