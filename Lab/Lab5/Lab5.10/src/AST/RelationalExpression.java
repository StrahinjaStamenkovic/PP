package AST;
import main.*;
import java.io.BufferedWriter;
import java.io.IOException;

public class RelationalExpression extends Expression{
	private Expression left;
	private Expression right;
	private int relOp;
	public RelationalExpression(Expression l,int ro,Expression r)
	{
		left = l;
		relOp = ro;
		right = r;
	}
	
	protected String opCode() {
		switch (relOp){
			case sym.EQUAL_TO:
				return "Compare_Equal";
		
			case sym.LESS_OR_EQUAL_TO:
				return "Compare_Less";
	
			case sym.GREATER_OR_EQUAL_TO:
				return "Compare_Greater";
			case sym.LESS:
				return "Compare_Less";
	
			case sym.GREATER:
				return "Compare_Greater";
			default:
				return "ERROR";
	
		}
	}
	
	public void translate(BufferedWriter out)
	throws IOException
	{
		left.translate( out );
		right.translate( out );
		left.genLoad( "R1", out );
		right.genLoad( "R2", out );
		out.write( "\t" + opCode() + "\t\tR1, R2" );
		out.newLine();
		this.result = ASTNode.genVar();
		out.write( "\tStore\t\tR1, " + this.result );
		out.newLine();
	}	
}
