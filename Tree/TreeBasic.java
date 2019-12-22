public class TreeBasic {
    static void DFS (Node r){
        if (r.left == null && r.right == null){
            System.out.println(r);
            return;
        }
        if (r.left != null){
            DFS(r.left);
        }
        if (r.right != null){
            DFS(r.right);
        }
    }
    public static void main(String args[])
    {
        Node root = new Node (1);
        root.left      = new Node(2);
        root.right     = new Node(3);
        root.right.left = new Node(7);
        root.left.left  = new Node(4);
        root.left.right  = new Node(5);
        root.left.right.right = new Node(6);

        DFS(root);
    }
}

class Node {
    static Node left;
    static Node right;
    static int val;
    public Node(int val){
        this.val = val;
        left = right = null;
    }
}
