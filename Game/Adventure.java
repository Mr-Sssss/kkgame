
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Adventure {
    //Temporary Attributes
    private String tempTextInput;
    private String tempCharacterName;
    private String tempCharacterSex;
    private String tempCharacterDescription;
    private Subject tempCharacterSubject;
    private boolean startonetimeuse = true;

    //temporary Methods
    public void setCharacterName(String name) {tempCharacterName = name;}
    public void setCharacterSex(String sex) {tempCharacterSex = sex;}
    public void setCharacterDescription(String description) {tempCharacterDescription = description;}
    public void setCharacterSubject(Subject subject) {tempCharacterSubject = subject;}


    private Character player;
    private final Scanner scanner = new Scanner(System.in);
    private int day = 0;

    //Main Methods:
    public void help() {
        System.out.println("The open world:");
        System.out.println(" - moveTo(FLOORNUMBER) (You can move from floor to floor, not when you are in a room. Floors: 0, 1, 2, 3)");
        System.out.println(" - enter(ROOMNUMBER) (You can enter a room. You can only enter rooms on the floor you are in. Some rooms have specific rules. Se the rules in the Room section)");
        System.out.println(" - exit() (Exit the Room you are in. Onyl usable, when you are in a room.)");
        System.out.println(" ");
        System.out.println("Inventory:");
        System.out.println(" - take(number) (When items are visible and pick upable, you can input this command and take an item from the list. It is only possible to take one item of this list. Some items take up  a specific inventory space!)");
        System.out.println(" - drop(number) (Drop a specific item from your inventory. Dropped items are NOT regainable. Story relevant items are not droppable, but also do not take any inventory space)");
        System.out.println(" - showInv() (Shows your inventory and how much space you have left)");
        System.out.println(" ");
        System.out.println("In dialoge mode:");
        System.out.println(" - When you are in a dialoge you can on the left, the person that is talking");
        System.out.println(" - To see the next sentence, just press enter");
        System.out.println(" - Sometimes you are asked to enter a specific thing or decide. When there is no question asked to enter something, there is also nothing to enter. Some decisions may change the storyline");
        System.out.println(" ");
        System.out.println("In combat:");
        System.out.println(" - The damage you can deal differs from the weapon you use, the subject you chose and the subject of your enemy, the level you have and that the enemy has and also some randomness.");
        System.out.println(" - When someone attacks you, you can either deal damage, heal or protect yourself.");
        System.out.println(" - There are 5 subject groups: Maths, Science, Languages, Social and Art/Music.");
        System.out.println(" - Maths is stronger then Languages, Languages is stronger then Social, Social is stronger then Science, Science is strongr then Art/Music, Art/Music is stronger then Maths");
        System.out.println(" ");
        System.out.println("Get Information");
        System.out.println(" - You can always get Information about every floor, room, item, weaponn, boss, ... with objectname.getInformation()");
        System.out.println(" - With classname.getObjectname() you can get the objectnames of the unlocked floors, rooms, items, ... you have (classnames: floor, room, item, weapon, boss, teacher, student, subject)");
    }

    public void start() {
        if (startonetimeuse) {
            dialoge("Narrator", new String[]{"It is the last day of summer vacation and you decide to check your email!", "A mail from your school pops up!", "Hello..."}, false, "Input your name:", new String[]{}, new String[]{"setCharacterName(tempTextInput)"}, true);
            dialoge("School", new String[]{"Hello " + tempCharacterName + ". This email got sent from the Kollwitz-Käthe-Gymnasium.", "It wants to inform you about the upcoming school year and the new teachers!", "Also because you are _______"}, true, "Choose your gender:", new String[]{"Male", "Female"}, new String[]{"setCharacterSex(\"Male\")", "setCharacterSex(\"Female\")"}, false);
            dialoge("School", new String[]{"Also because you are a " + tempCharacterSex + ", we wanted to tell you that there is a new unisex bathrooms on the second floor!", "This year, it would also be optimal if you chose one subject group to specialize in!"}, true, "Choose your subject group:", new String[]{"Maths","Science", "Languages", "Social", "Art and Music"}, new String[]{"setCharacterSubject(Subject.maths)", "setCharacterSubject(Subject.science)", "setCharacterSubject(Subject.languages)", "setCharacterSubject(Subject.social)", "setCharacterSubject(Subject.artmusic)"}, false);
            dialoge("School", new String[]{"Because you chose " + tempCharacterSubject.getName() + " as your subject group, you will be able to specialize in it!", "Now have fun this year at the KKG!", "Please also write a short description of yourself, it would help us very much"}, false, "Your description:", new String[]{}, new String[]{"setCharacterDescription(tempTextInput)"}, true);
            dialoge("School", new String[]{"Your School, the Kollwitz-Käthe-Gymnasium"}, false, "", new String[]{}, new String[]{}, false);
            dialoge("Narrator", new String[]{"You find this e-mail a little bit weird, but you don't think much of it.", "You go to sleep for the next day of school."}, false, "", new String[]{}, new String[]{}, false);
            dialoge("You", new String[]{"(Sleeping...)"}, false, "", new String[]{}, new String[]{}, false);
            dialoge("Game", new String[]{"Chapter 1 Monday - The beginning"}, false, "", new String[]{}, new String[]{}, false);
            dialoge("Narrator", new String[]{"You are now in school and you imediatly notice something is different.", "Nothing realy visiably noticable, but it just feels different"}, false, "", new String[]{}, new String[]{}, false);
            dialoge("Game", new String[]{"You are now in the open world mode", "Type help() to see how you can navigate in it.", "You are currantly in the main floor"}, false, "", new String[]{}, new String[]{}, false);
            startonetimeuse = !startonetimeuse;
        } else {
            System.out.println("Method not found: start()");
        }
        player = new Character(tempCharacterName, tempCharacterSex, tempCharacterDescription, tempCharacterSubject, 100, 1, null, null, Floor.nul);
    }

    public void nextDay(){
        if (day <= 5) {
            day++;
            //level of character + 1 (MAX LEvel 10)
        } else {
            System.out.println("The game has ended. You have completed all 5 days.");
        }
    }

    public void showMap(){
        
    }

    // Open World Methods

    public void moveTo(int floorNumber) {
        Floor floor = findObjectByNumber(Floor.class, floorNumber);
        if (floor == null) {
            System.out.println("Floor " + floorNumber + " does not exist.");
            return;
        }
        player.moveTo(floor);
    }

    public void enter(int roomNumber) {
        Room room = findObjectByNumber(Room.class, roomNumber);
        if (room == null) {
            System.out.println("Room " + roomNumber + " does not exist.");
            return;
        }
        player.enter(room);
    }
    public void exit() {
        player.exit();
    }

    //Scanner Methods
    private void dialoge(String speaker, String[] texts, boolean isDecision, String decisionQuestion, String[] decisionText, String[] decisionMethods, boolean isTextInput) {
        for (String text : texts) {
            System.out.println(speaker + "> " + text);
            scanner.nextLine();
        }

        if (isTextInput) {

            System.out.println(speaker + "> " + decisionQuestion);
            tempTextInput = scanner.nextLine();
            if (decisionMethods.length > 0) {
                executeCommand(decisionMethods[0]);
            }
            return;
        }

        if (isDecision) {
            System.out.println(speaker + "> " + decisionQuestion);
            for (int i = 0; i < decisionText.length; i++) {
                System.out.println((i + 1) + " = " + decisionText[i]);
            }
            int decision;

            while (true) {
                System.out.print("> ");
                try {
                    decision = Integer.parseInt(scanner.nextLine().trim());

                    if (decision >= 1 && decision <= decisionText.length) {
                        break;
                    }

                } catch (NumberFormatException e) {
                }
                System.out.println("Please choose a number between 1 and " + decisionText.length + ".");
            }
            if (decisionMethods.length >= decision) {
                executeCommand(decisionMethods[decision - 1]);
            } else {
                System.out.println("Error: No method call defined for this choice.");
            }
        }
    }

    private void executeCommand(String command) {
        try {
            int openParen = command.indexOf("(");
            int closeParen = command.lastIndexOf(")");
            if (openParen == -1 || closeParen == -1 || closeParen < openParen) {
                System.out.println("Invalid command: " + command);
                return;
            }
            String methodName = command
                    .substring(0, openParen)
                    .trim();

            String argsString = command
                    .substring(openParen + 1, closeParen)
                    .trim();

            String[] rawArgs = argsString.isEmpty()
                    ? new String[0] : argsString.split(",");
            Object[] convertedArgs = new Object[rawArgs.length];
            for (int i = 0; i < rawArgs.length; i++) {
                String arg = rawArgs[i].trim();
                if (arg.equals("tempTextInput")) {
                    convertedArgs[i] = tempTextInput;
                }
                else if (arg.startsWith("Subject.")) {
                    String fieldName = arg.substring("Subject.".length());
                    Field field = Subject.class.getDeclaredField(fieldName);
                    field.setAccessible(true);
                    convertedArgs[i] = field.get(null);
                }
                else if (arg.startsWith("\"") && arg.endsWith("\"")) {
                    convertedArgs[i] = arg.substring(1, arg.length() - 1);
                }
                else if (arg.equalsIgnoreCase("true")
                        || arg.equalsIgnoreCase("false")) {
                    convertedArgs[i] = Boolean.parseBoolean(arg);

                }
                else {
                    try {
                        convertedArgs[i] = Integer.parseInt(arg);
                    } catch (NumberFormatException e) {
                        convertedArgs[i] = arg;
                    }
                }
            }
            Method matchingMethod = null;
            for (Method method : Adventure.class.getDeclaredMethods()) {
                if (!method.getName().equals(methodName)) {
                    continue;
                }
                if (method.getParameterCount() != convertedArgs.length) {
                    continue;
                }
                Class<?>[] parameterTypes = method.getParameterTypes();
                boolean matches = true;
                for (int i = 0; i < parameterTypes.length; i++) {
                    Class<?> type = parameterTypes[i];
                    Object arg = convertedArgs[i];
                    if (arg == null) {
                        if (type.isPrimitive()) {
                            matches = false;
                            break;
                        }
                    } else if (type == int.class
                            && arg instanceof Integer) {
                    } else if (type == boolean.class
                            && arg instanceof Boolean) {
                    } else if (!type.isAssignableFrom(arg.getClass())) {
                        matches = false;
                        break;
                    }
                }
                if (matches) {
                    matchingMethod = method;
                    break;
                }
            }
            if (matchingMethod == null) {
                System.out.println("Method not found: " + command);
                return;
            }
            matchingMethod.setAccessible(true);
            matchingMethod.invoke(this, convertedArgs);

        } catch (Exception e) {
            System.out.println("Error executing command: " + command);
            e.printStackTrace();
        }
    }

    private <T> T findObjectByNumber(Class<T> type, int number) {
        try {
            Method getNumber = type.getMethod("getNumber");

            for (Field field : type.getDeclaredFields()) {

                // Nur statische Objekte berücksichtigen
                if (!java.lang.reflect.Modifier.isStatic(
                        field.getModifiers())) {
                    continue;
                }

                if (!type.isAssignableFrom(field.getType())) {
                    continue;
                }

                field.setAccessible(true);

                // Statisches Objekt auslesen
                Object object = field.get(null);

                if (object == null) {
                    continue;
                }

                // Nummer des Objekts überprüfen
                int objectNumber = (int) getNumber.invoke(object);

                if (objectNumber == number) {
                    return type.cast(object);
                }
            }

        } catch (Exception e) {
            System.out.println("Error searching for object: " + e.getMessage());
        }

        return null;
    }

    public static void main(String[] args) {
        Adventure program = new Adventure();
        System.out.println("Welcome to our Text Adventure KKGame from Stefan, Jurij and Mats.");
        System.out.println("Type 'start()' to start the game.");
        System.out.println("Type 'help()' to see available commands.");
        System.out.println("Type 'exitgame' to exit the game.");
        System.out.println("NOTE: When you exit, your progress will not be saved.");
        System.out.println("Have fun and enjoy the game!");
        while (true) {
            System.out.print("\nKKGame> ");
            String input = program.scanner.nextLine().trim();
            if (input.equalsIgnoreCase("exitgame")) {
                System.out.println("Goodbye!");
                break;
            }
            program.executeCommand(input);
        }
        program.scanner.close();
    }
}
