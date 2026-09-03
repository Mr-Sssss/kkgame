public class Character{
    public String name;
    public String sex;
    public String description;
    public String subject;
    public int health;
    public int inventorySpace;
    public String[] items;
    public int level;
    public String inFightWith;

    public Character(String newName, String newSex, String newDescription, String newSubject, int newHealth, int newInventorySpace, int newLevel, String newInFightWith){
        name = newName;
        sex = newSex;
        description = newDescription;
        subject = newSubject;
        health = newHealth;
        inventorySpace = newInventorySpace;
        level = newLevel;
        inFightWith = newInFightWith; 
    }
    
    private changeName(String changedName){
        name = changedName;
    }

    private changeSex(String changedSex){
        sex = changedSex;
    }

    private changeDescription(String changedDescription){
        description = changedDescription;
    }

    private changeSubject(String changedSubject){
        subject = changedSubjec;t
    }

    private changeHealth(int changedHealth){
        health = changedHealth;
    }

    private changenventorySpace(int changedInventorySpace){
        inventorySpace = changedInventorySpace;
    }

    private changeLevel(int changedLevel){
        level = changedLevel;
    }

    private changeInFightWith(String changedInFightWith){
        inFightWith = changedInFightWith;
    }

    public use(item){

    }

    public pickUp(item){
        if item.inSight {
            items
        }
    }

    public attack(String item){

    }

    public moveTo(int floor){

    }

    public enter(String room){

    }

    public exit(){

    }
}
