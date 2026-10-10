import java.lang.reflect.Method;
import java.util.Scanner;

public class Adventure {

    /* e
    =========
      START
    =========
    */

    public void buildMap(){

    }

    public void start() {
        dialoge("BASTARD", new String[]{"Hallo", "Wie gehts"}, true, "Bist du taub?", new String[]{"EINS", "ZASI", "ksdee"}, new String[]{"jmi", "nene", "1348902"});

    }



    public void help(){

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
                if (!input.contains("(") || !input.endsWith(")")) {
                    System.out.println("Error: Please use proper syntax like methodName(arg1, arg2)");
                    continue;
                }

                int openParen = input.indexOf("(");
                String methodName = input.substring(0, openParen).trim();

                String argsString = input.substring(openParen + 1, input.length() - 1).trim();
                
                String[] rawArgs = argsString.isEmpty() ? new String[0] : argsString.split(",");
                Object[] convertedArgs = new Object[rawArgs.length];

                for (int i = 0; i < rawArgs.length; i++) {
                    String arg = rawArgs[i].trim();
                    
                    if (arg.startsWith("\"") && arg.endsWith("\"")) {
    
                        convertedArgs[i] = arg.substring(1, arg.length() - 1);
                    } else if (arg.equalsIgnoreCase("true") || arg.equalsIgnoreCase("false")) {
    
                        convertedArgs[i] = Boolean.parseBoolean(arg);
                    } else {
    
                        try {
                            convertedArgs[i] = Integer.parseInt(arg);
                        } catch (NumberFormatException e) {
        
                            convertedArgs[i] = arg;
                        }
                    }
                }

                Method[] methods = Adventure.class.getDeclaredMethods();
                Method match = null;

                for (Method m : methods) {
                    if (m.getName().equals(methodName) && m.getParameterCount() == convertedArgs.length) {
                        match = m;
                        break;
                    }
                }

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

    private void dialoge(String speaker, String[] texts, boolean isDecision, String descisionQuestion, String[] decisionText, String[] decisionMethods) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < texts.length; i++) {
            System.out.println(speaker + ">" + " " + texts[i]);
            scanner.nextLine();
        }
        if (isDecision) {

            System.out.println(speaker + ">" + " " + descisionQuestion);

            for (int i = 0; i < decisionText.length; i++) {
                System.out.println((i + 1) + " = " + decisionText[i]);
            }

            int decision;

            while (true) {
                System.out.print("> ");
                String input = scanner.nextLine();

                try {
                    decision = Integer.parseInt(input);

                    if (decision >= 1 && decision <= decisionText.length) {
                        break;
                    }

                    System.out.println("Please choose a Number between 1 and " + decisionText.length + ".");

                } catch (NumberFormatException e) {
                    System.out.println("Please choose a Number between 1 and " + decisionText.length + ".");
                }
            }

            String methodName = decisionMethods[decision - 1];

            try {
                Method[] methods = Adventure.class.getDeclaredMethods();

                for (Method method : methods) {
                    if (method.getName().equals(methodName)
                            && method.getParameterCount() == 0) {

                        method.invoke(this);
                        return;
                    }
                }

                System.out.println("Method '" + methodName + "' not found.");

            } catch (Exception e) {
                System.out.println("Error executing this Method: " + e.getMessage());
            }
        }
    }  
}
