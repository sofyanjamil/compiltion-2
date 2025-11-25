package ast;

public class AST_FUNC_DEC extends AST_DEC
{
	public AST_TYPE returnType;
	public String name;
	public AST_ARG_LIST args;
	public AST_STMT_LIST body;
	
	public AST_FUNC_DEC(int line, AST_TYPE returnType, String name, AST_ARG_LIST args, AST_STMT_LIST body)
	{
		serialNumber = AST_Node_Serial_Number.getFresh();
		this.line = line;
		System.out.format("====================== funcDec -> type ID( %s ) LPAREN args RPAREN LBRACE stmtList RBRACE\n", name);
		
		this.returnType = returnType;
		this.name = name;
		this.args = args;
		this.body = body;
	}
	
	public void printMe()
	{
		System.out.format("AST NODE FUNC DEC( %s )\n", name);
		if (returnType != null) returnType.printMe();
		if (args != null) args.printMe();
		if (body != null) body.printMe();
		
		AST_GRAPHVIZ.getInstance().logNode(
			serialNumber,
			String.format("FUNC DEC\n(%s)", name));
		
		if (returnType != null) AST_GRAPHVIZ.getInstance().logEdge(serialNumber, returnType.serialNumber);
		if (args != null) AST_GRAPHVIZ.getInstance().logEdge(serialNumber, args.serialNumber);
		if (body != null) AST_GRAPHVIZ.getInstance().logEdge(serialNumber, body.serialNumber);
	}
}

