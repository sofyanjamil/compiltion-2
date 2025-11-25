package ast;

public class AST_EXP_VAR extends AST_EXP
{
	public AST_VAR var;
	
	public AST_EXP_VAR(int line, AST_VAR var)
	{
		serialNumber = AST_Node_Serial_Number.getFresh();
		this.line = line;
		this.var = var;
	}
	
	public void printMe()
	{
		if (var != null) var.printMe();
		
		AST_GRAPHVIZ.getInstance().logNode(serialNumber, "EXP\\nVAR");
		if (var != null) AST_GRAPHVIZ.getInstance().logEdge(serialNumber, var.serialNumber);
	}
}
