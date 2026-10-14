public class Room{
    private String description;
    private int number;
    private Floor floor;
    private Subject subject;
    private boolean locked;
    private boolean bossroom;
    private int hostile;

    public Room(String newDescription, int newNumber, Floor newFloor, Subject newSubject, boolean newLocked, boolean newBossroom, int newHostile){
        description = newDescription;
        number = newNumber;
        floor = newFloor;
        subject = newSubject;
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

    public boolean getLocked() {return locked;}

    public boolean getBossroom() {return bossroom;}

    public int getHostile() {return hostile;}

    public static Room R1 = new Room("A shared toilet", 1, Floor.nul, Subject.neutral, false, false, 0);
    public static Room R2 = new Room("The large computer science room", 2, Floor.nul, Subject.maths, false, false, 2);
    public static Room R3 = new Room("One of the small computer science rooms", 3, Floor.nul, Subject.maths, false, false, 1);
    public static Room R4 = new Room("One of the small computer science rooms", 4, Floor.nul, Subject.maths, false, false, 1);
    public static Room R5 = new Room("The server room", 5, Floor.nul, Subject.maths, true, true, 0);
    public static Room R6 = new Room("The one classroom for the kids", 6, Floor.nul, Subject.neutral, false, false, 1);
    public static Room R7 = new Room("Room of the Master", 7, Floor.nul, Subject.neutral, true, false, 3);
    public static Room R8 = new Room("The Upper Staff Coordination", 8, Floor.nul, Subject.neutral, true, false, 3);
    public static Room R9 = new Room("Tartaros", 9, Floor.nul, Subject.neutral, true, false, 5);
    public static Room R10 = new Room("The Furies", 10, Floor.nul, Subject.neutral, true, false, 0);
    public static Room R11 = new Room("Tanatos", 11, Floor.nul, Subject.neutral, true, false, 3);
    public static Room R12 = new Room("Lehrerspawner one", 12, Floor.nul, Subject.neutral, true, false, 10);
    public static Room R13 = new Room("Lehrerspawner two", 13, Floor.nul, Subject.neutral, true, false, 10);
    public static Room R14 = new Room("The one classroom for the kids", 14, Floor.nul, Subject.neutral, false, false, 1);
    public static Room R101 = new Room("A normal room", 101, Floor.one, Subject.social, false, false, 1);
    public static Room R102 = new Room("A normal room", 102, Floor.one, Subject.social, false, false, 1);
    public static Room R103 = new Room("A normal room", 103, Floor.one, Subject.languages, false, false, 1);
    public static Room R104 = new Room("A normal room", 104, Floor.one, Subject.languages, false, false, 1);
    public static Room R105 = new Room("A normal room", 105, Floor.one, Subject.languages, false, false, 1);
    public static Room R106 = new Room("A normal room", 106, Floor.one, Subject.languages, false, false, 1);
    public static Room R107 = new Room("Krosse Krabbe", 107, Floor.one, Subject.languages, true, true, 0);
    public static Room R108 = new Room("The preparation room for language subjects", 108, Floor.one, Subject.languages, true, false, 1);
    public static Room R109 = new Room("A normal room", 109, Floor.one, Subject.languages, false, false, 1);
    public static Room R110 = new Room("The House of the Scoundrel", 110, Floor.one, Subject.social, true, true, 0);
    public static Room R111 = new Room("A normal room", 111, Floor.one, Subject.social, false, false, 1);
    public static Room R112 = new Room("A normal room", 112, Floor.one, Subject.social, false, false, 1);
    public static Room R113 = new Room("A normal room", 113, Floor.one, Subject.social, false, false, 1);
    public static Room R114 = new Room("The preparation room for social subjects", 114, Floor.one, Subject.social, true, false, 1);
    public static Room R115 = new Room("The girls' toilet", 115, Floor.one, Subject.neutral, false, false, 1);
    public static Room R201 = new Room("A normal room with electricity", 201, Floor.two, Subject.neutral, false, false, 1);
    public static Room R202 = new Room("A normal room with electricity", 202, Floor.two, Subject.neutral, false, false, 1);
    public static Room R203 = new Room("A normal science room", 203, Floor.two, Subject.science, false, false, 1);
    public static Room R204 = new Room("A normal science room", 204, Floor.two, Subject.science, false, false, 1);
    public static Room R205 = new Room("A normal science room", 205, Floor.two, Subject.science, false, false, 1);
    public static Room R206 = new Room("The Cave of the Lion", 206, Floor.two, Subject.maths, true, true, 0);
    public static Room R207 = new Room("The Laboratory", 207, Floor.two, Subject.science, true, true, 0);
    public static Room R208 = new Room("A science preparation room", 208, Floor.two, Subject.science, true, false, 1);
    public static Room R209 = new Room("A normal science room", 209, Floor.two, Subject.science, false, false, 1);
    public static Room R210 = new Room("A normal science room", 210, Floor.two, Subject.science, false, false, 1);
    public static Room R212 = new Room("A normal science room", 212, Floor.two, Subject.science, false, false, 1);
    public static Room R213 = new Room("A normal science room", 213, Floor.two, Subject.science, false, false, 1);
    public static Room R214 = new Room("A science preparation room", 214, Floor.two, Subject.science, true, false, 1);
    public static Room R215 = new Room("The very strange unisex toilet", 215, Floor.two, Subject.neutral, false, false, 1);
    public static Room R301 = new Room("A normal room", 301, Floor.three, Subject.neutral, false, false, 1);
    public static Room R302 = new Room("A music room", 302, Floor.three, Subject.artmusic, false, false, 1);
    public static Room R303 = new Room("A normal science room", 303, Floor.three, Subject.science, false, false, 1);
    public static Room R304 = new Room("A very small science room", 304, Floor.three, Subject.science, false, false, 1);
    public static Room R305 = new Room("A normal science room", 305, Floor.three, Subject.science, false, false, 1);
    public static Room R307 = new Room("Nobody knows what's behind it", 307, Floor.three, Subject.neutral, true, false, 1);
    public static Room R308 = new Room("The Aula, the central propaganda dissemination place", 308, Floor.three, Subject.artmusic, true, false, 0);
    public static Room R309 = new Room("Mr. Jaunich's AI Server", 309, Floor.three, Subject.maths, false, false, 1);
    public static Room R310 = new Room("A Music Room", 310, Floor.three, Subject.artmusic, false, false, 1);
    public static Room R311 = new Room("A Art Room", 311, Floor.three, Subject.artmusic, false, false, 1);
    public static Room R312 = new Room("A Art Room", 312, Floor.three, Subject.artmusic, false, false, 1);
    public static Room R313 = new Room("Art/Music Preparation Room", 313, Floor.three, Subject.artmusic, false, false, 1);
    public static Room R314 = new Room("The Young People's Toilet", 314, Floor.three, Subject.neutral, false, false, 1);
    public static Room R401 = new Room("The Art Studio", 401, Floor.three, Subject.artmusic, true, true, 0);

}
