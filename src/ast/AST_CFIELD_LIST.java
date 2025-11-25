package ast;

public class AST_CFIELD_LIST extends AST_Node
{
	public AST_CFIELD head;
	public AST_CFIELD_LIST tail;
	
	public AST_CFIELD_LIST(AST_CFIELD head, AST_CFIELD_LIST tail)
	{
		serialNumber = AST_Node_Serial_Number.getFresh();
		if (tail != null) System.out.print("====================== cFieldList -> cField cFieldList\n");
		if (tail == null) System.out.print("====================== cFieldList -> cField\n");
		
		this.head = head;
		this.tail = tail;
	}
	
	public void printMe()
	{
		System.out.print("AST NODE CFIELD LIST\n");
		if (head != null) head.printMe();
		if (tail != null) tail.printMe();
		
		AST_GRAPHVIZ.getInstance().logNode(
			serialNumber,
			"CFIELD\nLIST");
		
		if (head != null) AST_GRAPHVIZ.getInstance().logEdge(serialNumber, head.serialNumber);
		if (tail != null) AST_GRAPHVIZ.getInstance().logEdge(serialNumber, tail.serialNumber);
	}
}

