import java.util.ArrayList;

public class HeapTester {

    public static void main(String[] args) {
        HeapTester hp = new HeapTester();

        if (args.length == 0)
            hp.which = true;
        else hp.which = false;


         try {

             hp.testString();
         }
         catch (Exception e) {
             System.out.println(e);
             e.printStackTrace();
         }
         try {

             hp.testWord();
        }
         catch (Exception e) {
             System.out.println(e);
             e.printStackTrace();}
         try {

             hp.testWord2();
         }
         catch (Exception e) {
             System.out.println(e);
             e.printStackTrace();
         }

        try {

            hp.testInteger();
        }
        catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }

    }

    boolean which;

    protected void testInteger() {

        System.out.println("Test of an Integer heap with flag reversed - should be max heap  also build");
        //MyHeap<Integer>  th1 = new MyHeap<Integer>(!which);

        // create a max heap (this  sets isMin to  true but we don't get a minheap??)
        MyHeap<Integer>  th1 = new MyHeap<Integer>(true);

        ArrayList<Integer> list = new ArrayList<Integer>();

        th1.insert(10);
        th1.insert(2);
        th1.insert(17);
        th1.insert(95);
        th1.insert(-19);
        th1.insert(0);
        th1.insert(54);
        th1.insert(52);
        th1.insert(55);

        System.out.println("Printing heap before remove: ");
        th1.writePQ();

        System.out.println("Removed element: " + th1.remove());
        System.out.println("Removed element: " + th1.remove());
        System.out.println("Removed element: " + th1.remove());

        System.out.println("Printing heap after removes: ");
        th1.writePQ();

        System.out.println("95 54 54 52 17 10 2 0 -19");

        while (!th1.isEmpty()) {
             System.out.println(th1.remove());
        }
    }

    private void finishUp3(MyHeap<Integer> th1) {


    }

    public HeapTester() {


    }




    public void testString() {

        System.out.println("Test of string heap - insert, peek, remove, isEmpty");

        MyHeap<String>  th1 = new MyHeap<String>(which);

        th1.insert("zoo");
        finishUp(th1);


    }

    protected void finishUp(MyHeap<String> th1) {
        th1.insert("apple");
        th1.insert("penguin");

        System.out.println("apple "+th1.peek());
        System.out.println("apple "+th1.remove());
        System.out.println("False "+th1.isEmpty());
        System.out.println("penguin "+th1.remove());
        System.out.println("zoo "+th1.remove());
        System.out.println("true "+th1.isEmpty());
    }


    public void testWord() {

        System.out.println("Test of Word Heap insert, etc.");

        MyHeap<Word> th1 = new MyHeap<Word>(which);

        th1.insert(new Word("apple",10));
        finishUp2(th1);
    }

    public void testWord2() {

        System.out.println("Test of Word Heap using build (with a ArrayList)");


        MyHeap<Word> th2= new MyHeap<Word>(which);
        ArrayList<Word> th1 = new ArrayList<Word>();

        th1.add(new Word("apple",10));
        th1.add(new Word("zoo",5));
        th1.add(new Word("banana",12));
        th1.add(new Word("plum",8));
        th1.add(new Word("pear",22));
        th1.add(new Word("cherry",1));
        th1.add(new Word("steam",15));
        th1.add(new Word("math",13));
        th1.add(new Word("duck",15));

        th2.build(th1);

        while (!th2.isEmpty()) {
            System.out.println(th2.remove());
        }
    }

    public void finishUp2(MyHeap<Word> th1) {

        th1.insert(new Word("zoo",5));
        th1.insert(new Word("banana",12));
        th1.insert(new Word("plum",8));
        th1.insert(new Word("pear",22));
        th1.insert(new Word("cherry",1));
        System.out.println("cherry 1 "+th1.remove());
        System.out.println("zoo 5 "+th1.remove());
        th1.insert(new Word("steam",15));
        th1.insert(new Word("math",13));
        System.out.println("plum 8"+th1.remove());
        System.out.println("apple 10 "+th1.remove());
        th1.insert(new Word("duck",15));
        System.out.println("banana 12 "+th1.remove());

        System.out.println("math 13 duck 15 steam 15 pear 22");
        while (!th1.isEmpty()) {
            System.out.println(th1.remove());
        }


    }

}