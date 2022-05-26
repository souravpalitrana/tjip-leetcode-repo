/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designinmemoryfilesystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


/**
 *
 * @author souravpalit
 */
class Trie {

    private TrieNode root = new TrieNode();
    
    public void mkdir(String path) {
        createDirectoryOrUpdateFile(path, null);
    }
    
    public void addContentToFile(String path, String content) {
        createDirectoryOrUpdateFile(path, content);
    }
    
    public String readContentFromFile(String path) {
        TrieNode currentNode = root;
        StringTokenizer tokenizer = new StringTokenizer(path, "/");
        
        while (tokenizer.hasMoreTokens()) {
            String directory = tokenizer.nextToken();;
            currentNode = currentNode.directories.get(directory);
        }
        
        return currentNode.getContent();
    }
    
    public List<String> getDirectories(String path) {
        List<String> directories = new ArrayList<String>();
        
        // If it is single directory then we will handle it differently
        if (path.equals("/")) {
            // If no directories created return empty directories
            if (root.directories.size() == 0) {
                return directories;
            }
            
            // Add all directories
            for (TrieNode  node: root.directories.values()) {
                directories.add(node.directoryName);
            }
            
            // Directory list must return lexographically so need to sort the 
            // answer
            Collections.sort(directories);
            
            return directories;
        }
        
        // Now we need to parse the path and move to the last
        TrieNode currentNode = root;
        StringTokenizer tokenizer = new StringTokenizer(path, "/");
        
        while (tokenizer.hasMoreTokens()) {
            String directory = tokenizer.nextToken();;
            currentNode = currentNode.directories.get(directory);
        }
        
        // We reached at the last directory based on the path. So we will add
        // all the directories inside the current directory
        for (TrieNode  node: currentNode.directories.values()) {
                directories.add(node.directoryName);
        }
        
        // If still result directories = 0 means maybe our path is a file 
        // directory and we are at the last of the directory so a file will be
        // inside a directory. As there is no other directories thats why result
        // is 0. In that case we need to add the currentNode as our directory
        if (directories.size() == 0 && currentNode.isFile) {
            directories.add(currentNode.directoryName);
        }
        
        Collections.sort(directories);
        
        return directories;
    }
    
    private void createDirectoryOrUpdateFile(String path, String content) {
        TrieNode currentNode = root;
        StringTokenizer tokenizer = new StringTokenizer(path, "/");
        
        while (tokenizer.hasMoreTokens()) {
            String directory = tokenizer.nextToken();;
            
            if (!currentNode.directories.containsKey(directory)) {
                currentNode.directories.put(directory, new TrieNode());
            }
            
            currentNode = currentNode.directories.get(directory);
            currentNode.directoryName = directory;
        }
        
        if (content != null) {
            currentNode.isFile = true;
            currentNode.addContent(content);
        }
    }
}
