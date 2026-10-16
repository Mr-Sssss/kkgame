//The Abstract Item class
abstract public class Item{
    private String name;
    private Subject subject;
    private String description;
    private int rarity; // 1 = common, 2 = uncommon, 3 = rare, 4 = epic, 5 = legendary 6=Not foundable (It is realy not foundable)

    public Item(String newName, Subject newSubject, String newDescription, int newRarity){
        name = newName;
        subject = newSubject;
        description = newDescription;
        rarity = newRarity;
    }

    public void setName(String changedName) { name = changedName; }

    public void setSubject(Subject changedSubject) { subject = changedSubject; }

    public void setDescription(String changedDescription){ description = changedDescription; }

    public void setRarity(int changedRarity) { rarity = changedRarity; }

    public String getName() {return name; }

    public Subject getSubject() {return subject; }

    public String getDescription(){return description; }

    public int getRarity() {return rarity; }
}
