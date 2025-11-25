package ast;

public class AST_STMT_RETURN extends AST_STMT
{
	public AST_EXP exp;  // null for void return
	
	public AST_STMT_RETURN(int line, AST_EXP exp)
	{
		serialNumber = AST_Node_Serial_Number.getFresh();
		this.line = line;
		
		if (exp != null) {
			System.out.print("====================== stmt -> RETURN exp SEMICOLON\n");
		} else {
			System.out.print("====================== stmt -> RETURN SEMICOLON\n");
		}
		
		this.exp = exp;
	}
	
	public void printMe()
	{
		System.out.print("AST NODE STMT RETURN\n");
		if (exp != null) exp.printMe();
		
		AST_GRAPHVIZ.getInstance().logNode(
			serialNumber,
			"RETURN");
		
		if (exp != null) AST_GRAPHVIZ.getInstance().logEdge(serialNumber, exp.serialNumber);
	}
}

