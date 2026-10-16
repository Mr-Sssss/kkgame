public class Floor{
    private int number;
    private String description;

    public Floor(int newNumber, String newDescription){
        number =  newNumber;
        description = newDescription;
    }
    public void setDescription(String changedDescription) {
        description = changedDescription;
    }

    public void setNumber(int changedNumber) {
        number = changedNumber;
    }

    public String getDescription() {return description;}

    public int getNumber(){return number;}

    public static Floor nul = new Floor(0, "On the main floor you can find the school office, the teachers' room and the library. You can also find the stairs to the other floors here.");
    public static Floor one = new Floor(1, "On the first floor you can find mostly normal rooms. The most common are the language and music rooms.");
    public static Floor two = new Floor(2, "On the second floor you can find mostly subject-specific rooms, but also normal rooms.");
    public static Floor three = new Floor(3, "On the third floor you can find science rooms on one side and music/art rooms on the other side. Here you can also find the assembly hall and the art studio.");
}
