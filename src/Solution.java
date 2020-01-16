import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> outputList = new ArrayList<>();
        Map<Integer, Integer> holder = new HashMap<>();
        int occurence = 0;
        for(int i = 0; i < queries.size() ; i++){
            List<Integer> operation = queries.get(i);
            if(operation.get(0) == 1){
                   if(holder.keySet().contains(operation.get(1))){
                       occurence = holder.get(operation.get(1));
                       holder.put(operation.get(1) , occurence + 1);
                   }else{
                       holder.put(operation.get(1) , 1);
                   }
            }else if(operation.get(0) == 2){
                occurence = holder.get(operation.get(1));

                holder.remove(operation.get(1));
                holder.put(operation.get(1), occurence--);

            }else{

                if(checkIfPresent(operation.get(1), holder)){
                    System.out.print(1);
                    outputList.add(1);

                }else{
                    System.out.print(0);
                    outputList.add(0);
                }
            }

        }
        return outputList;

    }

    public static boolean checkIfPresent(Integer val ,Map<Integer,Integer> holder ){
        int count = 0 ;
        for(Integer i : holder.keySet()){
            if(holder.get(i) == val){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {

        List<List<Integer>> queries = new ArrayList<>();
        List<Integer> smallList = new ArrayList<>();
        smallList.add(1);
        smallList.add(5);
        queries.add(smallList);

        smallList = new ArrayList<>();
        smallList.add(1);
        smallList.add(6);
        queries.add(smallList);
        smallList = new ArrayList<>();

        smallList.add(3);
        smallList.add(2);
        queries.add(smallList);
        smallList = new ArrayList<>();

        smallList.add(1);
        smallList.add(10);
        queries.add(smallList);
        smallList = new ArrayList<>();

        smallList.add(1);
        smallList.add(10);
        queries.add(smallList);
        smallList = new ArrayList<>();

        smallList.add(1);
        smallList.add(6);
        queries.add(smallList);
        smallList = new ArrayList<>();

        smallList.add(2);
        smallList.add(5);
        queries.add(smallList);
        smallList = new ArrayList<>();

        smallList.add(3);
        smallList.add(2);
        queries.add(smallList);


        freqQuery(queries);

    }
}
