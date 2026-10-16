public class Key extends Item{
    private boolean found;

    public Key(String newName, Subject newSubject, String newDescription, int newRarity){
        super(newName, newSubject, newDescription, newRarity);
        found = false;
    }

    public boolean getFound(){return found;}
    public void setFound(boolean changedFound){found = changedFound;}

    //Key can be found anytime when entering a room except for the ones that are not foundable (rarity 6)
    public static Key key005 = new Key("Key for Room 005", Subject.maths, "This key can open Room 005", 6);
    public static Key key007 = new Key("Key for Room 007", Subject.neutral, "This key can open Room 007", 4);
    public static Key key008 = new Key("Key for Room 008", Subject.neutral, "This key can open Room 008", 4);
    public static Key key009 = new Key("Key for Room 009", Subject.neutral, "This key can open Room 009", 5);
    public static Key key010 = new Key("Key for Room 010", Subject.neutral, "This key can open Room 010", 3);
    public static Key key011 = new Key("Key for Room 011", Subject.neutral, "This key can open Room 011", 2);
    public static Key key012 = new Key("Key for Room 012", Subject.neutral, "This key can open Room 012", 2);
    public static Key key013 = new Key("Key for Room 013", Subject.neutral, "This key can open Room 013", 2);
    public static Key key107 = new Key("Key for Room 107", Subject.languages, "This key can open Room 107", 6);
    public static Key key108 = new Key("Key for Room 108", Subject.languages, "This key can open Room 108", 2);
    public static Key key110 = new Key("Key for Room 110", Subject.languages, "This key can open Room 110", 6);
    public static Key key114 = new Key("Key for Room 114", Subject.languages, "This key can open Room 114", 2);
    public static Key key206 = new Key("Key for Room 206", Subject.maths, "This key can open Room 206", 6);
    public static Key key208 = new Key("Key for Room 208", Subject.science, "This key can open Room 208", 2);
    public static Key key214 = new Key("Key for Room 214", Subject.science, "This key can open Room 214", 3);
    public static Key key307 = new Key("Key for Room 307", Subject.neutral, "This key can open Room 307", 5);
    public static Key key308 = new Key("Key for Room 308", Subject.artmusic, "This key can open Room 308", 3);
    public static Key key309 = new Key("Key for Room 309", Subject.maths, "This key can open Room 309", 3);
    public static Key key313 = new Key("Key for Room 313", Subject.artmusic, "This key can open Room 313", 2);
    public static Key key401 = new Key("Key for Room 401", Subject.artmusic, "This key can open Room 401", 4);
}
//Social:0