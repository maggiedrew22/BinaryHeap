import java.util.ArrayList;

public interface CS211PriorityQueueInterface<V extends Comparable<V>> {


    public void insert(V w);

    public V peek();

    public V remove();

    public void build(ArrayList<V> words);

    public boolean isEmpty();

    public void writePQ();
}
