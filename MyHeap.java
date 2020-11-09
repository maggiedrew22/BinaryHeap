import java.util.ArrayList;

public class MyHeap<V extends Comparable<V>> implements CS211PriorityQueueInterface<V> {
    private ArrayList<V> myQueue;
    private boolean isMin;
    private int lastIndex;

    public MyHeap(boolean isMin){
        this.myQueue = new ArrayList<V>();
        this.myQueue.add(0, null);
        this.isMin = isMin;
        this.lastIndex = 0;
    }

    @Override
    public void insert(V w) {
        //increment lastIndex by 1
        lastIndex++;

        //place directly at end of myQueue
        this.myQueue.add((lastIndex), w);

        //bubble up as needed
        bubbleUp(lastIndex);
    }

    @Override
    public V peek() {
        //if myQueue is empty, return null
        if(isEmpty()){
            return null;
            //otherwise, return element at root of myQueue
        } else{
            V toPeek = this.myQueue.get(1);
            return toPeek;
        }
    }

    @Override
    public V remove() {

        //remove element from root (index 1)
        V toReturn = this.myQueue.get(1);
        this.myQueue.remove(1);
        //decrement lastIndex by 1
        lastIndex--;
        //move element at the end of heap to top
        this.myQueue.add(1, this.myQueue.get(this.myQueue.size() - 1));
        //remove last element
        this.myQueue.remove(this.myQueue.size() - 1);
        //call bubbleDown on root element
        bubbleDown(1);


        return toReturn;
    }

    @Override
    public void build(ArrayList<V> words) {
        this.myQueue.clear();
        this.myQueue.add(null);
        for (int i = 0; i < words.size(); i++){
            this.insert(words.get(i));
        }
    }

    @Override
    public boolean isEmpty() {
        if(this.myQueue.size() == 1){
            return true;
        }
        return false;
    }

    @Override
    public void writePQ() {
        //prints every element in arraylist
        for(int i = 1; i < lastIndex + 1; i++){
            System.out.println(this.myQueue.get(i) + " ");
        }
    }

    public boolean compare(V parent, V child){
        //creates boolean to return, default is don't swap elements
        boolean ifSwap = false;
        //finds index of where both elements are stored
        int pspot = this.myQueue.indexOf(parent);
        int cspot = this.myQueue.indexOf(child);
        //checks to make sure both elements exist
        if (parent != null && child != null) {
            //if tree is a min tree
            if (!isMin) {
                if (this.myQueue.get(pspot).compareTo(this.myQueue.get(cspot)) > 0){
                    ifSwap = true;
                    return ifSwap;
                } else {
                    ifSwap = false;
                    return ifSwap;
                }
            }
            //if the tree is a max tree
            if (isMin) {
                if (this.myQueue.get(pspot).compareTo(this.myQueue.get(cspot)) < 0) {
                    ifSwap = true;
                    return ifSwap;
                } else {
                    ifSwap = false;
                    return ifSwap;
                }
            }
        }
        return ifSwap;
    }

    //bubbleUp
    public void bubbleUp(int index){
        //checks if the element is at the root or if it is already sorted
        if (index == 1 || (compare(this.myQueue.get(index), this.myQueue.get(index / 2))) == false){
            //if not at root or sorted, swap elements, then call bubbleUp recursively on new parent element
        } else {
            swap(index, index/2);
            bubbleUp(index/2);
        }

    }

    //swap exchanges two elements, used in bubbleUp and bubbleDown
    public void swap(int myIndex, int newIndex){
        V temp = this.myQueue.get(myIndex);
        this.myQueue.set(myIndex, this.myQueue.get(newIndex));
        this.myQueue.set(newIndex, temp);
    }

    //bubbleDown
    public void bubbleDown(int index){
        //System.out.println("Bubble Down index is: " + index);
        int twiceIndex = 2 * index;
        //bottom cases of heap tree - checks if there is a left/right child element corresponding to parent element in the array
        if(twiceIndex >= this.myQueue.size() || (twiceIndex + 1) >= this.myQueue.size()){
            //checks if parent element then has as left child in array
            if(twiceIndex < this.myQueue.size()){
                //gets parent element and child element from array
                V parent = this.myQueue.get(index);
                V leftChild = this.myQueue.get(twiceIndex);
                //if parent is smaller than left child
                if(compare(leftChild, parent)){
                    //swap if parent should be swapped with left child
                    swap(this.myQueue.indexOf(parent), this.myQueue.indexOf(leftChild));
                    bubbleDown(twiceIndex);
                }
            }
            //if twiceIndex is at the end or beyond the arraylist, return because we're at the bottom of heap
            return;
        }

        //creates parent, left child, right child elements
        //System.out.println("Check bubbleDown");
        V parent = this.myQueue.get(index);
        V leftChild = this.myQueue.get(twiceIndex);
        V rightChild = this.myQueue.get(twiceIndex + 1);
        //if left child is larger than right child
        if(compare(leftChild, rightChild)){
            //System.out.println("first side");
            //if parent should be swapped with left child
            if(compare(leftChild, parent)){
                swap(this.myQueue.indexOf(parent), this.myQueue.indexOf(leftChild));
                bubbleDown(twiceIndex);
            }
            //if left child is smaller than or equal to right child
        } else {
            //System.out.println("Second side");
            //if parent should be swapped with right child
            if(compare(rightChild, parent)){
                //System.out.println("Swap elements");
                swap(this.myQueue.indexOf(parent), this.myQueue.indexOf(rightChild));
                bubbleDown(twiceIndex + 1);
            }
        }

    }
}
