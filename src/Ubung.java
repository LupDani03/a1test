import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ubung {
    public static void main(String[] args) {
        String filepath = "punkte.txt";
        List<PunkteStudierende> eintrage = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(Paths.get(filepath));
            for (String line : lines) {
                String[] daten = line.split("&");
                int id = Integer.parseInt(daten[0]);
                String name = daten[1];
                PunkteStudierende.Haus h = PunkteStudierende.Haus.valueOf(daten[2]);
                String autoritation = daten[3];
                int punkte = Integer.parseInt(daten[4]);

                PunkteStudierende neuesObjekt = new PunkteStudierende(id, name, h, autoritation, punkte);
                eintrage.add(neuesObjekt);
            }
        } catch (IOException e) {
            System.err.println("Fehler beim lesen der Datei" + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Fehler beim Parsen der Datei" + e.getMessage());
        }
//        for (PunkteStudierende objekt:eintrage){
//            System.out.println(objekt.toString());
//        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Anfangsbuchstabe: ");
        String ch = sc.nextLine();
        for (PunkteStudierende objekt : eintrage) {
            if (objekt.name.charAt(0) == ch.charAt(0)) {
                System.out.println(objekt.name);
            }
        }

        List<PunkteStudierende> studierendeNamen = new ArrayList<>();
        List<String> noDuplicates = new ArrayList<>();

        for (PunkteStudierende objekt : eintrage) {
            if (objekt.h == PunkteStudierende.Haus.Gryffindor)
                if (!noDuplicates.contains(objekt.name)) {
                    studierendeNamen.add(objekt);
                    noDuplicates.add(objekt.name);
                }
        }
        studierendeNamen.sort(PunkteStudierende::compareTo);

        System.out.println("\nStudierenden von Gryffindor gesortet:");
        for (PunkteStudierende studierende : studierendeNamen) {
            System.out.println(studierende.name);
        }

        int punkteGryffindor = 0;
        int punkteSlytherin = 0;
        int punkteHufflepuff=0;
        int punkteRavenclaw=0;

        for (PunkteStudierende studierende : eintrage) {
            if (studierende.h==PunkteStudierende.Haus.Gryffindor)
                punkteGryffindor+=studierende.punkte;
            else if(studierende.h==PunkteStudierende.Haus.Slytherin)
                punkteSlytherin+=studierende.punkte;
            else if(studierende.h==PunkteStudierende.Haus.Hufflepuff)
                punkteHufflepuff+=studierende.punkte;
            else if(studierende.h==PunkteStudierende.Haus.Ravenclaw)
                punkteRavenclaw+=studierende.punkte;
            else throw new RuntimeException("Haus der Studenten ist falsch");
        }
        try{
            String daten="Gryffindor#"+ punkteGryffindor+"\n"+
                    "Ravenclaw#"+punkteRavenclaw+"\n"+
                    "Slytherin#"+punkteSlytherin+"\n"+
                    "Hufflepuff#"+punkteHufflepuff+"\n";
            Files.write(Path.of("ergebnis.txt"),daten.getBytes());
        } catch (IOException e) {
            System.err.println("Fehler beim schreiben in der Datei" + e.getMessage());
        }
    }


}
