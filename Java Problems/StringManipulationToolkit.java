import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StringManipulationToolkit {
  static class Toolkit {
    String StringReversal(String strInput1) {
      int intLength = strInput1.length();
      String strReversed = "";

      for (int i = intLength - 1; i >= 0; i--) {
        strReversed += strInput1.charAt(i);
      }

      return strReversed;
    }

    Boolean PalindromeChecker(String strInput1) {
      strInput1 = strInput1.replaceAll("[^a-zA-Z0-9]", "");
      String strReversed = StringReversal(strInput1);
      String strOriginal = strInput1;

      return strReversed.equalsIgnoreCase(strOriginal);
    }

    Boolean AnagramChecker(String strInput1, String strInput2) {
      strInput1 = strInput1.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
      strInput2 = strInput2.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

      char[] arrFirstString = strInput1.toCharArray();
      char[] arrSecondString = strInput2.toCharArray();

      Arrays.sort(arrFirstString);
      Arrays.sort(arrSecondString);

      return Arrays.equals(arrFirstString, arrSecondString);
    }

    int WordCounter(String strInput1) {
      if (strInput1 == null) {
        return 0;
      }

      strInput1 = strInput1.replaceAll("[^a-zA-Z0-9]", " ");

      strInput1 = strInput1.trim();

      if (strInput1.isEmpty()) {
        return 0;
      }

      String[] strWords = strInput1.split("\\s+");

      return strWords.length;
    }

    int CharacterCounter(String strInput1) {
      int intCounter = 0;
      int intLength = strInput1.length();

      for (int i = 0; i <= intLength - 1; i++) {
        if (strInput1.charAt(i) != ' ') {
          intCounter++;
        }
      }
      return intCounter;
    }

    int SubstringFinder(String strInput1, String strInput2) {
      if (strInput2 == null || strInput2.isEmpty()) {
        return 0;
      }

      int intCount = 0;
      int index = strInput1.indexOf(strInput2);

      while (index != -1) {
        intCount++;

        index = strInput1.indexOf(strInput2, index + strInput2.length());
      }

      return intCount;
    }

    String UppercaseConverter(String strInput1) {
      return strInput1.toUpperCase();
    }

    String LowercaseConverter(String strInput1) {
      return strInput1.toLowerCase();
    }

    String VowelRemover(String strInput1) {
      return strInput1.replaceAll("[aeiouAEIOU]", "");
    }

    String ConsonantRemover(String strInput1) {
      return strInput1.replaceAll(
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

    String strInput1;
    String strInput2;

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
            strInput1 = input.nextLine();
            System.out.println("Reversed String: " + tool.StringReversal(strInput1));
          }
          case 2 -> {
            System.out.println("--- Welcome to Palindrome Checker ---");
            System.out.print("Enter a string consisting of 3 sentences: ");
            strInput1 = input.nextLine();
            if (!tool.PalindromeChecker(strInput1)) {
              System.out.println("'" + strInput1 + "' is NOT a Palindrome");
            } else
              System.out.println("'" + strInput1 + "' IS a Palindrome");
          }
          case 3 -> {
            System.out.println("--- Welcome to Anagram Checker ---");
            System.out.print("Enter First String consisting of 3 sentences: ");
            strInput1 = input.nextLine(); 
            System.out.print("Enter Second String consisting of 3 sentences: ");
            strInput2 = input.nextLine(); 

            if (tool.AnagramChecker(strInput1, strInput2)) {
              System.out.println("The strings are anagrams!");
            } else {
              System.out.println("The strings are NOT anagrams.");
            }
          }
          case 4 -> {
            System.out.println("--- Welcome to Word Counter ---");
            System.out.print("Enter a string consisting of 3 sentences: ");
            strInput1 = input.nextLine();
            System.out.println("Total Word Count: " + tool.WordCounter(strInput1));
          }
          case 5 -> {
            System.out.println("--- Welcome to Character Counter ---");
            System.out.print("Enter a string consisting of 3 sentences: ");
            strInput1 = input.nextLine();
            System.out.println("Total Character Count: " + tool.CharacterCounter(strInput1));
          }
          case 6 -> {
            System.out.println("--- Welcome to Substring Finder ---");
            System.out.print("Enter the main string consisting of 3 sentences: ");
            strInput1 = input.nextLine(); 
            System.out.print("Enter the substring to find: ");
            strInput2 = input.nextLine(); 

            if (strInput2.isEmpty()) {
              System.out.println("Substring cannot be empty.");
            } else {
              System.out.println("Total occurrences found: " + tool.SubstringFinder(strInput1, strInput2));
            }
          }
          case 7 -> {
            System.out.println("--- Welcome to Lowercase Converter ---");
            System.out.print("Enter a string consisting of 3 sentences: ");
            strInput1 = input.nextLine();
            System.out.println("Lowercase: " + tool.LowercaseConverter(strInput1));
          }
          case 8 -> {
            System.out.println("--- Welcome to Uppercase Converter ---");
            System.out.print("Enter a string consisting of 3 sentences: ");
            strInput1 = input.nextLine();
            System.out.println("Uppercase: " + tool.UppercaseConverter(strInput1));
          }
          case 9 -> {
            System.out.println("--- Welcome to Vowel Remover ---");
            System.out.print("Enter a string consisting of 3 sentences: ");
            strInput1 = input.nextLine();
            System.out.println("Vowels Removed: " + tool.VowelRemover(strInput1));
          }
          case 10 -> {
            System.out.println("--- Welcome to Consonant Remover ---");
            System.out.print("Enter a string consisting of 3 sentences: ");
            strInput1 = input.nextLine();
            System.out.println("Consonants Removed: " + tool.ConsonantRemover(strInput1));
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