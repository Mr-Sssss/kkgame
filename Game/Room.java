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

    Room R001 = new Room("Eine geteilte Toilette", 1, 0, "Default", false, false, false, 0);
    Room R002 = new Room("Der große Informatikraum", 2, 0, "Informatik", true, false, false, 2);
    Room R003 = new Room("Einer der kleinen Informatikräume", 3, 0, "Informatik", true, false, false, 1);
    Room R004 = new Room("Einer der kleinen Informatikräume", 4, 0, "Informatik", true, false, false, 1);
        Room R005 = new Room("Der Serverraum", 5, 0, "Informatik", true, true, true, 0);
    Room R006 = new Room("Der eine Klassenraum der Kiddos", 6, 0, "Default", false, false, false, 1);
    Room R007 = new Room("Raum des Meisters", 7, 0, "Default", false, true, false, 3);
    Room R008 = new Room("Die Oberstuffenkoordination", 8, 0, "Default", false, true, false, 3);
    Room R009 = new Room("Tartaros", 9, 0, "Default", false, true, false, 5);
    Room R010 = new Room("Die Furien", 10, 0, "Default", false, true, false, 0);
    Room R011 = new Room("Tanatos", 11, 0, "Default", false, true, false, 3);
    Room R012 = new Room("Lehrerspawner eins", 12, 0, "Default", false, true, false, 10);
    Room R013 = new Room("Lehrerspawner zwei", 13, 0, "Default", false, true, false, 10);
    Room R014 = new Room("Der eine Klassenraum der Kiddos", 14, 0, "Default", false, false, false, 1);
    Room R101 = new Room("Ein ganz normaler Raum", 101, 1, "Gewi", false, false, false, 1);
    Room R102 = new Room("Ein ganz normaler Raum", 102, 1, "Gewi", false, false, false, 1);
    Room R103 = new Room("Ein ganz normaler Raum", 103, 1, "Sprache", false, false, false, 1);
    Room R104 = new Room("Ein ganz normaler Raum", 104, 1, "Sprache", false, false, false, 1);
    Room R105 = new Room("Ein ganz normaler Raum", 105, 1, "Sprache", false, false, false, 1);
    Room R106 = new Room("Ein ganz normaler Raum", 106, 1, "Sprache", false, false, false, 1);
        Room R107 = new Room("Krosse Krabbe", 107, 1, "Sprache", false, true, true);
    Room R108 = new Room("Der Vorbereitungsraum für Sprachfächer", 108, 1, "Sprache", false, true, false, 1);
    Room R109 = new Room("Ein ganz normaler Raum", 109, 1, "Sprache", false, false, false, 1);
        Room R110 = new Room("Haus des Halunken", 110, 1, "Gewi", false, true, true);
    Room R111 = new Room("Ein ganz normaler Raum", 111, 1, "Gewi", false, false, false, 1);
    Room R112 = new Room("Ein ganz normaler Raum", 112, 1, "Gewi", false, false, false, 1);
    Room R113 = new Room("Ein ganz normaler Raum", 113, 1, "Gewi", false, false, false, 1);
    Room R114 = new Room("Der Vorbereitungsraum für Gewifächer", 114, 1, "Gewi", false, true, false, 1);
    Room R115 = new Room("Die Mädchentoilette", 115, 1, "Default", false, false, false, 1);
    Room R201 = new Room("Ein ganz normaler Raum mit Strom", 201, 2, "Default", false, false, false, 1);
    Room R202 = new Room("Ein ganz normaler Raum mit Strom", 202, 2, "Default", false, false, false, 1);
    Room R203 = new Room("Ein ganz normaler Nawiraum", 203, 2, "Nawi", true, false, false, 1);
    Room R204 = new Room("Ein ganz normaler Nawiraum", 204, 2, "Nawi", true, false, false, 1);
    Room R205 = new Room("Ein ganz normaler Nawiraum", 205, 2, "Nawi", true, false, false, 1);
        Room R206 = new Room("Die Hölle des Löwen", 206, 2, "Mathe", false, true, true);
        Room R207 = new Room("Das Laboratorium", 207, 2, "Nawi", true, true, true);
    Room R208 = new Room("Ein Nawi Vorbereitungsraum", 208, 2, "Nawi", false, true, false, 1);
    Room R209 = new Room("Ein ganz normaler nawiraum", 209, 2, "Nawi", true, false, false, 1);
    Room R210 = new Room("Ein ganz normaler Nawiraum", 210, 2, "Nawi", false, false, false, 1);
    Room R211 = new Room("Ein ganz normaler Nawiraum", 211, 2, "Nawi", false, false, false, 1);
    Room R212 = new Room("Ein ganz normaler Nawiraum", 212, 2, "Nawi", false, false, false, 1);
    Room R213 = new Room("Ein ganz normaler Nawiraum", 213, 2, "Nawi", false, false, false, 1);
    Room R214 = new Room("Ein Nawi Vorbereitungsraum", 214, 2, "Nawi", false, false, false, 1);
    Room R215 = new Room("Die ganz komische Unisex Toilette", 215, 2, "Default", false, false, false, 1);
    Room R301 = new Room("Ein ganz normaler Raum", 301, 3, "Default", false, false, false, 1);
    Room R302 = new Room("Ein Musikraum", 302, 3, "Kunstmusik", true, false, false, 1);
    Room R303 = new Room("Ein ganz normaler Nawiraum", 303, 3, "Nawi", true, false, false, 1);
    Room R304 = new Room("Ein sehr kleiner Nawiraum", 304, 3, "Nawi", true, false, false, 1);
    Room R305 = new Room("Ein ganz normaler Nawiraum", 305, 3, "Nawi", true, false, false, 1);
    Room R306 = new Room("Ein ganz normaler Nawiraum", 306, 3, "Nawi", true, false, false, 1);
    Room R307 = new Room("Keiner weis was dahinter ist", 307, 3, "Default", false, false, false, 1);
        Room R308 = new Room("Die Aula, der zentrale Propagandaverbreitungsplatz", 308, 3, "Kunstmusik", false, true, true);
    Room R309 = new Room("Herr Jaunichs KI-Server", 309, 3, "Informatik", true, false, false, 1);
    Room R310 = new Room("Ein Musikraum", 310, 3, "Kunstmusik", true, false, false, 1);
    Room R311 = new Room("Ein Kunstraum", 311, 3, "Kunstmusik", true, false, false, 1);
    Room R312 = new Room("Ein Kunstraum", 312, 3, "Kunstmusik", true, false, false, 1);
    Room R313 = new Room("Kunst/Musik Vorbereitungsraum", 313, 3, "Kunstmusik", false, false, false, 1);
    Room R314 = new Room("Die Jungstoilette", 314, 3, "Default", false, false, false, 1);
    Room R401 = new Room("Das Kunst Atelier", 401, 3, "Kunstmusik", false, true, true);
      
}