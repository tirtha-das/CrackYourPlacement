import java.util.Arrays;

class DSU{
    
    int[] parent;
    
    DSU(int size){
        parent = new int[size+1];
        
        for(int i=0;i<=size;i++){
            parent[i] = i;
        }
    }
    
    
    int getParent(int node){
        if(parent[node]==node){
            return node;
        }
        
        return parent[node] = getParent(parent[node]);
    }
    
    
    void connect(int node1,int node2){
        int p1 = getParent(node1);
        int p2 = getParent(node2);
        
        if(p1==p2){
            return;
        }else if(p1>p2){
            parent[p1] = p2;
        }else{
            parent[p2] = p1;
        }
    }
}

class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
       Arrays.sort(arr,(j1,j2)->{
          
            return Integer.compare(j2.profit,j1.profit);
         });
         
         DSU ds = new DSU(n);
         
         int ans = 0,cnt=0;
         
         for(int i=0;i<n;i++){
             int parent = ds.getParent(arr[i].deadline);
             
             if(parent!=0){
                 cnt++;
                 ans+=arr[i].profit;
                 ds.connect(parent,parent-1);
             }
         }
     
     int[] res = {cnt,ans};
     
     return res;
    
    
      
    }
}


class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
