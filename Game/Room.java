public class Room{
    public String description;
    public int number;
    public int floor;
    public String subject;
    public boolean isFachraum;
    public boolean locked;
    public boolean bossroom;
    public int hostile;

    public Room(String newDescription, int newNumber, int newFloor, String newSubject, boolean newIsFachraum, boolean newLocked, boolean newBossroom, int newHostile){
        description = newDescription;
        number = newNumber;
        floor = newFloor;
        subject = newSubject;
        isFachraum = newIsFachraum;
        locked = newLocked;
        bossroom = newBossroom;
        hostile = newHostile;
    }
    
    
    private void changeDescription(String changedDescription) {
        description = changedDescription;
    }
    
    private void changeNumber(int changedNumber) {
        number = changedNumber;
    }
    
    private void changeFloor(int changedFloor) {
        floor = changedFloor;
    }

    private void changeSubject(int changedSubject) {
        subject = changedSubject;
    }
    
    private void changeIsFachraum(boolean changedIsFachraum) {
        isFachraum = changedIsFachraum;
    }
    
    private void changeLocked(boolean changedLocked) {
        locked = changedLocked;
    }
    
    private void changeBossroom(boolean changedBossroom) {
        bossroom = changedBossroom;
    }

    private void changeHostile(boolean changedHostile) {
        hostile = changedHostile;
    }
    
    public void inFloor() {
    }
    
    public void interactStudent(String student) {
    }
    
    public void interactTeacher(String teacher) {
    }

    Item R001 = new Item("Eine geteilte Toilette", 1, 0, "Default", false, false, false, 0);
    Item R002 = new Item("Der große Informatikraum", 2, 0, "Informatik", true, false, false, 2);
    Item R003 = new Item("Einer der kleinen Informatikräume", 3, 0, "Informatik", true, false, false, 1);
    Item R004 = new Item("Einer der kleinen Informatikräume", 4, 0, "Informatik", true, false, false, 1);
        Item R005 = new Item("Der Serverraum", 5, 0, "Informatik", true, true, true, 0);
    Item R006 = new Item("Der eine Klassenraum der Kiddos", 6, 0, "Default", false, false, false, 1);
    Item R007 = new Item("Der Raum des Hausmeisters", 7, 0, "Default", false, true, false, 3);
    Item R008 = new Item("Die Oberstuffenkoordination", 8, 0, "Default", false, true, false, 3);
    Item R009 = new Item("Der Raum der Schulleiterin", 9, 0, "Default", false, true, false, 5);
    Item R010 = new Item("Das Sekretariat", 10, 0, "Default", false, true, false, 0);
    Item R011 = new Item("Das Raum des Stellvertreten Schulleiters", 11, 0, "Default", false, true, false, 3);
    Item R012 = new Item("Der erste Eingang Lehrerzimmers", 12, 0, "Default", false, true, false, 10);
    Item R013 = new Item("Der zweite Eingang Lehrerzimmers", 13, 0, "Default", false, true, false, 10);
    Item R014 = new Item("Der eine Klassenraum der Kiddos", 14, 0, "Default", false, false, false, 1);
    Item R101 = new Item("Ein ganz normaler Raum", 101, 1, "Gewi", false, false, false, 1);
    Item R102 = new Item("Ein ganz normaler Raum", 102, 1, "Gewi", false, false, false, 1);
    Item R103 = new Item("Ein ganz normaler Raum", 103, 1, "Sprache", false, false, false, 1);
    Item R104 = new Item("Ein ganz normaler Raum", 104, 1, "Sprache", false, false, false, 1);
    Item R105 = new Item("Ein ganz normaler Raum", 105, 1, "Sprache", false, false, false, 1);
    Item R106 = new Item("Ein ganz normaler Raum", 106, 1, "Sprache", false, false, false, 1);
        Item R107 = new Item("Krabbenburger Restaurant", 107, 1, "Sprache", false, true, true);
    Item R108 = new Item("Der Vorbereitungsraum für Sprachfächer", 108, 1, "Sprache", false, true, false, 1);
    Item R109 = new Item("Ein ganz normaler Raum", 109, 1, "Sprache", false, false, false, 1);
        Item R110 = new Item("Haus des Halunken", 110, 1, "Gewi", false, true, true);
    Item R111 = new Item("Ein ganz normaler Raum", 111, 1, "Gewi", false, false, false, 1);
    Item R112 = new Item("Ein ganz normaler Raum", 112, 1, "Gewi", false, false, false, 1);
    Item R113 = new Item("Ein ganz normaler Raum", 113, 1, "Gewi", false, false, false, 1);
    Item R114 = new Item("Der Vorbereitungsraum für Gewifächer", 114, 1, "Gewi", false, true, false, 1);
    Item R115 = new Item("Die Mädchentoilette", 115, 1, "Default", false, false, false, 1);
    Item R201 = new Item("Ein ganz normaler Raum mit Strom", 201, 2, "Default", false, false, false, 1);
    Item R202 = new Item("Ein ganz normaler Raum mit Strom", 202, 2, "Default", false, false, false, 1);
    Item R203 = new Item("Ein ganz normaler Nawiraum", 203, 2, "Nawi", true, false, false, 1);
    Item R204 = new Item("Ein ganz normaler Nawiraum", 204, 2, "Nawi", true, false, false, 1);
    Item R205 = new Item("Ein ganz normaler Nawiraum", 205, 2, "Nawi", true, false, false, 1);
        Item R206 = new Item("Die Hölle des Löwen", 206, 2, "Mathe", false, true, true);
        Item R207 = new Item("Das Labor", 207, 2, "Nawi", true, true, true);
    Item R208 = new Item("Ein Nawi Vorbereitungsraum", 208, 2, "Nawi", false, true, false, 1);
    Item R209 = new Item("Ein ganz normaler nawiraum", 209, 2, "Nawi", true, false, false, 1);
    Item R210 = new Item("Ein ganz normaler Nawiraum", 210, 2, "Nawi", false, false, false, 1);
    Item R211 = new Item("Ein ganz normaler Nawiraum", 211, 2, "Nawi", false, false, false, 1);
    Item R212 = new Item("Ein ganz normaler Nawiraum", 212, 2, "Nawi", false, false, false, 1);
    Item R213 = new Item("Ein ganz normaler Nawiraum", 213, 2, "Nawi", false, false, false, 1);
    Item R214 = new Item("Ein Nawi Vorbereitungsraum", 214, 2, "Nawi", false, false, false, 1);
    Item R215 = new Item("Die ganz komische Unsiex Toilette", 215, 2, "Default", false, false, false, 1);
    Item R301 = new Item("Ein ganz normaler Raum", 301, 3, "Default", false, false, false, 1);
    Item R302 = new Item("Ein Musikraum", 302, 3, "Kunstmusik", true, false, false, 1);
    Item R303 = new Item("Ein ganz normaler Nawiraum", 303, 3, "Nawi", true, false, false, 1);
    Item R304 = new Item("Ein sehr kleiner Nawiraum", 304, 3, "Nawi", true, false, false, 1);
    Item R305 = new Item("Ein ganz normaler Nawiraum", 305, 3, "Nawi", true, false, false, 1);
    Item R306 = new Item("Ein ganz normaler Nawiraum", 306, 3, "Nawi", true, false, false, 1);
    Item R307 = new Item("Keiner weis was dahinter ist", 307, 3, "Default", false, false, false, 1);
        Item R308 = new Item("Die Aula", 308, 3, "Kunstmusik", false, true, true);
    Item R309 = new Item("Herr Jaunichs KI-Server", 309, 3, "Informatik", true, false, false, 1);
    Item R310 = new Item("Ein Musikraum", 310, 3, "Kunstmusik", true, false, false, 1);
    Item R311 = new Item("Ein Kunstraum", 311, 3, "Kunstmusik", true, false, false, 1);
    Item R312 = new Item("Ein Kunstraum", 312, 3, "Kunstmusik", true, false, false, 1);
    Item R313 = new Item("Kunst/Musik Vorbereitungsraum", 313, 3, "Kunstmusik", false, false, false, 1);
    Item R314 = new Item("Die Jungstoilette", 314, 3, "Default", false, false, false, 1);
        Item R401 = new Item("Das Kunst Atelier", 401, 3, "Kunstmusik", false, true, true);
      
}