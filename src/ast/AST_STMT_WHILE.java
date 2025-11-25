package ast;

public class AST_STMT_WHILE extends AST_STMT
{
	public AST_EXP cond;
	public AST_STMT_LIST body;
	
	public AST_STMT_WHILE(int line, AST_EXP cond, AST_STMT_LIST body)
	{
		serialNumber = AST_Node_Serial_Number.getFresh();
		this.line = line;
		System.out.print("====================== stmt -> WHILE LPAREN exp RPAREN LBRACE stmtList RBRACE\n");
		
		this.cond = cond;
		this.body = body;
	}
	
	public void printMe()
	{
		System.out.print("AST NODE STMT WHILE\n");
		if (cond != null) cond.printMe();
		if (body != null) body.printMe();
		
		AST_GRAPHVIZ.getInstance().logNode(
			serialNumber,
			"WHILE");
		
		if (cond != null) AST_GRAPHVIZ.getInstance().logEdge(serialNumber, cond.serialNumber);
		if (body != null) AST_GRAPHVIZ.getInstance().logEdge(serialNumber, body.serialNumber);
	}
}

