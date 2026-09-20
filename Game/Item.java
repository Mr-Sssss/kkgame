public static class Item{
    public String name;
    public String subject;
    public String description;
    public int place;
    public static boolean inSight;

    public Item(String newName, String newSubject, String newDescription, int newPlace, boolean newInSight){
        name = newName;
        subject = newSubject;
        description = newDescription;
        level = newPlace;
        inSight = newInSight;
    }

    private void changeName(String changedName) { name = changedName; }

    private void changeSubject(String changedSubject) { subject = changedSubject; }

    private void changeDescription(String changedDescription){ description = changedDescription; }

    private void changePlace(int changedPlace) { level = changedPlace; }

    private void changeInSight(boolean changedInSight) { inSight = changedInSight; }

    public void use(String name){
     
    }

    Item key005 = new Item("Schlüssel für Raum 005", "Informatik", "Dieser Schlüssel kann den Raum 005 öffnen", 1, false);
    Item key007 = new Item("Schlüssel für Raum 007", "Default", "Dieser Schlüssel kann den Raum 007 öffnen", 1, false);
    Item key008 = new Item("Schlüssel für Raum 008", "Default", "Dieser Schlüssel kann den Raum 008 öffnen", 1, false);
    Item key009 = new Item("Schlüssel für Raum 009", "Default", "Dieser Schlüssel kann den Raum 009 öffnen", 1, false);
    Item key010 = new Item("Schlüssel für Raum 010", "Sprache", "Dieser Schlüssel kann den Raum 010 öffnen", 1, false);
    Item key011 = new Item("Schlüssel für Raum 011", "Sprache", "Dieser Schlüssel kann den Raum 011 öffnen", 1, false);
    Item key012_013 = new Item("Schlüssel für Raum 012/13", "Default", "Dieser Schlüssel kann den Raum 012 bzw. 013 öffnen", 1, false);
    Item key108 = new Item("Schlüssel für Raum 108", "Sprache", "Dieser Schlüssel kann den Raum 108 öffnen", 1, false);
    Item key114 = new Item("Schlüssel für Raum 114", "Sprache", "Dieser Schlüssel kann den Raum 114 öffnen", 1, false);
    Item key206 = new Item("Schlüssel für Raum 206", "Mathe", "Dieser Schlüssel kann den Raum 206 öffnen", 1, false);
    Item key208 = new Item("Schlüssel für Raum 208", "Nawi", "Dieser Schlüssel kann den Raum 208 öffnen", 1, false);
    Item key214 = new Item("Schlüssel für Raum 214", "Nawi", "Dieser Schlüssel kann den Raum 214 öffnen", 1, false);
    Item key307 = new Item("Schlüssel für Raum 307", "Default", "Dieser Schlüssel kann den Raum 307 öffnen", 1, false);
    Item key309 = new Item("Schlüssel für Raum 309", "Informatik", "Dieser Schlüssel kann den Raum 309 öffnen", 1, false);
    Item key313 = new Item("Schlüssel für Raum 313", "Kunstmusik", "Dieser Schlüssel kann den Raum 313 öffnen", 1, false);
    Item key401 = new Item("Schlüssel für Raum 401", "Kunstmusik", "Dieser Schlüssel kann den Raum 401 öffnen", 1, false);
}