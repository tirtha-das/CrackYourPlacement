import java.util.*;

class Solution {
    public static void generate(ArrayList<Integer> arr , int start,ArrayList<ArrayList<Integer>> res,
    HashSet<ArrayList<Integer>> h){
        if(start==arr.size()-1){
            if(h.contains(arr)){
                return;
            }
            ArrayList<Integer> perm=new ArrayList<>(arr);
            h.add(perm);
            res.add(perm);
            return;
        }
        Integer a,b;
        for(int i=start;i<arr.size();i++){
            a=arr.get(start);
            b=arr.get(i);
            arr.set(start,b);
            arr.set(i,a);
            generate(arr,start+1,res,h);
            arr.set(start,a);
            arr.set(i,b);
        }
    }
    public static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr , int n) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        if(arr.size()==0){
            return res;
        }
        generate(arr,0,res,new HashSet<>());
        Collections.sort(res, (ArrayList<Integer> a, ArrayList<Integer> b) -> {
            int i = 0, l = Math.min(a.size(), b.size());
            
            while(i < l) {
                if(a.get(i).compareTo(b.get(i)) != 0)
                    return a.get(i).compareTo(b.get(i));
                i++;
            }
            
            return a.size() - b.size();
        });
        
        return res;
    }
};