import java.util.Stack;
import java.util.stream.Collectors;

class Solution {
    public static boolean backspaceCompare(String s, String t) {
        String sWord = getCharacters(s);
        String tWord = getCharacters(t);

        return sWord.equals(tWord);
    }

    private static String getCharacters(String s) {
        Stack<Character> sStack = new Stack<>();
        char[] sCharArray = s.toCharArray();
        for (char c : sCharArray) {
            if (c == '#' && !sStack.isEmpty()) {
                sStack.pop();
            } else if (c != '#') {
                sStack.add(c);
            }
        }
        return sStack.stream().map(Object::toString).collect(Collectors.joining());
    }

    public static void main(String[] args) {

        boolean b = Solution.backspaceCompare("y#fo##f", "y#f#o##f");
        System.out.println(b);
    }
}