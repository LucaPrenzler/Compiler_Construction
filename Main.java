import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static Boolean error = false;

    public static void main(String[] args) {
        LinkedList myList = new LinkedList();

        myList = ReadFile("input.txt", myList);
        new parser(myList, error);

    }

    public static void CheckFilename() {

        try {
            File file = new File("logs.txt"); // creates a new file instance
            FileReader fr = new FileReader(file); // reads the file
            BufferedReader br = new BufferedReader(fr); // creates a buffering character input stream
            StringBuffer sb = new StringBuffer(); // constructs a string buffer with no characters
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line); // appends line to string buffer
                sb.append("\n");
                String name = line.toString();
                // line feed
                if (name.toLowerCase().contains("ok") || name.toLowerCase().contains("accept")
                        || name.toLowerCase().contains("OK") || name.toLowerCase().equals("ACCEPT")) {

                } else if (name.toLowerCase().contains("error") || name.toLowerCase().contains("missing")
                        || name.toLowerCase().contains("reject") || name.toLowerCase().contains("invallid")
                        || name.toLowerCase().contains("incorrect")
                        || name.toLowerCase().contains("un_valued") || name.toLowerCase().contains("unvalued")
                        || name.toLowerCase().contains("un-valued") || name.toLowerCase().contains("value-less")
                        || name.toLowerCase().contains("illegal") || name.toLowerCase().contains("wrong")
                        || name.toLowerCase().contains("less") || name.toLowerCase().contains("missing")) {
                    error = true;
                }
            }
            fr.close(); // closes the stream and release the resources
            // returns a string that textually represents the object
        } catch (IOException e) {
            // e.printStackTrace();
        }

    }

    public static LinkedList ReadFile(String filename, LinkedList list) {
        String key = "";
        LinkedList myList = list;
        int tokenNum = 0;

        try {

            // Creates a FileInputStream
            FileInputStream file = new FileInputStream(filename);

            // Creates a BufferedInputStream
            BufferedInputStream input = new BufferedInputStream(file);

            // Reads first byte from file
            int i = input.read();

            States state = new States();
            while (i != -1) {
                char c = (char) i;

                // ;
                // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

                if (c == ' ' || c == '\n' || c == '\r' || c == '\t') {
                    // System.out.println("if");

                    if (state.currentState == States.State.SE || state.currentState == States.State.S27) {
                        tokenNum = tokenNum - 1;
                        System.out.println("Error found after T" + tokenNum + " ,the token that caused the error is: "
                                + key + getError(key));

                        key = "";
                        state.resetDFA();
                        state.numberOfChars = 0;
                        input.close();
                        return myList;
                    } else if (state.currentState == States.State.SS) {
                        tokenNum = tokenNum - 1;
                        System.out.println("Error found after T" + tokenNum + " ,the token that caused the error is: "
                                + key
                                + " short strings must be shorter than 8 characters long and enclosed in a double bracket. Tokens created before the error:");

                        key = "";
                        state.resetDFA();
                        state.numberOfChars = 0;
                        input.close();
                        return myList;
                    } else if (state.currentState == States.State.SA) {
                        // System.out.print("Input character : " +c+ " current state:
                        // "+state.currentState );
                        state.runThroughStates(state.currentState, c);
                        // System.out.println("after run " +state.currentState + " "+ c);
                        // System.out.println("\t" + "Transition State "+state.currentState );

                        key = key + c;

                    } else if (key != "") {
                        myList = myList.insert(myList, tokenNum++, calculateType(key), key);
                        key = "";
                        state.resetDFA();
                    }

                } else if (c == ',' || c == ';' || c == '{' || c == '}' || c == '(' || c == ')' || c == '=' || c == '<'
                        || c == '>') {
                    // System.out.println(c);
                    // System.out.print("Input character Here: " +c+ " current state:
                    // "+state.currentState );
                    // System.out.println("\t" + "Transition State Here "+state.currentState );
                    if (state.currentState == States.State.S9 || state.currentState == States.State.S10
                            || state.currentState == States.State.S34 || state.currentState == States.State.SA) {
                        // System.out.println(key);
                        // System.out.print("Input character : " +c+ " current state:
                        // "+state.currentState );

                        myList = myList.insert(myList, tokenNum++, calculateType(key), key);
                        key = "";
                        myList = myList.insert(myList, tokenNum++, calculateType(Character.toString(c)),
                                Character.toString(c));
                        state.resetDFA();

                    } else if (state.currentState == States.State.SE) {
                        tokenNum = tokenNum - 1;
                        System.out.println("Error found after T" + tokenNum + " ,the token that caused the error is: "
                                + key + getError(key));

                        key = "";
                        state.resetDFA();
                        input.close();
                        return myList;
                    } else if (state.currentState == States.State.SS) {
                        tokenNum = tokenNum - 1;
                        System.out.println("Error found after T" + tokenNum + " ,the token that caused the error is: "
                                + key
                                + " short strings must be shorter than 8 characters long and enclosed in a double bracket. Tokens created before the error: ");

                        key = "";
                        state.resetDFA();
                        state.numberOfChars = 0;
                        input.close();
                        return myList;
                    } else {
                        if (key != "") {
                            myList = myList.insert(myList, tokenNum++, calculateType(key), key);
                            key = "";
                            myList = myList.insert(myList, tokenNum++, calculateType(Character.toString(c)),
                                    Character.toString(c));
                            state.resetDFA();
                        } else {
                            myList = myList.insert(myList, tokenNum++, calculateType(Character.toString(c)),
                                    Character.toString(c));
                            state.resetDFA();

                        }

                    }

                } else {

                    state.runThroughStates(state.currentState, c);

                    key = key + c;

                    if (state.currentState == States.State.SE) {
                        tokenNum = tokenNum - 1;
                        System.out.println("Error found after T" + tokenNum + " ,the token that caused the error is: "
                                + key + getError(key));

                        key = "";
                        state.resetDFA();
                        input.close();
                        return myList;

                    } else if (state.currentState == States.State.SS) {
                        tokenNum = tokenNum - 1;
                        System.out.println("Error found after T" + tokenNum + " ,the token that caused the error is: "
                                + key
                                + " short strings must be shorter than 8 characters long and enclosed in a double bracket. Tokens created before the error: ");

                        key = "";

                        state.resetDFA();
                        state.numberOfChars = 0;
                        input.close();
                        return myList;
                    }

                }

                // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                // Reads next byte from the file
                i = input.read();
            }

            input.close();
        }

        catch (Exception e) {
            e.getStackTrace();
        }

        return myList;
    }

    public static String getError(String key) {
        if (key.matches("[A-Z]")) {
            return "  uppercase letters are not part of the aplhabet. Tokens created before the error: ";
        } else if (key.startsWith("0")) {
            return "  a number input can not start with leading zeros. Tokens created before the error: ";
        } else if (key.contains("0") || key.contains("1") || key.contains("2") || key.contains("3") || key.contains("4")
                || key.contains("5") || key.contains("6") || key.contains("7") || key.contains("8")
                || key.contains("9")) {
            return "  a user-defined variable can not start with a number. Tokens created before the error: ";
        } else {
            return "  symbol is not part of the aplphabet. Tokens created before the error: ";
        }

    }

    public static String calculateType(String key) {
        String type = "";
        if (key.matches("eq") || key.matches("<") || key.matches("<")) {
            type = "Comparison symbol ";
        } else if (key.matches("and") || key.matches("or") || key.matches("not")) {
            type = "Boolean operator ";
        } else if (key.matches("add") || key.matches("sub") || key.matches("mult")) {
            type = "Number operator ";
        } else if (key.compareTo("{") == 0 || key.equalsIgnoreCase("}") || key.equalsIgnoreCase(";")
                || key.equalsIgnoreCase("(") || key.equalsIgnoreCase(")") || key.equalsIgnoreCase(",")) {
            type = "Grouping symbol ";
        } else if (key.equalsIgnoreCase("=")) {
            type = "Assignment operator ";
        } else if (key.matches("if") || key.matches("then") || key.matches("else") || key.matches("while")
                || key.equalsIgnoreCase("for")) {
            type = "Control structure ";
        } else if (key.matches("input") || key.matches("output")) {
            type = "I/O command ";
        } else if (key.matches("halt")) {
            type = "Special command ";
        } else if (key.matches("proc")) {
            type = "Procedure definition ";
        } else if (key.startsWith("-") || key.startsWith("0") || key.startsWith("1") || key.startsWith("2")
                || key.startsWith("3") || key.startsWith("4") || key.startsWith("5") || key.startsWith("6")
                || key.startsWith("7") || key.startsWith("8") || key.startsWith("9")) {
            type = "Number";
        } else if (key.startsWith("a") || key.startsWith("b") || key.startsWith("c") || key.startsWith("d")
                || key.startsWith("e") || key.startsWith("f")
                || key.startsWith("g") || key.startsWith("h") || key.startsWith("i") || key.startsWith("j")
                || key.startsWith("k") || key.startsWith("l")
                || key.startsWith("m") || key.startsWith("n") || key.startsWith("o") || key.startsWith("p")
                || key.startsWith("q") || key.startsWith("r")
                || key.startsWith("s") || key.startsWith("t") || key.startsWith("u") || key.startsWith("v")
                || key.startsWith("w") || key.startsWith("x") || key.startsWith("y") || key.startsWith("z")) {
            type = "Variable";

        } else {
            type = "String";

        }

        return type;
    }

}