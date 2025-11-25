package ast;

public class AST_VAR_FIELD extends AST_VAR
{
	public AST_VAR var;
	public String fieldName;
	
	public AST_VAR_FIELD(int line, AST_VAR var, String fieldName)
	{
		serialNumber = AST_Node_Serial_Number.getFresh();
		this.line = line;
		this.var = var;
		this.fieldName = fieldName;
	}
	
	public void printMe()
	{
		if (var != null) var.printMe();
		
		AST_GRAPHVIZ.getInstance().logNode(serialNumber, String.format("FIELD\\n.%s", fieldName));
		if (var != null) AST_GRAPHVIZ.getInstance().logEdge(serialNumber, var.serialNumber);
	}
}
