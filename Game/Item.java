public static class Item{
    public String name;
    public String subject;
    public int level;
    public static boolean inSight;

    public Item(String newName, String newSubject, boolean newIsWeapon, int NewDamage, int NewLevel, boolean newInSight){
        name = newName;
        subject = newSubject;
        isWeapon = newIsWeapon;
        damage = NewDamage;
        level = NewLevel;
        inSight = newInSight;
    }

    private void changeName(String changedName) { name = changedName; }

    private void changeSubject(String changedSubject) { subject = changedSubject; }

    private void changeIsWeapon(boolean changedIsWeapon) { isWeapon = changedIsWeapon; }

    private void changeDamage(int changedDamage) { damage = changedDamage; }

    private void changeLevel(int changedLevel) { level = changedLevel; }

    public void use(String name){
     
    }

}