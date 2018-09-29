/**
 * EvalPostfix Class
 *
 * @author Drew Theis
 * @date 9/27/2018
 */
public interface ObjectStackInterface {
    /**
     * Interface ObjectStackInterface
     * Given code from class online and book
     */
    public boolean isEmpty();
    public boolean isFull();
    public void clear();
    public void push(Object o);
    public Object pop();
    public Object top();
}