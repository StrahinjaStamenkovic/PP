package AST;

import java.io.BufferedWriter;
import java.io.IOException;

public class WhileLoop extends Statement{
	private Expression condition;
	private Statement thenBlock;
	private Statement elseBlock;
	public WhileLoop(Expression e, Statement thenS, Statement elseS )
	{
		condition = e;
		thenBlock = thenS;
		elseBlock = elseS;
	}
	@Override
	public void translate(BufferedWriter out) throws IOException {
		String startLabel = ASTNode.genLab();
		String endLabel = ASTNode.genLab();
		out.write( startLabel + ":" );
		out.newLine();
		condition.translate( out );
		condition.genLoad( "R1", out );
		out.write( "\tJumpIfNotZero\tR1, " + endLabel );
		out.newLine();
		thenBlock.translate( out );
		out.write( "\tJump\t" + startLabel );
		out.newLine();
		out.write( endLabel + ":" );
		out.newLine();
		elseBlock.translate(out);
	}
	
}
