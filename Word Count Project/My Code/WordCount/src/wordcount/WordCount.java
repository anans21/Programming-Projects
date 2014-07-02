package wordcount;

/**
 *
 * @author Sameer Anand
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class WordCount {

    private static Map sortByComparator(Map unsortMap) {

        List<String> list = new LinkedList(unsortMap.entrySet());
        
        // Sort list based on comparator
        
        Collections.sort(list, new Comparator() {
            
            @Override
            
            public int compare(Object o1, Object o2) {
            
                return ((Comparable) ((Map.Entry) (o1)).getValue())
                
                        .compareTo(((Map.Entry) (o2)).getValue());
            
            }
        
        });
        
        //Reverse the list so it is in descending order
        
        Collections.reverse(list);
        
        // Put sorted list into map again
        // LinkedHashMap make sure order in which keys were inserted
        
        Map sortedMap = new LinkedHashMap();
        
        Iterator it = list.iterator();
        
        while (it.hasNext()) {
        
            Map.Entry entry = (Map.Entry) it.next();
            
            sortedMap.put(entry.getKey(), entry.getValue());
        
        }
        
        return sortedMap;
    
    }

    public static void main(String[] args) throws FileNotFoundException {

        long time;

        String[] words = processInputFile("DoI.txt");
        
        // System.out.println("Length: " + words.length);

        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();

        time = buildMap(words, hashMap);
        
        System.err.printf("HashMap   build time: %10.3f ms.\n", time / 1000000.0);

        System.out.println("HashMap based Map...");
        
        time = displayMap(hashMap);
        
        System.err.printf("HashMap display time: %10.3f ms.\n", time / 1000000.0);

        TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();

        
        time = buildMap(words, treeMap);
        
        System.err.printf("HashMap   build time: %10.3f ms.\n", time / 1000000.0);

        
        System.out.println("==============================\nTreeMap based Map...");
        
        time = displayMap(treeMap);
        
        System.err.printf("HashMap display time: %10.3f ms.\n", time / 1000000.0);

        
        System.out.println("==============================\nUsage based Map...");
        
        Map sortedByValue = sortByComparator(hashMap);

        for (Object key : sortedByValue.keySet()) {

            System.out.printf("%-15s %8d\n", key, sortedByValue.get(key));
        
        }

    }

    private static long buildMap(String[] words, Map<String, Integer> map) {
       
        long startTime = System.nanoTime();
        
        for (String word : words) {
        
            if (map.containsKey(word)) {
            
                map.put(word, map.get(word) + 1);
            
            } else {
            
                map.put(word, 1);
            
            }
        
        }
        
        return System.nanoTime() - startTime;
    
    }

    private static long displayMap(Map<String, Integer> map) {
        
        long startTime = System.nanoTime();
        
        Set<String> keySet = map.keySet();
        
        for (String key : keySet) {
        
            System.out.printf("%-15s %8d\n", key, map.get(key));
        
        }
        
        return System.nanoTime() - startTime;
    
    }

    private static String[] processInputFile(String fileName) throws FileNotFoundException {

        ArrayList<String> words = new ArrayList<>();
    
        Scanner scanner = new Scanner(new File(fileName));

        String line;

        while (scanner.hasNextLine()) {
            
            line = scanner.nextLine().toLowerCase();
            
            line = line.replace("-", " ");
            
            String[] temp = line.split("[\\d+,.:;& +]");
            
            for (String s : temp) {
            
                if (s.length() > 0) {
                
                    // System.out.println(s);
                    
                    words.add(s);
                
                }
            
            }
        
        }
        
        // System.out.println("Length: " + words.size());
        
        return words.toArray(new String[words.size()]);
    
    }

}