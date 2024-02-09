import java.util.Scanner;
import java.util.Set;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class TextAnalysis {

    public static void main (String[] args) {

        // Initialize Scanner
        Scanner scanner = new Scanner(System.in);


        // Intro
        System.out.println("TEXT ANALYSIS. \n\nWELCOME.");
        String text = getTextInputCI(scanner, "Insert text to be analyzed");


        // Count Characters
        StringBuilder message = new StringBuilder("\nAnalysis:\n\n");
        message.append("Character Count " + text.length() + "\n");


        // Count Words
        Integer wordCount = getWordCount(text);
        message.append("Word count: " + wordCount + "\n");


        // Find Most Common Character
        Character mostCommonChar = getMostCommonCharacter(text);
        message.append("Most Common Character: " + mostCommonChar + "\n");


        // Count Character Frequency
        Character character = getCharacterFromUser(scanner);
        Integer frequency = countCharacterFrequency(character, text);
        message.append("Frequency for character '" + character + "': " + frequency + " times.\n");


        // Get Word Frequency
        String word = getTextInputCI(scanner, "Insert a word to count the frequency:");
        frequency = countWordFrequency(word, text);
        message.append("Frequency for word '" + word + "': " + frequency + " times.\n");


        // Get Unique Words
        Integer unique = countUniqueWords(text);
        message.append("Unique words: " + unique + "\n");


        // Print Analysis
        System.out.println(message.toString());


        // Finish
        scanner.close();

    }


    public static String getTextInputCI(Scanner scanner, String message) {

        System.out.println(message);
        String text = scanner.nextLine();

        return text.toLowerCase();
    }


    public static Integer getWordCount(String text) {

        if (text.length() == 0) {
            return 0;
        }

        String[] wordList = text.split(" ");
        return wordList.length;
    }


    public static Character getMostCommonCharacter(String text) {

        // Create a HashMap to store character counts
        Map<Character, Integer> count = new HashMap<>();

        // Remove white spaces
        String textWithoutSpaces = text.replaceAll(" ", "");

        // Count every character occurence
        for(char c : textWithoutSpaces.toCharArray()) {

            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        Integer hightestCount = 0;
        Character mostCommonChar = ' ';

        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            if (entry.getValue() > hightestCount) {

                mostCommonChar = entry.getKey();
                hightestCount = entry.getValue();
            }
        }

        return mostCommonChar;
    }


    public static Character getCharacterFromUser(Scanner scanner) {

        Boolean isInvalid = true;
        String input;

        while (isInvalid) {

            input = getTextInputCI(scanner, "Insert a Character to count the frequency:");

                if (input.length() == 1) {

                    return input.charAt(0);
                }

                System.out.println("Insert a single character");

        }

        return '0';
    }


    public static Integer countCharacterFrequency(Character c, String text) {

        Integer count = 0;

        for (Character d : text.toCharArray()) {

            if (c == d) {

                count += 1;
            }
        }

        return count;
    }


    public static Integer countWordFrequency(String word, String text) {

        Integer count = 0;
        String[] wordList = text.split(" ");

        for (String item : wordList) {

            if (item.equals(word)) {

                count += 1;
            }
        }

        return count;
    }


    public static Integer countUniqueWords(String text) {

        Set<String> uniqueWords = new HashSet<>();

        for (String word : text.split(" ")) {

            uniqueWords.add(word);
        }

        return uniqueWords.size();
    }
}
