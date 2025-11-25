package ast;

public class AST_CLASS_DEC extends AST_DEC
{
	public String name;
	public String parent;
	public AST_CFIELD_LIST fields;
	
	public AST_CLASS_DEC(int line, String name, String parent, AST_CFIELD_LIST fields)
	{
		serialNumber = AST_Node_Serial_Number.getFresh();
		this.line = line;
		this.name = name;
		this.parent = parent;
		this.fields = fields;
	}
	
	public void printMe()
	{
		if (fields != null) fields.printMe();
		
		String label = parent != null ? 
			String.format("CLASS\\n(%s)\\nextends(%s)", name, parent) :
			String.format("CLASS\\n(%s)", name);
		
		AST_GRAPHVIZ.getInstance().logNode(serialNumber, label);
		if (fields != null) AST_GRAPHVIZ.getInstance().logEdge(serialNumber, fields.serialNumber);
	}
}
