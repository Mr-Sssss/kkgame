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