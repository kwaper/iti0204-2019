package ee.ttu.algoritmid.dancers;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        HW01 hw = new HW01();
        Dancer dancer1 = new DancerImpl("Gary", Dancer.Gender.FEMALE, 44);
        Dancer dancer2 = new DancerImpl("Gary", Dancer.Gender.FEMALE, 47);
        Dancer dancer3 = new DancerImpl("Gary", Dancer.Gender.FEMALE, 43);
        Dancer dancer4 = new DancerImpl("Gary", Dancer.Gender.FEMALE, 45);
        Dancer dancer9 = new DancerImpl("Gary", Dancer.Gender.FEMALE, 42);
        Dancer dancer5 = new DancerImpl("Gary2", Dancer.Gender.MALE, 50);
        Dancer dancer6 = new DancerImpl("Gary2", Dancer.Gender.MALE, 52);
        Dancer dancer7 = new DancerImpl("Gary2", Dancer.Gender.MALE, 50);
        Dancer dancer8 = new DancerImpl("Gary2", Dancer.Gender.MALE, 50);

//        Dancer dancer3 = new DancerImpl("Gary3", Dancer.Gender.MALE, 50);
//        Dancer dancer4 = new DancerImpl("Gary4", Dancer.Gender.MALE, 50);
//        Dancer dancer5 = new DancerImpl("Gary5", Dancer.Gender.MALE, 50);
//        Dancer dancer6 = new DancerImpl("Gary6", Dancer.Gender.MALE, 50);
//        Dancer dancer7 = new DancerImpl("Gary6", Dancer.Gender.FEMALE, 50);
//        Dancer dancer8 = new DancerImpl("Gary6", Dancer.Gender.FEMALE, 50);
//        Dancer dancer9 = new DancerImpl("Gary6", Dancer.Gender.MALE, 50);


//        hw.getTree().addNode(new Node(dancer1,null,null));
//        hw.getTree().addNode(new Node(dancer2,null,null));
//        hw.getTree().addNode(new Node(dancer3,null,null));
//        hw.getTree().addNode(new Node(dancer4,null,null));
//        hw.getTree().addNode(new Node(dancer5,null,null));
//        hw.getTree().addNode(new Node(dancer6,null,null));
//        hw.getTree().addNode(new Node(dancer7,null,null));
//        hw.getTree().addNode(new Node(dancer8,null,null));
//        hw.getTree().addNode(new Node(dancer9,null,null));

//        hw.findPartnerFor(dancer1);
//
//        hw.findPartnerFor(dancer2);
//
//        hw.findPartnerFor(dancer3);
//        hw.findPartnerFor(dancer4);
//        hw.findPartnerFor(dancer5);
//        hw.findPartnerFor(dancer6);
//        hw.findPartnerFor(dancer7);
//        hw.findPartnerFor(dancer8);
//        hw.getTree().addNode(new Node(dancer9,null,null));

//        Node root = hw.getTree().getRoot();
        List<Dancer> females = new ArrayList<>();
        List<Integer> perfect_males = new ArrayList<>();
        int max = 220;
        int min = 150;
        int range = max - min + 1;
        for (int i = 0; i < 200; i++) {
            hw.findPartnerFor(new DancerImpl("F", Dancer.Gender.FEMALE,((int)(Math.random() * range) + min)));
        }
        for (int i = 0; i < 200; i++) {
            System.out.println(hw.findPartnerFor(new DancerImpl("M", Dancer.Gender.MALE,((int)(Math.random() * range) + min))));
            System.out.println(hw.returnWaitingList());
        }
//        hw.findPartnerFor(dancer1);
//        System.out.println(hw.returnWaitingList());
//        hw.findPartnerFor(dancer2);
//        System.out.println(hw.returnWaitingList());
//        hw.findPartnerFor(dancer3);
//        System.out.println(hw.returnWaitingList());
//        hw.findPartnerFor(dancer9);
//        System.out.println(hw.returnWaitingList());
////        hw.findPartnerFor(dancer4);
//        System.out.println(hw.returnWaitingList());
//        System.out.println(hw.findPartnerFor(dancer5));
//        System.out.println(hw.returnWaitingList());
//        System.out.println(hw.findPartnerFor(dancer6));
//        System.out.println(hw.returnWaitingList());
//        System.out.println(hw.findPartnerFor(dancer7));
//        System.out.println(hw.returnWaitingList());
//        System.out.println(hw.findPartnerFor(dancer8));
//        System.out.println(hw.returnWaitingList());

//        hw.getTree().removeNode(root);


//        System.out.println(root.getDancer().getHeight());
//        System.out.println(root.getLeft().getDancer().getHeight());
//        System.out.println(root.getRight().getDancer().getHeight());
//        System.out.println(root.getRight().getRight().getDancer().getHeight());
//        System.out.println(root.getRight().getLeft().getDancer().getHeight());
//        System.out.println(root.getRight().getLeft().getRight().getDancer().getHeight());
//        System.out.println(root.getRight().getLeft().getLeft().getDancer().getHeight());

//        System.out.println(hw.returnWaitingList());




    }
}
