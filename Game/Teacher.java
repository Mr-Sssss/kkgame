public class Teacher{
    private Subject subject;
    private int health;
    private int level;

    public Teacher(Subject newSubject, int newHealth, int newLevel){
        subject = newSubject;
        health = newHealth;
        level = newLevel;

    }

    public void setSubject(Subject changedSubject) {subject = changedSubject;}

    public void setHealth(int changedHealth) {
        health = changedHealth;
    }

    public void setLevel(int changedLevel) {
        level = changedLevel;
    }

    public Subject getSubject() {return subject;}

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

}
