public class Inventory{
    private int weaponSpace;
    private int itemSpace;
    private Weapon[] weaponSlots;
    private Item[] itemSlots;

    public Inventory(int newWeaponSpace, int newItemSpace, Weapon[] newWeaponSlots, Item[] newItemSlots){
        weaponSpace = newWeaponSpace;
        itemSpace = newItemSpace;
        weaponSlots = newWeaponSlots;
        itemSlots = newItemSlots;
    }

    public void setWeaponSpace(int changedWeaponSpace){ weaponSpace = changedWeaponSpace; }

    public void setItemSpace(int changedItemSpace){ itemSpace = changedItemSpace; }

    public void setWeaponSlots(Weapon[] changedWeaponSlots){ weaponSlots = changedWeaponSlots; }

    public void setItemSlots(Item[] changedItemSlots){ itemSlots = changedItemSlots; }

    public int getWeaponSpace(){return weaponSpace; }

    public int getItemSpace(){return itemSpace; }

    public Weapon[] getWeaponSlots(){return weaponSlots; }

    public Item[] getItemSlots(){return itemSlots; }

    public void showInv(){

    }

    Inventory inventory = new Inventory(2, 10, new Weapon[]{}, new Item[]{});

}
