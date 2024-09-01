import java.util.*;


 class NestedIterator implements Iterator<Integer> {
    ArrayList<Integer> list=new ArrayList<>();
     int start=0;
     public NestedIterator(List<NestedInteger> nestedList) {
            for(NestedInteger i:nestedList)
            { 
                if(i.isInteger())
                {
                    list.add(i.getInteger());
                }
                else
                {
                  NestedIterator k = new NestedIterator(i.getList());
                  while (k.hasNext())
                  {
                     list.add(k.next());
                  }
                }
            }
     }
 
     @Override
     public Integer next() {
          Integer ans=list.get(start);
          start++;
          return ans;
     } 
 
     @Override
     public boolean hasNext() {
         if(start<list.size())
         {
             return true;
         }
         else
         {
             return false;
         }
     }
 }
 