public static class Inventory{
    public int weaponSpace;
    public int itemSpace;
    public String[] weaponSlots;
    public String[] itemSlots;

    public Character(int newWeaponSpace, int newItemSpace, String[] newWeaponSlots, String[] newItemSlots){
        weaponSpace = newWeaponSlots;
        itemSpace = newItemSpace;
        weaponSlots = newWeaponSlots;
        itemSlots = newItemSlots;
    }

    private void changeDescription(String changedDescription){ description = changedDescription; }

    private void changeSubject(String changedSubject){ subject = changedSubject; }

    private void changeHealth(int changedHealth){ health = changedHealth; }

    private void changeLevel(int changedLevel){ level = changedLevel; }

    public void showInv(){

    }

    public void reSlot(String[] reslotet){

    }

    public void drop(){

    }

    Inventory inventory = new Inventory(2, 10, weaponSlots[""], itemSlots[""]);

}