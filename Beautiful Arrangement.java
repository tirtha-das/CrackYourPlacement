import java.util.*;

class Solution {
    public int countArrangement(int n) {
        List<List<Integer>> answer=new ArrayList<>();
        backtrack(n,new boolean[n+1],new ArrayList<>(),answer);
       

        return answer.size();
    }
    public void backtrack(int n,boolean[] used,List<Integer> arr,List<List<Integer>> answer){
        if(arr.size()==n){
            answer.add(new ArrayList<>(arr));
        }else{
            for(int i=1;i<=n;i++){
                if(used[i]) continue;
                if(!(i%(arr.size()+1)==0||(arr.size()+1)%i==0)) continue;
                arr.add(i);
                used[i]=true;
                backtrack(n,used,arr,answer);
                used[i]=false;
                arr.remove(arr.size()-1);
            }
        }

    }
    
}