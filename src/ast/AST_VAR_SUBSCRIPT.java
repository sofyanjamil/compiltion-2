package ast;

public class AST_VAR_SUBSCRIPT extends AST_VAR
{
	public AST_VAR var;
	public AST_EXP subscript;
	
	public AST_VAR_SUBSCRIPT(int line, AST_VAR var, AST_EXP subscript)
	{
		serialNumber = AST_Node_Serial_Number.getFresh();
		this.line = line;
		this.var = var;
		this.subscript = subscript;
	}
	
	public void printMe()
	{
		if (var != null) var.printMe();
		if (subscript != null) subscript.printMe();
		
		AST_GRAPHVIZ.getInstance().logNode(serialNumber, "SUBSCRIPT\\n[...]");
		if (var != null) AST_GRAPHVIZ.getInstance().logEdge(serialNumber, var.serialNumber);
		if (subscript != null) AST_GRAPHVIZ.getInstance().logEdge(serialNumber, subscript.serialNumber);
	}
}
