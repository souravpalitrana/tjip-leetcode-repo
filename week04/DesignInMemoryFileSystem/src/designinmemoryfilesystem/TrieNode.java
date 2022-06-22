/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designinmemoryfilesystem;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author souravpalit
 */
public class TrieNode {
    
    public Map<String, TrieNode> directories = new HashMap<>();
    private String content = "";
    public boolean isFile;
    public String directoryName;
    
    public void addContent(String content) {
        this.content += content;
    }
    
    public String getContent() {
        return content;
    }
}
