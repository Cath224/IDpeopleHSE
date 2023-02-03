
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.time.*;
import java.time.format.DateTimeFormatter;



public class IDPersonTest {

    public static void main(String[] args) {

        System.out.println("Please, enter your name in format \"Name Patronymic LastName\": ");
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");
        String initials = "";

        System.out.println("What type of initials do u want?");
        System.out.println("1. I.O.F.\n2. I.O.Lastname");
        int answerType = scanner.nextInt();
        switch (answerType){
            case 1:
                IOF ( strings,initials);
                break;
            case 2:
                IOLastname ( strings,initials);
                break;
            default:
                System.out.println("Not found");
        }

        System.out.println("Enter your birth in format YYYY-MM-DD: ");
        String birth = scanner1.nextLine();
        dateBirth (birth);

    }


        private static void IOLastname (String[]strings, String initials){

        try {
            initials = strings[0].substring(0, 1) + strings[1].substring(0, 1);
            initials(initials);
            int initialsLen = initials.length();
            char str3 = strings[initialsLen].charAt(0);
            String str4 = "";
            int length = strings[initialsLen].length();
            for (int k = 1; k < length; k++) {
                str4 = str4 + strings[initialsLen].charAt(k);
            }
            System.out.println( Character.toUpperCase(str3) + str4.toLowerCase());
            biologicalSex (strings);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("You wrote not full name");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("You wrote an empty string");
        } catch (Exception e){
            System.out.println("Something went wrong");
    }

        }

        private static void IOF (String[]strings, String initials) {

            try {
                initials = strings[0].substring(0, 1) + strings[1].substring(0, 1) + strings[2].substring(0, 1);
                initials(initials);
                System.out.println(" ");
                biologicalSex(strings);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("You wrote not full name");
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("You wrote an empty string");
            } catch (Exception e){
                System.out.println("Something went wrong");
            }
        }


    private static void dateBirth (String birth){

        LocalDate nowDate = LocalDate.now();
        DateTimeFormatter formate = DateTimeFormatter.ofPattern("dd/MM/yyyy");

       try {
           LocalDate date = LocalDate.parse(birth);
           System.out.println("Your birth is  " + formate.format(date) +"\nAnd today is "+ formate.format(nowDate));
           Period age = Period.between(date, nowDate);
           System.out.println("Your age is " + age.getYears() + " years , " + age.getMonths() +
                    " months," + age.getDays() + " days");
        } catch (DateTimeParseException c) {
            System.out.println("You wrote incorrecly");
        }
   }

    private static void initials(String initials){
        System.out.print("Your initials : ");
        for (int j = 0; j < initials.length(); j++) {
            String str = " ";
            char character = initials.charAt(j);
            str = character + ".";
            System.out.print(str.toUpperCase());
        }
    }

    private static void biologicalSex (String[]strings) {
        char[] patronName = strings[1].toCharArray();
        if (patronName[patronName.length - 1] == 'a') {
            System.out.println("Your biological sex is W");
        } else {
            System.out.println("Your biological sex is M");
        }
    }

}