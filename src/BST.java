

import java.util.List;
import java.util.ArrayList;

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
                return null;
            }

            int cmp = key.compareTo(node.key);
            if (cmp < 0) {
                node.left = delete(node.left, key);
            } else if (cmp > 0) {
                node.right = delete(node.right, key);
            } else {
                if (node.left == null) {
                    return node.right;
                } else if (node.right == null) {
                    return node.left;
                } else {

                    Node successor = findMin(node.right);
                    node.key = successor.key;
                    node.val = successor.val;
                    node.right = delete(node.right, successor.key);
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

        public Iterable<K> iterator() {
            List<K> keys = new ArrayList<>();
            inorderTraversal(root, keys);
            return keys;
        }

        private void inorderTraversal(Node node, List<K> keys) {
            if (node == null)
                return;
            inorderTraversal(node.left, keys);
            keys.add(node.key);
            inorderTraversal(node.right, keys);
        }
    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + size(node.left) + size(node.right);
        }
    }

    public int getHeight(){
        return getHeight(root);
    }
    public int getHeight (Node node){
        if (node==null) {
            return 0;
        }
        else {
            int leftHeight=getHeight(node.left);
            int rightHeight=getHeight(node.right);
            return Math.max(leftHeight,rightHeight)+1;
        }
    }

}

