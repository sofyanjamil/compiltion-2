package ast;

public class AST_VAR_SIMPLE extends AST_VAR
{
	public String name;
	
	public AST_VAR_SIMPLE(int line, String name)
	{
		serialNumber = AST_Node_Serial_Number.getFresh();
		this.line = line;
		this.name = name;
	}
	
	public void printMe()
	{
		AST_GRAPHVIZ.getInstance().logNode(serialNumber, String.format("VAR\\n(%s)", name));
	}
}
