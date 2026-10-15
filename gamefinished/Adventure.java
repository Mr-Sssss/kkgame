import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Adventure {
    //Temporary Attributes
    private String tempTextInput;
    private String tempCharacterName;
    private String tempCharacterSex;
    private String tempCharacterDescription;
    private Subject tempCharacterSubject;
    private boolean startonetimeuse = true;

    //temporary Methods
    public void setCharacterName(String name) {tempCharacterName = name;}
    public void setCharacterSex(String sex) {tempCharacterSex = sex;}
    public void setCharacterDescription(String description) {tempCharacterDescription = description;}
    public void setCharacterSubject(Subject subject) {tempCharacterSubject = subject;}


    private Character player;
    public static final Scanner scanner = new Scanner(System.in);
    private int day = 0;

    //Story Attributes
    private int questStage = 0; //0 = go to the teacher, 1 = quest is running, 2 = go back to the teacher, 3 = go to the boss
    private int questProgress = 0;
    private ArrayList<Integer> questRooms = new ArrayList<>();
    private int weaponsGiven = 0;
    private boolean gameFinished = false;
    private Random random = new Random();
    private int[] huntRooms = {2, 215, 302, 104, 14};
    private String[] huntHints = {"The biggest computer room is waiting for you.", "Go where everybody has to go, no matter if boy or girl. Second floor.", "The music room with the smallest number.", "Take the number of the music room and subtract 198.", "Go back to where your first day really began."};

    //only these functions can be used by the player
    private String[] allowedCommands = {"start", "help", "showMap", "moveTo", "enter", "exit", "unlockRoom", "showStats", "showInv", "floorStats", "roomStats", "bossStats", "weaponStats", "subjectStats"};

    //Main Methods:
    public void help() {
        System.out.println("\n==============================================");
        System.out.println("                 KKGame - HELP");
        System.out.println("==============================================");
        System.out.println("General:");
        System.out.println(" - start() (Starts the game. It can only be used once.)");
        System.out.println(" - help() (Shows this help.)");
        System.out.println(" - exitgame (Closes the game. Your progress will not be saved.)");
        System.out.println(" ");
        System.out.println("The open world:");
        System.out.println(" - showMap() (Shows all rooms of the school, their subject, how much loot they have and if they are closed.)");
        System.out.println(" - moveTo(FLOORNUMBER) (Moves you to another floor. Floors: 0, 1, 2, 3. You have to be in the hallway, not in a room.)");
        System.out.println(" - enter(ROOMNUMBER) (Enters a room on your current floor, e.g. enter(14). Room 401 can be entered from floor 3.)");
        System.out.println(" - exit() (Leaves the room you are in and brings you back to the hallway.)");
        System.out.println(" - unlockRoom(ROOMNUMBER) (Opens a closed room on your current floor, if you have the right key. The key is used up.)");
        System.out.println(" ");
        System.out.println("Your character:");
        System.out.println(" - showStats() (Shows your name, subject, level, health, the day and your current quest.)");
        System.out.println(" - showInv() (Shows your weapons, keys, potions, books and numbers.)");
        System.out.println(" ");
        System.out.println("Information:");
        System.out.println(" - floorStats(FLOOR), e.g. floorStats(1)");
        System.out.println(" - roomStats(ROOM), e.g. roomStats(14)");
        System.out.println(" - bossStats(BOSS), e.g. bossStats(Frau Stockroh)");
        System.out.println(" - weaponStats(WEAPON), e.g. weaponStats(Chalk)");
        System.out.println(" - subjectStats(SUBJECT), e.g. subjectStats(maths)");
        System.out.println(" - These show all important information like name, description, damage and so on.");
        System.out.println(" - If you leave the brackets empty or write something wrong, you get a list of what you can choose from.");
        System.out.println(" ");
        System.out.println("Loot:");
        System.out.println(" - When you enter a normal room, you find loot and can choose what you want to take.");
        System.out.println(" - The loot value of a room decides how much: 1 = 3 items, you can take 1. 2 = 6 items, you can take 2. 3 = 9 items, you can take 3. 0 = nothing.");
        System.out.println(" - Loot can be a neutral weapon, a key, a potion, a book or a number.");
        System.out.println(" - The rarity decides how often something appears: 1 = common, 2 = uncommon, 3 = rare, 4 = epic, 5 = legendary. Things with rarity 6 are never in the loot.");
        System.out.println(" - Weapons are twice as rare as items. On your first day you also find a weapon in each of the first two rooms you enter.");
        System.out.println(" - Weapons and keys can only be found once. Potions, books and numbers can be found again and again and there is no limit in your inventory.");
        System.out.println(" - After you visited a room, you have to visit 10 other rooms before there is new loot in it. Every time a room is looted, its loot value goes down by 1 (but never below 1).");
        System.out.println(" ");
        System.out.println("Boss fights:");
        System.out.println(" - When you enter a boss room, the fight starts immediately.");
        System.out.println(" - Every turn you choose: 1 = Attack, 2 = Use Item, 3 = Defend. After your action the boss attacks you.");
        System.out.println(" - Attack: Choose a weapon that is ready. After you use a weapon it has a cooldown (its use score). Every action you do lowers the cooldown of all other weapons by 1.");
        System.out.println(" - Use Item: Potions heal you (but some potions hurt you). Books lower the cooldown of all weapons even more. Numbers make your next attack stronger.");
        System.out.println(" - Defend: You only take half of the damage.");
        System.out.println(" - Your damage depends on the damage and level of the weapon, your level, your subject, the subject of the boss and a bit of luck.");
        System.out.println(" - There are 5 subject groups: Maths, Languages, Social, Science and Art/Music.");
        System.out.println(" - Maths is stronger than Languages, Languages is stronger than Social, Social is stronger than Science, Science is stronger than Art/Music, Art/Music is stronger than Maths.");
        System.out.println(" - Against a boss with a weaker subject you deal 20% more damage and take 20% less damage. Against a stronger subject it is the other way around.");
        System.out.println(" - If your health reaches 0, you lose and have to start the game again.");
        System.out.println(" ");
        System.out.println("Levels and story:");
        System.out.println(" - You start at level 1 and can reach level 10. You level up when you finish a quest or defeat a boss.");
        System.out.println(" - Every level gives you 20 more max health and heals you completely.");
        System.out.println(" - The story takes 5 days, from Monday to Friday. Every day you get a quest. When you finish it, you get the key for a boss room.");
        System.out.println(" - When you defeat the boss of the day, you get two new weapons of your subject and the next day begins.");
        System.out.println(" - Use showStats() if you forget what your current quest is.");
        System.out.println(" - Herr Kreuter is an optional boss in room 005. Its key is very rare. If you defeat him, you can choose a strong weapon of another subject.");
        System.out.println(" ");
        System.out.println("Dialogues:");
        System.out.println(" - The name on the left is the person that is talking. To see the next sentence, just press enter.");
        System.out.println(" - Sometimes you are asked to enter something or to decide. Then type your answer or the number of your choice.");
        System.out.println("==============================================");
    }

    public void start() {
        if (startonetimeuse) {
            dialoge("Narrator", new String[]{"It is the last day of summer vacation and you decide to check your email!", "A mail from your school pops up!", "Hello..."}, false, "Input your name:", new String[]{}, new String[]{"setCharacterName(tempTextInput)"}, true);
            dialoge("School", new String[]{"Hello " + tempCharacterName + ". This email got sent from the Kollwitz-Käthe-Gymnasium.", "It wants to inform you about the upcoming school year and the new teachers!", "Also because you are _______"}, true, "Choose your gender:", new String[]{"Male", "Female"}, new String[]{"setCharacterSex(\"Male\")", "setCharacterSex(\"Female\")"}, false);
            dialoge("School", new String[]{"Also, because you are " + tempCharacterSex.toLowerCase() + ", we wanted to tell you that there is a new unisex bathroom on the second floor!", "This year, it would also be optimal if you chose one subject group to specialize in!"}, true, "Choose your subject group:", new String[]{"Maths","Science", "Languages", "Social", "Art and Music"}, new String[]{"setCharacterSubject(Subject.maths)", "setCharacterSubject(Subject.science)", "setCharacterSubject(Subject.languages)", "setCharacterSubject(Subject.social)", "setCharacterSubject(Subject.artmusic)"}, false);
            dialoge("School", new String[]{"Because you chose " + tempCharacterSubject.getName() + " as your subject group, you will be able to specialize in it!", "Now have fun this year at the KKG!", "Please also write a short description of yourself, it would help us very much"}, false, "Your description:", new String[]{}, new String[]{"setCharacterDescription(tempTextInput)"}, true);
            dialoge("School", new String[]{"Your School, the Kollwitz-Käthe-Gymnasium"}, false, "", new String[]{}, new String[]{}, false);
            dialoge("Narrator", new String[]{"You find this e-mail a little bit weird, but you don't think much of it.", "You go to sleep for the next day of school."}, false, "", new String[]{}, new String[]{}, false);
            dialoge("You", new String[]{"(Sleeping...)"}, false, "", new String[]{}, new String[]{}, false);
            dialoge("Game", new String[]{"Chapter 1 Monday - The beginning"}, false, "", new String[]{}, new String[]{}, false);
            dialoge("Narrator", new String[]{"You are now in school and you immediately notice something is different.", "Nothing really visible, but it just feels different."}, false, "", new String[]{}, new String[]{}, false);
            dialoge("Game", new String[]{"You are now in the open world mode", "You are currently on the main floor", "Go to room 014 to get your task from Frau Axt", "Tip: In the first two rooms you enter today you will find a weapon. You will need it!", "Type help() to see how you can navigate in it."}, false, "", new String[]{}, new String[]{}, false);
            startonetimeuse = !startonetimeuse;
            player = new Character(tempCharacterName, tempCharacterSex, tempCharacterDescription, tempCharacterSubject, 100, 1, null, null, Floor.nul);
            day = 1;
        } else {
            System.out.println("Game> The game has already started.");
        }
    }

    public void showMap() {
        System.out.println("\n==============================================");
        System.out.println("                 KKGame - MAP");
        System.out.println("==============================================");
        Room[] rooms = Room.getAllRooms();

        for (int floorNumber = 0; floorNumber <= 3; floorNumber++) {
            System.out.println("\nFloor " + floorNumber + "\n");
            for (Room room : rooms) {
                if (room.getFloor().getNumber() != floorNumber) {
                    continue;
                }
                String roomNumber = String.format(
                    "%03d", room.getNumber()
                );
                String bossName = getBossName(room.getNumber());
                if (room.getLocked()) {
                    System.out.print("CLOSED ");
                } else {
                    System.out.print("- ");
                }
                System.out.print("R" + roomNumber);
                if (bossName != null) {
                    System.out.print(" - BOSS: " + bossName);
                }
                System.out.println(
                    " - " + room.getSubject().getName()
                    + ", Loot: " + room.getLootValue()*3 + "/9"
                    + " (" + room.getDescription() + ")"
                );
            }
        }
        System.out.println("\n==============================================");
    }

    private Boss getBossInRoom(int roomNumber) {
        switch (roomNumber) {
            case 5:
                return Boss.herrKreuter;

            case 107:
                return Boss.frauBurger;

            case 110:
                return Boss.herLunke;

            case 206:
                return Boss.derLoewe;

            case 207:
                return Boss.herrDamny;

            case 401:
                return Boss.frauStockroh;

            default:
                return null;
        }
    }

    private String getBossName(int roomNumber) {
        Boss boss = getBossInRoom(roomNumber);
        if (boss == null) {
            return null;
        }
        if (boss == Boss.derLoewe && !loeweRevealed()) {
            return "UNKNOWN";
        }
        return boss.getName();
    }

    //Der Löwe stays a secret until you find out about him on day 5
    private boolean loeweRevealed() {
        return gameFinished || (day == 5 && questStage == 3);
    }

    // Open World Methods

    public void moveTo(int floorNumber) {
        Floor floor = findObjectByNumber(Floor.class, floorNumber);
        if (floor == null) {
            System.out.println("Floor " + floorNumber + " does not exist.");
            return;
        }
        player.moveTo(floor);
    }

    public void enter(int roomNumber) {
        Room room = findObjectByNumber(Room.class, roomNumber);
        if (room == null) {
            System.out.println("Room " + roomNumber + " does not exist.");
            return;
        }
        boolean wasInHallway = player.getCurrentRoom() == null;
        player.enter(room);
        if (wasInHallway && player.getCurrentRoom() == room) {
            enteredRoom(room);
        }
    }
    public void exit() {
        player.exit();
    }

    public void unlockRoom(int roomNumber) {
        Room room = findObjectByNumber(Room.class, roomNumber);
        if (room == null) {
            System.out.println("Room " + roomNumber + " does not exist.");
            return;
        }
        player.unlockRoom(room);
    }

    // Character Methods

    public void showInv() {
        Character.inventory.showInv();
    }

    public void showStats() {
        System.out.println("\n==============================================");
        System.out.println("                 YOUR STATS");
        System.out.println("==============================================");
        System.out.println("Name: " + player.getName());
        System.out.println("Gender: " + player.getSex());
        System.out.println("Description: " + player.getDescription());
        System.out.println("Subject: " + player.getSubject().getName());
        System.out.println("Level: " + player.getLevel() + "/10");
        System.out.println("Health: " + player.getHealth() + "/" + player.getMaxHealth());
        System.out.println("Day: " + day + " (" + getDayName() + ")");
        if (player.getCurrentRoom() == null) {
            System.out.println("Location: Floor " + player.getCurrentFloor().getNumber() + ", in the hallway");
        } else {
            System.out.println("Location: Floor " + player.getCurrentFloor().getNumber() + ", room " + player.getCurrentRoom().getNumber());
        }
        System.out.println("Quest: " + getQuestText());
        System.out.println("==============================================");
    }

    // Information Methods

    public void floorStats() {
        System.out.println("Game> You need to enter which floor you want to see the stats of. Available floors: 0, 1, 2, 3");
    }

    public void floorStats(String wrongInput) {
        System.out.println("Game> There is no floor '" + wrongInput + "'. Available floors: 0, 1, 2, 3");
    }

    public void floorStats(int floorNumber) {
        Floor floor = findObjectByNumber(Floor.class, floorNumber);
        if (floor == null) {
            floorStats(String.valueOf(floorNumber));
            return;
        }
        int roomCount = 0;
        int closedCount = 0;
        String roomNumbers = "";
        for (Room room : Room.getAllRooms()) {
            if (room.getFloor() == floor) {
                roomCount++;
                if (room.getLocked()) {
                    closedCount++;
                }
                roomNumbers += String.format("%03d", room.getNumber()) + " ";
            }
        }
        System.out.println("\n==============================================");
        System.out.println("                 FLOOR " + floor.getNumber());
        System.out.println("==============================================");
        System.out.println("Description: " + floor.getDescription());
        System.out.println("Rooms: " + roomCount + " (" + closedCount + " of them are closed)");
        System.out.println("Room numbers: " + roomNumbers);
        System.out.println("==============================================");
    }

    public void roomStats() {
        System.out.println("Game> You need to enter which room you want to see the stats of. Available rooms: " + getRoomList());
    }

    public void roomStats(String wrongInput) {
        System.out.println("Game> There is no room '" + wrongInput + "'. Available rooms: " + getRoomList());
    }

    public void roomStats(int roomNumber) {
        Room room = findObjectByNumber(Room.class, roomNumber);
        if (room == null) {
            roomStats(String.valueOf(roomNumber));
            return;
        }
        String bossName = getBossName(room.getNumber());
        System.out.println("\n==============================================");
        System.out.println("                 ROOM " + String.format("%03d", room.getNumber()));
        System.out.println("==============================================");
        System.out.println("Description: " + room.getDescription());
        System.out.println("Floor: " + room.getFloor().getNumber());
        System.out.println("Subject: " + room.getSubject().getName());
        if (room.getLocked()) {
            System.out.println("Closed: yes (you need the 'Key for Room " + String.format("%03d", room.getNumber()) + "')");
        } else {
            System.out.println("Closed: no");
        }
        if (bossName != null) {
            System.out.println("Boss room: yes (" + bossName + ")");
        } else {
            System.out.println("Boss room: no");
            System.out.println("Loot value: " + room.getLootValue() + " (" + room.getLootValue() * 3 + " items, you can take " + room.getLootValue() + ")");
            if (room.getRoomsUntilLoot() == 0) {
                System.out.println("New loot: yes");
            } else {
                System.out.println("New loot: after you visited " + room.getRoomsUntilLoot() + " other rooms");
            }
        }
        System.out.println("==============================================");
    }

    private String getRoomList() {
        String list = "";
        for (Room room : Room.getAllRooms()) {
            list += room.getNumber() + " ";
        }
        return list;
    }

    public void bossStats() {
        System.out.println("Game> You need to enter which boss you want to see the stats of. Available bosses: " + getBossList());
    }

    public void bossStats(int wrongInput) {
        bossStats(String.valueOf(wrongInput));
    }

    public void bossStats(String bossName) {
        for (Boss boss : Boss.getAllBosses()) {
            if (boss == Boss.derLoewe && !loeweRevealed()) {
                continue;
            }
            if (!simplify(boss.getName()).equals(simplify(bossName))) {
                continue;
            }
            System.out.println("\n==============================================");
            System.out.println("                 " + boss.getName().toUpperCase());
            System.out.println("==============================================");
            System.out.println("Subject: " + boss.getSubject().getName());
            System.out.println("Description: " + boss.getDescription());
            System.out.println("Level: " + boss.getLevel());
            System.out.println("Damage: " + boss.getDamage());
            System.out.println("Health: " + boss.getHealth());
            for (Room room : Room.getAllRooms()) {
                if (getBossInRoom(room.getNumber()) == boss) {
                    System.out.println("Room: " + String.format("%03d", room.getNumber()));
                }
            }
            if (boss.getHealth() <= 0) {
                System.out.println("Status: defeated");
            } else {
                System.out.println("Status: not defeated yet");
            }
            System.out.println("==============================================");
            return;
        }
        System.out.println("Game> There is no boss called '" + bossName + "'. Available bosses: " + getBossList());
    }

    private String getBossList() {
        String list = "";
        for (Boss boss : Boss.getAllBosses()) {
            if (boss == Boss.derLoewe && !loeweRevealed()) {
                continue;
            }
            if (!list.isEmpty()) {
                list += ", ";
            }
            list += boss.getName();
        }
        return list;
    }

    public void weaponStats() {
        System.out.println("Game> You need to enter which weapon you want to see the stats of. Available weapons: " + getWeaponList());
    }

    public void weaponStats(int wrongInput) {
        weaponStats(String.valueOf(wrongInput));
    }

    public void weaponStats(String weaponName) {
        for (Weapon weapon : Weapon.getAllWeapons()) {
            if (!simplify(weapon.getName()).equals(simplify(weaponName))) {
                continue;
            }
            boolean inInventory = false;
            for (Weapon ownWeapon : Character.inventory.getWeaponSlots()) {
                if (ownWeapon == weapon) {
                    inInventory = true;
                }
            }
            System.out.println("\n==============================================");
            System.out.println("                 " + weapon.getName().toUpperCase());
            System.out.println("==============================================");
            System.out.println("Subject: " + weapon.getSubject().getName());
            System.out.println("Description: " + weapon.getDescription());
            System.out.println("Level: " + weapon.getLevel());
            System.out.println("Damage: " + weapon.getDamage());
            System.out.println("Cooldown (use score): " + weapon.getUseScore());
            if (weapon.getSubject() == Subject.neutral) {
                System.out.println("Rarity: " + weapon.getRarety() + " (" + Loot.getRarityName(weapon.getRarety()) + ")");
            } else {
                System.out.println("Rarity: can only be won from bosses");
            }
            if (inInventory) {
                System.out.println("In your inventory: yes");
            } else {
                System.out.println("In your inventory: no");
            }
            System.out.println("==============================================");
            return;
        }
        System.out.println("Game> There is no weapon called '" + weaponName + "'. Available weapons: " + getWeaponList());
    }

    private String getWeaponList() {
        String list = "";
        for (Weapon weapon : Weapon.getAllWeapons()) {
            if (!list.isEmpty()) {
                list += ", ";
            }
            list += weapon.getName();
        }
        return list;
    }

    public void subjectStats() {
        System.out.println("Game> You need to enter which subject you want to see the stats of. Available subjects: maths, languages, social, science, artmusic");
    }

    public void subjectStats(int wrongInput) {
        subjectStats(String.valueOf(wrongInput));
    }

    public void subjectStats(String subjectName) {
        Subject[] subjects = {Subject.maths, Subject.languages, Subject.social, Subject.science, Subject.artmusic};
        for (Subject subject : subjects) {
            if (!simplify(subject.getName()).equals(simplify(subjectName))) {
                continue;
            }
            System.out.println("\n==============================================");
            System.out.println("                 " + subject.getName().toUpperCase());
            System.out.println("==============================================");
            System.out.println("Description: " + subject.getDescription());
            System.out.println("Strong against: " + subject.getStrongAgainst().getName());
            System.out.println("Weak against: " + subject.getWeakAgainst().getName());
            if (player != null && player.getSubject() == subject) {
                System.out.println("This is your subject!");
            }
            System.out.println("==============================================");
            return;
        }
        System.out.println("Game> There is no subject called '" + subjectName + "'. Available subjects: maths, languages, social, science, artmusic");
    }

    //makes names easier to compare, e.g. "Der Löwe" and "derloewe" are the same
    private String simplify(String text) {
        return text.toLowerCase().replace("ö", "oe").replace("ä", "ae").replace("ü", "ue").replace("ß", "ss").replaceAll("[^a-z0-9]", "");
    }

    // Room Methods

    private void enteredRoom(Room room) {
        //every other room gets one step closer to having new loot again
        for (Room otherRoom : Room.getAllRooms()) {
            if (otherRoom != room && otherRoom.getRoomsUntilLoot() > 0) {
                otherRoom.setRoomsUntilLoot(otherRoom.getRoomsUntilLoot() - 1);
            }
        }

        if (room.getBossroom()) {
            enterBossRoom(room);
            return;
        }

        checkStory(room);

        if (room.getRoomsUntilLoot() == 0) {
            //in the first two rooms on day 1 there is always a weapon
            if (day == 1 && weaponsGiven < 2) {
                Weapon weapon = Loot.randomWeapon();
                if (weapon != null) {
                    Character.inventory.addWeapon(weapon);
                    weaponsGiven++;
                    System.out.println("Game> You found a weapon lying on the floor: " + weapon.getName() + " (Damage: " + weapon.getDamage() + ", Cooldown: " + weapon.getUseScore() + ")");
                }
            }
            findQuestItems(room);
            Loot.lootRoom(room);
            room.setRoomsUntilLoot(10);
            if (room.getLootValue() > 1) {
                room.setLootValue(room.getLootValue() - 1);
            }
        } else {
            System.out.println("Game> You already searched this room. Visit " + room.getRoomsUntilLoot() + " other rooms and there will be new loot here.");
        }
    }

    private void enterBossRoom(Room room) {
        Boss boss = getBossInRoom(room.getNumber());
        if (boss.getHealth() <= 0) {
            System.out.println("Game> The room is empty. " + boss.getName() + " is not here anymore.");
            return;
        }
        bossIntro(boss);
        player.goInFightWith(boss, player);
        if (boss.getHealth() <= 0) {
            bossDefeated(boss);
        }
    }

    private void bossIntro(Boss boss) {
        if (boss == Boss.frauStockroh) {
            say("Narrator", new String[]{"You open the door to the art studio.", "Frau Stockroh is standing in the middle of the room and plays the violin. Very, very badly.", "Her eyes are glowing red. She doesn't look like herself at all."});
            say("Frau Stockroh", new String[]{"Nobody leaves my lesson!"});
        } else if (boss == Boss.herLunke) {
            say("Narrator", new String[]{"The room is full of charts about the world economy.", "HerLunke turns around. His eyes are glowing red, just like the ones of Frau Stockroh."});
            say("HerLunke", new String[]{"Let's talk about social issues. For a very, very long time."});
        } else if (boss == Boss.frauBurger) {
            say("Narrator", new String[]{"It smells like burgers in here.", "Frau Burger is standing behind a counter and talks in a language you have never heard before."});
            say("Frau Burger", new String[]{"Krrbl blrrp... I mean: prepare yourself!"});
        } else if (boss == Boss.herrDamny) {
            say("Narrator", new String[]{"The laboratory is full of green smoke.", "Herr Damny is mixing strange liquids and is carrying a huge stack of papers."});
            say("Herr Damny", new String[]{"Here is your homework. All of it. For today!"});
        } else if (boss == Boss.derLoewe) {
            say("Narrator", new String[]{"You enter the Cave of the Lion.", "In the middle of the room there is a huge machine with the logo of the Schliemann-Heinrich-Gymnasium on it.", "In front of it stands Der Löwe."});
            say("Der Löwe", new String[]{"So you are the student who ruined my plan.", "Now I will show you some real maths!"});
        } else if (boss == Boss.herrKreuter) {
            say("Narrator", new String[]{"The server room is loud and warm.", "Herr Kreuter is sitting in front of a black screen full of strange code."});
            say("Herr Kreuter", new String[]{"You found the key? Impressive.", "Let's see if you understand assembly language."});
        }
    }

    //Story ----------------------------------------------------------------------------------------------------------------------------------------------------------------

    private void checkStory(Room room) {
        if (gameFinished) {
            return;
        }
        if (day == 1) {
            dayOneStory(room);
        } else if (day == 2) {
            dayTwoStory(room);
        } else if (day == 3) {
            dayThreeStory(room);
        } else if (day == 4) {
            dayFourStory(room);
        } else if (day == 5) {
            dayFiveStory(room);
        }
    }

    private void dayOneStory(Room room) {
        if (room.getNumber() == 14 && questStage == 0) {
            say("Frau Axt", new String[]{"Ah, there you are, " + player.getName() + "! I have been waiting for you.", "I have a big problem. Somebody took the 20 exams I wanted to give back today.", "Now they are spread all over the school.", "Can you find all of them and bring them back to me?"});
            say("Game", new String[]{"New quest: Find the 20 lost exams.", "In every room with loot there is a 50% chance to find 1 to 4 exams.", "When you have all 20, go back to Frau Axt in room 014."});
            questStage = 1;
        } else if (room.getNumber() == 14 && questStage == 2) {
            say("Frau Axt", new String[]{"Wow, you found all 20 exams! Thank you so much.", "Oh no, I am late for my next lesson. Bye!"});
            player.levelUp();
            say("Narrator", new String[]{"Frau Axt runs out of the room. While running, something falls out of her bag.", "It is a keycard for room 401...", "Did she drop it by accident?"});
            Character.inventory.addItem(Key.key401);
            say("Game", new String[]{"You got the Key for Room 401.", "Go to the third floor and use unlockRoom(401) to open the art studio."});
            questStage = 3;
        }
    }

    private void dayTwoStory(Room room) {
        if (room.getNumber() == 111 && questStage == 0) {
            say("Herr Neleleleleleson", new String[]{"Ah, " + player.getName() + "! Frau Axt told me about you.", "I have to do the yearly room inspection, but my knees hurt too much to walk.", "Every room has a stamp pad. Please collect a stamp from 8 different rooms on the first and second floor.", "Here is the stamp list."});
            say("Narrator", new String[]{"In the corner of the stamp list there is a small logo: 'SHG'. Strange..."});
            say("Game", new String[]{"New quest: Collect stamps from 8 different rooms on floor 1 and 2.", "When you have all 8, go back to Herr Neleleleleleson in room 111."});
            questStage = 1;
        } else if (room.getNumber() == 111 && questStage == 2) {
            say("Herr Neleleleleleson", new String[]{"All 8 stamps! Perfect, the inspection is done.", "Now excuse me, I have a very important meeting... with... someone."});
            player.levelUp();
            say("Narrator", new String[]{"Herr Neleleleleleson walks away. Behind him, a keycard falls on the floor.", "It's the keycard for room 110. Again an accident?"});
            Character.inventory.addItem(Key.key110);
            say("Game", new String[]{"You got the Key for Room 110.", "Go to the first floor and use unlockRoom(110)."});
            questStage = 3;
        } else if (questStage == 1 && room.getNumber() != 111 && (room.getFloor().getNumber() == 1 || room.getFloor().getNumber() == 2) && !questRooms.contains(room.getNumber())) {
            questRooms.add(room.getNumber());
            System.out.println("Game> You found the stamp pad and got a stamp for room " + room.getNumber() + "! (" + questRooms.size() + "/8)");
            if (questRooms.size() == 8) {
                System.out.println("Game> You have all 8 stamps! Go back to Herr Neleleleleleson in room 111.");
                questStage = 2;
            }
        }
    }

    private void dayThreeStory(Room room) {
        if (room.getNumber() == 203 && questStage == 0) {
            say("Frau Blumenstrauß", new String[]{"Oh, hello " + player.getName() + "! I really need your help.", "Somebody stole my 15 flowers! They were a present from the school next door.", "I think they are hidden in the science rooms and in the art and music rooms.", "Please bring them back to me!"});
            say("Game", new String[]{"New quest: Find 15 flowers.", "They can only be in science and art/music rooms. In every one of these rooms with loot there is a 50% chance to find 1 to 4 flowers.", "When you have all 15, go back to Frau Blumenstrauß in room 203."});
            questStage = 1;
        } else if (room.getNumber() == 203 && questStage == 2) {
            say("Frau Blumenstrauß", new String[]{"My beautiful flowers! Thank you, thank you, thank you!", "Oh, I have to water them right now. Excuse me."});
            player.levelUp();
            say("Narrator", new String[]{"While Frau Blumenstrauß is looking for her watering can, a keycard falls out of her pocket.", "It's the keycard for room 107. This can't be an accident anymore..."});
            Character.inventory.addItem(Key.key107);
            say("Game", new String[]{"You got the Key for Room 107.", "Go to the first floor and use unlockRoom(107)."});
            questStage = 3;
        }
    }

    private void dayFourStory(Room room) {
        if (questStage != 1) {
            return;
        }
        if (room.getNumber() != huntRooms[questProgress]) {
            if (random.nextInt(4) == 0) {
                System.out.println("Game> Somewhere you hear a quiet giggle... Wrong room!");
            }
            return;
        }
        questProgress++;
        if (questProgress == 1) {
            say("Note", new String[]{"Hihihi, you found my first note. Way too easy!", "Next one: Go where everybody has to go, no matter if boy or girl.", "It's a bit strange up there on the second floor. ~ ???"});
        } else if (questProgress == 2) {
            say("Note", new String[]{"Ewww, you really searched the toilet for a little note?", "Respect. Now climb even higher.", "Find the music room with the smallest number. ~ ???"});
        } else if (questProgress == 3) {
            say("Note", new String[]{"La la laaa! You are already halfway there.", "Here, a little present for you."});
            player.levelUp();
            say("Note", new String[]{"Now some maths: Take the number of this room and subtract 198. That's where the next note is. ~ ???"});
        } else if (questProgress == 4) {
            say("Note", new String[]{"Haha, did you really think I would be here?", "...", "Okay, I was. Last note: Go back to where your first day really began. ~ ???"});
        } else if (questProgress == 5) {
            say("Note", new String[]{"Okay, okay, you won. You are smarter than you look.", "Here is the key for room 207. Go there, if you dare.", "I'll be watching you. ~ S.H."});
            Character.inventory.addItem(Key.key207);
            say("Game", new String[]{"You got the Key for Room 207.", "Go to the second floor and use unlockRoom(207)."});
            questStage = 3;
        }
    }

    private void dayFiveStory(Room room) {
        if (questStage != 1) {
            return;
        }
        int number = room.getNumber();
        if ((number != 14 && number != 111 && number != 203) || questRooms.contains(number)) {
            return;
        }
        questRooms.add(number);
        if (number == 14) {
            say("Frau Axt", new String[]{"Exams... must... collect... exams..."});
            say("Narrator", new String[]{"Frau Axt is staring at the wall and doesn't react to you.", "On her desk you find a letter with the logo of the Schliemann-Heinrich-Gymnasium:", "'Plan: Control all teachers of the KKG. Then no student will want to come to the KKG anymore.'"});
        } else if (number == 111) {
            say("Herr Neleleleleleson", new String[]{"Stamps... more... stamps..."});
            say("Narrator", new String[]{"Next to him lies a strange remote control.", "On it is written: 'SHG Teacher Control 3000'."});
        } else if (number == 203) {
            say("Frau Blumenstrauß", new String[]{"My flowers... from the neighbours... so pretty..."});
            say("Narrator", new String[]{"Between the flowers you find a map of the KKG.", "Room 206 is circled in red. Next to it is written: 'Control center - Der Löwe'."});
        }
        System.out.println("Game> Clues found: " + questRooms.size() + "/3");

        if (questRooms.size() == 3) {
            say("Narrator", new String[]{"Now everything makes sense!", "The Schliemann-Heinrich-Gymnasium is controlling all teachers of the KKG, so that in the end no students are left in the school!", "And the control center is in room 206, the Cave of the Lion."});
            player.levelUp();
            say("Narrator", new String[]{"Under the last clue you also find a key. It's the Key for Room 206!"});
            Character.inventory.addItem(Key.key206);
            questStage = 3;
            say("Game", new String[]{"You got the Key for Room 206.", "Go to the second floor and use unlockRoom(206). This is the final fight!"});
        }
    }

    //exams on day 1 and flowers on day 3 can only be found in rooms that have loot
    private void findQuestItems(Room room) {
        if (questStage != 1) {
            return;
        }
        if (day == 1 && random.nextInt(2) == 0) {
            int found = Math.min(random.nextInt(4) + 1, 20 - questProgress);
            questProgress += found;
            System.out.println("Game> You found " + found + " lost exam(s)! (" + questProgress + "/20)");
            if (questProgress == 20) {
                System.out.println("Game> You have all 20 exams! Go back to Frau Axt in room 014.");
                questStage = 2;
            }
        } else if (day == 3 && (room.getSubject() == Subject.science || room.getSubject() == Subject.artmusic) && random.nextInt(2) == 0) {
            int found = Math.min(random.nextInt(4) + 1, 15 - questProgress);
            questProgress += found;
            System.out.println("Game> You found " + found + " flower(s)! (" + questProgress + "/15)");
            if (questProgress == 15) {
                System.out.println("Game> You have all 15 flowers! Go back to Frau Blumenstrauß in room 203.");
                questStage = 2;
            }
        }
    }

    private void bossDefeated(Boss boss) {
        if (boss == Boss.herrKreuter) {
            kreuterReward();
            return;
        }
        if (boss == Boss.derLoewe) {
            ending();
            return;
        }
        int firstWeapon = 0;
        if (boss == Boss.frauStockroh) {
            say("Frau Stockroh", new String[]{"Huh? Where am I? And why am I holding a violin?"});
            say("Narrator", new String[]{"Frau Stockroh looks like she just woke up from a bad dream. She doesn't remember anything."});
            firstWeapon = 0;
        } else if (boss == Boss.herLunke) {
            say("HerLunke", new String[]{"What... what happened? I was talking about the world economy and then... nothing."});
            firstWeapon = 2;
        } else if (boss == Boss.frauBurger) {
            say("Frau Burger", new String[]{"Oh! Sorry, did I talk weird? It felt like someone else was talking through me."});
            firstWeapon = 4;
        } else if (boss == Boss.herrDamny) {
            say("Herr Damny", new String[]{"The Schliemann... no... I can't remember..."});
            firstWeapon = 6;
        }
        Weapon[] subjectWeapons = Weapon.getSubjectWeapons(player.getSubject());
        Character.inventory.addWeapon(subjectWeapons[firstWeapon]);
        Character.inventory.addWeapon(subjectWeapons[firstWeapon + 1]);
        System.out.println("Game> You got two new " + player.getSubject().getName() + " weapons: " + subjectWeapons[firstWeapon].getName() + " and " + subjectWeapons[firstWeapon + 1].getName() + "!");
        player.levelUp();
        nextDay();
    }

    private void kreuterReward() {
        Weapon[] lastWeapons = {Weapon.proof, Weapon.shakespeare, Weapon.stasimethod, Weapon.relativity, Weapon.C418};
        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> methods = new ArrayList<>();
        for (Weapon weapon : lastWeapons) {
            if (weapon.getSubject() != player.getSubject()) {
                names.add(weapon.getName() + " (" + weapon.getSubject().getName() + ", Damage: " + weapon.getDamage() + ")");
                methods.add("takeKreuterReward(\"" + weapon.getName() + "\")");
            }
        }
        dialoge("Herr Kreuter", new String[]{"Not bad. Nobody has ever beaten me in assembly language.", "As a reward you can choose one of these weapons."}, true, "Which weapon do you want?", names.toArray(new String[0]), methods.toArray(new String[0]), false);
    }

    private void takeKreuterReward(String weaponName) {
        for (Weapon weapon : Weapon.getAllWeapons()) {
            if (weapon.getName().equals(weaponName)) {
                Character.inventory.addWeapon(weapon);
                System.out.println("Game> You got " + weapon.getName() + "!");
            }
        }
    }

    private void nextDay() {
        day++;
        questStage = 0;
        questProgress = 0;
        questRooms.clear();
        player.setCurrentRoom(null);
        player.setCurrentFloor(Floor.nul);
        player.setHealth(player.getMaxHealth());

        say("Narrator", new String[]{"You go home and fall into your bed. What a strange day...", "(Sleeping...)"});
        if (day == 2) {
            say("Game", new String[]{"Chapter 2 Tuesday - The inspection"});
            say("Narrator", new String[]{"The next morning you are back in school.", "Through the speakers you hear an announcement: '" + player.getName() + ", please come to Herr Neleleleleleson in room 111!'"});
        } else if (day == 3) {
            say("Game", new String[]{"Chapter 3 Wednesday - Flower power"});
            say("Narrator", new String[]{"The next morning you are back in school.", "Through the speakers you hear an announcement: '" + player.getName() + ", Frau Blumenstrauß needs your help in room 203!'"});
        } else if (day == 4) {
            say("Game", new String[]{"Chapter 4 Thursday - The hunt"});
            say("Narrator", new String[]{"When you arrive at school, there is a note stuck to the entrance door:"});
            say("Note", new String[]{"Roses are red, screens are blue, in the biggest computer room I'm waiting for you. ~ ???"});
            say("Narrator", new String[]{"Who wrote this? It seems like someone wants to play a game with you..."});
            say("Game", new String[]{"New quest: Follow the notes."});
            questStage = 1;
        } else if (day == 5) {
            say("Game", new String[]{"Chapter 5 Friday - The truth"});
            say("Narrator", new String[]{"On your way to school you see a group of students in Schliemann-Heinrich-Gymnasium hoodies coming out of the KKG.", "Why would students from the school next door be in your school this early?", "Then you remember the note from yesterday. It was signed with 'S.H.'...", "The teachers that gave you your tasks this week must know something."});
            say("Game", new String[]{"New quest: Find out what is going on. Visit Frau Axt (014), Herr Neleleleleleson (111) and Frau Blumenstrauß (203)."});
            questStage = 1;
        }
        say("Game", new String[]{"You are on the main floor. Use showStats() to see your quest."});
    }

    private void ending() {
        say("Der Löwe", new String[]{"Nooo! This can't be! The Schliemann-Heinrich-Gymnasium will come back..."});
        say("Narrator", new String[]{"The huge machine in the middle of the cave breaks into a thousand pieces.", "All over the school the teachers wake up. Frau Axt, Herr Neleleleleleson, Frau Blumenstrauß... they are all themselves again.", "Juhuu! You defeated the power of the Schliemann-Heinrich-Gymnasium and saved the Kollwitz-Käthe-Gymnasium!", "On Monday all students can come back to school. And nobody will ever know that it was you who saved it."});
        say("Game", new String[]{"THE END", "Thank you for playing KKGame!", "You can still explore the school. Maybe you will find the very rare key for room 005...", "Type exitgame to close the game."});
        gameFinished = true;
    }

    private String getDayName() {
        String[] dayNames = {"-", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        if (day >= 0 && day < dayNames.length) {
            return dayNames[day];
        }
        return "-";
    }

    private String getQuestText() {
        if (gameFinished) {
            return "You saved the school! You can still explore it.";
        }
        if (day == 1) {
            if (questStage == 0) {return "Go to room 014 on floor 0 and talk to Frau Axt.";}
            if (questStage == 1) {return "Find the 20 lost exams (" + questProgress + "/20).";}
            if (questStage == 2) {return "Bring the exams back to Frau Axt in room 014.";}
            return "Unlock room 401 on floor 3 and find out what is going on there.";
        } else if (day == 2) {
            if (questStage == 0) {return "Go to room 111 on floor 1 and talk to Herr Neleleleleleson.";}
            if (questStage == 1) {return "Collect stamps from 8 different rooms on floor 1 and 2 (" + questRooms.size() + "/8).";}
            if (questStage == 2) {return "Bring the stamp list back to Herr Neleleleleleson in room 111.";}
            return "Unlock room 110 on floor 1 and find out what is going on there.";
        } else if (day == 3) {
            if (questStage == 0) {return "Go to room 203 on floor 2 and talk to Frau Blumenstrauß.";}
            if (questStage == 1) {return "Find 15 flowers in science and art/music rooms (" + questProgress + "/15).";}
            if (questStage == 2) {return "Bring the flowers back to Frau Blumenstrauß in room 203.";}
            return "Unlock room 107 on floor 1 and find out what is going on there.";
        } else if (day == 4) {
            if (questStage == 1) {return "Follow the notes. Last hint: " + huntHints[questProgress];}
            return "Unlock room 207 on floor 2 and find out what is going on there.";
        } else if (day == 5) {
            if (questStage == 1) {return "Visit Frau Axt (014), Herr Neleleleleleson (111) and Frau Blumenstrauß (203) and find out what is going on (" + questRooms.size() + "/3).";}
            return "Unlock room 206 on floor 2 and defeat Der Löwe!";
        }
        return "-";
    }

    //Scanner Methods
    private void dialoge(String speaker, String[] texts, boolean isDecision, String decisionQuestion, String[] decisionText, String[] decisionMethods, boolean isTextInput) {
        for (String text : texts) {
            System.out.println(speaker + "> " + text);
            scanner.nextLine();
        }

        if (isTextInput) {

            System.out.println(speaker + "> " + decisionQuestion);
            tempTextInput = scanner.nextLine();
            if (decisionMethods.length > 0) {
                executeCommand(decisionMethods[0]);
            }
            return;
        }

        if (isDecision) {
            System.out.println(speaker + "> " + decisionQuestion);
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
    }

    //shorter version of dialoge() for texts without a question
    private void say(String speaker, String[] texts) {
        dialoge(speaker, texts, false, "", new String[]{}, new String[]{}, false);
    }

    //checks if the player is allowed to use the command before it is executed
    private void runPlayerCommand(String input) {
        if (input.isEmpty()) {
            return;
        }
        if (!input.contains("(") || !input.endsWith(")")) {
            System.out.println("Game> Commands need brackets, e.g. help() or enter(14).");
            return;
        }
        String commandName = input.substring(0, input.indexOf("(")).trim();
        boolean allowed = false;
        for (String command : allowedCommands) {
            if (command.equals(commandName)) {
                allowed = true;
            }
        }
        if (!allowed) {
            System.out.println("Game> Unknown command: " + commandName + "(). Type help() to see all commands.");
            return;
        }
        if (player == null && !commandName.equals("start") && !commandName.equals("help")) {
            System.out.println("Game> You need to start the game first. Type start()");
            return;
        }
        executeCommand(input);
    }

    private void executeCommand(String command) {
        try {
            int openParen = command.indexOf("(");
            int closeParen = command.lastIndexOf(")");
            if (openParen == -1 || closeParen == -1 || closeParen < openParen) {
                System.out.println("Invalid command: " + command);
                return;
            }
            String methodName = command
                    .substring(0, openParen)
                    .trim();

            String argsString = command
                    .substring(openParen + 1, closeParen)
                    .trim();

            String[] rawArgs = argsString.isEmpty()
                    ? new String[0] : argsString.split(",");
            Object[] convertedArgs = new Object[rawArgs.length];
            for (int i = 0; i < rawArgs.length; i++) {
                String arg = rawArgs[i].trim();
                if (arg.equals("tempTextInput")) {
                    convertedArgs[i] = tempTextInput;
                }
                else if (arg.startsWith("Subject.")) {
                    String fieldName = arg.substring("Subject.".length());
                    Field field = Subject.class.getDeclaredField(fieldName);
                    field.setAccessible(true);
                    convertedArgs[i] = field.get(null);
                }
                else if (arg.startsWith("\"") && arg.endsWith("\"")) {
                    convertedArgs[i] = arg.substring(1, arg.length() - 1);
                }
                else if (arg.equalsIgnoreCase("true")
                        || arg.equalsIgnoreCase("false")) {
                    convertedArgs[i] = Boolean.parseBoolean(arg);

                }
                else {
                    try {
                        convertedArgs[i] = Integer.parseInt(arg);
                    } catch (NumberFormatException e) {
                        convertedArgs[i] = arg;
                    }
                }
            }
            Method matchingMethod = null;
            for (Method method : Adventure.class.getDeclaredMethods()) {
                if (!method.getName().equals(methodName)) {
                    continue;
                }
                if (method.getParameterCount() != convertedArgs.length) {
                    continue;
                }
                Class<?>[] parameterTypes = method.getParameterTypes();
                boolean matches = true;
                for (int i = 0; i < parameterTypes.length; i++) {
                    Class<?> type = parameterTypes[i];
                    Object arg = convertedArgs[i];
                    if (arg == null) {
                        if (type.isPrimitive()) {
                            matches = false;
                            break;
                        }
                    } else if (type == int.class
                            && arg instanceof Integer) {
                    } else if (type == boolean.class
                            && arg instanceof Boolean) {
                    } else if (!type.isAssignableFrom(arg.getClass())) {
                        matches = false;
                        break;
                    }
                }
                if (matches) {
                    matchingMethod = method;
                    break;
                }
            }
            if (matchingMethod == null) {
                System.out.println("Game> Wrong input: " + command + ". Type help() to see how the commands work.");
                return;
            }
            matchingMethod.setAccessible(true);
            matchingMethod.invoke(this, convertedArgs);

        } catch (Exception e) {
            System.out.println("Error executing command: " + command);
            e.printStackTrace();
        }
    }

    private <T> T findObjectByNumber(Class<T> type, int number) {
        try {
            Method getNumber = type.getMethod("getNumber");

            for (Field field : type.getDeclaredFields()) {

                // Nur statische Objekte berücksichtigen
                if (!java.lang.reflect.Modifier.isStatic(
                        field.getModifiers())) {
                    continue;
                }

                if (!type.isAssignableFrom(field.getType())) {
                    continue;
                }

                field.setAccessible(true);

                // Statisches Objekt auslesen
                Object object = field.get(null);

                if (object == null) {
                    continue;
                }

                // Nummer des Objekts überprüfen
                int objectNumber = (int) getNumber.invoke(object);

                if (objectNumber == number) {
                    return type.cast(object);
                }
            }

        } catch (Exception e) {
            System.out.println("Error searching for object: " + e.getMessage());
        }

        return null;
    }

    public static void main(String[] args) {
        Adventure program = new Adventure();
        System.out.println("Welcome to our Text Adventure KKGame from Stefan, Jurij and Mats.");
        System.out.println("Type 'start()' to start the game.");
        System.out.println("Type 'help()' to see available commands.");
        System.out.println("Type 'exitgame' to exit the game.");
        System.out.println("NOTE: When you exit, your progress will not be saved.");
        System.out.println("Have fun and enjoy the game!");
        while (true) {
            System.out.print("\nKKGame> ");
            String input = program.scanner.nextLine().trim();
            if (input.equalsIgnoreCase("exitgame")) {
                System.out.println("Goodbye!");
                break;
            }
            program.runPlayerCommand(input);
        }
        program.scanner.close();
    }
}
