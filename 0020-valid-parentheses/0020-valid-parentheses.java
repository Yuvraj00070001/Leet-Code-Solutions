class Solution {
    private boolean compareOpenningAndClosing(char openningBracket, char closingBracket){
        return ((openningBracket=='('&&closingBracket==')') ||
        (openningBracket=='{'&&closingBracket=='}') ||
        (openningBracket=='['&&closingBracket==']'));

        
    }
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for(char singleBracket:s.toCharArray()){
            if(singleBracket=='('|| singleBracket=='{'|| singleBracket=='['){
                stack.push(singleBracket);
            }
            else if(!stack.isEmpty() && compareOpenningAndClosing(stack.peek(),singleBracket)){
                stack.pop();
            }
            else{
                return false;
            }
        }
        return stack.isEmpty();
        
    }
}