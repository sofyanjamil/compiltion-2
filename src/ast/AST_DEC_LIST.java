package ast;

public class AST_DEC_LIST extends AST_Node
{
	public AST_DEC head;
	public AST_DEC_LIST tail;
	
	public AST_DEC_LIST(AST_DEC head, AST_DEC_LIST tail)
	{
		serialNumber = AST_Node_Serial_Number.getFresh();
		if (tail != null) System.out.print("====================== decList -> dec decList\n");
		if (tail == null) System.out.print("====================== decList -> dec\n");
		this.head = head;
		this.tail = tail;
	}
	
	public void printMe()
	{
		System.out.print("AST NODE DEC LIST\n");
		if (head != null) head.printMe();
		if (tail != null) tail.printMe();
		
		AST_GRAPHVIZ.getInstance().logNode(
			serialNumber,
			"DEC\nLIST");
		
		if (head != null) AST_GRAPHVIZ.getInstance().logEdge(serialNumber, head.serialNumber);
		if (tail != null) AST_GRAPHVIZ.getInstance().logEdge(serialNumber, tail.serialNumber);
	}
}

