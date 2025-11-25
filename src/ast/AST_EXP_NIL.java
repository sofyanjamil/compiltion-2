package ast;

public class AST_EXP_NIL extends AST_EXP
{
	public AST_EXP_NIL(int line)
	{
		serialNumber = AST_Node_Serial_Number.getFresh();
		this.line = line;
		System.out.print("====================== exp -> NIL\n");
	}
	
	public void printMe()
	{
		System.out.print("AST NODE EXP NIL\n");
		
		AST_GRAPHVIZ.getInstance().logNode(
			serialNumber,
			"NIL");
	}
}

