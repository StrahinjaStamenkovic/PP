package AST;

public class Or extends LogicalExpression {
	
	public Or( Expression left, Expression right )
	{
		super( left, right );
	}
	
	protected String opCode()
	{
		return "Or";
	}
}
