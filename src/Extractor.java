import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Extractor {

    public static void main(String[] args) throws IOException {

        List<String> file1= extractLines(Path.of("/home/tosigame/LogisimDSD/traces (2)/golden_q3.txt"));
        List<String> file2= extractLines(Path.of("/home/tosigame/LogisimDSD/traces (2)/trace_q3.txt"));
        for (int i = 0; i < file1.size(); i++) {
            //if(!file1.get(i).equals(file2.get(i))) {
            file1.set(i, file1.get(i).replace("001","0"));
            file1.set(i, file1.get(i).replace("100","1"));
            file1.set(i, file1.get(i).replace("010","2"));
            file1.set(i, file1.get(i).replace("011","3"));
            file1.set(i, file1.get(i).replace("110","4"));

            file2.set(i, file2.get(i).replace("001","0"));
            file2.set(i, file2.get(i).replace("100","1"));
            file2.set(i, file2.get(i).replace("010","2"));
            file2.set(i, file2.get(i).replace("011","3"));
            file2.set(i, file2.get(i).replace("110","4"));
                System.out.println(" trace: "+file1.get(i) + "\n" + "golden: "+file2.get(i));
                System.out.println();
            //}
        }


    }

    public static List<String> extractLines(Path pathOfFile) throws IOException {

        List<String> lines=new ArrayList<>();

        try(BufferedReader br= new BufferedReader(new FileReader(String.valueOf((pathOfFile))))){
            String nextLine="";

            while(nextLine!=null) {
                lines.add(nextLine);
                nextLine=br.readLine();

            }

        }

    return lines;
    }

}
