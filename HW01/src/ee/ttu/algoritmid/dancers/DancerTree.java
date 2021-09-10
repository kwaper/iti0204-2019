package ee.ttu.algoritmid.dancers;

import java.util.ArrayList;
import java.util.List;

public class DancerTree {
    //    private Node root;
    private Node root_female;
    private Node root_male;
    private List<Node> nodes = new ArrayList<>();
    private List<Dancer> dancers_female = new ArrayList<>();
    private List<Dancer> dancers_male = new ArrayList<>();
    private List<Dancer> dancers = new ArrayList<>();
    private Node bestMale;
    private Node bestFemale;

    public void addNode(Node root, Node node) {
        if (root == null) {
            if (node.getDancer().getGender() == Dancer.Gender.MALE) {
                root_male = node;
                return;
            } else {
                root_female = node;
                return;
            }
        } else {
            if (node != null) {
                int dancer_h = node.getDancer().getHeight();
                int root_h = root.getDancer().getHeight();
                if (root_h > dancer_h) {
                    if (root.getLeft() == null) {
                        root.setLeft(node);
                    } else {
                        findEmptyNode(root.getLeft(), node);
                    }
                } else {
                    if (root.getRight() == null) {
                        root.setRight(node);
                    } else {
                        findEmptyNode(root.getRight(), node);
                    }
                }
            }

        }
        nodes.add(node);
    }

    public Node findGirl(Node rootNode, Dancer dancer) {
        int height = dancer.getHeight();
        if (rootNode != null) {
            int parent_h = rootNode.getDancer().getHeight();
            if (parent_h == height - 5) {
                bestFemale = rootNode;
                return null;
            } else if (parent_h < height - 5) {
                bestFemale = rootNode;
                return findGirl(rootNode.getRight(), dancer);
            } else {
                return findGirl(rootNode.getLeft(), dancer);
            }
        } else return null;
    }

    public Node findBoy(Node rootNode, Dancer dancer) {
        int height = dancer.getHeight();
        if (rootNode != null) {
            int parent_h = rootNode.getDancer().getHeight();
            if (parent_h == height + 5) {
                bestMale = rootNode;
                return null;
            } else if (parent_h > height + 5) {
                bestMale = rootNode;
                return findBoy(rootNode.getLeft(), dancer);
            } else return findBoy(rootNode.getRight(), dancer);
        } else return null;
    }

    //root = root_male / root_female
    public void removeNode(Node root, Node node) {
        Node left = node.getLeft();
        Node right = node.getRight();
        Node parent = node.getParent();
        Dancer.Gender gender = root.getDancer().getGender();
        Node node2 = null;
        boolean one = false;
        boolean two = false;
        boolean three = false;
        if (left == null && right == null && parent == null) {
            if (gender == Dancer.Gender.MALE) {
                root_male = null;
                return;
            } else {
                root_female = null;
                return;
            }
        }
        if (left == null && right == null) {
            if (parent.getRight() == node) {
                parent.deleteRightChild();
                return;
            }
            if (parent.getLeft() == node) {
                parent.deleteLeftChild();
                return;
            }
        }
        if (left != null) {
            node2 = left;
            one = true;
            two = false;
            three = false;
            Node left_right = left.getRight();
            if (left_right != null) {
                node2 = findRightNodeToReplace(left_right);
                one = false;
                two = true;
                three = false;
            }
        } else {
            if (right != null) {
                node2 = right;
                one = false;
                two = false;
                three = true;
            }
        }
        if (node2 != null) {
            Dancer dancer = node2.getDancer();
            Dancer.Gender gender2 = node2.getDancer().getGender();
            if (one) {
                if (node2.getLeft() != null) {//dancer to root
                    Node nodeToSave = node2.getLeft();
                    if (node2.getLeft() != null) {
                        nodeToSave.deleteParent();
                    }
                    node2.getParent().deleteLeftChild();
                    node.setDancer(node2.getDancer());
                    if (gender2 == Dancer.Gender.MALE) {
                        addNode(root_male, nodeToSave);
                    } else addNode(root_female, nodeToSave);
                } else {
                    node.setDancer(dancer);
                    node.deleteLeftChild();
                }
            } else if (two) {
                node.setDancer(dancer);
                Node nodeToSave = node2.getLeft();
                if (node2.getLeft() != null) {
                    nodeToSave.deleteParent();
                }
                node2.getParent().deleteRightChild();
                if (gender2 == Dancer.Gender.MALE) {
                    addNode(root_male, nodeToSave);
                } else addNode(root_female, nodeToSave);
            } else if (three) {
                if (parent != null) {
                    node.setDancer(node2.getDancer());
                    node.setLeft(node2.getLeft());
                    node.setRight(node2.getRight());
                } else {
                    node2.deleteParent();
                    if (gender2 == Dancer.Gender.MALE) {
                        root_male = node2;
                    } else root_female = node2;
                }
            }
        }

    }

