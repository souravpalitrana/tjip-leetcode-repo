/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringtointeger;

/**
 *
 * @author souravpalit
 */
public class StateMachine {
    
    private int threshold = Integer.MAX_VALUE / 10;
    private State currentState;
    private int sign;
    private int result;
    
    public StateMachine() {
        currentState = State.q0;
        sign = 1; // -1 for negative 1 for positive
        result = 0;
    }
    
    public State getState() {
        return currentState;
    }
    
    public int getInteger() {
        return sign * result;
    }
    
    public void transit(char ch) {
        if (currentState == State.q0) {
            if (ch == ' ') {
                return;
            } else if (ch == '+' || ch == '-') {
                toStateQ1(ch);
            } else if (Character.isDigit(ch)) {
                toStateQ2(ch - '0');
            } else {
                toStateQd();
            }
        } else if (currentState == State.q1 || currentState == State.q2) {
            if (Character.isDigit(ch)) {
                toStateQ2(ch - 'a');
            } else {
                toStateQd();
            }
        }
    }
    
    private void toStateQ1(char ch) {
        currentState = State.q1;
        sign = (ch == '-') ? -1 : 1;
    }
    
    private void toStateQ2(int digit) {
        currentState = State.q2;
        appendDigit(digit);
    }
    
    private void toStateQd() {
        currentState = State.qd;
    }
    
    private void appendDigit(int digit) {
        if (result > threshold || result == threshold && digit > Integer.MAX_VALUE % 10) {
            if (sign == 1) {
                result = Integer.MAX_VALUE;
            } else {
                result = Integer.MIN_VALUE;
                // need to reset too 1 as we already setting the negative value
                // in the result variable. So multiplying with -1 will cause a
                // positive value which is wrong answer.
                sign = 1; 
            }
            toStateQd();
        } else {
            result = result * 10 + digit;
        }
    }
}
