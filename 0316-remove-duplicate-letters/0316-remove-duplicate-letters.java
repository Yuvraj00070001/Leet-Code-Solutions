class Solution {
    public String removeDuplicateLetters(String s) {

        int[] count = new int[26];
        boolean[] visited = new boolean[26];

        // Count frequency
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            // Current character is now being processed
            count[c - 'a']--;

            // Already present in stack
            if (visited[c - 'a']) {
                continue;
            }

            // Remove larger characters if they appear again later
            while (!stack.isEmpty()
                    && stack.peek() > c
                    && count[stack.peek() - 'a'] > 0) {

                visited[stack.pop() - 'a'] = false;
            }

            stack.push(c);
            visited[c - 'a'] = true;
        }

        // Convert stack to String
        StringBuilder result = new StringBuilder();

        for (char c : stack) {
            result.append(c);
        }

        return result.toString();
    }
}