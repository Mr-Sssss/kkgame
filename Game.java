 public static class Character{
    public String name;
    public String sex;
    public String description;
    public String subject;
    public int health;
    public int inventorySpace;
    public String[] items;
    public int level;
    public String inFightWith;
    public int currentFloor;
    public int currentRoom;

    public Character(String newName, String newSex, String newDescription, String newSubject, int newHealth, int newInventorySpace, int newLevel, String newInFightWith, int newCurrentRoom, int newCurrentFloor){
        name = newName;
        sex = newSex;
        description = newDescription;
        subject = newSubject;
        health = newHealth;
        inventorySpace = newInventorySpace;
        level = newLevel;
        inFightWith = newInFightWith;
        currentRoom = newCurrentRoom;
        currentFloor = newCurrentFloor;
    }

    private void changeName(String changedName){ name = changedName; }

    private void changeSex(String changedSex){ sex = changedSex; }

    private void changeDescription(String changedDescription){ description = changedDescription; }

    private void changeSubject(String changedSubject){ subject = changedSubject; }

    private void changeHealth(int changedHealth){ health = changedHealth; }

    private void changeInventorySpace(int changedInventorySpace){ inventorySpace = changedInventorySpace; }

    private void changeLevel(int changedLevel){ level = changedLevel; }

    private void changeInFightWith(String changedInFightWith){ inFightWith = changedInFightWith; }

    private void changeCurrentFloor(int changedCurrentFloor){ currentRoom = changedCurrentFloor; }

    private void changeCurrentRoom(int changedCurrentRoom){ currentRoom = changedCurrentRoom; }

    public void use(){

    }

    public void pickUp(){

    }

    public void attack(String item){

    }

    public void moveTo(int floor){
        if (floor == currentFloor){
            System.out.print("Broski du bist schon hier.");
        } else {
            changeCurrentFloor("floor");
            changeCurrenRoom("");
            if (floor == 0){
                System.out.print("Du bist jetzt im Erdgeschoss");
            } else if (floor == 1){
                System.out.print("Du bist jetzt im 1. Obergeschoss");
            } else if (floor == 2){
                System.out.print("Du bist jetzt im 2. Obergeschoss");
            } else if (floor == 3){
                System.out.print("Du bist jetzt im 3. Obergeschoss");
            } else if (floor == 4){
                System.out.print("Du kannst übers 3. Obergeschoss direkt in 401 reingehen.");
            } else {
                System.out.print("Was soll das den sein.");
            }
        }
    }

    public void enter(String room){
        if (room == currentRoom){
            System.out.print("Broski du bist schon hier.");
        } else {
            changeCurrenRoom(room);
            if (floor == 0){

            } else if (floor == 1){
                if (Room == "115"){
                    if (sex == "Female"){
                        changeCurrentRoom(room);
                    } else if (sex == "Male"){
                        System.out.print("Du bist kein Mädchen du kleiner Perversling.");
                    }
                }
                
            } else if (floor == 2){
                if (Room == "215"){
                    System.out.print("Bist du gay oder so. Aber okay");
                }
                
            } else if (floor == 3){
                if (Room == "314"){
                    if (sex == "Male"){
                        changeCurrentRoom(room);
                    } else if (sex == "Female"){
                        System.out.print("Schwänze kannst du dir auch auf P**nhub oder so angucken");
                        System.out.print("Also bitte verpiss dich hier.");
                    }        
                }
            }
        }
    }
    public void exit(){

    }

  public class Floor{
      public int Number;
      public String Description;

      public Floor(String newDescription, int newNumber){
          description = newDescription;
          number = newNumber;

      public void changeDescription(String changedDescription) {
          description = changedDescription;
      }
      
      public void changeNumber(int changedNumber) {
          number = changedNumber;
      }
  }

    public class Room{
      public String description;
      public int number;
      public int floor;
      public boolean isFachraum;
      public boolean locked;
      public boolean bossroom;

      public Room(String newDescription, int newNumber, int newFloor, boolean newIsFachraum, boolean newLocked, boolean newBossroom){
          description = newDescription;
          number = newNumber;
          floor = newFloor;
          isFachraum = newIsFachraum;
          locked = newLocked;
          bossroom = newBossroom;
      ]
      
      
      public void changeDescription(String changedDescription) {
          description = changedDescription;
      }
      
      public void changeNumber(int changedNumber) {
          number = changedNumber;
      }
      
      public void changeFloor(int changedFloor) {
          floor = changedFloor;
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
      
      public void inFloor() {
      }
      
      public void interactStudent(String student) {
      }
      
      public void interactTeacher(String teacher) {
      }
      
}

public static class Item{
    public String name;
    public String subject;
    public int level;
    public static boolean inSight;

    public Item(String newName, String newSubject, boolean newIsWeapon, int NewDamage, int NewLevel, boolean newInSight){
        name = newName;
        subject = newSubject;
        isWeapon = newIsWeapon;
        damage = NewDamage;
        level = NewLevel;
        inSight = newInSight;
    }

    private void changeName(String changedName) { name = changedName; }

    private void changeSubject(String changedSubject) { subject = changedSubject; }

    private void changeIsWeapon(boolean changedIsWeapon) { isWeapon = changedIsWeapon; }

    private void changeDamage(int changedDamage) { damage = changedDamage; }

    private void changeLevel(int changedLevel) { level = changedLevel; }

    public void use(String name){
     
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

    public Teacher(String newName, String newSubject, String newDescription, int newHealth, int newStrictness, String newAttack, int newLevel){
        name = newName;
        subject = newSubject;
        description = newDescription;
        health = newHealth;
        strictness = newStrictness;
        attack = newAttack;
        level = newLevel;
        
    }
    
    private void changeName (String changedName){
      name = changedName;
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
    

public static class Student{
    public String name;
    public String year;
    public String subject;
    public String description;

    public Student(String newName, String newYear, String newSubject, String newDescription){
        name = newName;
        year = newYear;
        subject = newSubject;
        description = newDescription;
    }

    private void changeName (String changedName){ name = changedName;}

    private void changeYear (String changedYear){ year = changedYear;}

    private void changeSubject (String changedSubject){ name = changedSubject; }

    private void changeDescription (String changedDescription){ name = changedDescription; }
}

public static class Weapon{
    public String name;
    public String subject;
    public String description;
    public int damage;

    public Attack(String newName, String newSubject, String newDescription, int newDamage){
        name = newName;
        subject = newSubject;
        teacher = newDescription;
        damage = newDamage;
    }
    private void changeName (String changedName){ name = changedName;}

    private void changeDamage (String changedDamage){ year = changedDamage;}

    private void changeSubject (String changedSubject){ name = changedSubject; }

    private void changeDescription (String changedDescription){ name = changedDescription; }

}}
/*public static void main(String[] args) {
    
}*/
