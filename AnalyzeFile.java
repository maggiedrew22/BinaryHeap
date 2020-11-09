import java.util.ArrayList;

public class AnalyzeFile<E extends Comparable<E>>{
    //creates maxHeap, minHeap, and 2 wordArray to hold words in text file
    MyHeap<Word> maxHeap;
    MyHeap<Word> minHeap;
    ArrayList<Word> wordArray;
    ArrayList<Word> wordArray2;

    public AnalyzeFile(String fileName){
        //reads file name to be inputted
        ReadFile fileToRead = new ReadFile(fileName);
        //creates array out of words in file
        wordArray = fileToRead.process();
        //creates duplicate array (to use for minHeap)
        wordArray2 = new ArrayList<>();
        //copies elements from wordArray into wordArray2
        for (int i = 0; i < wordArray.size(); i++){
            wordArray2.add(i, this.wordArray.get(i));
        }
        //sets max and min heaps
        maxHeap = new MyHeap<>(false);
        minHeap = new MyHeap<>(true);
        maxHeap.build(wordArray);
        minHeap.build(wordArray2);
    }

    public static void main(String[] args) {
        //instantiates toAnalyze for TextFile1.txt
        AnalyzeFile toAnalyze = new AnalyzeFile("TextFile1.txt");

        //prints out elements in minHeap
        for (int i = 0; i < 10; i++) {
            System.out.println("The " + (i + 1) + " least common word is: " + toAnalyze.minHeap.remove());
        }

        //prints out elements in maxHeap
        for (int i = 0; i < 10; i++){
            System.out.println("The " + (i + 1) + " most common word is: " + toAnalyze.maxHeap.remove());
        }
    }

}
