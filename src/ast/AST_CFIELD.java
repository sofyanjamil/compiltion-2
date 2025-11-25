package ast;

public class AST_CFIELD extends AST_Node
{
	public AST_VAR_DEC varDec;
	public AST_FUNC_DEC funcDec;
	
	public AST_CFIELD(AST_VAR_DEC varDec)
	{
		serialNumber = AST_Node_Serial_Number.getFresh();
		this.varDec = varDec;
		this.funcDec = null;
	}
	
	public AST_CFIELD(AST_FUNC_DEC funcDec)
	{
		serialNumber = AST_Node_Serial_Number.getFresh();
		this.varDec = null;
		this.funcDec = funcDec;
	}
	
	public void printMe()
	{
		if (varDec != null) varDec.printMe();
		if (funcDec != null) funcDec.printMe();
		
		AST_GRAPHVIZ.getInstance().logNode(serialNumber, "CFIELD");
		if (varDec != null) AST_GRAPHVIZ.getInstance().logEdge(serialNumber, varDec.serialNumber);
		if (funcDec != null) AST_GRAPHVIZ.getInstance().logEdge(serialNumber, funcDec.serialNumber);
	}
}
