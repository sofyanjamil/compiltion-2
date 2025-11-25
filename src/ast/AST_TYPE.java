package ast;

public class AST_TYPE extends AST_Node
{
	public String typeName;
	
	public AST_TYPE(int line, String typeName)
	{
		serialNumber = AST_Node_Serial_Number.getFresh();
		this.line = line;
		this.typeName = typeName;
	}
	
	public void printMe()
	{
		AST_GRAPHVIZ.getInstance().logNode(serialNumber, String.format("TYPE\\n(%s)", typeName));
	}
}
