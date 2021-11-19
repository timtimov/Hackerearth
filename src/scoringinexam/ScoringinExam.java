package scoringinexam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author Eftim
 */
public class ScoringinExam {
    
    static class Question{
        
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
    
    static class QuestionComp implements Comparator<Question>{
        
        @Override
        public int compare(Question o1, Question o2) {
            if(o1.getScore()==o2.getScore()){
                return o1.getTime() - o2.getTime();
            }
            return o2.getScore() - o1.getScore();
            
        }
    }
    
    public static void main(String[] args) {
        
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String[] firstLine = br.readLine().split(" ");
            int numQuest = Integer.parseInt(firstLine[0]);
            int queries = Integer.parseInt(firstLine[1]);
            Question[] questions = new Question[numQuest];
            String[] getTimes = br.readLine().split(" ");
            for (int i = 0; i < numQuest; i++) {
                questions[i] = new Question(Integer.parseInt(getTimes[i]));
            }
            String[] getScores = br.readLine().split(" ");
            for (int i = 0; i < numQuest; i++) {
                questions[i].setScore(Integer.parseInt(getScores[i]));
            }
            Arrays.sort(questions, new QuestionComp());
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            for (int i = 0; i < queries; i++) {
                int num = Integer.parseInt(br.readLine());
                int result = 0;
                for (int j = 0; j < num; j++) {
                    result += questions[j].getTime();
                }
                bw.write(result + "\n");
            }
            bw.flush();
            bw.close();
        }catch(Exception e){
            System.out.println("Error");
        }
    }
}
