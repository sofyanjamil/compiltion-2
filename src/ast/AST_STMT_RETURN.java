package ast;

public class AST_STMT_RETURN extends AST_STMT
{
	public AST_EXP exp;
	
	public AST_STMT_RETURN(int line, AST_EXP exp)
	{
		serialNumber = AST_Node_Serial_Number.getFresh();
		this.line = line;
		this.exp = exp;
	}
	
	public void printMe()
	{
		if (exp != null) exp.printMe();
		
		AST_GRAPHVIZ.getInstance().logNode(serialNumber, "RETURN");
		if (exp != null) AST_GRAPHVIZ.getInstance().logEdge(serialNumber, exp.serialNumber);
	}
}
