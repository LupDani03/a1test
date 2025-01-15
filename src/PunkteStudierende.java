public class PunkteStudierende {
    int id;
    String name;

    public enum Haus {
        Gryffindor, Slytherin, Ravenclaw, Hufflepuff
    }

    Haus h;
    String autoritat;
    int punkte;

    public PunkteStudierende(int id, String name, Haus h, String autoritat, int punkte) {
        this.id = id;
        this.name = name;
        this.h = h;
        this.autoritat = autoritat;
        this.punkte = punkte;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Haus: " + h + ", Autoritat: " + autoritat + ", Punkte: " + punkte;
    }

    public int compareTo(PunkteStudierende o) {
        return this.name.compareTo(o.name);
    }
}
