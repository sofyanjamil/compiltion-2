package ast;

public class AST_EXP_INT extends AST_EXP
{
	public int value;
	public boolean isNegative;
	
	public AST_EXP_INT(int line, int value, boolean isNegative)
	{
		serialNumber = AST_Node_Serial_Number.getFresh();
		this.line = line;
		
		if (isNegative) {
			System.out.format("====================== exp -> MINUS INT( %d )\n", value);
		} else {
			System.out.format("====================== exp -> INT( %d )\n", value);
		}
		
		this.value = value;
		this.isNegative = isNegative;
	}
	
	public void printMe()
	{
		int displayValue = isNegative ? -value : value;
		System.out.format("AST NODE EXP INT( %d )\n", displayValue);
		
		AST_GRAPHVIZ.getInstance().logNode(
			serialNumber,
			String.format("INT\n(%d)", displayValue));
	}
}

