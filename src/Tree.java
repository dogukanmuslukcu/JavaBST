public class Tree implements ITree {
    private Node root;

    public Tree() {
        root = null;
    }

    public void insertion(int data) {
        root = insertion(root, data);
    }

    private static Node insertion(Node root, int data) {
        if (root == null) {
            root = new Node(data, null, null);
            return root;
        }
        if (data < root.data) {
            root.leftChild = insertion(root.leftChild, data);
        }
        if (data > root.data) {
            root.rightChild = insertion(root.rightChild, data);

        }
        return root;
    }

    public void deletion(int data) {

        root = deletion(root, data);
    }

    private static Node deletion(Node root, int data) {
        if (root == null) {
            return null;
        }
        if (root.data == data) {
            if (root.rightChild == null && root.leftChild == null) {
                return null;
            }
            if (root.leftChild != null) {
                root.data = max(root.leftChild);
                root.leftChild = deletion(root.leftChild, max(root.leftChild));
                return root;
            }
            root.data = min(root.rightChild);
            root.rightChild = deletion(root.rightChild, min(root.rightChild));
            return root;
        }
        if (data < root.data) {
            root.leftChild = deletion(root.leftChild, data);
            return root;
        }
        root.rightChild = deletion(root.rightChild, data);
        return root;

    }

    public int min() {

        return min(root);
    }

    private static int min(Node root) {
        while (root.leftChild != null) {
            root = root.leftChild;
        }
        return root.data;
    }

    public int max() {
        return max(root);
    }

    private static int max(Node root) {
        while (root.rightChild != null) {
            root = root.rightChild;
        }
        return root.data;
    }

    public void traversal_LRN() {
        traversal_LRN(root);
    }

    private static void traversal_LRN(Node root) {
        if (root == null) {
            return;
        }
        traversal_LRN(root.leftChild);
        traversal_LRN(root.rightChild);
        System.out.print(root.data + " ");


    }

    public void traversal_LNR() {
        traversal_LNR(root);
    }

    private static void traversal_LNR(Node root) {
        if (root == null) {
            return;
        }
        traversal_LNR(root.leftChild);
        System.out.print(root.data + " ");
        traversal_LNR(root.rightChild);

    }

    public void traversal_NLR() {
        traversal_NLR(root);
    }

    private static void traversal_NLR(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        traversal_NLR(root.leftChild);
        traversal_NLR(root.rightChild);

    }
}