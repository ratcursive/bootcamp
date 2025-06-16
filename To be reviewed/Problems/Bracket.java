public class Bracket{
    public static void main(String[] args) {
        System.out.println(checkBrackets("skldsklaskl;sa{}{()}"));
    }
    public static boolean checkBrackets(String word){
        Stack bracketStack = new Stack(word.length()+1);
        bracketStack.push(2);
        char currentBracketType = '0';
        for(int i = 0; i < word.length(); i++){
            if (isBracket(word.charAt(i))) {
                if(!checkBracketType(currentBracketType, (word.charAt(i)))){
                    if(bracketStack.size() == 1){
                        currentBracketType = word.charAt(i);
                    }
                }
                if(isOpeningBracket(word.charAt(i))){
                    bracketStack.push(1);
                }
                else
                bracketStack.pop();
            }
        }
        return bracketStack.size() == 1;
    }
    private static boolean isBracket(char bracket){
        return (isOpeningBracket(bracket) || bracket == '}' || bracket == ')' || bracket == ']');
    }
    private static boolean isOpeningBracket(char bracket){
        return bracket == '{' || bracket == '(' || bracket == '[';
    }
    private static boolean checkBracketType(char type, char bracket){
        if(type =='{'){
            if(bracket == '{' || bracket == '}')
            return true;
        }
        if(type =='('){
            if(bracket == '(' || bracket == ')')
            return true;
        }
        if(type =='['){
            if(bracket == '[' || bracket == ']')
            return true;
        }
        return false;
    }
}