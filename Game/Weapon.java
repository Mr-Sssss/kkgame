public class Weapon{
    private String name;
    private Subject subject;
    private String description;
    private int level;
    private int damage;

    public Weapon(String newName, Subject newSubject, String newDescription, int newLevel, int newDamage){
        name = newName;
        subject = newSubject;
        description = newDescription;
        level = newLevel;
        damage = newDamage;
    }
    public void setName (String changedName){ name = changedName;}

    public void setSubject (Subject changedSubject){ subject = changedSubject; }

    public void setDescription (String changedDescription){ description = changedDescription; }

    public void setLevel(int changedLevel) { level = changedLevel; }

    public void setDamage (int changedDamage){ damage = changedDamage;}

    public String getName (){return name;}

    public Subject getSubject (){return subject; }

    public String getDescription (){return description; }

    public int getLevel() {return level; }

    public int getDamage (){return damage;}
}
