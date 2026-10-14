public class Character{
    private String name;
    private String sex;
    private String description;
    private Subject subject;
    private int health;
    private int level;
    private Boss inFightWith;
    private Floor currentFloor;
    private Room currentRoom;

    public Character(String newName, String newSex, String newDescription, Subject newSubject, int newHealth, int newLevel, Boss newInFightWith, Room newCurrentRoom, Floor newCurrentFloor){
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

    public void setLevel(int changedLevel){ if (changedLevel >= 1 && changedLevel <= 10) { level = changedLevel; } }

    public void setInFightWith(Boss changedInFightWith){ inFightWith = changedInFightWith; }

    public void setCurrentFloor(Floor changedCurrentFloor){ currentFloor = changedCurrentFloor; }

    public void setCurrentRoom(Room changedCurrentRoom){ currentRoom = changedCurrentRoom; }

    public String getName(){return name;}

    public String getSex(){return sex; }

    public String getDescription(){return description; }

    public Subject getSubject(){return subject; }

    public int getHealth(){return health; }

    public int getLevel(){return level; }

    public Boss getInFightWith(){return inFightWith; }

    public Floor getCurrentFloor(){return currentFloor; }

    public Room getCurrentRoom(){return currentRoom; }


    public static Inventory inventory = new Inventory(new Weapon[]{}, new Key[]{}, new Book[]{}, new Number[]{});


    public void pickUp(){

    }

    //Fighting-System

    public void goInFightWith(Boss boss){
        setInFightWith(boss);
        while(boss.getHealth() > 0){
            
        }
    }

    public void fightDecision(Boss boss, Character player) {
        String[] decisionText = {"Attack", "Use Item", "Defend"};
    

        int[] useScoreLeft = {};
        for(int i=0; i <= inventory.getWeaponSlots().length; i++){
            useScoreLeft[i] = inventory.getWeaponslots()[i].getUseScore();
        }

        String[] decisionMethods = {"attackFightDecision(useScoreLeft, player)", "", ""};

        System.out.println("Game> What do you want to do now?");
        for (int i = 0; i < decisionText.length; i++) {
            System.out.println((i + 1) + " = " + decisionText[i]);
        }
        int decision;

        while (true) {
            System.out.print("> ");
            try {
                decision = Integer.parseInt(scanner.nextLine().trim());

                if (decision >= 1 && decision <= decisionText.length) {
                    break;
                }

            } catch (NumberFormatException e) {
            }
            System.out.println("Please choose a number between 1 and " + decisionText.length + ".");
        }
        if (decisionMethods.length >= decision) {
            executeCommand(decisionMethods[decision - 1]);
            for (i=0; i <= useScoreLeft.lenght; i++){
                if (useScoreLeft[i] == 0){} else if (useScoreLeft[i] > 0){
                    useScoreLeft[i] = useScoreLeft[i] -1;
                }
            }
        } else {
            System.out.println("Error: No method call defined for this choice.");
        }
    }

    private void attackFightDecision(int[] useScoreLeft, Character player){
        String[] decisionText = {};
        for(int i=0; i <= inventory.getWeaponSlots().length; i++){
            decisionText[i] = inventory.getWeaponslots()[i].getName() + " (" + (String) useScoreLeft[i] + ")";
        }

        String[] decisionMethods = {};

        for(int i=0; i <= inventory.getWeaponSlots().length; i++){
            decisionMethods[i] = "Attack(" + inventory.getWeaponSlots()[i].getName() + ", player)";
        }


        System.out.println("Game> What do you want to do now?");
        for (int i = 0; i < decisionText.length; i++) {
            System.out.println((i + 1) + " = " + decisionText[i]);
        }
        int decision;

        while (true) {
            System.out.print("> ");
            try {
                decision = Integer.parseInt(scanner.nextLine().trim());

                if (decision >= 1 && decision <= decisionText.length) {
                    break;
                }

            } catch (NumberFormatException e) {
            }
            System.out.println("Please choose a number between 1 and " + decisionText.length + ".");
        }
        if (decisionMethods.length >= decision) {
            executeCommand(decisionMethods[decision - 1]);
        } else {
            System.out.println("Error: No method call defined for this choice.");
        } 
    }

    public void attack(Weapon weapon, Character player){
        inFightWith.setHealth(inFightWith.getHealth() - weapon.calcDamage(weapon, player));
        player.setHealth(player.getHealth() - inFightWith.calculateBossDamage(inFightWith, player));

        if (player.getHealth() <= 0){
            System.out.println("You died...");
            System.out.println("Damn that must suck. You do realize you need to start this game over again.");
            System.out.println("Well Good luck next time.");
            System.exit(0);
        }

        if (inFightWith.getHealth() <= 0){
            System.out.println("You defeated the Boss" + inFightWith.getName());
            inFightWith = "";
            return;
        }

        System.out.println("You dealt " + (String)weapon.calcDamage(weapon, player) + " Damage to " + inFightWith.getName() + ".");
        System.out.println("He now has " + (String)inFightWith.getHealth() + " Health.");
        System.out.println(" ");
        System.out.println(inFightWith.getName() + " dealt " + (String)inFightWith.calculateBossDamage(inFightWith, player) + " Damage to you.");
        System.out.println("You now have " + (String)inFightWith.getHealth() + " Health.");
    }

    public void levelUp(){
        if (level < 10){
            level++;
            System.out.println("Game> You are now level " + level);
        } else{
            System.out.println("Game> You have already reached the maximum level. You cannot level up further.");
        }
    }

    //MovingSystem

    public void moveTo(Floor floor){
        if (currentRoom == null){
            if (floor == currentFloor){
                System.out.println("Game> Broski you are already in this floor.");
            } else if (floor.getNumber() >= 0 && floor.getNumber() <= 3){
                setCurrentFloor(floor);
                if (floor.getNumber() == 0){
                    System.out.println("Game> You are now on the ground floor.");
                } else if (floor.getNumber() == 1){
                    System.out.println("Game> You are now on the first floor.");
                } else if (floor.getNumber() == 2){
                    System.out.println("Game> You are now on the second floor.");
                } else if (floor.getNumber() == 3){
                    System.out.println("Game> You are now on the third floor.");
                }
            } else if(floor.getNumber() == 4){
                System.out.println("Game> You can go directly from the third floor to room 401. Floor 4 does not exist.");
            } else{
                System.out.println("Game> What do you want that to be?");
            }
        } else if (currentRoom != null){
            System.out.println("Game> You are in a room. Use the exit() function to go to the hallway and change floors.");
        }
    }

    public void enter(Room room){
        if (currentRoom == null){
            if (room.getNumber() >= 1 && room.getNumber() <= 15 && currentFloor.getNumber() == 0){
                setCurrentRoom(room);
                System.out.println("Game> You are now in room " + room.getNumber());
            } else if (room.getNumber() >= 101 && room.getNumber() <= 114 && currentFloor.getNumber() == 1){
                setCurrentRoom(room);
                System.out.println("Game> You are now in room " + room.getNumber());
                System.out.println("Du bist jetzt in Raum " + room.getNumber());
            } else if(room.getNumber() == 115 && currentFloor.getNumber() == 1){
                if (sex.equals("Male")){
                    System.out.println("Game> What do you want in the female bathroom you pervert?");
                } else if (sex.equals("Female")){
                    setCurrentRoom(room);
                    System.out.println("Game> You are now in room " + room.getNumber());
                }
            } else if (room.getNumber() >= 201 && room.getNumber() <= 215 && currentFloor.getNumber() == 2){
                setCurrentRoom(room);
                System.out.println("Game> You are now in room " + room.getNumber());
            } else if ((room.getNumber() >= 301 && room.getNumber() <= 313 || room.getNumber() == 401) && currentFloor.getNumber() == 3){
                setCurrentRoom(room);
                System.out.println("Game> You are now in room " + room.getNumber());
            } else if(room.getNumber() == 314 && currentFloor.getNumber() == 3){
                if (sex.equals("Female")){
                    System.out.println("Game> You can watch cocks on p***hub, but not here. Get out of here!");
                } else if (sex.equals("Male")){
                    setCurrentRoom(room);
                    System.out.println("Game> You are now in room " + room.getNumber());
                }
            } else{
                System.out.println("Game> You cannot go to that room. Either it does not exist or you are in the wrong floor.");
            }
        } else if (currentRoom != null){
            System.out.println("Game> You are already in a room. Use the exit() function to go to the hallway and change floors.");
        }
    }
    public void exit(){
        if (currentRoom != null){
            System.out.println("Game> You have left room " + currentRoom.getNumber());
            setCurrentRoom(null);
        } else if (currentRoom == null){
            System.out.println("Game> You are already in the hallway.");
        }
    }
}   
