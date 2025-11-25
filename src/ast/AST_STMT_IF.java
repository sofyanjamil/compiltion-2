package ast;

public class AST_STMT_IF extends AST_STMT
{
	public AST_EXP cond;
	public AST_STMT_LIST thenBody;
	public AST_STMT_LIST elseBody;  // null if no else
	
	public AST_STMT_IF(int line, AST_EXP cond, AST_STMT_LIST thenBody, AST_STMT_LIST elseBody)
	{
		serialNumber = AST_Node_Serial_Number.getFresh();
		this.line = line;
		
		if (elseBody != null) {
			System.out.print("====================== stmt -> IF LPAREN exp RPAREN LBRACE stmtList RBRACE ELSE LBRACE stmtList RBRACE\n");
		} else {
			System.out.print("====================== stmt -> IF LPAREN exp RPAREN LBRACE stmtList RBRACE\n");
		}
		
		this.cond = cond;
		this.thenBody = thenBody;
		this.elseBody = elseBody;
	}
	
	public void printMe()
	{
		System.out.print("AST NODE STMT IF\n");
		if (cond != null) cond.printMe();
		if (thenBody != null) thenBody.printMe();
		if (elseBody != null) elseBody.printMe();
		
		String label = elseBody != null ? "IF-ELSE" : "IF";
		AST_GRAPHVIZ.getInstance().logNode(serialNumber, label);
		
		if (cond != null) AST_GRAPHVIZ.getInstance().logEdge(serialNumber, cond.serialNumber);
		if (thenBody != null) AST_GRAPHVIZ.getInstance().logEdge(serialNumber, thenBody.serialNumber);
		if (elseBody != null) AST_GRAPHVIZ.getInstance().logEdge(serialNumber, elseBody.serialNumber);
	}
}

