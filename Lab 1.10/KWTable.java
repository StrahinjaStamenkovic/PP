import java.util.Hashtable;

public class KWTable{
    private Hashtable<String, Integer> m_Table;
    public KWTable(){
        m_Table = new Hashtable<>();

        this.m_Table.put("program", sym.PROGRAM);
        this.m_Table.put("begin", sym.BEGIN);
        this.m_Table.put("end", sym.END);
        this.m_Table.put("integer", sym.INTEGER);
        this.m_Table.put("char", sym.CHAR);
        this.m_Table.put("real", sym.REAL);
        this.m_Table.put("boolean", sym.BOOLEAN);
        this.m_Table.put("while", sym.WHILE);
        this.m_Table.put("else", sym.ELSE);
        this.m_Table.put("or", sym.OR);
        this.m_Table.put("and", sym.AND);
        //this.m_Table.put("true", sym.TRUE);
        //this.m_Table.put("false", sym.FALSE);

    }

    public int find(String keyword)
    {
        Object symbol = this.m_Table.get(keyword);

        if(symbol != null)
            return ((Integer)symbol).intValue();

        return sym.ID;
    }
}