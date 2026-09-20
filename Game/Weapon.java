public static class Weapon{
    public String name;
    public String subject;
    public String description;
    public String level;
    public int damage;

    public Weapon(String newName, String newSubject, String newDescription, String newLevel, int newDamage){
        name = newName;
        subject = newSubject;
        teacher = newDescription;
        level = newLevel;
        damage = newDamage;
    }
    private void changeName (String changedName){ name = changedName;}

    private void changeDescription (String changedDescription){ name = changedDescription; }

    private void changeSubject (String changedSubject){ name = changedSubject; }

    private void changeLevel(int changedLevel) { level = changedLevel; }

    private void changeDamage (String changedDamage){ year = changedDamage;}

}