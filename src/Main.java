import java.io.*;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("output.json"));
            bw.write("karen");
            bw.newLine();
            bw.close();
            BufferedReader br = new BufferedReader(new FileReader("output.json"));
            var p=br.readLine();
            var b=br.readLine();
            br.close();
            System.out.println(p);
            System.out.println(b);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}