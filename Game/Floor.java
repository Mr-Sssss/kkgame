public class Floor{
    public int Number;
    public String Description;

    public Floor(String newDescription, int newNumber){
        description = newDescription;
        number = newNumber;
    }
    public void changeDescription(String changedDescription) {
        description = changedDescription;
    }
    
    public void changeNumber(int changedNumber) {
        number = changedNumber;
    }
}