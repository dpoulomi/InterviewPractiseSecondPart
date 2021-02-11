//package AmazonPrep;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ProdSuggestion {
//
//
//    public static void main(String[] args) {
//        String[] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
//        String searchWord = "mouse";
//        Trie trie = new Trie();
//        ProdSuggestion prodSuggestion = new ProdSuggestion();
//        for (int i = 0; i < products.length; i++) {
//            prodSuggestion.insertWordInTrie(trie, products[i]);
//        }
//        String[] suggestions = prodSuggestion.getSuggestions();
//    }
//
//    private String[] getSuggestions() {
//
//    }
//
//    private void insertWordInTrie(Trie trie, String word) {
//
//        for (int i = 0; i < word.length(); i++) {
//            int index = word.charAt(i) - 'a';
//            if (trie.children[index] == null) {
//                Trie newNode = new Trie();
//                trie.children[index] = newNode;
//                trie = trie.children[index];
//            }
//            trie.endOfWord = true;
//        }
//    }
//
//    public List<String> searchWordInTrie(Trie trie, Character character) {
//
//        // for (int i = 0; i < word.length(); i++) {
//        List<String> suggestions = new ArrayList<>();
//        int index = character - 'a';
//        if (trie.children[index] == null) {
//           return null;
//        }
//        trie = trie.children[index];
//       // suggestions.add();
//
//        //  }
//        return suggestions;
//
//    }
//
//    static class Trie {
//        private int ALPHABET_SIZE = 26;
//        Trie[] children = new Trie[26];
//        boolean endOfWord = false;
//
//        Trie() {
//            endOfWord = false;
//            for (int i = 0; i < ALPHABET_SIZE; i++) {
//                children[i] = null;
//            }
//        }
//    }
//
//
//}
