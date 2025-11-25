package ast;

public class AST_EXP_INT extends AST_EXP
{
	public int value;
	public boolean isNegative;
	
	public AST_EXP_INT(int line, int value, boolean isNegative)
	{
		serialNumber = AST_Node_Serial_Number.getFresh();
		this.line = line;
		this.value = value;
		this.isNegative = isNegative;
	}
	
	public void printMe()
	{
		int displayValue = isNegative ? -value : value;
		AST_GRAPHVIZ.getInstance().logNode(serialNumber, String.format("INT\\n(%d)", displayValue));
	}
}
