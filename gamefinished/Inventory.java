import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Inventory{
    private Weapon[] weaponSlots;
    private Key[] keySlots;
    private Book[] bookSlots;
    private Number[] numberSlots;
    private Potion[] potionSlots;

    public Inventory(Weapon[] newWeaponSlots, Key[] newKeySlots, Book[] newBookSlots, Number[] newNumberSlots, Potion[] newPotionSlots){
        weaponSlots = newWeaponSlots;
        keySlots = newKeySlots;
        bookSlots = newBookSlots;
        numberSlots = newNumberSlots;
        potionSlots = newPotionSlots;
    }

    public void setWeaponSlots(Weapon[] changedWeaponSlots){ weaponSlots = changedWeaponSlots; }

    public void setKeySlots(Key[] changedKeySlots){ keySlots = changedKeySlots; }

    public void setBookSlots(Book[] changedBookSlots){ bookSlots = changedBookSlots; }

    public void setPotionSlots(Potion[] changedPotionSlots){ potionSlots = changedPotionSlots; }

    public void setNumberSlots(Number[] changedNumberSlots){ numberSlots = changedNumberSlots; }

    public Weapon[] getWeaponSlots(){return weaponSlots; }

    public Key[] getKeySlots(){return keySlots; }

    public Book[] getBookSlots(){return bookSlots; }

    public Potion[] getPotionSlots(){return potionSlots; }

    public Number[] getNumberSlots(){return numberSlots; }

    //weapons and keys can only be found once, so found is set to true here and stays true
    public void addWeapon(Weapon weapon){
        weapon.setFound(true);
        weaponSlots = Arrays.copyOf(weaponSlots, weaponSlots.length + 1);
        weaponSlots[weaponSlots.length - 1] = weapon;
    }

    public void addItem(Item item) {
        if (item instanceof Book) {
            bookSlots = Arrays.copyOf(bookSlots, bookSlots.length + 1);
            bookSlots[bookSlots.length - 1] = (Book) item;
        } else if (item instanceof Potion) {
            potionSlots = Arrays.copyOf(potionSlots, potionSlots.length + 1);
            potionSlots[potionSlots.length - 1] = (Potion) item;
        } else if (item instanceof Number) {
            numberSlots = Arrays.copyOf(numberSlots, numberSlots.length + 1);
            numberSlots[numberSlots.length - 1] = (Number) item;
        } else if (item instanceof Key) {
            ((Key) item).setFound(true);
            keySlots = Arrays.copyOf(keySlots, keySlots.length + 1);
            keySlots[keySlots.length - 1] = (Key) item;
        }
    }

    public void showInv(){
        System.out.println("\n==============================================");
        System.out.println("                 INVENTORY");
        System.out.println("==============================================");
        System.out.println("Weapons:");
        boolean hasWeapon = false;
        for (Weapon weapon : weaponSlots) {
            if (weapon != null) {
                System.out.println(" - " + weapon.getName() + " (" + weapon.getSubject().getName() + ", Damage: " + weapon.getDamage() + ", Cooldown: " + weapon.getUseScore() + ")");
                hasWeapon = true;
            }
        }
        if (!hasWeapon) {
            System.out.println(" - nothing");
        }
        printItems("Keys", keySlots);
        printItems("Potions", potionSlots);
        printItems("Books", bookSlots);
        printItems("Numbers", numberSlots);
        System.out.println("==============================================");
    }

    private void printItems(String title, Item[] items) {
        System.out.println(title + ":");
        List<String> shownNames = new ArrayList<>();
        for (Item item : items) {
            if (item == null || shownNames.contains(item.getName())) {
                continue;
            }
            int amount = 0;
            for (Item otherItem : items) {
                if (otherItem != null && otherItem.getName().equals(item.getName())) {
                    amount++;
                }
            }
            shownNames.add(item.getName());
            System.out.println(" - " + item.getName() + " x" + amount + " (" + item.getDescription() + ")");
        }
        if (shownNames.isEmpty()) {
            System.out.println(" - nothing");
        }
    }

    public List<Item> getAllItems() {
        List<Item> items = new ArrayList<>();

        for (Book book : bookSlots) {
            if (book != null) {
                items.add(book);
            }
        }

        for (Potion potion : potionSlots) {
            if (potion != null) {
                items.add(potion);
            }
        }

        for (Number number : numberSlots) {
            if (number != null) {
                items.add(number);
            }
        }

        return items;
    }

    public void removeItem(Item item) {
        if (item instanceof Book) {
            for (int i = 0; i < bookSlots.length; i++) {
                if (bookSlots[i] != null
                        && bookSlots[i].getName().equals(item.getName())) {
                    bookSlots[i] = null;
                    return;
                }
            }
        }

        if (item instanceof Potion) {
            for (int i = 0; i < potionSlots.length; i++) {
                if (potionSlots[i] != null
                        && potionSlots[i].getName().equals(item.getName())) {
                    potionSlots[i] = null;
                    return;
                }
            }
        }

        if (item instanceof Number) {
            for (int i = 0; i < numberSlots.length; i++) {
                if (numberSlots[i] != null
                        && numberSlots[i].getName().equals(item.getName())) {
                    numberSlots[i] = null;
                    return;
                }
            }
        }

        if (item instanceof Key) {
            for (int i = 0; i < keySlots.length; i++) {
                if (keySlots[i] != null
                        && keySlots[i].getName().equals(item.getName())) {
                    keySlots[i] = null;
                    return;
                }
            }
        }
    }
}
