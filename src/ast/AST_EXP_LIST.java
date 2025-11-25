package ast;

public class AST_EXP_LIST extends AST_Node
{
	public AST_EXP head;
	public AST_EXP_LIST tail;
	
	public AST_EXP_LIST(AST_EXP head, AST_EXP_LIST tail)
	{
		serialNumber = AST_Node_Serial_Number.getFresh();
		this.head = head;
		this.tail = tail;
	}
	
	public void printMe()
	{
		if (head != null) head.printMe();
		if (tail != null) tail.printMe();
		
		AST_GRAPHVIZ.getInstance().logNode(serialNumber, "EXP\\nLIST");
		if (head != null) AST_GRAPHVIZ.getInstance().logEdge(serialNumber, head.serialNumber);
		if (tail != null) AST_GRAPHVIZ.getInstance().logEdge(serialNumber, tail.serialNumber);
	}
}
