import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GenerazioneTesto {
    HashMap<String, HashSet<String>> prefixMap;

    public GenerazioneTesto(){
        prefixMap = new HashMap<>();
    }

    public void train(ArrayList<String> text){
        for (int i = 0; i < text.size() - 1; i++) {
            String key = text.get(i);
            if (!prefixMap.containsKey(key))
                prefixMap.put(key, new HashSet<>());
            prefixMap.get(key).add(text.get(i+1));
        }
    }

    public ArrayList<String> generate(int maxSize){
        ArrayList<String> text = new ArrayList<>();
        //Generazione della prima parola casuale
        ArrayList<String> keys = new ArrayList<>(prefixMap.keySet());
        ArrayList<String> suffixes;
        suffixes = new ArrayList<>(prefixMap.get(keys.get((int)(Math.random()*keys.size()))));
        text.add(suffixes.get((int)(Math.random()*suffixes.size())));
        //Generazione delle parole successive
        for (int i = 1; i < maxSize; i++) {
            suffixes = new ArrayList<>(prefixMap.get(text.get(i-1)));
            text.add(suffixes.get((int)(Math.random()*suffixes.size())));
        }
        return text;
    }

    public ArrayList<String> generate(int maxSize, String inizio){
        ArrayList<String> text = new ArrayList<>();
        text.add(inizio);
        //Generazione delle parole successive
        ArrayList<String> suffixes;
        for (int i = 1; i < maxSize; i++) {
            suffixes = new ArrayList<>(prefixMap.get(text.get(i-1)));
            text.add(suffixes.get((int)(Math.random()*suffixes.size())));
        }
        return text;
    }
}
