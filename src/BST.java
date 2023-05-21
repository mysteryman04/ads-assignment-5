
public class BST<K extends Comparable<K>, V> {
    private Node root;

    private class Node {
        private K key;
        private V val;
        private Node left, right;
        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
        public void put(K key, V val) {
            root = put(root, key, val);
        }
        private Node put(Node node, K key, V val) {
            if (node == null) {
                return new Node(key, val);
            }

            int cmp = key.compareTo(node.key);
            if (cmp < 0) {
                node.left = put(node.left, key, val);
            } else if (cmp > 0) {
                node.right = put(node.right, key, val);
            } else {
                node.val = val;
            }

            return node;
        }
        public V get (K key){
            return get(root, key);
        }
        private V get(Node node, K key) {
            if (node == null) {
                return null;
            }

            int cmp = key.compareTo(node.key);
            if (cmp < 0) {
                return get(node.left, key);
            } else if (cmp > 0) {
                return get(node.right, key);
            } else {
                return node.val;
            }
        }
        public void delete (K key){
            root = delete(root, key);
        }
        private Node delete(Node node, K key) {
            if (node == null) {
                return null; // Key not found
            }

            int cmp = key.compareTo(node.key);
            if (cmp < 0) {
                node.left = delete(node.left, key); // Key might be in the left subtree
            } else if (cmp > 0) {
                node.right = delete(node.right, key); // Key might be in the right subtree
            } else {
                // Key found, perform deletion
                if (node.left == null) {
                    return node.right; // No left child, replace with right child (or null)
                } else if (node.right == null) {
                    return node.left; // No right child, replace with left child
                } else {
                    // Node has both left and right children
                    Node successor = findMin(node.right); // Find the minimum node in the right subtree
                    node.key = successor.key; // Replace current node with the successor
                    node.val = successor.val;
                    node.right = delete(node.right, successor.key); // Delete the successor node from the right subtree
                }
            }

            return node;
        }
        private Node findMin(Node node) {
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }

        public Iterable<K> iterator () {}
    }
}

