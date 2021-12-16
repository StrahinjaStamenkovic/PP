import java.io.Reader;
import java.util.Stack;

public class SyntaxAnalyzer {

    private Stack<Integer> stack;
    private SyntaxTable st;
    private MPLexer lexer;

    SyntaxAnalyzer(Reader in) {
        this.stack = new Stack<>();
        this.lexer = new MPLexer(in);

        this.st = new SyntaxTable();
    }

    public boolean SA_LR() {
        push(sym.EOF);
        boolean found = false, error = false;
        int top_state, k;
        Yytoken next = nextlex();
        String action;

        do {
            action = action(top(), next);
            String[] split_action = action.split(" ");

            switch (split_action[0]) {
                case ("sk"):
                    push(next.m_index);
                    push(Integer.parseInt(split_action[1]));
                    next = nextlex();
                    break;
                case ("rk"):
                    k = Integer.parseInt(split_action[1]);
                    pop(2 * st.Rules.get(k).right.size());

                    top_state = top();
                    push(st.Rules.get(k).left);
                    push(goTo(top_state, st.Rules.get(k).left));
                    break;
                case ("acc"):
                    found = true;
                    break;
                case ("err"):
                    error = true;
                    break;
            }
        } while (!found && !error);

        return found;
    }

    private Yytoken nextlex() {
        try {
            return this.lexer.next_token();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private int push(int token) {
        return this.stack.push(token);
    }

    private void pop(int n) {
        try {
            for (var i = 0; i < n; i++)
                stack.pop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int top() {
        try {
            return this.stack.peek();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    private String action(int a, Yytoken next) {
        String ret = null;
        try {
            System.out.println("State: " + top());
            System.out.println("Next: " + next.m_index + " [" + next.m_text + "]");
            ret = this.st.Table.get(a).get(next.m_index);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (ret == null)
            ret = "err";
        return ret;
    }

    private int goTo(int state, int rule) {
        int ret = -1;
        try {
            ret = Integer.parseInt(this.st.Table.get(state).get(rule));
            System.out.println("Goto(" + state + ", " + rule + ") = " + ret);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }
}
