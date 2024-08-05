import java.util.*;


class Pair{
    String word;
    Integer steps;

    public Pair(String word,Integer steps){
       this.word = word;
       this.steps = steps;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String,Integer>vis = new HashMap<>();

        int check = 0;
        for(int i=0;i<wordList.size();i++){
            vis.put(wordList.get(i),0);
            if(wordList.get(i).equals(endWord)) {
                check = 1;
            }
        }

         vis.put(beginWord,0);

    

        if(check==0) return 0;

        Queue<Pair> pn = new LinkedList<>();

        pn.add(new Pair(beginWord,1));
       

        while(pn.size()>0){
           
            Pair cur = pn.poll();
           
            if(cur.word.equals(endWord)) return cur.steps;
            
            if(vis.get(cur.word)==0){
                vis.put(cur.word,1);
                
                for(int i=0;i<cur.word.length();i++){
                    StringBuilder next = new StringBuilder(cur.word);  
                    for(char c = 'a';c<='z';c++){
                        if(cur.word.charAt(i)!=c){
                           next.setCharAt(i,c);
                           if(vis.containsKey(next.toString()) && vis.get(next.toString())==0){
                            int nextStep = cur.steps+1;
                           pn.add(new Pair(next.toString(),nextStep));
                           }
                        }
                    }
                }
            }
        }

        return 0;
    }
}