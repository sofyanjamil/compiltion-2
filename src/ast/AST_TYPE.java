package ast;

public class AST_TYPE extends AST_Node
{
	public String typeName;
	
	public AST_TYPE(int line, String typeName)
	{
		serialNumber = AST_Node_Serial_Number.getFresh();
		this.line = line;
		System.out.format("====================== type -> %s\n", typeName);
		this.typeName = typeName;
	}
	
	public void printMe()
	{
		System.out.format("AST NODE TYPE( %s )\n", typeName);
		
		AST_GRAPHVIZ.getInstance().logNode(
			serialNumber,
			String.format("TYPE\n(%s)", typeName));
	}
}

