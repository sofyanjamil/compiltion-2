package ast;

public class AST_STMT_VAR_DEC extends AST_STMT
{
	public AST_VAR_DEC varDec;
	
	public AST_STMT_VAR_DEC(AST_VAR_DEC varDec)
	{
		serialNumber = AST_Node_Serial_Number.getFresh();
		this.varDec = varDec;
		if (varDec != null) this.line = varDec.line;
	}
	
	public void printMe()
	{
		if (varDec != null) varDec.printMe();
		
		AST_GRAPHVIZ.getInstance().logNode(serialNumber, "STMT\\nVAR DEC");
		if (varDec != null) AST_GRAPHVIZ.getInstance().logEdge(serialNumber, varDec.serialNumber);
	}
}
