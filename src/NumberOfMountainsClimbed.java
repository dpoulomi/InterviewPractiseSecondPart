import java.util.Stack;

public class NumberOfMountainsClimbed {


    // UP DOWN UP DOWN --2
    //UP UP DOWN DOWN --1
    //UP UP UP DOWN DOWN --0
    public int getNumberOfMountainsClimbed(String mountainclimbed){
        Stack<String> s = new Stack<>();
        String[] arr = mountainclimbed.split(" ");
        for(int i =arr.length - 1 ; i > 0 ; i--){
            s.push(arr[i]);
        }
        int count = 0 ;
        int upCounter= 0;
        while(!s.isEmpty()){
            String element = s.pop();
            if(element.equals("UP")){
                upCounter++;
            }
            if(element != s.peek()){

                s.pop();
                upCounter--;
                if(upCounter == 0){
                    count++;
                }
            }else{
               while(element.equals(s.peek())){
                   upCounter++;
                    s.pop();
               }
            }
        }
        return count;
    }
}
