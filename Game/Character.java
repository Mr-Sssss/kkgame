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
        if (currentRoom != 0){
            if (floor == currentFloor){
                System.out.print("Broski du bist schon hier.");
            } else {
                changeCurrentFloor(floor);
                changeCurrentRoom(0);
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
        } else {
            System.out.print("Du bist in einem Raum. Nutze die Funktion exit() um im Flur zu gelangen, um den Flur wechseln zu können.");
        }
    }

    public void enter(int room){
        if (room == currentRoom){
            System.out.print("Broski du bist schon hier.");
        } else {
            if (currentFloor == 0){
                if (room >= 001 || room <= 015){
                    changeCurrentRoom(room);
                } else {
                    System.out.print("Du bist im Erdgeschoss. Du kannst du nur in Raum 001-015 gehen. Um im Raum " + String.valueOf(room) + " gehen zu können, wechsle den Flur mit moveTo(floor)");
                }

            } else if (currentFloor == 1){
                if (room >= 101 || room <= 115){
                    changeCurrentRoom(room);
                    if (room == 115){
                        if (sex == "Female"){
                            changeCurrentRoom(room);
                        } else if (sex == "Male"){
                            System.out.print("Du bist kein Mädchen du kleiner Perversling.");
                            changeCurrentRoom(0);
                        }
                    }
                } else {
                    System.out.print("Du bist im 1. Obergeschoss. Du kannst du nur in Raum 101-115 gehen. Um im Raum " + String.valueOf(room) + " gehen zu können, wechsle den Flur mit moveTo(floor)");
                }
                
            } else if (currentFloor == 2){
                if (room >= 201 || room <= 215){
                    changeCurrentRoom(room);
                    if (room == 215){
                        System.out.print("Bist du Gay oder so. Aber okay");
                    }
                } else {
                    System.out.print("Du bist im 2. Obergeschoss. Du kannst du nur in Raum 201-215 gehen. Um im Raum " + String.valueOf(room) + " gehen zu können, wechsle den Flur mit moveTo(floor)");
                    
                    
                }
                
            } else if (currentFloor == 3){
                if (room >= 301 || room <= 314 || room == 401){
                    changeCurrentRoom(room);
                    if (room == 314){
                        if (sex == "Male"){
                            changeCurrentRoom(room);
                        } else if (sex == "Female"){
                            System.out.print("Schwänze kannst du dir auch auf P**nhub oder so angucken");
                            System.out.print("Also bitte verpiss dich hier.");
                            changeCurrentRoom(0);
                        }
                    }
                } else {
                    System.out.print("Du bist im 3. Obergeschoss. Du kannst du nur in Raum 301-315 und 401 gehen. Um im Raum " + String.valueOf(room) + " gehen zu können, wechsle den Flur mit moveTo(floor)");
                }       
            } else {
                System.out.print("Du bist jetzt im Raum" + room);
            }
        }
    }
    public void exit(){
        if (currentRoom != 0){
            changeCurrentRoom(0);
            if (currentRoom >= 001 || currentRoom <= 015){
                changeCurrentFloor(0);
            } else if (currentRoom >= 101 || currentRoom <= 115){
                changeCurrentFloor(1);
            } else if (currentRoom >= 201 || currentRoom <= 215){
                changeCurrentFloor(2);
            } else if (currentRoom >= 301 || currentRoom <= 315 || currentRoom == 401){
                changeCurrentFloor(3);
            }
        }
    }
}