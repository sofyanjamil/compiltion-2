package ast;

public class AST_VAR_DEC extends AST_DEC
{
	public AST_TYPE type;
	public String name;
	public AST_EXP initExp;
	public AST_NEW_EXP newExp;
	
	public AST_VAR_DEC(int line, AST_TYPE type, String name, AST_EXP initExp, AST_NEW_EXP newExp)
	{
		serialNumber = AST_Node_Serial_Number.getFresh();
		this.line = line;
		this.type = type;
		this.name = name;
		this.initExp = initExp;
		this.newExp = newExp;
	}
	
	public void printMe()
	{
		if (type != null) type.printMe();
		if (initExp != null) initExp.printMe();
		if (newExp != null) newExp.printMe();
		
		AST_GRAPHVIZ.getInstance().logNode(serialNumber, String.format("VAR DEC\\n(%s)", name));
		if (type != null) AST_GRAPHVIZ.getInstance().logEdge(serialNumber, type.serialNumber);
		if (initExp != null) AST_GRAPHVIZ.getInstance().logEdge(serialNumber, initExp.serialNumber);
		if (newExp != null) AST_GRAPHVIZ.getInstance().logEdge(serialNumber, newExp.serialNumber);
	}
}
