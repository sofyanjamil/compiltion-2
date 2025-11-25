package ast;

public class AST_ARRAY_TYPEDEF extends AST_DEC
{
	public String name;
	public AST_TYPE elementType;
	
	public AST_ARRAY_TYPEDEF(int line, String name, AST_TYPE elementType)
	{
		serialNumber = AST_Node_Serial_Number.getFresh();
		this.line = line;
		this.name = name;
		this.elementType = elementType;
	}
	
	public void printMe()
	{
		if (elementType != null) elementType.printMe();
		
		AST_GRAPHVIZ.getInstance().logNode(serialNumber, String.format("ARRAY\\nTYPEDEF\\n(%s)", name));
		if (elementType != null) AST_GRAPHVIZ.getInstance().logEdge(serialNumber, elementType.serialNumber);
	}
}
