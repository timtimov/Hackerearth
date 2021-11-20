package onesizedgame;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author Eftim
 */
public class OneSizedGame {
    
    static class Element{
        
        private int value;
        private int poss;

        public Element(int value, int poss) {
            this.value = value;
            this.poss = poss;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getPoss() {
            return poss;
        }

        public void setPoss(int poss) {
            this.poss = poss;
        }

        @Override
        public String toString() {
            return "Element{" + "value=" + value + ", poss=" + poss + '}';
        }
        
    }
    
    static class ElemComp implements Comparator<Element>{

        @Override
        public int compare(Element o1, Element o2) {
            if(o1.getValue() == o2.getValue()){
                return o1.getPoss() - o2.getPoss();
            }
            return o1.getValue() - o2.getValue();
        }
        
    }
       
    public static void main(String[] args) {
        
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int test = Integer.parseInt(br.readLine());
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            for (int i = 0; i < test; i++) {
                int num = Integer.parseInt(br.readLine());
                ArrayList<Element> elem = new ArrayList<>(num);
                Element[] sortElem = new Element[num];
                String[] values = br.readLine().split(" ");
                for (int j = 0; j < num; j++) {
                    Element el = new Element(Integer.parseInt(values[j]), j+1);
                    sortElem[j] = el;
                    elem.add(el);
                }
                Arrays.sort(sortElem, new ElemComp());
                int target = 0;
                for (int j = 0; j < num-1; j++) {
                    sortElem[j].setValue(sortElem[j].getValue() - target);
                    if(sortElem[j].getValue()>=0){
                        target += sortElem[j].getValue() + sortElem[j].getPoss() - 
                                  (sortElem[j].getValue()%sortElem[j].getPoss());
                        int temp = target;
                        elem.removeIf(n -> (n.getValue()<temp));
                        for (int k = 0; k < elem.size(); k++) {
                            elem.get(k).setPoss(k+1);
                        }
                    }
                                     
                }
                if(sortElem[num-1].getValue() - target < 0){
                    bw.write("Kushagra\n");
                }else{
                    bw.write("Ladia\n");
                }
            }
            bw.flush();
            bw.close();
        }catch(Exception e){
            System.out.println("Error");
        }

    }
}
