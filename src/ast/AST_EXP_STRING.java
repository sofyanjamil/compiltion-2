package ast;

public class AST_EXP_STRING extends AST_EXP
{
	public String value;
	
	public AST_EXP_STRING(int line, String value)
	{
		serialNumber = AST_Node_Serial_Number.getFresh();
		this.line = line;
		System.out.format("====================== exp -> STRING( \"%s\" )\n", value);
		this.value = value;
	}
	
	public void printMe()
	{
		System.out.format("AST NODE EXP STRING( \"%s\" )\n", value);
		
		AST_GRAPHVIZ.getInstance().logNode(
			serialNumber,
			String.format("STRING\n(\"%s\")", value));
	}
}

