package ast;

public class AST_STMT_CALL extends AST_STMT
{
	public AST_VAR var;  // null for simple function call, non-null for method call
	public String funcName;
	public AST_EXP_LIST args;
	
	public AST_STMT_CALL(int line, AST_VAR var, String funcName, AST_EXP_LIST args)
	{
		serialNumber = AST_Node_Serial_Number.getFresh();
		this.line = line;
		
		if (var != null) {
			System.out.format("====================== stmt -> var DOT ID( %s ) LPAREN expList RPAREN SEMICOLON\n", funcName);
		} else {
			System.out.format("====================== stmt -> ID( %s ) LPAREN expList RPAREN SEMICOLON\n", funcName);
		}
		
		this.var = var;
		this.funcName = funcName;
		this.args = args;
	}
	
	public void printMe()
	{
		System.out.format("AST NODE STMT CALL( %s )\n", funcName);
		if (var != null) var.printMe();
		if (args != null) args.printMe();
		
		String label = var != null ? 
			String.format("CALL\n.%s()", funcName) :
			String.format("CALL\n%s()", funcName);
		
		AST_GRAPHVIZ.getInstance().logNode(serialNumber, label);
		
		if (var != null) AST_GRAPHVIZ.getInstance().logEdge(serialNumber, var.serialNumber);
		if (args != null) AST_GRAPHVIZ.getInstance().logEdge(serialNumber, args.serialNumber);
	}
}

