import java.util.*; 
 
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }

 }

 class Codec{

    TreeNode temp;
   public String serialize(TreeNode root) {
   if (root == null) return "";

   StringBuilder res = new StringBuilder();
   Queue<TreeNode> q = new LinkedList<>();

   q.offer(root);
   while (!q.isEmpty()) {
       TreeNode curr = q.poll();

       if (curr != null) {
           res.append(curr.val).append(",");
           q.offer(curr.left);
           q.offer(curr.right);
       } else {
           res.append("N,");
       }
   }

   if (res.length() > 0) {
       res.setLength(res.length() - 1);
   }

   System.out.println(res.toString());
   return res.toString();
}


   public TreeNode deserialize(String data) {
       int ind = 0;
       Queue<TreeNode> q = new LinkedList<>();

       if(data.equals("")) return null;

       String[] str = data.split("," , -1);
       TreeNode root = new TreeNode(Integer.parseInt(str[ind]));

       q.offer(root);
       ind++;

       System.out.println(Arrays.toString(str));

       while(!q.isEmpty()){
           TreeNode curr = q.poll();
           
           if(!str[ind].equals("N")){
               int nodeData = Integer.parseInt(str[ind]);
               curr.left = new TreeNode(nodeData);
               q.offer(curr.left);
           }

           ind++;

           if(!str[ind].equals("N")){
               int nodeData = Integer.parseInt(str[ind]);
               curr.right = new TreeNode(nodeData);
               q.offer(curr.right);
           }

           ind++;
       }

       return root;
   }
}

