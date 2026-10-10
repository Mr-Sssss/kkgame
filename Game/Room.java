public class Room{
    private String description;
    private int number;
    private Floor floor;
    private Subject subject;
    private boolean isFachraum;
    private boolean locked;
    private boolean bossroom;
    private int hostile;

    public Room(String newDescription, int newNumber, Floor newFloor, Subject newSubject, boolean newIsFachraum, boolean newLocked, boolean newBossroom, int newHostile){
        description = newDescription;
        number = newNumber;
        floor = newFloor;
        subject = newSubject;
        isFachraum = newIsFachraum;
        locked = newLocked;
        bossroom = newBossroom;
        hostile = newHostile;
    }


    public void setDescription(String changedDescription) {
        description = changedDescription;
    }

    public void setNumber(int changedNumber) {
        number = changedNumber;
    }

    public void setFloor(Floor changedFloor) {
        floor = changedFloor;
    }

    public void setSubject(Subject changedSubject) {
        subject = changedSubject;
    }

    public void setIsFachraum(boolean changedIsFachraum) {
        isFachraum = changedIsFachraum;
    }

    public void setLocked(boolean changedLocked) {
        locked = changedLocked;
    }

    public void setBossroom(boolean changedBossroom) {
        bossroom = changedBossroom;
    }

    public void setHostile(int changedHostile) {
        hostile = changedHostile;
    }

    public String getDescription() {return description;}

    public int getNumber() {return number;}

    public Floor getFloor() {return floor;}

    public Subject getSubject() {return subject;}

    public boolean getIsFachraum() {return isFachraum;}

    public boolean getLocked() {return locked;}

    public boolean getBossroom() {return bossroom;}

    public int getHostile() {return hostile;}

    Room R001 = new Room("Eine geteilte Toilette", 1, Floor.erdgeschoss, Subject.neutral, false, false, false, 0);
    Room R002 = new Room("Der große Informatikraum", 2, Floor.erdgeschoss, Subject.maths, true, false, false, 2);
    Room R003 = new Room("Einer der kleinen Informatikräume", 3, Floor.erdgeschoss, Subject.maths, true, false, false, 1);
    Room R004 = new Room("Einer der kleinen Informatikräume", 4, Floor.erdgeschoss, Subject.maths, true, false, false, 1);
    Room R005 = new Room("Der Serverraum", 5, Floor.erdgeschoss, Subject.maths, true, true, true, 0);
    Room R006 = new Room("Der eine Klassenraum der Kiddos", 6, Floor.erdgeschoss, Subject.neutral, false, false, false, 1);
    Room R007 = new Room("Raum des Meisters", 7, Floor.erdgeschoss, Subject.neutral, false, true, false, 3);
    Room R008 = new Room("Die Oberstuffenkoordination", 8, Floor.erdgeschoss, Subject.neutral, false, true, false, 3);
    Room R009 = new Room("Tartaros", 9, Floor.erdgeschoss, Subject.neutral, false, true, false, 5);
    Room R010 = new Room("Die Furien", 10, Floor.erdgeschoss, Subject.neutral, false, true, false, 0);
    Room R011 = new Room("Tanatos", 11, Floor.erdgeschoss, Subject.neutral, false, true, false, 3);
    Room R012 = new Room("Lehrerspawner eins", 12, Floor.erdgeschoss, Subject.neutral, false, true, false, 10);
    Room R013 = new Room("Lehrerspawner zwei", 13, Floor.erdgeschoss, Subject.neutral, false, true, false, 10);
    Room R014 = new Room("Der eine Klassenraum der Kiddos", 14, Floor.erdgeschoss, Subject.neutral, false, false, false, 1);
    Room R101 = new Room("Ein ganz normaler Raum", 101, Floor.eins, Subject.social, false, false, false, 1);
    Room R102 = new Room("Ein ganz normaler Raum", 102, Floor.eins, Subject.social, false, false, false, 1);
    Room R103 = new Room("Ein ganz normaler Raum", 103, Floor.eins, Subject.languages, false, false, false, 1);
    Room R104 = new Room("Ein ganz normaler Raum", 104, Floor.eins, Subject.languages, false, false, false, 1);
    Room R105 = new Room("Ein ganz normaler Raum", 105, Floor.eins, Subject.languages, false, false, false, 1);
    Room R106 = new Room("Ein ganz normaler Raum", 106, Floor.eins, Subject.languages, false, false, false, 1);
    Room R107 = new Room("Krosse Krabbe", 107, Floor.eins, Subject.languages, false, true, true, 0);
    Room R108 = new Room("Der Vorbereitungsraum für Sprachfächer", 108, Floor.eins, Subject.languages, false, true, false, 1);
    Room R109 = new Room("Ein ganz normaler Raum", 109, Floor.eins, Subject.languages, false, false, false, 1);
    Room R110 = new Room("Haus des Halunken", 110, Floor.eins, Subject.social, false, true, true, 0);
    Room R111 = new Room("Ein ganz normaler Raum", 111, Floor.eins, Subject.social, false, false, false, 1);
    Room R112 = new Room("Ein ganz normaler Raum", 112, Floor.eins, Subject.social, false, false, false, 1);
    Room R113 = new Room("Ein ganz normaler Raum", 113, Floor.eins, Subject.social, false, false, false, 1);
    Room R114 = new Room("Der Vorbereitungsraum für Gewifächer", 114, Floor.eins, Subject.social, false, true, false, 1);
    Room R115 = new Room("Die Mädchentoilette", 115, Floor.eins, Subject.neutral, false, false, false, 1);
    Room R201 = new Room("Ein ganz normaler Raum mit Strom", 201, Floor.zwei, Subject.neutral, false, false, false, 1);
    Room R202 = new Room("Ein ganz normaler Raum mit Strom", 202, Floor.zwei, Subject.neutral, false, false, false, 1);
    Room R203 = new Room("Ein ganz normaler Nawiraum", 203, Floor.zwei, Subject.science, true, false, false, 1);
    Room R204 = new Room("Ein ganz normaler Nawiraum", 204, Floor.zwei, Subject.science, true, false, false, 1);
    Room R205 = new Room("Ein ganz normaler Nawiraum", 205, Floor.zwei, Subject.science, true, false, false, 1);
    Room R206 = new Room("Die Hölle des Löwen", 206, Floor.zwei, Subject.maths, false, true, true, 0);
    Room R207 = new Room("Das Laboratorium", 207, Floor.zwei, Subject.science, true, true, true, 0);
    Room R208 = new Room("Ein Nawi Vorbereitungsraum", 208, Floor.zwei, Subject.science, false, true, false, 1);
    Room R209 = new Room("Ein ganz normaler nawiraum", 209, Floor.zwei, Subject.science, true, false, false, 1);
    Room R210 = new Room("Ein ganz normaler Nawiraum", 210, Floor.zwei, Subject.science, false, false, false, 1);
    Room R211 = new Room("Ein ganz normaler Nawiraum", 211, Floor.zwei, Subject.science, false, false, false, 1);
    Room R212 = new Room("Ein ganz normaler Nawiraum", 212, Floor.zwei, Subject.science, false, false, false, 1);
    Room R213 = new Room("Ein ganz normaler Nawiraum", 213, Floor.zwei, Subject.science, false, false, false, 1);
    Room R214 = new Room("Ein Nawi Vorbereitungsraum", 214, Floor.zwei, Subject.science, false, false, false, 1);
    Room R215 = new Room("Die ganz komische Unisex Toilette", 215, Floor.zwei, Subject.neutral, false, false, false, 1);
    Room R301 = new Room("Ein ganz normaler Raum", 301, Floor.drei, Subject.neutral, false, false, false, 1);
    Room R302 = new Room("Ein Musikraum", 302, Floor.drei, Subject.artmusic, true, false, false, 1);
    Room R303 = new Room("Ein ganz normaler Nawiraum", 303, Floor.drei, Subject.science, true, false, false, 1);
    Room R304 = new Room("Ein sehr kleiner Nawiraum", 304, Floor.drei, Subject.science, true, false, false, 1);
    Room R305 = new Room("Ein ganz normaler Nawiraum", 305, Floor.drei, Subject.science, true, false, false, 1);
    Room R306 = new Room("Ein ganz normaler Nawiraum", 306, Floor.drei, Subject.science, true, false, false, 1);
    Room R307 = new Room("Keiner weis was dahinter ist", 307, Floor.drei, Subject.neutral, false, false, false, 1);
    Room R308 = new Room("Die Aula, der zentrale Propagandaverbreitungsplatz", 308, Floor.drei, Subject.artmusic, false, true, true, 0);
    Room R309 = new Room("Herr Jaunichs KI-Server", 309, Floor.drei, Subject.maths, true, false, false, 1);
    Room R310 = new Room("Ein Musikraum", 310, Floor.drei, Subject.artmusic, true, false, false, 1);
    Room R311 = new Room("Ein Kunstraum", 311, Floor.drei, Subject.artmusic, true, false, false, 1);
    Room R312 = new Room("Ein Kunstraum", 312, Floor.drei, Subject.artmusic, true, false, false, 1);
    Room R313 = new Room("Kunst/Musik Vorbereitungsraum", 313, Floor.drei, Subject.artmusic, false, false, false, 1);
    Room R314 = new Room("Die Jungstoilette", 314, Floor.drei, Subject.neutral, false, false, false, 1);
    Room R401 = new Room("Das Kunst Atelier", 401, Floor.drei, Subject.artmusic, false, true, true, 0);

}
