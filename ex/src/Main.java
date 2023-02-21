import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Character openBracket = '(';
    static Character closeBracket = ')';

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String lineNew = scanner.nextLine();
        char[] chars = lineNew.toCharArray();
        long startTime = System.nanoTime();


        List<Character> result = new ArrayList<>();
        LinkedList<Integer> openBracketPositions = new LinkedList<>();
        int openBracketCounter = 0;
        int positionCounter = 0;
        for (char character : chars) {
            if (openBracket.equals(character)) {
                result.add(character);
                openBracketCounter++;
                openBracketPositions.add(positionCounter);
                positionCounter++;
            } else if (closeBracket.equals(character) && !result.isEmpty() && openBracketCounter > 0) {
                result.add(character);
                openBracketCounter--;
                positionCounter++;
                if (!openBracketPositions.isEmpty()) {
                    openBracketPositions.removeLast();
                }
            }
        }
        removeNonValidOpenBrackets(result, openBracketPositions, openBracketCounter);

        long count = result.size();
        if (count > 0) {
            System.out.print(count + " - ");
            result.forEach(System.out::print);
        } else {
            System.out.println(count);
        }

        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println();
        System.out.print(totalTime / 1000000);
    }

    private static void removeNonValidOpenBrackets(List<Character> linkedList, LinkedList<Integer> positions, int openBracketsCounter) {
        while (openBracketsCounter > 0) {
            if (!positions.isEmpty()) {
                linkedList.remove(positions.getFirst().intValue());
            }
            openBracketsCounter--;
        }
    }
}