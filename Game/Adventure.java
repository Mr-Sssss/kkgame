import java.lang.reflect.Method;
import java.util.Scanner;

public class Adventure {

    /* 
    =========
      START
    =========
    */

    public void start() {
        System.out.println("");
    }

    /* 
    =========
       END
    =========
    */
    
    public static void main(String[] args) {
        Adventure program = new Adventure();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to our Text Adventure KKGame from Stefan, Jurij and Mats.");
        System.out.println("Type 'help()' to see what commands you can execute.");
        System.out.println("Type 'start()' to start the game.");
        System.out.println("Type 'exit' to quit.");

        while (true) {
            System.out.print("\nKKGame> ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye!");
                break;
            }

            try {
                // 1. Check if the format looks like a method call: methodName(...)
                if (!input.contains("(") || !input.endsWith(")")) {
                    System.out.println("Error: Please use proper syntax like methodName(arg1, arg2)");
                    continue;
                }

                // 2. Extract the method name
                int openParen = input.indexOf("(");
                String methodName = input.substring(0, openParen).trim();

                // 3. Extract the arguments string inside the parentheses
                String argsString = input.substring(openParen + 1, input.length() - 1).trim();
                
                // Separate arguments by commas (if any exist)
                String[] rawArgs = argsString.isEmpty() ? new String[0] : argsString.split(",");
                Object[] convertedArgs = new Object[rawArgs.length];

                // 4. Convert the text arguments into real Java types (int, String, etc.)
                for (int i = 0; i < rawArgs.length; i++) {
                    String arg = rawArgs[i].trim();
                    
                    if (arg.startsWith("\"") && arg.endsWith("\"")) {
                        // It's a String (remove the quotes)
                        convertedArgs[i] = arg.substring(1, arg.length() - 1);
                    } else if (arg.equalsIgnoreCase("true") || arg.equalsIgnoreCase("false")) {
                        // It's a Boolean
                        convertedArgs[i] = Boolean.parseBoolean(arg);
                    } else {
                        // Try to treat it as an Integer
                        try {
                            convertedArgs[i] = Integer.parseInt(arg);
                        } catch (NumberFormatException e) {
                            // Fallback to raw string if it's unquoted text
                            convertedArgs[i] = arg;
                        }
                    }
                }

                // 5. Use Reflection to look through this class for a matching method
                Method[] methods = Adventure.class.getDeclaredMethods();
                Method match = null;

                for (Method m : methods) {
                    if (m.getName().equals(methodName) && m.getParameterCount() == convertedArgs.length) {
                        match = m;
                        break;
                    }
                }

                // 6. If found, run it!
                if (match != null) {
                    match.invoke(program, convertedArgs);
                } else {
                    System.out.println("Error: No method found named '" + methodName + "' with " + convertedArgs.length + " parameters.");
                }

            } catch (Exception e) {
                System.out.println("Failed to run method: " + e.getMessage());
            }
        }
        
        scanner.close();
    }
}

