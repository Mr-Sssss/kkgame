public class Floor{
    private int number;
    private String description;

    public Floor(int newNumber, String newDescription){
        number =  newNumber;
        description = newDescription;
    }
    public void setDescription(String changedDescription) {
        description = changedDescription;
    }

    public void setNumber(int changedNumber) {
        number = changedNumber;
    }

    public String getDescription() {return description;}

    public int getNumber(){return number;}

    static Floor erdgeschoss = new Floor(0, "Im Erdgeschoss findest du Informatikräume, Klassenräume der kleinen Kiddos und Verwaltungsräume.");
    static Floor eins = new Floor(1, "Hier sind meistens ganz normale Räume. Am häufigsten findest du hier Sprach- und Gewilehrer");
    static Floor zwei = new Floor(2, "Hier sind fast nur Fachräume der Naturwissenschafft, aber auch normale Räume");
    static Floor drei = new Floor(3, "Hier sind Nawi-Räume auf der einen und Musik/Kunst-Räume auf der anderen Seite. Hier ist auch die Aula und das Kunst-Atelier");
}
