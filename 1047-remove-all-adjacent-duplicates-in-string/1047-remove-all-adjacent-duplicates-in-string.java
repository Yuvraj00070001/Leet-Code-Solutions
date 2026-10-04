class Solution {

    private boolean compareLetter(char alreadyPresent, char upcoming) {
        return alreadyPresent == upcoming;
    }

    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for (char letter : s.toCharArray()) {

            if (!stack.isEmpty() && compareLetter(stack.peek(), letter)) {
                stack.pop();
            } else {
                stack.push(letter);
            }
        }

        StringBuilder result = new StringBuilder();

        for (char c : stack) {
            result.append(c);
        }

        return result.toString();
    }
}