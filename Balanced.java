import java.util.Stack;
public class Balanced{
    public static void main(String[] args) {
        String[] str = {"({[]})","({[})", "((()))", "({)}"};
        for(String s: str)
            System.out.println(isBalanced(s));
    }
    public static boolean isBalanced(String s){
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if( ch=='{' || ch=='[' || ch=='(' ) {
                stack.push(ch);
            }
            else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()){
                    return false;
                }
                char lastChar=stack.pop();
                if (!isMatchingPair(lastChar, ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public static boolean isMatchingPair(char opener,char closer){
        boolean result = (opener=='(' && closer==')') || (opener=='{' && closer=='}') || (opener=='[' && closer==']');
        return result;
    }


}
