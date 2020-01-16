
public class TrieImplementation {


    class TrieNode{

        TrieNode[] arr  = new TrieNode[26];;
        boolean endOfWord;

        public TrieNode(){

            endOfWord = false;
            for(int i = 0 ; i < arr.length ; i ++){
                arr[i] = null;
            }

        }

        private  TrieNode root;
        public void insert(String word){
             TrieNode trie = root;
            for(int i = 0 ; i < word.length() ; i++){
                char ch = word.charAt(i);
                int index = ch - 'a';
                 trie = root.arr[index];
                if(trie == null){

                    trie = new TrieNode();
                }
                trie = trie.arr[index];

            }

            trie.endOfWord = true;
        }

        public boolean search(String word){
            TrieNode trieNode = root;
            for(int i =  0 ; i < word.length() ;  i++){
                int index = word.charAt(i) - 'a';
                trieNode = trieNode.arr[index];
                if(trieNode == null){
                    return false;
                }
                trieNode = trieNode.arr[index];

            }

            return trieNode != null && trieNode.endOfWord;


        }

    }
}
