public class Main {

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insertion(200);
        tree.insertion(213);
        tree.insertion(190);
        tree.insertion(56);
        tree.insertion(28);
        tree.insertion(27);
        tree.insertion(12);
        tree.insertion(18);
        tree.insertion(26);
        tree.insertion(24);
        tree.insertion(1);
        tree.insertion(-1);
        tree.traversal_LNR();
        System.out.println();
        System.out.println(tree.min());
        System.out.println();
        System.out.println(tree.max());
        tree.traversal_LNR();
        tree.deletion(200);
        System.out.println();
        tree.traversal_LNR();
        System.out.println();
        tree.traversal_LRN();
        System.out.println();
        tree.traversal_NLR();
    }
}
