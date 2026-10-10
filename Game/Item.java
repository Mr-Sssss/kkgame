public class Item{
    private String name;
    private Subject subject;
    private String description;
    private int place;
    private static boolean inSight;

    public Item(String newName, Subject newSubject, String newDescription, int newPlace, boolean newInSight){
        name = newName;
        subject = newSubject;
        description = newDescription;
        place = newPlace;
        inSight = newInSight;
    }

    public void setName(String changedName) { name = changedName; }

    public void setSubject(Subject changedSubject) { subject = changedSubject; }

    public void setDescription(String changedDescription){ description = changedDescription; }

    public void setPlace(int changedPlace) { place = changedPlace; }

    public void setInSight(boolean changedInSight) { inSight = changedInSight; }

    public String getName() {return name; }

    public Subject getSubject() {return subject; }

    public String getDescription(){return description; }

    public int getPlace() {return place; }

    public boolean getInSight() {return inSight; }

    public void use(String name){

    }

    Item key005 = new Item("Schlüssel für Raum 005", Subject.maths, "Dieser Schlüssel kann den Raum 005 öffnen", 1, false);
    Item key007 = new Item("Schlüssel für Raum 007", Subject.neutral, "Dieser Schlüssel kann den Raum 007 öffnen", 1, false);
    Item key008 = new Item("Schlüssel für Raum 008", Subject.neutral, "Dieser Schlüssel kann den Raum 008 öffnen", 1, false);
    Item key009 = new Item("Schlüssel für Raum 009", Subject.neutral, "Dieser Schlüssel kann den Raum 009 öffnen", 1, false);
    Item key010 = new Item("Schlüssel für Raum 010", Subject.neutral, "Dieser Schlüssel kann den Raum 010 öffnen", 1, false);
    Item key011 = new Item("Schlüssel für Raum 011", Subject.neutral, "Dieser Schlüssel kann den Raum 011 öffnen", 1, false);
    Item key012_013 = new Item("Schlüssel für Raum 012/13", Subject.neutral, "Dieser Schlüssel kann den Raum 012 bzw. 013 öffnen", 1, false);
    Item key108 = new Item("Schlüssel für Raum 108", Subject.languages, "Dieser Schlüssel kann den Raum 108 öffnen", 1, false);
    Item key114 = new Item("Schlüssel für Raum 114", Subject.languages, "Dieser Schlüssel kann den Raum 114 öffnen", 1, false);
    Item key206 = new Item("Schlüssel für Raum 206", Subject.maths, "Dieser Schlüssel kann den Raum 206 öffnen", 1, false);
    Item key208 = new Item("Schlüssel für Raum 208", Subject.science, "Dieser Schlüssel kann den Raum 208 öffnen", 1, false);
    Item key214 = new Item("Schlüssel für Raum 214", Subject.science, "Dieser Schlüssel kann den Raum 214 öffnen", 1, false);
    Item key307 = new Item("Schlüssel für Raum 307", Subject.neutral, "Dieser Schlüssel kann den Raum 307 öffnen", 1, false);
    Item key309 = new Item("Schlüssel für Raum 309", Subject.maths, "Dieser Schlüssel kann den Raum 309 öffnen", 1, false);
    Item key313 = new Item("Schlüssel für Raum 313", Subject.artmusic, "Dieser Schlüssel kann den Raum 313 öffnen", 1, false);
    Item key401 = new Item("Schlüssel für Raum 401", Subject.artmusic, "Dieser Schlüssel kann den Raum 401 öffnen", 1, false);
}
