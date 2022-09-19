import java.util.LinkedList;
import java.util.List;

public class Rule {
    public int left;
    public LinkedList<Integer> right;

    public Rule(int left, List<Integer> list) {
        this.left = left;

        this.right = new LinkedList<>();
        for (int s : list) {
            this.right.add(s);
        }
    }

    @Override
    public String toString() {
        String ret = String.format("%d -> ", left);
        for (int alpha : this.right)
            ret += String.format("%d ", alpha);
        return ret;
    }
}