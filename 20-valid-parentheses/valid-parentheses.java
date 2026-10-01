class Solution {
    public boolean isValid(String str) {
    Stack<Character> st = new Stack <>();
    for(int i = 0; i < str.length(); i++){
        char ch = str.charAt(i);
        if(ch == '(' || ch == '{' || ch == '['){
            st.push(ch);
        } else if(ch == ')'){
            boolean val = handleClosing(st, '(');
            if(val == false){
                return false;
            }
        } else if(ch == '}'){
            boolean val = handleClosing(st, '{');
            if(val == false){
                return false;
            }
        } else if(ch == ']'){
            boolean val = handleClosing(st, '[');
            if(val == false){
                return false ;
            }
        } 
    }
    if(st.size() == 0){
        return true;
    } else{
        return false;
    }
    }
    public static boolean handleClosing(Stack<Character> st,  char corresoc){
        if(st.size() == 0){
            return false;
        }else if(st.peek() != corresoc){
            return false;
        } else{
            st.pop();
            return true;
        }
    }
}