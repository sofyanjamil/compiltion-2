package ast;

public class AST_STMT_CALL extends AST_STMT
{
	public AST_VAR var;
	public String funcName;
	public AST_EXP_LIST args;
	
	public AST_STMT_CALL(int line, AST_VAR var, String funcName, AST_EXP_LIST args)
	{
		serialNumber = AST_Node_Serial_Number.getFresh();
		this.line = line;
		this.var = var;
		this.funcName = funcName;
		this.args = args;
	}
	
	public void printMe()
	{
		if (var != null) var.printMe();
		if (args != null) args.printMe();
		
		String label = var != null ? 
			String.format("CALL\\n.%s()", funcName) :
			String.format("CALL\\n%s()", funcName);
		
		AST_GRAPHVIZ.getInstance().logNode(serialNumber, label);
		if (var != null) AST_GRAPHVIZ.getInstance().logEdge(serialNumber, var.serialNumber);
		if (args != null) AST_GRAPHVIZ.getInstance().logEdge(serialNumber, args.serialNumber);
	}
}
