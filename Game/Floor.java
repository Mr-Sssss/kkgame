public class Floor{
    public int Number;
    public String Description;

   public Floor(int newNumber, String newDescription){
        number =  newNumber;
        description = newDescription;
    }

    private Floor(String newDescription, int newNumber){
        description = newDescription;
        number = newNumber;
    }
    private void changeDescription(String changedDescription) {
        description = changedDescription;
    }
    
    public void changeNumber(int changedNumber) {
        number = changedNumber;
    }
    Floor erdgeschoss = new Floor(0, "Im Erdgeschoss findest du Informatikräume, Klassenräume der kleinen Kiddos und Verwaltungsräume.");
    Floor eins = new Floor(1, "Hier sind meistens ganz normale Räume. Am häufigsten findest du hier Sprach- und Gewilehrer");
    Floor zwei = new Floor(2, "Hier sind fast nur Fachräume der Naturwissenschafft, aber auch normale Räume");
    Floor drei = new Floor(3, "Hier sind Nawi-Räume auf der einen und Musik/Kunst-Räume auf der anderen Seite. Hier ist auch die Aula und das Kunst-Atelier");
}