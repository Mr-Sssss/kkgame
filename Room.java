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
    
   
   