    public void balanceTree(Node root) {
        if (root != null) {
            if (root.getRight() != null && root.getLeft() == null) {
                Node old_root = root;
                Node new_root = root.getRight();
                new_root.deleteParent();
                old_root.deleteRightChild();
                if (old_root.getDancer().getGender() == Dancer.Gender.MALE) {
                    root_male = new_root;
                    addNode(root_male, old_root);
                } else {
                    root_female = new_root;
                    addNode(root_female, old_root);
                }

            }
            if (root.getRight() == null && root.getLeft() != null) {
                Node old_root = root;
                Node new_root = root.getLeft();
                new_root.deleteParent();
                old_root.deleteLeftChild();
                if (old_root.getDancer().getGender() == Dancer.Gender.MALE) {
                    root_male = new_root;
                    addNode(root_male, old_root);
                } else {
                    root_female = new_root;
                    addNode(root_female, old_root);
                }

            }
            getDancers();

        }
    }

    public List<Dancer> getDancers() {
        dancers_female.clear();
        dancers_male.clear();
        collectDancers(root_male);
        collectDancers(root_female);
        return dancers;
    }

    public void collectDancers(Node root) {
        if (root == null) {
            return;
        }
        Dancer.Gender d_g = root.getDancer().getGender();
        Dancer d = root.getDancer();
        if (d_g == Dancer.Gender.MALE) {
            dancers_male.add(d);
        }
        if (d_g == Dancer.Gender.FEMALE) {
            dancers_female.add(d);
        }
        collectDancers(root.getLeft());
        collectDancers(root.getRight());


    }

    public List<Dancer> getDancers_female() {
        return dancers_female;
    }

    public List<Dancer> getDancers_male() {
        return dancers_male;
    }


    //most right from first left
    public Node findRightNodeToReplace(Node node) {
        if (node != null) {
            Node right = node.getRight();
            if (right != null) {
                return findRightNodeToReplace(right);
            } else return node;
        }
        return null;
    }


    //rootNode should be Tree root!!!
//    public Node findPartner(Node rootNode, Dancer dancer) {
//        Dancer.Gender gender = dancer.getGender();
//        int height = dancer.getHeight();
//        if (rootNode != null) {
//            int parent_h = rootNode.getDancer().getHeight();
//            Dancer.Gender parent_s = rootNode.getDancer().getGender();
//
//            if (gender == Dancer.Gender.MALE) {
//                if (parent_h == height - 5) {
//                    if (parent_s == Dancer.Gender.FEMALE) {
//                        bestFemale = rootNode;
//                        return null;
//                    } else return findPartner(rootNode.getRight(), dancer);
//                } else if (parent_h < height - 5) {
//                    if (parent_s == Dancer.Gender.FEMALE) {
//                        bestFemale = rootNode;
//                    }
//                    return findPartner(rootNode.getRight(), dancer);
//
//                } else {
//                    return findPartner(rootNode.getLeft(), dancer);
//                }
//
//            } else {
//                if (parent_h == height + 5) {
//                    if (parent_s == Dancer.Gender.MALE) {
//                        bestMale = rootNode;
//                        return null;
//                    }
//                    return findPartner(rootNode.getLeft(), dancer);
//                } else if (parent_h > height + 5) {
//                    if (parent_s == Dancer.Gender.MALE) {
//                        bestMale = rootNode;
//                    }
//                    return findPartner(rootNode.getLeft(), dancer);
//
//                } else return findPartner(rootNode.getRight(), dancer);
//
//            }
//        } else return null;
//    }

    public Node getRoot_female() {
        return root_female;
    }

    public Node getRoot_male() {
        return root_male;
    }

    public Node getBestMale() {
        return bestMale;
    }

    public Node getBestFemale() {
        return bestFemale;
    }

    public void setBestMale() {
        this.bestMale = null;
    }

    public void setBestFemale() {
        this.bestFemale = null;
    }

    private Node findEmptyNode(Node node, Node dancerNode) {
        int parent_h = node.getDancer().getHeight();
        int dancer_h = dancerNode.getDancer().getHeight();
        if (parent_h > dancer_h) {
            if (node.getLeft() == null) {
                node.setLeft(dancerNode);
                return null;
            } else return findEmptyNode(node.getLeft(), dancerNode);
        } else {
            if (node.getRight() == null) {
                node.setRight(dancerNode);
                return null;
            } else return findEmptyNode(node.getRight(), dancerNode);
        }
    }

//    public Node getRoot() {
//        return root;
//    }

//    public List<Node> getNodes() {
//        return nodes;
//    }
}
