package AST;

public class And extends LogicalExpression {
	
	public And( Expression left, Expression right )
	{
		super( left, right );
	}
	
	protected String opCode()
	{
		return "And";
	}
}
