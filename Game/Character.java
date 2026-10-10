public class Character{
    private String name;
    private String sex;
    private String description;
    private Subject subject;
    private int health;
    private int level;
    private String inFightWith;
    private int currentFloor;
    private int currentRoom;

    public Character(String newName, String newSex, String newDescription, Subject newSubject, int newHealth, int newLevel, String newInFightWith, int newCurrentRoom, int newCurrentFloor){
        name = newName;
        sex = newSex;
        description = newDescription;
        subject = newSubject;
        health = newHealth;
        level = newLevel;
        inFightWith = newInFightWith;
        currentRoom = newCurrentRoom;
        currentFloor = newCurrentFloor;
    }

    public void setName(String changedName){ name = changedName; }

    public void setSex(String changedSex){ sex = changedSex; }

    public void setDescription(String changedDescription){ description = changedDescription; }

    public void setSubject(Subject changedSubject){ subject = changedSubject; }

    public void setHealth(int changedHealth){ health = changedHealth; }

    public void setLevel(int changedLevel){ level = changedLevel; }

    public void setInFightWith(String changedInFightWith){ inFightWith = changedInFightWith; }

    public void setCurrentFloor(int changedCurrentFloor){ currentRoom = changedCurrentFloor; }

    public void setCurrentRoom(int changedCurrentRoom){ currentRoom = changedCurrentRoom; }

    public String getName(){return name;}

    public String getSex(){return sex; }

    public String getDescription(){return description; }

    public Subject getSubject(){return subject; }

    public int getHealth(){return health; }

    public int getLevel(){return level; }

    public String getInFightWith(){return inFightWith; }

    public int getCurrentFloor(){return currentRoom; }

    public int getCurrentRoom(){return currentRoom; }

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
                setCurrentFloor(floor);
                setCurrentRoom(0);
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
                    setCurrentRoom(room);
                } else {
                    System.out.print("Du bist im Erdgeschoss. Du kannst du nur in Raum 001-015 gehen. Um im Raum " + String.valueOf(room) + " gehen zu können, wechsle den Flur mit moveTo(floor)");
                }

            } else if (currentFloor == 1){
                if (room >= 101 || room <= 115){
                    setCurrentRoom(room);
                    if (room == 115){
                        if (sex == "Female"){
                            setCurrentRoom(room);
                        } else if (sex == "Male"){
                            System.out.print("Du bist kein Mädchen du kleiner Perversling.");
                            setCurrentRoom(0);
                        }
                    }
                } else {
                    System.out.print("Du bist im 1. Obergeschoss. Du kannst du nur in Raum 101-115 gehen. Um im Raum " + String.valueOf(room) + " gehen zu können, wechsle den Flur mit moveTo(floor)");
                }

            } else if (currentFloor == 2){
                if (room >= 201 || room <= 215){
                    setCurrentRoom(room);
                    if (room == 215){
                        System.out.print("Bist du Gay oder so. Aber okay");
                    }
                } else {
                    System.out.print("Du bist im 2. Obergeschoss. Du kannst du nur in Raum 201-215 gehen. Um im Raum " + String.valueOf(room) + " gehen zu können, wechsle den Flur mit moveTo(floor)");


                }

            } else if (currentFloor == 3){
                if (room >= 301 || room <= 314 || room == 401){
                    setCurrentRoom(room);
                    if (room == 314){
                        if (sex == "Male"){
                            setCurrentRoom(room);
                        } else if (sex == "Female"){
                            System.out.print("Schwänze kannst du dir auch auf P**nhub oder so angucken");
                            System.out.print("Also bitte verpiss dich hier.");
                            setCurrentRoom(0);
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
            setCurrentRoom(0);
            if (currentRoom >= 001 || currentRoom <= 015){
                setCurrentFloor(0);
            } else if (currentRoom >= 101 || currentRoom <= 115){
                setCurrentFloor(1);
            } else if (currentRoom >= 201 || currentRoom <= 215){
                setCurrentFloor(2);
            } else if (currentRoom >= 301 || currentRoom <= 315 || currentRoom == 401){
                setCurrentFloor(3);
            }
        }
    }
}   
