public class Inventory{
    private Weapon[] weaponSlots;
    private Key[] keySlots;
    private Book[] bookSlots;
    private Number[] numberSlots;

    public Inventory(Weapon[] newWeaponSlots, Key[] newKeySlots, Book[] newBookSlots, Number[] newNumberSlots){
        weaponSlots = newWeaponSlots;
        keySlots = newKeySlots;
        bookSlots = newBookSlots;
        numberSlots = newNumberSlots;
    }

    public void setWeaponSlots(Weapon[] changedWeaponSlots){ weaponSlots = changedWeaponSlots; }

    public void setKeySlots(Key[] changedKeySlots){ keySlots = changedKeySlots; }

    public void setBookSlots(Book[] changedBookSlots){ bookSlots = changedBookSlots; }

    public void setNumberSlots(Number[] changedNumberSlots){ numberSlots = changedNumberSlots; }

    public Weapon[] getWeaponSlots(){return weaponSlots; }

    public Key[] getKeySlots(){return keySlots; }

    public Book[] getBookSlots(){return bookSlots; }

    public Number[] getNumberSlots(){return numberSlots; }

    public void showInv(){

    }

}
