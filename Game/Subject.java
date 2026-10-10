public class Subject {
    private String description;
    private Subject strongAgainst;
    private Subject weakAgainst;

    public Subject(String newDescription, Subject newStrongAgainst, Subject newWeakAgainst){
        description = newDescription;
        strongAgainst = newStrongAgainst;
        weakAgainst = newWeakAgainst;
    }

    public void setDescription(String changedDescription) {
        description = changedDescription;
    }

    public String getDescription(){return description;}

    public Subject getStrongAgainst(){return strongAgainst;}

    public Subject getWeakAgainst(){return weakAgainst;}

    static Subject neutral = new Subject("This is the neutral Subject. Here nothing subject related is happening", Subject.neutral, Subject.neutral);
    static Subject maths = new Subject("This is the strongest subject, but also the hardest to master. It is strong against languages but weak against artmusic. This subject includes maths, computer-science and chess", Subject.languages, Subject.artmusic);
    static Subject languages = new Subject("This is a strong subject, but not the bes and weak against maths. It is strong against social but weak against maths. This subject includes german, english, spanish, french and latin", Subject.social, Subject.maths);
    static Subject social = new Subject("This is a neutral Subject. It is not super strong, but not that weak. It is strong against science but weak against languages. This subject includes History, Politics, Geography and ethiks", Subject.science, Subject.languages);
    static Subject science = new Subject("This is also an extremely strong subject, but it is neutral against other strong subjects. It is strong against artmusic but weak against social. This subject includes Biology, Chemistry and Physics", Subject.artmusic, Subject.social);
    static Subject artmusic = new Subject("This is a weak subject, but it is stronger than mats (the strongest subject). It is strong against maths but weak against science. This subject includes art, music and theater", Subject.maths, Subject.science);

}
