public static class Weapon{
    public String name;
    public String subject;
    public String description;
    public int damage;

    public Attack(String newName, String newSubject, String newDescription, int newDamage){
        name = newName;
        subject = newSubject;
        teacher = newDescription;
        damage = newDamage;
    }
    private void changeName (String changedName){ name = changedName;}

    private void changeDamage (String changedDamage){ year = changedDamage;}

    private void changeSubject (String changedSubject){ name = changedSubject; }

    private void changeDescription (String changedDescription){ name = changedDescription; }

}