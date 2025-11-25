package ast;

public class AST_STMT_LIST extends AST_Node
{
	public AST_STMT head;
	public AST_STMT_LIST tail;
	
	public AST_STMT_LIST(AST_STMT head, AST_STMT_LIST tail)
	{
		serialNumber = AST_Node_Serial_Number.getFresh();
		this.head = head;
		this.tail = tail;
	}
	
	public void printMe()
	{
		if (head != null) head.printMe();
		if (tail != null) tail.printMe();
		
		AST_GRAPHVIZ.getInstance().logNode(serialNumber, "STMT\\nLIST");
		if (head != null) AST_GRAPHVIZ.getInstance().logEdge(serialNumber, head.serialNumber);
		if (tail != null) AST_GRAPHVIZ.getInstance().logEdge(serialNumber, tail.serialNumber);
	}
}
