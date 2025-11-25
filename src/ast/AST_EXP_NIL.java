package ast;

public class AST_EXP_NIL extends AST_EXP
{
	public AST_EXP_NIL(int line)
	{
		serialNumber = AST_Node_Serial_Number.getFresh();
		this.line = line;
	}
	
	public void printMe()
	{
		AST_GRAPHVIZ.getInstance().logNode(serialNumber, "NIL");
	}
}
