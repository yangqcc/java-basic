package datastructure;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yangqc
 */
public class IndexTree {

    static private int Sn = -1;
    static private Node root;

    static private class Node implements Serializable {

        int data;
        transient Node left;
        transient Node right;
        int l = -1, r = -1;

        public Node(int data, Node l, Node r) {
            this.data = data;
            this.left = l;
            this.right = r;
        }

        public int write(ObjectOutputStream out) throws IOException {
            if (left != null) {
                l = left.write(out);
            }
            if (right != null) {
                r = right.write(out);
            }
            Sn++;
            out.writeObject(this);
            return Sn;
        }

        private void init(List<Node> list) {
            if (l != -1) {
                left = list.get(l);
                left.init(list);
            }
            if (r != -1) {
                right = list.get(r);
                right.init(list);
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(data + " ");
            if (left != null) {
                sb.append(left);
            }
            if (right != null) {
                sb.append(right);
            }
            return sb.toString();
        }
    }

    static public void read(ObjectInputStream in) {
        List<Node> list = new ArrayList<>();
        Node n;
        try {
            while (((n = (Node) in.readObject()) != null)) {
                list.add(n);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        root = list.get(list.size() - 1);
        root.init(list);
    }

    public static void main(String[] args) throws IOException {
        // 构造一棵二叉树
        /*
         * 1 2 3 4 5 6
         */
        Node n6 = new Node(6, null, null);
        Node n4 = new Node(4, n6, null);
        Node n5 = new Node(5, null, null);
        Node n2 = new Node(2, n4, n5);
        Node n3 = new Node(3, null, null);
        Node n1 = new Node(1, n2, n3);
        root = n1;
        System.out.println(root);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("abc.ser"));
        root.write(out);
        out.close();
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("abc.ser"));
        read(in);
        in.close();
        System.out.println(root);
    }
}
