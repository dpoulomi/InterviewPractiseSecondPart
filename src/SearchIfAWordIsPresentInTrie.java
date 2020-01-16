public class SearchIfAWordIsPresentInTrie {

    private Trie root;

    //abc

   public void insertDataToTrie(String key){
       Trie current = root;

       for(int i = 0 ; i < key.length() ; i++ ){
           int indexInChildren  = key.charAt(i) - 'a';
           Trie child = current.children[indexInChildren];
           if(child == null){
              child = new Trie();
              current.children[indexInChildren] = child;
           }
           current = child;
       }
        current.endOfWord = false;
   }

   public boolean search(String key){
        Trie current = root;
        for(int i = 0 ; i< key.length() ; i++){
            int indexOfChilrenArray = key.charAt(i) - 'a';
            Trie node = current.children[indexOfChilrenArray];
            if(node == null){
             return false;
            }
            current = node;

        }
        return (current != null && current.endOfWord);
   }
}
