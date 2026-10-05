class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for(char letter1 : s.toCharArray()){
            if(letter1 == '#'){
                if(!stack1.isEmpty()){
                    stack1.pop();
                }
            }
            else{
                stack1.push(letter1);
            }
        }

        StringBuilder result1 = new StringBuilder();

        for(char c : stack1){
            result1.append(c);
        }

        for(char letter2 : t.toCharArray()){
            if(letter2 == '#'){
                if(!stack2.isEmpty()){
                    stack2.pop();
                }
            }
            else{
                stack2.push(letter2);
            }
        }

        StringBuilder result2 = new StringBuilder();

        for(char c : stack2){
            result2.append(c);
        }

        if(!result1.toString().equals(result2.toString())){
            return false;
        }

        return true;
    }
}