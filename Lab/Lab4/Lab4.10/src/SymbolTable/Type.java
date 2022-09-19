package SymbolTable;

public class Type extends SymbolNode {
	public static int UNKNOWN = 0;
	public static int INTEGER = 1;
	public static int REAL = 3;
	public static int BOOLEAN = 4;
	public static int CHAR = 5;

	public int tkind;
	
	public Type ( String name, 
			int typeKind, 
			SymbolNode next)
	{
		super( name, SymbolNode.TYPE, null, next );
		this.tkind = typeKind;
		this.type = this;
	}
}