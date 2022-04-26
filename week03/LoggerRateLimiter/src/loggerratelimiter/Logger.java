/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loggerratelimiter;

import java.util.HashMap;

/**
 *
 * @author souravpalit
 */
public class Logger {

    private HashMap<String, Integer> messageQueue;
    
    public Logger() {
        messageQueue = new HashMap<String, Integer>();
    }
    
    // Time Complexity: O(1)
    // Space Complexity: O(N) where n is the size of incoming messages
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (messageQueue.containsKey(message)) {
            if (timestamp >= messageQueue.get(message)) {
                messageQueue.put(message, timestamp + 10);
                return true;
            } else {
                return false;
            }
        } else {
            messageQueue.put(message, timestamp + 10);
            return true;
        }
    }
}
