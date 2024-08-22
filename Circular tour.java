class Solution
{
    int tour(int petrol[], int distance[])
    {
        int len = petrol.length;
        int size = 2*len-1;
        int start = -1;
        int fuel = 0;
	  for(int i = 0; i < size ; i++){
	      int diff = petrol[i%len] - distance[i%len];
	       fuel+=diff;
	       
	      if(diff>= 0 && start == -1){
	            start = i;
	      }else if(fuel<0){
	          start = -1;
	          fuel = 0;
	      }
	      
	      if(fuel>=0 && start!=-1 && i-start == len-1) {
	         return start; 
	      }
	  }	
	  
	  return -1;
    }
}