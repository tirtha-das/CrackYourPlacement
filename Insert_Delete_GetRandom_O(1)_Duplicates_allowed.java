import java.util.*;
class RandomizedCollection {
    HashMap<Integer, PriorityQueue<Integer>> map;
    ArrayList<Integer> List;
    Random randomNum = new Random();
    public RandomizedCollection() {
        map = new HashMap();
        List = new ArrayList();
    }
    
    public boolean insert(int val) {
        if(!map.containsKey(val)){
            PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a,b) -> b - a); 
            maxPQ.add(List.size());
            List.add(val);
            map.put(val, maxPQ);
            return true;
        }
        else{
            PriorityQueue<Integer> maxPQ = map.get(val);
            maxPQ.add(List.size());
            List.add(val);
            map.put(val, maxPQ);
            return false;
        }

    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        else{
            PriorityQueue<Integer> maxPQ = map.get(val);
            int index = maxPQ.poll();
            if(maxPQ.size()==0){
                map.remove(val);
            }
            else{
                map.put(val, maxPQ);
            }
            int lastVal = List.remove(List.size()-1);
            if(lastVal!=val)
            {PriorityQueue<Integer> maxPQ2 = map.get(lastVal);
            maxPQ2.poll();
            maxPQ2.add(index);
            List.set(index, lastVal);
            map.put(lastVal, maxPQ2);}
            return true;
        }
    }
    
    public int getRandom() {
        int showMe = randomNum.nextInt(List.size());
        return List.get(showMe);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */