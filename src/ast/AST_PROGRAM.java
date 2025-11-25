package ast;

public class AST_PROGRAM extends AST_Node
{
	public AST_DEC_LIST decList;
	
	public AST_PROGRAM(AST_DEC_LIST decList)
	{
		serialNumber = AST_Node_Serial_Number.getFresh();
		this.decList = decList;
	}
	
	public void printMe()
	{
		if (decList != null) decList.printMe();
		
		AST_GRAPHVIZ.getInstance().logNode(serialNumber, "PROGRAM");
		if (decList != null) {
			AST_GRAPHVIZ.getInstance().logEdge(serialNumber, decList.serialNumber);
		}
	}
}
