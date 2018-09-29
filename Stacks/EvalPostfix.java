/**
 * EvalPostfix Class
 *
 * @author Drew Theis
 * @date 9/27/2018
 */
public class EvalPostfix {
    /**
     * Integer evaluate
     * Has postFixExp string passed and used for StringBuilder applied to noSpaceExp
     * removing the spaces allow for easier handling
     * @return integer value of value for postStack
     */
    int evaluate(String postFixExp) {
        // postStack is new object for ObjectStack which will have operands
        ObjectStack postStack = new ObjectStack();
        // noSpaceExp object is the postFixExp to have no spaces
        StringBuilder noSpaceExp = new StringBuilder(postFixExp);
        // Declares answer and set to 0
        int answer = 0;
        // loop to parse through StringBuilder and remove spaces
        for (int i = 0; i < noSpaceExp.length(); i++) {
            if (noSpaceExp.charAt(i) == ' ') {
                noSpaceExp.deleteCharAt(i);
            }
        }
        // loop for handling char value and solve for answer
        for (int i = 0; i < noSpaceExp.length(); i++) {
            char ch = noSpaceExp.charAt(i);
            // IF statements look for and separate operators and operands for solution
            if (ch >= '0' && ch <= '9')
                postStack.push(ch - '0');
            else {
                int val2 = (int) postStack.pop();
                int val1 = (int) postStack.pop();
                if (ch == '+') {
                    answer = val1 + val2;
                }
                else if (ch == '-') {
                    answer = val1 - val2;
                }
                else if (ch == '*') {
                    answer = val1 * val2;
                }
                else if (ch == '/') {
                    answer = val1 / val2;
                }
                else if (ch == '^') {
                    answer = (int) Math.pow(val1, val2);
                }
                postStack.push(answer);
            }
        }
        return (int) postStack.pop();
    }
}