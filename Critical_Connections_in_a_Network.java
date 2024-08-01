import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
class Solution {
    
    static void dfs(int node,int parent,List<List<Integer>>graph, List<Integer> steps, List<Integer> low,List<List<Integer>>ans,AtomicInteger curStep){
        
        steps.set(node,curStep.get());
        low.set(node,curStep.get());

        

        for(Integer it:graph.get(node)){
            if(steps.get(it)==0){
                curStep.getAndIncrement();
                dfs(it,node,graph,steps,low,ans,curStep);
            }

            if(it!=parent){
                low.set(node,Math.min(low.get(it),low.get(node)));
            }

                if(low.get(it)>steps.get(node)){
                    List<Integer>res = new ArrayList<>();
                    res.add(node);
                    res.add(it);
                    ans.add(res);
                
            }
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>>ans = new ArrayList<>();
         List<List<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
         List<Integer>steps = new ArrayList<>(Collections.nCopies(n,0));
         List<Integer>low = new ArrayList<>(Collections.nCopies(n,0));
        

        for(List<Integer>it:connections){
            int src = it.get(0),dest = it.get(1);
             graph.get(src).add(dest);
              graph.get(dest).add(src);

        }


         AtomicInteger curStep = new AtomicInteger(1);

        for(int node=0;node<n;node++){
            if(steps.get(node)==0){
               
                dfs(node,-1,graph,steps,low,ans,curStep);
            }
        }

        return ans;
    }
}