import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

/*    static void getParole (String s, ArrayList<String> t){
        int index = s.indexOf(" ");
        int index_ = 0;
        while (index == )
        String parola = s.substring(0, index);
//        System.out.println(parola);
        t.add(parola);
    }*/

    public static void main(String[] args) throws IOException {
        /*BufferedReader in;
        try {
            in = new BufferedReader(new FileReader("train.txt"));
        }catch (Exception e ){
            throw new RuntimeException();
        }*/
        Scanner in = new Scanner(new FileReader("train.txt"));
        String s = in.next();
        ArrayList<String> testo = new ArrayList<>();
        testo.add(s);
//        String s = in.readLine();
        while (in.hasNext()){
            s = in.next();
            testo.add(s);
        }
        GenerazioneTesto gt = new GenerazioneTesto();
        gt.train(testo);
        ArrayList<String> testoGenerato = gt.generate(500);
        StringBuilder output = new StringBuilder();
        for (String word : testoGenerato) {
            output.append(word).append(' ');
        }
        FileWriter out = new FileWriter("output.txt");
        out.write(output.toString());
        out.close();
    }
}