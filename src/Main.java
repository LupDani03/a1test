import java.io.*;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("punkte.txt"));
            var p=br.readLine();
            var b=br.readLine();
            br.close();
            System.out.println(p);
            System.out.println(b);
            BufferedWriter bw = new BufferedWriter(new FileWriter("ergebnis.txt"));
            bw.write("karen");
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}