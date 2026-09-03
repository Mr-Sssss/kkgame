public class Attack{
    public String name;
    public String subject;
    public String teacher;
    public int damage;
    
    public Student(String nameNeu, String subjectNeu, String teacherNeu, int damageNeu){
        name = nameNeu;
        subject = subjectNeu;
        teacher = teacherNeu;
        damage = damageNeu;
    }
    private void changename(String changedname) {
        name = changedname;
    }

    private void changeSubject(String changedSubject) {
        subject = changedSubject;
    }

    private void changeteacher(boolean changedteacher) {
        isWeapon = changedteacher;
    }

    private void changeDamage(int changedDamage) {
        damage = changedDamage;
    }
}
