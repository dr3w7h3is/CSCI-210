/**
 * InfixToPostfix Class
 *
 * @author Drew Theis
 * @date 9/27/2018
 */
public class InfixToPostfix {
    // Declares stack for use in constructor and method calls
    private ObjectStack stack;

    InfixToPostfix() {
        /**
         * Constructor
         * sets object stack for ObjectStack
         */
         stack = new ObjectStack();
    }
    /**
     * String infixToPostfix
     * used to parse through and check for operator and operands to create postfix expression
     * @return integer value of value for postStack
     */
    String infixToPostfix(String infixExp) {
        // Creates two objects postfixExp and noSpaceExp from StringBuilder to create postfix
        // expression hold operators
        StringBuilder postfixExp = new StringBuilder();
        StringBuilder noSpaceExp = new StringBuilder(infixExp);
        // Loop to remove spaces to allow for easier handling
        for (int i = 0; i < noSpaceExp.length(); i++) {
            if (noSpaceExp.charAt(i) == ' ') {
                noSpaceExp.deleteCharAt(i);
            }
        }
        // loop for length of noSpaceExp
        for (int i = 0; i < noSpaceExp.length(); i++) {
            char ch = noSpaceExp.charAt(i);
            String s = String.valueOf(ch);
            // If statements to creating order for postfix expression based on 6 rules
            // If var is an integer 0 - 9
            if (s.matches("[0-9]+") ) {
                postfixExp.append(ch);
            }
            // If char is (
            else if (s.matches("[(]")) {
                stack.push(ch);
            }
            // if operator is a value 3
            else if (priority(ch) == 3) {
                if (stack.isEmpty())
                    stack.push(ch);
                else {
                    char input = (char) stack.top();
                    while (!stack.isEmpty() && priority(input) > 2 && input != '(') {
                        postfixExp.append(stack.pop());
                        if (stack.isEmpty());
                        else {
                            input = (char) stack.top();
                        }
                    }
                    stack.push(ch);
                }
            }
            // if operator is a value 2
            else if (priority(ch) == 2) {
                if (stack.isEmpty())
                    stack.push(ch);
                else {
                    char input = (char) stack.top();
                    while (!stack.isEmpty() && priority(input) > 1 && input != '(') {
                        postfixExp.append(stack.pop());
                        if (stack.isEmpty());
                        else {
                            input = (char) stack.top();
                        }
                    }
                    stack.push(ch);
                }
            }
            // if operator is a value 1
            else if (priority(ch) == 1) {
                if (stack.isEmpty())
                    stack.push(ch);
                else {
                    char input = (char) stack.top();
                    while (!stack.isEmpty() && input != '(') {
                        postfixExp.append(stack.pop());
                        if (stack.isEmpty());
                        else {
                            input = (char) stack.top();
                        }
                    }
                    stack.push(ch);
                }
            }
            else if (s.matches("[)]")) {
                char input = (char) stack.top();
                while (!stack.isEmpty() && input != '(') {
                    postfixExp.append(stack.pop());
                    if (stack.isEmpty());
                    else {
                        input = (char) stack.top();
                    }
                }
                stack.pop();
            }
        }
        while (!stack.isEmpty()) {
            postfixExp.append(stack.pop());
        }
        addSpace(postfixExp);
        return postfixExp.toString();
    }
    /**
     * Integer priority
     * Method from book for the lab
     * @return an integer value of priority based on postfix rules
     */
    private int priority(char op) {
        switch (op) {
            case '^': return 3;
            case '*':
            case '/': return 2;
            case '+':
            case '-': return 1;
            default : return 0;
        }
    }
    /**
     * Method addSpace
     * @param exp is parsed to add a space between all characters
     */
    private void addSpace(StringBuilder exp) {
        for (int i = 0; i < exp.length(); i++) {
            if (i % 2 != 0) {
                exp.insert(i, ' ');
            }
        }
    }
}