package ee.ttu.algoritmid.subtreesum;

public class SubtreeSum {

    public static void main(String[] args) throws Exception {
        /**
         *  Use this example to test your solution
         *                  Tree:
         *                   15
         *               /       \
         *             10         17
         *           /   \       /  \
         *         3     13     5    25
         */
        Node rootNode = new Node(15);
        Node a = new Node(10);
        Node b = new Node(17);
        Node c = new Node(3);
        Node d = new Node(13);
        Node e = new Node(5);
        Node f = new Node(25);

        Node dd = new Node(17);

        rootNode.setLeft(a);
        rootNode.setRight(b);
        a.setLeft(c);
        a.setRight(d);
        b.setLeft(e);
        b.setRight(f);
//        c.setLeft(dd);

//        rootNode.setLeft(a);
//        a.setLeft(b);
//        b.setLeft(c);
//        b.setRight(e);
//        c.setLeft(d);


        SubtreeSum solution = new SubtreeSum();
        solution.calculateLeftSums(rootNode);

        System.out.println(rootNode.getSumOfAllLeft()); // 15
        System.out.println(a.getSumOfAllLeft()); // 10
        System.out.println(b.getSumOfAllLeft()); // 17
        System.out.println(c.getSumOfAllLeft()); // 3

        if (rootNode.getSumOfAllLeft() != 26 ||
                a.getSumOfAllLeft() != 3 ||
                b.getSumOfAllLeft() != 5 ||
                c.getSumOfAllLeft() != 0) {
//            throw new Exception("There is a mistake in your solution.");
            System.out.println("MISTAKE!!");
        }

        System.out.println("Your solution should be working fine in basic cases, try to push.");
    }

    /**
     * Calculate sum of all left children for every node
     *
     * @param rootNode root node of the tree. Use it to traverse the tree.
     * @return root node of the tree where for every node is computed sum of it's all left children
     */
    public Node calculateLeftSums(Node rootNode) {
        return getRekt(rootNode);
    }

    private Node getRekt(Node node) {
        if (node != null) {
            Node left = node.getLeft();
            Node right = node.getRight();
            getRekt(left);
            getRekt(right);
            if (left != null && right != null) {
                node.setSumOfAllLeft(left.getValue() + left.getSumOfAllChildren());
                node.setSumOfAllChildren(left.getValue() + right.getValue() + left.getSumOfAllChildren() + right.getSumOfAllChildren());
            } else if (left != null) {
                node.setSumOfAllLeft(left.getValue() + left.getSumOfAllChildren());
                node.setSumOfAllChildren(left.getSumOfAllChildren() + left.getValue());
            } else if (right != null) {
                node.setSumOfAllChildren(right.getSumOfAllChildren() + right.getValue());
            }
        }
        return node;
    }
}
