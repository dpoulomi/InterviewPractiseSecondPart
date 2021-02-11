package AmazonPrep;

import java.util.*;

class SuggestedProducts {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products); // needed to sort at beginning to return results in lexicographical order
        PrefixTrie pTrie = new PrefixTrie(products);
        final int n = searchWord.length();
        List<List<String>> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(searchWord.charAt(i));
            result.add(pTrie.search(sb.toString()));
        }
        return result;
    }
}

class PrefixTrie {
    TrieNode root;

    public PrefixTrie(String[] words) {
        this.root = new TrieNode("");
        for (String w : words) {
            addWord(w);
        }
    }

    public void addWord(String word) {
        TrieNode curr = this.root;
        StringBuilder sb = new StringBuilder();
        String prefix;
        for (char c : word.toCharArray()) {
            sb.append(c);
            prefix = sb.toString();
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new TrieNode(prefix));
            }
            curr = curr.children.get(c);
            curr.addPrefixWord(word);
        }
        curr.endWord = true;
    }

    public List<String> search(String prefix) {
        TrieNode curr = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            final char c = prefix.charAt(i);
            if (!curr.children.containsKey(c)) break;
            curr = curr.children.get(c);
        }
        if (curr.prefix.equals(prefix)) return curr.prefixWords;
        return new ArrayList();
    }
}

class TrieNode {
    Map<Character, TrieNode> children;
    String prefix;
    List<String> prefixWords;
    boolean endWord;

    public TrieNode(String prefix) {
        this.children = new HashMap<>();
        this.prefix = prefix;
        this.prefixWords = new ArrayList();
        this.endWord = false;
    }

    public void addPrefixWord(String word) {
        if (this.prefixWords.size() < 3) this.prefixWords.add(word);
    }

    public static void main(String[] args) {
        String[] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord = "mouse";
        SuggestedProducts suggestedProducts = new SuggestedProducts();
        List<List<String>> result = suggestedProducts.suggestedProducts(products , searchWord);

    }


}