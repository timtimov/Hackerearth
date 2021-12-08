package cardgame;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Eftim
 */
public class CardGame {
    
    public static void main(String[] args) {
        
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int numFirst = Integer.parseInt(br.readLine());
            String[] lineF = br.readLine().split(" ");
            int[] cardsF = new int[numFirst];
            for (int i = 0; i < numFirst; i++) {
                cardsF[i] = Integer.parseInt(lineF[i]);
            }
            int numSecond = Integer.parseInt(br.readLine());
            String[] lineS = br.readLine().split(" ");
            int[] cardsS = new int[numSecond];
            int max = Integer.MIN_VALUE;
            int card = 0;
            for (int i = 0; i < numSecond; i++) {
                card = Integer.parseInt(lineS[i]);
                max = card > max ? card : max;
                cardsS[i] = card;
            }
            max += 1;
            long result = 0;
            for (int i = 0; i < numFirst; i++) {
                if(cardsF[i] < max){
                    result += max - cardsF[i];
                }
            }
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
