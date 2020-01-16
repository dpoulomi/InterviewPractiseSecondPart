import data.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Trie {

   // Map<Character , Trie> children = null;
    private int ALPHABET_SIZE = 26 ;
    boolean endOfWord;
    Trie[] children = new Trie[ALPHABET_SIZE];
    Trie(){
        for(int i = 0; i < ALPHABET_SIZE ; i++){
            children[i] = null;
        }
        endOfWord = false;
    }
}
