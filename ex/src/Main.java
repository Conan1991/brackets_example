import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static Character openBracket = '(';
    static Character closeBracket = ')';

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String lineNew = scanner.nextLine();
        char[] chars = lineNew.toCharArray();

        LinkedList<ValidBracket> result = new LinkedList<>();
        int counter = 0;
        for (char character : chars) {
            if (openBracket.equals(character)) {
                result.addLast(new ValidBracket(openBracket, false));
                counter++;
            } else if (closeBracket.equals(character) && !result.isEmpty() && counter > 0) {
                result.addLast(new ValidBracket(closeBracket, true));
                setFirstOpenBracketIsValid(result);
                counter--;
            }
        }

        long count = result.stream().filter(ValidBracket::getValid).count();
        if (count > 0) {
            System.out.print(count + " - ");
            result.stream()
                    .filter(ValidBracket::getValid)
                    .map(ValidBracket::getBracket)
                    .forEach(System.out::print);
        } else {
            System.out.println(count);
        }
    }

    private static void setFirstOpenBracketIsValid(LinkedList<ValidBracket> linkedList) {
        Iterator<ValidBracket> validBracketIterator = linkedList.descendingIterator();
        while (validBracketIterator.hasNext()) {
            ValidBracket next = validBracketIterator.next();
            if (!next.getValid()) {
                next.setValid(true);
                return;
            }
        }
    }

}