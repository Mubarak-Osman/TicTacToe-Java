import java.util.Scanner;

public class TicTacToe {

    public static String[][] fields = new String [1][9];

    public static void main(String [] args) {

        boolean  won = false;

        int userInput;

        setup(fields);
        field(fields);
        System.out.println("Please enter a number from 1 to 9");

        char user = 'X';

        while (!won) {
            userInput = Integer.parseInt(turn());
           if(userInput != 0) {
            boolean value =   addValue(userInput, user);
               field(fields);
               winPosition(fields, user);
               drawPositions(fields);
               if(value == true) {
                   if (user =='X') {
                       user = '0';
                       System.out.println("its " + user +" turn");
                   } else {
                       user = 'X';
                       System.out.println("its " + user +" turn");
                   }
               }

           }
        }

    }

    public static String turn() {
        Scanner  input = new Scanner(System.in);
        String eingabe = input.next();
        int zahl;
        try{
             zahl = Integer.parseInt(eingabe);
            if(zahl > 9 || zahl < 1 ) {
                System.out.println("Whoops, enter a number between 1 and 9");
                field(fields);
                return "0";
            } else {
                return eingabe;
            }
        } catch (NumberFormatException ex) {
            System.out.println("Whoops, enter a number between 1 and 9");
            return "0";
        }

    }

    private static void field(String[][] fields) {
 /*
    if(fields[0][0].isEmpty()) {
            System.out.print("   | ");

        } else {
            System.out.print(" "+ fields[0][0] +" | ");
        }
        if(fields[0][1].isEmpty()) {
            System.out.print("   | ");

        } else {
            System.out.print("  "+ fields[0][1] +" | ");

        }
        if(fields[0][2].isEmpty()) {
            System.out.print("");
        } else {
            System.out.print(" "+ fields[0][2] +" | ");

        }
        System.out.println();
        System.out.println("---|---|---");

        if(fields[0][3].isEmpty()) {
            System.out.print("   | ");

        } else {
            System.out.print(" "+ fields[0][3] +" | ");

        }
        if(fields[0][4].isEmpty()) {
            System.out.print("   | ");
        } else {
            System.out.println(" "+ fields[0][4] +" | ");
        }
        if(fields[0][5].isEmpty()) {
            System.out.println("    ");
        } else {
            System.out.println(" "+ fields[0][5] +" | ");
        }
        System.out.println("---|---|---");

        if(fields[0][6].isEmpty()) {
            System.out.print("   | ");
        } else {
            System.out.print(" "+ fields[0][6] +" | ");
        }
        if(fields[0][7].isEmpty()) {
            System.out.print("   | ");
        } else {
            System.out.print(" "+ fields[0][7] +" | ");
        }
        if(fields[0][8].isEmpty()) {
            System.out.print("   ");
        } else {
            System.out.print(" "+ fields[0][8] +" | ");
        } */

        System.out.println(" "+ fields[0][0] +" | "+ fields[0][1]+" | "+ fields[0][2]+"");
        System.out.println("---|---|---");
        System.out.println(" "+ fields[0][3]+" | "+ fields[0][4]+" | "+ fields[0][5]+"");
        System.out.println("---|---|---");
        System.out.println(" "+ fields[0][6]+" | "+ fields[0][7]+" | "+ fields[0][8]+"");

    }


    private static void setup(String[][] fields) {
        fields[0][0] = "";
        fields[0][1] = "";
        fields[0][2] = "";
        fields[0][3] = "";
        fields[0][4] = "";
        fields[0][5] = "";
        fields[0][6] = "";
        fields[0][7] = "";
        fields[0][8] = "";
    }

    private static boolean addValue(int userInput, char user) {
        if (fields[0][userInput - 1].equals("")) {
           fields[0][userInput - 1] = String.valueOf(user);
           return true;
        } else {
            System.out.println("Sorry " + user + " This Field is already marked try unmarked field ");
            return false;
        }
    }


    public static boolean horizontalWinPositions(String[][] fields) {
            if(!fields[0][0].isEmpty() && fields[0][0].equals(fields[0][1])  && fields[0][1].equals(fields[0][2] )){
                return true;
            } else if (!fields[0][3].isEmpty() && fields[0][3].equals(fields[0][4])  && fields[0][4].equals(fields[0][5])) {
                return true;
            } else if (!fields[0][6].isEmpty() && fields[0][6].equals(fields[0][7])  && fields[0][7].equals(fields[0][8])){
                return true;
            }
        return false;
    }


    public static boolean verticalWinPositions(String[][] fields) {

        if(!fields[0][0].isEmpty() && fields[0][0].equals(fields[0][3]) && fields[0][3].equals(fields[0][6]) ){
            return true;
        } else if (!fields[0][1].isEmpty() && fields[0][1].equals(fields[0][4])   && fields[0][4].equals(fields[0][7])) {
            return true;
        } else if (!fields[0][2].isEmpty() && fields[0][2].equals(fields[0][6])   && fields[0][6].equals(fields[0][8])){
            return true;
        }
        return false;
    }

    public static boolean diagonalWinPositions(String[][] fields) {
        if(!fields[0][0].isEmpty() && fields[0][0].equals(fields[0][4]) && fields[0][4].equals(fields[0][8])){
            return true;
        } else if (!fields[0][2].isEmpty() && fields[0][2].equals(fields[0][4])   && fields[0][4].equals(fields[0][6])) {
            return true;
        }
        return false;
    }


    public static void drawPositions(String[][] fields) {

          if(!fields[0][1].isEmpty() && !fields[0][2].isEmpty() && !fields[0][3].isEmpty() && !fields[0][4].isEmpty()
                  && !fields[0][5].isEmpty() && !fields[0][6].isEmpty() && !fields[0][7].isEmpty() && !fields[0][8].isEmpty()
          && !diagonalWinPositions(fields) && !horizontalWinPositions(fields) && !verticalWinPositions(fields)) {
            System.out.println("Draw");
            System.exit(0);
        }
    }

    public static void winPosition(String[][] fields, char user) {
        if(horizontalWinPositions(fields) || diagonalWinPositions(fields) || verticalWinPositions(fields)) {
            System.out.println(user + " is the Winner");
            System.exit(0);
        }
    }

}





