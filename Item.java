public class Item{
    public String name;
    public String subject;
    public boolean isWeapon;
    public int damage;
    public int level;
    
    public Item(String nameNeu, String subjectNeu, boolean isWeaponNeu, int damageNeu, int levelNeu){
        name = nameNeu;
        subject = subjectNeu;
        isWeapon = isWeaponNeu;
        damage = damageNeu;
        level = levelNeu;
    }
    
     private void changename(String changedname) {
        name = changedname;
    }

    private void changeSubject(String changedSubject) {
        subject = changedSubject;
    }

    private void changeIsWeapon(boolean changedIsWeapon) {
        isWeapon = changedIsWeapon;
    }

    private void changeDamage(int changedDamage) {
        damage = changedDamage;
    }

    private void changeLevel(int changedLevel) {
        level = changedLevel;
    }
   
}