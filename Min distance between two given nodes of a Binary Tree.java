import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
}


class GfG {
    int findDist(Node root, int a, int b) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
 
        util(root, a, list1);
        util(root, b, list2);
        int i = 0;
        
        while (i < list1.size() && i < list2.size() && list1.get(i).equals(list2.get(i))) {
            i++;
        }
        return (list1.size() - i) + (list2.size() - i);
    }
    
    static boolean util(Node root, int key, ArrayList<Integer> list){
        if(root==null){
            return false;
        }
        
        
        list.add(root.data);
        
        if(root.data == key){
            return true;
        }
        
        if(root.left != null){
            if(util(root.left, key, list)){
                return true;
            }
        }
        if(root.right != null){
            if(util(root.right, key, list)){
                return true;
            }
        }
        
        list.remove(list.size()-1);
        
        return false;
    }
}