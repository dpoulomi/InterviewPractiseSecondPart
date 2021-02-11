//package AmazonPrep;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ProductSuggestionSelf {
//
//
//    static class Trie {
//
//        private boolean endOfWord;
//        private Trie[] children = new Trie[26];
//
//        Trie() {
//            for (int i = 0; i < 26; i++) {
//                children[i] = null;
//            }
//            endOfWord = false;
//        }
//
//        public List<String> search(Trie trie, String prefix) {
//            List<String> suggestion = new ArrayList<>();
//            for(int i = 0 ; i < prefix.length() ; i++) {
//                int index = prefix.charAt(i) - 'a';
//
//                Trie child = trie.children[index];
//                if (child == null) {
//                    child = new Trie();
//
//
//                }
//                trie = child.children[index];
//            }
//            if(trie != null && trie.endOfWord == true ){
//                suggestion.add();
//            }
//
//        }
//
//
//        public void insert(Trie root, String product) {
//
//            for(int i = 0 ; i < product.length() ; i++) {
//                int index = prefix.charAt(i) - 'a';
//
//                Trie child = trie.children[index];
//                if (child == null) {
//                    child = new Trie();
//
//
//                }
//                trie = child.children[index];
//            }
//
//        }
//    }
//
//    private static Trie root;
//
//    public static void main(String[] args) {
//        String[] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
//        String searchWord = "mouse";
//        List<List<String>> suggestions = new ArrayList<>();
//        Trie trie = new Trie();
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < products.length; i++) {
//            trie.insert(root , products[i]);
//        }
//
//        for (int i = 0; i < searchWord.length(); i++) {
//            Character prefix = searchWord.charAt(i);
//            sb.append(prefix);
//            List<String> suggestion = trie.search(root , sb);
//            suggestions.add( suggestion);
//
//        }
//
//    }
//
//}
