package lottotest;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Sameer Anand
 * 
 */

public class LottoTest {

    public static final int NBALLS = 80;
    public static final int NGENS = 1000000;
    public static final int NPICKS = 20;

    private Random rand;
    private Set<Integer> userChoices;

    public LottoTest() {
        
        rand = new Random();
    
        userChoices = generatePicks();
    
    }

    public Set<Integer> generatePicks() {
        
        Set<Integer> set = new TreeSet<Integer>();
        
        while (set.size() < NPICKS) {
        
            // System.out.println(set);
        
            set.add(rand.nextInt(NBALLS) + 1);
        
        }
        
        return set;
    
    }

    public int countMatches(Set<Integer> picks) {
    
        int count = 0;
        
        for (Integer i : picks) {
        
            if (userChoices.contains(i)) {
            
                count++;
            
            }
        
        }
        
        return count;
    
    }

    public static void main(String[] args) {

        LottoTest lottoTest = new LottoTest();

        Set<Integer> picks;

        int[] matches = new int[NPICKS];

        for (int i = 0; i < NGENS; i++) {
            
            //System.out.println(i);
            
            picks = lottoTest.generatePicks();
            
            int countMatches = lottoTest.countMatches(picks);
            
            matches[countMatches]++;
        
        }

        for (int i = 0; i < NPICKS; i++) {
        
            System.out.print(matches[i] + ",");
        
        }
        
        System.out.println("");

    }

}