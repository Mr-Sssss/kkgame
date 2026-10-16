//This class is AI generated

import java.util.ArrayList;
import java.util.Random;

public class Loot {
    private static Random random = new Random();

    //the higher the rarity, the lower the chance. Rarity 6 is never in the loot
    private static int getChance(int rarity) {
        switch (rarity) {
            case 1: return 32;
            case 2: return 16;
            case 3: return 8;
            case 4: return 4;
            case 5: return 2;
            default: return 0;
        }
    }

    public static String getRarityName(int rarity) {
        switch (rarity) {
            case 1: return "common";
            case 2: return "uncommon";
            case 3: return "rare";
            case 4: return "epic";
            case 5: return "legendary";
            default: return "not findable";
        }
    }

    //only neutral weapons can be found, the subject weapons come from the bosses
    private static boolean canBeFound(Weapon weapon) {
        return weapon.getSubject() == Subject.neutral && !weapon.getFound() && getChance(weapon.getRarety()) > 0;
    }

    public static void lootRoom(Room room) {
        int amountToTake = room.getLootValue();
        if (amountToTake <= 0) {
            return;
        }
        ArrayList<Object> loot = createLoot(amountToTake * 3);
        if (loot.isEmpty()) {
            return;
        }

        System.out.println("\nGame> You look around in the room and find:");
        for (int i = 0; i < loot.size(); i++) {
            System.out.println((i + 1) + " = " + getLootText(loot.get(i)));
        }

        boolean[] alreadyTaken = new boolean[loot.size()];
        int taken = 0;
        while (taken < amountToTake) {
            System.out.println("Game> What do you want to take? (" + (amountToTake - taken) + " left, 0 = take nothing more)");
            int choice = Character.readDecision(0, loot.size());
            if (choice == 0) {
                break;
            }
            if (alreadyTaken[choice - 1]) {
                System.out.println("Game> You already took that.");
                continue;
            }
            alreadyTaken[choice - 1] = true;
            taken++;
            takeLoot(loot.get(choice - 1));
        }
    }

    private static ArrayList<Object> createLoot(int size) {
        ArrayList<Object> pool = new ArrayList<>();
        ArrayList<Integer> chances = new ArrayList<>();

        for (Weapon weapon : Weapon.getAllWeapons()) {
            if (canBeFound(weapon)) {
                pool.add(weapon);
                chances.add(getChance(weapon.getRarety()) / 2); //weapons are twice as rare as items
            }
        }
        for (Key key : Key.getAllKeys()) {
            if (!key.getFound() && getChance(key.getRarity()) > 0) {
                pool.add(key);
                chances.add(getChance(key.getRarity()));
            }
        }
        addItems(pool, chances, Potion.getAllPotions());
        addItems(pool, chances, Book.getAllBooks());
        addItems(pool, chances, Number.getAllNumbers());

        ArrayList<Object> loot = new ArrayList<>();
        while (loot.size() < size && !pool.isEmpty()) {
            int index = randomIndex(chances);
            Object thing = pool.get(index);
            loot.add(thing);
            //the same weapon or key can't be two times in one room
            if (thing instanceof Weapon || thing instanceof Key) {
                pool.remove(index);
                chances.remove(index);
            }
        }
        return loot;
    }

    private static void addItems(ArrayList<Object> pool, ArrayList<Integer> chances, Item[] items) {
        for (Item item : items) {
            if (getChance(item.getRarity()) > 0) {
                pool.add(item);
                chances.add(getChance(item.getRarity()));
            }
        }
    }

    private static int randomIndex(ArrayList<Integer> chances) {
        int total = 0;
        for (int chance : chances) {
            total += chance;
        }
        int number = random.nextInt(total);
        for (int i = 0; i < chances.size(); i++) {
            number -= chances.get(i);
            if (number < 0) {
                return i;
            }
        }
        return chances.size() - 1;
    }

    public static Weapon randomWeapon() {
        ArrayList<Weapon> weapons = new ArrayList<>();
        ArrayList<Integer> chances = new ArrayList<>();
        for (Weapon weapon : Weapon.getAllWeapons()) {
            if (canBeFound(weapon)) {
                weapons.add(weapon);
                chances.add(getChance(weapon.getRarety()));
            }
        }
        if (weapons.isEmpty()) {
            return null;
        }
        return weapons.get(randomIndex(chances));
    }

    private static void takeLoot(Object thing) {
        if (thing instanceof Weapon) {
            Weapon weapon = (Weapon) thing;
            Character.inventory.addWeapon(weapon);
            System.out.println("Game> You took the weapon " + weapon.getName() + ".");
        } else {
            Item item = (Item) thing;
            Character.inventory.addItem(item);
            System.out.println("Game> You took " + item.getName() + ".");
        }
    }

    private static String getLootText(Object thing) {
        if (thing instanceof Weapon) {
            Weapon weapon = (Weapon) thing;
            return "[Weapon] " + weapon.getName() + " - Damage: " + weapon.getDamage() + ", Cooldown: " + weapon.getUseScore() + " (" + getRarityName(weapon.getRarety()) + ")";
        }
        Item item = (Item) thing;
        String type = "Item";
        if (item instanceof Key) {
            type = "Key";
        } else if (item instanceof Potion) {
            type = "Potion";
        } else if (item instanceof Book) {
            type = "Book";
        } else if (item instanceof Number) {
            type = "Number";
        }
        return "[" + type + "] " + item.getName() + " - " + item.getDescription() + " (" + getRarityName(item.getRarity()) + ")";
    }
}
