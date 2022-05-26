/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designinmemoryfilesystem;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author souravpalit
 */
class FileSystem {

    Trie trie;
    
    public FileSystem() {
        trie = new Trie();;
    }
    
    public List<String> ls(String path) {
        return trie.getDirectories(path);
    }
    
    public void mkdir(String path) {
        trie.mkdir(path);
    }
    
    public void addContentToFile(String filePath, String content) {
        trie.addContentToFile(filePath, content);
    }
    
    public String readContentFromFile(String filePath) {
        return trie.readContentFromFile(filePath);
    }
}
