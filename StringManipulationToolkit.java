import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StringManipulationToolkit {

    static class Toolkit {
        String StringReversal(String strInput) {
            int intLength = strInput.length();
            String strReversed = "";

            for (int i = intLength - 1; i >= 0; i--) {
                strReversed += strInput.charAt(i);
            }

            return strReversed;
        }

        Boolean PalindromeChecker(String strInput) {
            strInput = strInput.replaceAll("\\s","");
            String strReversed = StringReversal(strInput);
            String strOriginal = strInput;

            return strReversed.equalsIgnoreCase(strOriginal);
        }

        Boolean AnagramChecker(String strFirstInput, String strSecondInput) {
            strFirstInput = strFirstInput.replaceAll("\\s", "").toLowerCase();
            strSecondInput = strSecondInput.replaceAll("\\s", "").toLowerCase();

            char[] arrFirstString = strFirstInput.toCharArray();
            char[] arrSecondString = strSecondInput.toCharArray();

            Arrays.sort(arrFirstString);
            Arrays.sort(arrSecondString);

            return Arrays.equals(arrFirstString, arrSecondString);
        }

        int WordCounter(String strInput) {
            if (strInput == null || strInput.trim().isEmpty()) {
                return 0;
            }

            String[] strWords = strInput.split("\\s+");
            return strWords.length;
        }

        int CharacterCounter(String strInput) {
            int intCounter = 0;
            int intLength = strInput.length();

            for (int i = 0; i <= intLength - 1; i++) {
                if (strInput.charAt(i) != ' ') {
                    intCounter++;
                }
            }
            return intCounter;
        }

        int SubstringFinder(String strInput, String subStr) {
            int intCount = 0;
            int index = strInput.indexOf(subStr);

            while (index != -1) {
                intCount++;

                index = strInput.indexOf(subStr, index + 1);
            }

            return intCount;
        }

        String UppercaseConverter(String strInput) {
            return strInput.toUpperCase();
        }

        String LowercaseConverter(String strInput) {
            return strInput.toLowerCase();
        }

        String VowelRemover(String strInput) {
            return strInput.replaceAll("[aeiouAEIOU]", "");
        }

        String ConsonantRemover(String strInput) {
            return strInput.replaceAll(
                    "[bcdfghjklmnpqrstvwxyxBCDFGHJKLMNPQRSTVWXYZ]", "");
        }

        void DisplayMenu() {
            System.out.println(
                    "|-------------------------------------------------------------|");
            System.out.println(
                    "|           STRING MANIPULATION TOOLKIT                       |");
            System.out.println(
                    "|-------------------------------------------------------------|");
            System.out.println(
                    "|  1. String Reversal        |  6. Substring Finder           |");
            System.out.println(
                    "|  2. Palindrome Checker     |  7. Lowercase Converter        |");
            System.out.println(
                    "|  3. Anagram Checker        |  8. Uppercase Converter        |");
            System.out.println(
                    "|  4. Word Counter           |  9. Vowel Remover              |");
            System.out.println(
                    "|  5. Character Counter      | 10. Consonant Remover          |");
            System.out.println(
                    "|-------------------------------------------------------------|");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int intChoice = 0;
        boolean boolValidity;
        String strInput;
        Toolkit tool = new Toolkit();

        tool.DisplayMenu();

        do {
            boolValidity = false;
            while (!boolValidity) {
                try {
                    System.out.print("Enter a choice from (1-10) only!: ");
                    intChoice = input.nextInt();
                    input.nextLine();
                    boolValidity = true;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter an integer only.");
                    input.nextLine();
                }
            }

            if (intChoice >= 1 && intChoice <= 10) {
                switch (intChoice) {
                    case 1 -> {
                        System.out.println("--- Welcome to String Reversal ---");
                        System.out.print("Enter a string consisting of 3 sentences: ");
                        strInput = input.nextLine();
                        System.out.println("Reversed String: " + tool.StringReversal(strInput));
                    }
                    case 2 -> {
                        System.out.println("--- Welcome to Palindrome Checker ---");
                        System.out.print("Enter a string consisting of 3 sentences: ");
                        strInput = input.nextLine();
                        if (!tool.PalindromeChecker(strInput)) {
                            System.out.println("'" + strInput + "' is NOT a Palindrome");
                        } else
                            System.out.println("'" + strInput + "' IS a Palindrome");
                    }
                    case 3 -> {
                        System.out.println("--- Welcome to Anagram Checker ---");
                        System.out.print("Enter First String consisting of 3 sentences: ");
                        String str1 = input.nextLine();
                        System.out.print("Enter Second String consisting of 3 sentences: ");
                        String str2 = input.nextLine();

                        if (tool.AnagramChecker(str1, str2)) {
                            System.out.println("The strings are anagrams!");
                        } else {
                            System.out.println("The strings are NOT anagrams.");
                        }
                    }
                    case 4 -> {
                        System.out.println("--- Welcome to Word Counter ---");
                        System.out.print("Enter a string consisting of 3 sentences: ");
                        strInput = input.nextLine();
                        System.out.println("Total Word Count: " + tool.WordCounter(strInput));
                    }
                    case 5 -> {
                        System.out.println("--- Welcome to Character Counter ---");
                        System.out.print("Enter a string consisting of 3 sentences: ");
                        strInput = input.nextLine();
                        System.out.println("Total Character Count: " + tool.CharacterCounter(strInput));
                    }
                    case 6 -> {
                        System.out.println("--- Welcome to Substring Finder ---");
                        System.out.print("Enter the main string consisting of 3 sentences: ");
                        strInput = input.nextLine();
                        System.out.print("Enter the substring to find: ");
                        String subStr = input.nextLine();

                        if (subStr.isEmpty()) {
                            System.out.println("Substring cannot be empty.");
                        } else {
                            System.out.println("Total occurrences found: " + tool.SubstringFinder(strInput, subStr));
                        }
                    }
                    case 7 -> {
                        System.out.println("--- Welcome to Lowercase Converter ---");
                        System.out.print("Enter a string consisting of 3 sentences: ");
                        strInput = input.nextLine();
                        System.out.println("Lowercase: " + tool.LowercaseConverter(strInput));
                    }
                    case 8 -> {
                        System.out.println("--- Welcome to Uppercase Converter ---");
                        System.out.print("Enter a string consisting of 3 sentences: ");
                        strInput = input.nextLine();
                        System.out.println("Uppercase: " + tool.UppercaseConverter(strInput));
                    }
                    case 9 -> {
                        System.out.println("--- Welcome to Vowel Remover ---");
                        System.out.print("Enter a string consisting of 3 sentences: ");
                        strInput = input.nextLine();
                        System.out.println("Vowels Removed: " + tool.VowelRemover(strInput));
                    }
                    case 10 -> {
                        System.out.println("--- Welcome to Consonant Remover ---");
                        System.out.print("Enter a string consisting of 3 sentences: ");
                        strInput = input.nextLine();
                        System.out.println("Consonants Removed: " + tool.ConsonantRemover(strInput));
                    }
                }
                System.out.println();
                tool.DisplayMenu();
            } else {
                System.out.println("Invalid Choice. Only 1-10 are accepted.");
                System.out.println();
            }

        } while (true);
    }
}