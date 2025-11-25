package ast;

public class AST_NEW_EXP extends AST_Node
{
	public AST_TYPE type;
	public AST_EXP arraySize;
	
	public AST_NEW_EXP(int line, AST_TYPE type, AST_EXP arraySize)
	{
		serialNumber = AST_Node_Serial_Number.getFresh();
		this.line = line;
		this.type = type;
		this.arraySize = arraySize;
	}
	
	public void printMe()
	{
		if (type != null) type.printMe();
		if (arraySize != null) arraySize.printMe();
		
		String label = arraySize != null ? "NEW\\n[...]" : "NEW";
		AST_GRAPHVIZ.getInstance().logNode(serialNumber, label);
		if (type != null) AST_GRAPHVIZ.getInstance().logEdge(serialNumber, type.serialNumber);
		if (arraySize != null) AST_GRAPHVIZ.getInstance().logEdge(serialNumber, arraySize.serialNumber);
	}
}
