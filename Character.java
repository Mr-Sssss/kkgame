import java.lang.reflect.Field;     
import java.lang.reflect.Method;
import java.security.Key;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.security.auth.Subject;

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

    //level 1 = 100 health, every level gives 20 more
    public int getMaxHealth(){return 80 + level * 20; }

    public Boss getInFightWith(){return inFightWith; }

    public Floor getCurrentFloor(){return currentFloor; }

    public Room getCurrentRoom(){return currentRoom; }

    //Main-Funcitons----------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static Inventory inventory = new Inventory(new Weapon[]{}, new Key[]{}, new Book[]{}, new Number[]{}, new Potion[]{});

    public void levelUp(){
        if (level < 10){
            level++;
            health = getMaxHealth();
            System.out.println("Game> You are now level " + level + "! Your max health is now " + getMaxHealth() + " and you are fully healed.");
        } else{
            System.out.println("Game> You have already reached the maximum level. You cannot level up further.");
        }
    }

    //Fighting-System ----------------------------------------------------------------------------------------------------------------------------------------------------------------

    private int[] weaponCooldowns;
    private int nextAttackDamageBoostPercent = 0;

    private void updateWeaponCooldowns(int usedWeaponIndex) {//updates the cooldown(useScore) of all used Weapons after an Attack/use of an Item/defence
        Weapon[] weapons = inventory.getWeaponSlots();
        for (int i = 0; i < weaponCooldowns.length; i++) {
            if (i != usedWeaponIndex && weaponCooldowns[i] > 0) {
                weaponCooldowns[i]--;
            }
        }
        if (usedWeaponIndex >= 0 && weapons[usedWeaponIndex] != null) {
            weaponCooldowns[usedWeaponIndex] =
                weapons[usedWeaponIndex].getUseScore();
        }
    }

    private void bossAttack(Character player, double damageMultiplier) {//The Boss attacks
        if (inFightWith == null) {
            return;
        }
        Boss boss = inFightWith;
        int damage = (int) Math.round(
            boss.calculateBossDamage(boss, player) * damageMultiplier
        );

        player.setHealth(Math.max(0, player.getHealth() - damage));

        System.out.println(boss.getName() + " dealt " + damage + " damage to you.");

        System.out.println("Your health: " + player.getHealth()+ "/" + player.getMaxHealth());

        if (player.getHealth() <= 0) {
            handlePlayerDeath();
        }
    }

    private void handlePlayerDeath() {//When the player dies
        System.out.println("You have been defeated!");
        System.out.println("You need to start this game over again.");
        System.exit(0);
    }

    public static int readDecision(int min, int max) {//When a decision has to be made during the fight
        while (true) {
            System.out.print("> ");
            try {
                int decision = Integer.parseInt(
                    Adventure.scanner.nextLine().trim()
                );
                if (decision >= min && decision <= max) {
                    return decision;
                }
            } catch (NumberFormatException e) {

            }
            System.out.println("Please choose a number between "+ min + " and " + max + ".");
        }
    }

    public void goInFightWith(Boss boss, Character player) {//Starts a fight with a boss
        setInFightWith(boss);
        weaponCooldowns =
            new int[inventory.getWeaponSlots().length];

        System.out.println("You are fighting " + boss.getName() + "!");
        while (inFightWith != null && inFightWith.getHealth() > 0 && player.getHealth() > 0) {
            fightDecision(inFightWith, player);
        }

        if (player.getHealth() > 0) {
            System.out.println("Fight ended.");
        }

        setInFightWith(null);
        weaponCooldowns = null;
    }

    public void fightDecision(Boss boss, Character player) {//The decision the player has to make after each attack of the Boss
        System.out.println("\nGame> What do you want to do?");
        System.out.println("1 = Attack");
        System.out.println("2 = Use Item");
        System.out.println("3 = Defend");

        int decision = readDecision(1, 3);
        switch (decision) {
            case 1: {
                int weaponIndex = attackFightDecision();
                if (weaponIndex == -1) {return;}
                Weapon weapon = inventory.getWeaponSlots()[weaponIndex];
                updateWeaponCooldowns(weaponIndex);
                attack(weapon, player);
                break;
            }
            case 2: {
                if (inventory.getAllItems().isEmpty()){
                    System.out.println("You don't have any items!");
                    break;
                } else {
                    boolean usedItem = useItemFightDecision(player);
                    if (!usedItem) {return;}
                    break;
                }
            }   
            case 3:
                System.out.println("You defend yourself!");
                updateWeaponCooldowns(-1);
                bossAttack(player, 0.5);
                break;
        }
    }

    private int attackFightDecision() {//Descision which weapon tochoose
        Weapon[] weapons = inventory.getWeaponSlots();
        int availableWeapons = 0;
        System.out.println("\nGame> Choose a weapon:");
        for (int i = 0; i < weapons.length; i++) {
            if (weapons[i] == null) {
                System.out.println((i + 1) + " = Empty slot");
            } else if (weaponCooldowns[i] == 0) {
                System.out.println((i + 1) + " = " + weapons[i].getName() + " (Ready)");
                availableWeapons++;
            } else {
                System.out.println((i + 1) + " = " + weapons[i].getName() + " (Cooldown: " + weaponCooldowns[i] + ")");
            }
        }

        if (availableWeapons == 0) {
            System.out.println("No weapons are ready!");
            return -1;
        }

        while (true) {
            int choice = readDecision(1, weapons.length);
            int index = choice - 1;

            if (weapons[index] == null) {
                System.out.println("This slot is empty.");
            } else if (weaponCooldowns[index] > 0) {
                System.out.println(
                    "This weapon has "
                    + weaponCooldowns[index]
                    + " actions remaining on cooldown."
                );
            } else {
                return index;
            }
        }
    }

    public void attack(Weapon weapon, Character player) {//Attacks the Boss with a specific weapon chosen in attackFightDecision
        if (inFightWith == null) {
            return;
        }

        Boss boss = inFightWith;

        int damage = weapon.calcDamage(weapon, player);

        if (nextAttackDamageBoostPercent > 0) {
            damage = (int) Math.round(damage * (1 + nextAttackDamageBoostPercent / 100.0));
            System.out.println("Damage boosted by "+ nextAttackDamageBoostPercent+ "%!");
            nextAttackDamageBoostPercent = 0;
        }

        boss.setHealth(Math.max(0, boss.getHealth() - damage));

        System.out.println(
            "You dealt " + damage + " damage to " + boss.getName() + "."
        );

        System.out.println(
            boss.getName() + " has " + boss.getHealth() + " health left."
        );

        if (boss.getHealth() <= 0) {
            System.out.println("You defeated " + boss.getName() + "!");
            setInFightWith(null);
            return;
        }

        bossAttack(player, 1.0);
    }

    private boolean useItemFightDecision(Character player) {//When the player decides to use an Item(Ai generated Method)
        List<Item> items = inventory.getAllItems();

        if (items.isEmpty()) {
            System.out.println("You don't have any items!");
            return false;
        }

        List<Item> choices = new ArrayList<>();

        // Unterschiedliche Items für die Anzeige sammeln.
        for (Item item : items) {
            boolean alreadyListed = false;

            for (Item choice : choices) {
                if (choice.getName().equals(item.getName())) {
                    alreadyListed = true;
                    break;
                }
            }

            if (!alreadyListed) {
                choices.add(item);
            }
        }

        System.out.println("\nGame> Choose an item:");

        for (int i = 0; i < choices.size(); i++) {
            Item item = choices.get(i);
            int amount = 0;

            for (Item ownedItem : items) {
                if (ownedItem.getName().equals(item.getName())) {
                    amount++;
                }
            }

            System.out.println((i + 1) + " = " + item.getName()+ " x" + amount + " (" + item.getDescription() + ")");
        }

        System.out.println("0 = Cancel");

        int choice = readDecision(0, choices.size());

        if (choice == 0) {
            return false;
        }

        Item selectedItem = choices.get(choice - 1);

        if (selectedItem instanceof Potion) {usePotion((Potion) selectedItem, player);} 
        else if (selectedItem instanceof Book) {useBook((Book) selectedItem);} 
        else if (selectedItem instanceof Number) {useNumber((Number) selectedItem);}

        inventory.removeItem(selectedItem);
        updateWeaponCooldowns(-1);
        if (player.getHealth() <= 0) {
            handlePlayerDeath();
            return true;
        }

        if (inFightWith != null && inFightWith.getHealth() > 0) {
            bossAttack(player, 1.0);
        }
        return true;
    }

    private void useBook(Book book) {//when the chosen item is a book
        int reduction = book.getCooldownReduction();
        for (int i = 0; i < weaponCooldowns.length; i++) {
            weaponCooldowns[i] = Math.max(
                0,
                weaponCooldowns[i] - reduction
            );
        }
        System.out.println("You used " + book.getName()+ "! All weapon cooldowns were reduced by " + reduction + ".");
    }

    private void usePotion(Potion potion, Character player) {//when the chosen item is a Potion
        int percent = potion.getHealthPercent();
        boolean heals = potion.heals();

        if (potion == Potion.mysterypotion) {
            if (Math.random() < 0.5) {
                heals = true;
                percent = 1 + (int) (Math.random() * 65);
            } else {
                heals = false;
                percent = 1 + (int) (Math.random() * 35);
            }
        }
        int amount = (int) Math.round(
            player.getMaxHealth() * percent / 100.0
        );

        if (heals) {
            int oldHealth = player.getHealth();
            player.setHealth(Math.min(player.getMaxHealth(), oldHealth + amount));
            System.out.println("You used " + potion.getName()+ " and healed "+ (player.getHealth() - oldHealth)+ " health!");
        } else {
            int oldHealth = player.getHealth();
            player.setHealth(Math.max(0,oldHealth - amount));

            System.out.println("You used " + potion.getName()+ " and lost "+ (oldHealth - player.getHealth())+ " health!");
        }

        System.out.println("Your health: " + player.getHealth()+ "/" + player.getMaxHealth());
    }

    private void useNumber(Number number) {//when the chosen item is a Number
        nextAttackDamageBoostPercent = number.getDamageBoostPercent();

        System.out.println(
            "You used " + number.getName() + "!"
        );

        System.out.println(
            "Your next attack will deal "
            + nextAttackDamageBoostPercent
            + "% more damage!"
        );
    }

    //MovingSystem ----------------------------------------------------------------------------------------------------------------------------------------------------------------

    public void moveTo(Floor floor){
        if (currentRoom == null){
            if (floor == currentFloor){
                System.out.println("Game> Broski, you are already on this floor.");
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
        if (room.getLocked()){
            System.out.println("Game> Room " + room.getNumber() + " is locked. You need the 'Key for Room " + String.format("%03d", room.getNumber()) + "' and then use unlockRoom(" + room.getNumber() + ").");
        } else {
            if (currentRoom == null){
                if (room.getNumber() >= 1 && room.getNumber() <= 15 && currentFloor.getNumber() == 0){
                    setCurrentRoom(room);
                    System.out.println("Game> You are now in room " + room.getNumber());
                } else if (room.getNumber() >= 101 && room.getNumber() <= 114 && currentFloor.getNumber() == 1){
                    setCurrentRoom(room);
                    System.out.println("Game> You are now in room " + room.getNumber());
                } else if(room.getNumber() == 115 && currentFloor.getNumber() == 1){
                    if (sex.equals("Male")){
                        System.out.println("Game> Oops, wrong door, Broski! This is the girls' bathroom. Better try another one.");
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
                        System.out.println("Game> Oops, wrong door! This is the boys' bathroom. Better try another one.");
                    } else if (sex.equals("Male")){
                        setCurrentRoom(room);
                        System.out.println("Game> You are now in room " + room.getNumber());
                    }
                } else{
                    System.out.println("Game> You cannot go to that room. Either it does not exist or you are on the wrong floor.");
                }
            } else if (currentRoom != null){
                System.out.println("Game> You are already in a room. Use the exit() function to go to the hallway and change floors.");
            }
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

    public void unlockRoom(Room room) {
        if (room.getFloor() != currentFloor) {
            System.out.println("Game> This room is not on your current floor!");
            return;
        }
        if (!room.getLocked()) {
            System.out.println("Game> This room is already unlocked!");
            return;
        }
        Key[] keys = inventory.getKeySlots();
        //key names always have 3 digits, e.g. "Key for Room 007"
        String expectedKeyName = "Key for Room " + String.format("%03d", room.getNumber());

        for (Key key : keys) {

            if (key == null) {
                continue;
            }

            if (key.getName().equals(expectedKeyName)) {
                if (!key.getFound()) {
                    System.out.println("Game> You haven't found this key yet!");
                    return;
                }
                room.setLocked(false);
                inventory.removeItem(key);

                System.out.println("Game> You unlocked Room " + room.getNumber() + "!");
                System.out.println("Game> " + key.getName() + " was removed from your inventory.");
                return;
            }
        }
        System.out.println("Game> You don't have the '" + expectedKeyName + "'. Keys can be found in the loot of other rooms.");
    }
}   
