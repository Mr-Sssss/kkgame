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

public class Item{
    public String name;
    public String subject;
    public boolean isWeapon;
    public int damage;
    public int level;
    
    public Item(String nameNeu, String subjectNeu, boolean isWeaponNeu, int damageNeu, int levelNeu){
        name = nameNeu;
        subject = subjectNeu;
        isWeapon = isWeaponNeu;
        damage = damageNeu;
        level = levelNeu;
    }
    
     private void changename(String changedname) {
        name = changedname;
    }

    private void changeSubject(String changedSubject) {
        subject = changedSubject;
    }

    private void changeIsWeapon(boolean changedIsWeapon) {
        isWeapon = changedIsWeapon;
    }

    private void changeDamage(int changedDamage) {
        damage = changedDamage;
    }

    private void changeLevel(int changedLevel) {
        level = changedLevel;
    }
   
}

public class Room{
    public String description;
    public int number;
    public int floor;
    public boolean isFloor;
    public boolean isFachraum;
    public boolean locked;
    public boolean bossroom;

    public Room(String descriptionNeu, int numberNeu, int floorNeu, boolean isFloorNeu, boolean isFachraumNeu, boolean lockedNeu, boolean bossroomNeu){
        description = descriptionNeu;
        number = numberNeu;
        floor = floorNeu;
        isFloor = isFloorNeu;
        isFachraum = isFachraumNeu;
        locked = lockedNeu;
        bossroom = bossroomNeu;
        
        }
        
    public void changeDescription(String changedDescription) {
        description = changedDescription;
    }
    
    public void changeNumber(int changedNumber) {
        number = changedNumber;
    }
    
    public void changeFloor(int changedFloor) {
        floor = changedFloor;
    }
    
    public void changeIsFloor(boolean changedIsFloor) {
        isFloor = changedIsFloor;
    }
    
    public void changeIsFachraum(boolean changedIsFachraum) {
        isFachraum = changedIsFachraum;
    }
    
    public void changeLocked(boolean changedLocked) {
        locked = changedLocked;
    }
    
    public void changeBossroom(boolean changedBossroom) {
        bossroom = changedBossroom;
    }
      

        
}

public class Student{
    public String name;
    public String year;
    public String subject;
    public String description;

    public Student(String nameNeu, String yearNeu, String subjectNeu, String descriptionNeu){
        name = nameNeu;
        year = yearNeu;
        subject = subjectNeu;
        description = descriptionNeu; 
    }
   
   private void changename (String changedname){
     name = changedname;
   }
   
   private void changeyear (String changedyear){
     year = changedyear;
   }
   
   private void changesubject (String changedsubject){
     name = changedsubject;
   }
   
   private void changedescription (String changeddescription){
     name = changeddescription;
   }
}

public class Teacher{
    public String name;
    public String subject;
    public String description;
    public int health;
    public int strictness;
    public String attack;
    public int level;

    public Teacher(String nameNeu, String subjectNeu, String descriptionNeu, int healthNeu, int strictnessNeu, String attackNeu, int levelNeu){
        name = nameNeu;
        subject = subjectNeu;
        description = descriptionNeu;
        health = healthNeu;
        strictness = strictnessNeu;
        attack = attackNeu;
        level = levelNeu;
        
    }
    
    private void changename (String changedname){
      name = changedname;
      }
      
    public void changeSubject(String changedSubject) {
        subject = changedSubject;
    }
    
    public void changeDescription(String changedDescription) {
        description = changedDescription;
    }
    
    public void changeAttack(String changedAttack) {
        attack = changedAttack;
    }
    
    public void changeHealth(int changedHealth) {
        health = changedHealth;
    }
    
    public void changeStrictness(int changedStrictness) {
        strictness = changedStrictness;
    }
    
    public void changeLevel(int changedLevel) {
        level = changedLevel;
    }
    
}

public class Attack{
    public String name;
    public String subject;
    public String teacher;
    public int damage;
    
    public Attack(String nameNeu, String subjectNeu, String teacherNeu, int damageNeu){
        name = nameNeu;
        subject = subjectNeu;
        teacher = teacherNeu;
        damage = damageNeu;
    }
    private void changename(String changedname) {
        name = changedname;
    }

    private void changeSubject(String changedSubject) {
        subject = changedSubject;
    }

    private void changeteacher(boolean changedteacher) {
        isWeapon = changedteacher;
    }

    private void changeDamage(int changedDamage) {
        damage = changedDamage;
    }
}

public static void main(String[] args){

}