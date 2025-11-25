package ast;

public class AST_ARG_LIST extends AST_Node
{
	public AST_TYPE type;
	public String name;
	public AST_ARG_LIST tail;
	
	public AST_ARG_LIST(AST_TYPE type, String name, AST_ARG_LIST tail)
	{
		serialNumber = AST_Node_Serial_Number.getFresh();
		if (tail != null) System.out.format("====================== argList -> type ID( %s ) COMMA argList\n", name);
		if (tail == null) System.out.format("====================== argList -> type ID( %s )\n", name);
		
		this.type = type;
		this.name = name;
		this.tail = tail;
	}
	
	public void printMe()
	{
		System.out.format("AST NODE ARG( %s )\n", name);
		if (type != null) type.printMe();
		if (tail != null) tail.printMe();
		
		AST_GRAPHVIZ.getInstance().logNode(
			serialNumber,
			String.format("ARG\n(%s)", name));
		
		if (type != null) AST_GRAPHVIZ.getInstance().logEdge(serialNumber, type.serialNumber);
		if (tail != null) AST_GRAPHVIZ.getInstance().logEdge(serialNumber, tail.serialNumber);
	}
}

