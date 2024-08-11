class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}


class Solution
{

  static boolean containDeadEnd(Node root, int min, int max) {
        if (root == null) {
            return false;
        }
        if (min == max) {
            return true;
        }
        return containDeadEnd(root.left, min, root.data - 1)
                || containDeadEnd(root.right, root.data + 1, max);
    }
public static boolean isDeadEnd(Node root) {
    return containDeadEnd(root, 1, Integer.MAX_VALUE);
}


}