public class Main {
    public static void main(String[] args) {
        BST<Integer, String> bst = new BST<>();
        bst.put(10, "A");
        bst.put(5, "B");
        bst.put(15, "C");
        bst.put(3, "D");
        bst.put(7, "E");
        bst.put(12, "F");
        bst.put(17, "G");
        bst.put(18, "h");
        bst.put(13, "y");
        bst.put(11, "d");
        bst.put(14, "s");

        System.out.println(bst.get(10));
        System.out.println(bst.get(3));
        System.out.println(bst.get(15));

        bst.delete(7);

        System.out.println(bst.get(7));
        System.out.println("Size of the tree: " + bst.size());

        for (Integer key : bst.iterator()) {
            System.out.println(key);
        }
        System.out.println("Height of tree:"+bst.getHeight());
    }
}