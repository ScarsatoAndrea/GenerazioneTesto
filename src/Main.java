import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    static void getParole (String s, ArrayList<String> t){
        int index = s.indexOf(" ");
        String parola = s.substring(0, index);
//        System.out.println(parola);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in;
        try {
            in = new BufferedReader(new FileReader("train.txt"));
        }catch (Exception e ){
            throw new RuntimeException();
        }
        ArrayList<String> testo = new ArrayList<>();
        String s = in.readLine();
        while (s != null){
            getParole(s, testo);
        }
    }
}