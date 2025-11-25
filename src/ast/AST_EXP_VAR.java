package ast;

public class AST_EXP_VAR extends AST_EXP
{
	public AST_VAR var;
	
	public AST_EXP_VAR(int line, AST_VAR var)
	{
		serialNumber = AST_Node_Serial_Number.getFresh();
		this.line = line;
		System.out.print("====================== exp -> var\n");
		this.var = var;
	}
	
	public void printMe()
	{
		System.out.print("AST NODE EXP VAR\n");
		if (var != null) var.printMe();
		
		AST_GRAPHVIZ.getInstance().logNode(
			serialNumber,
			"EXP\nVAR");
		
		if (var != null) AST_GRAPHVIZ.getInstance().logEdge(serialNumber, var.serialNumber);
	}
}

