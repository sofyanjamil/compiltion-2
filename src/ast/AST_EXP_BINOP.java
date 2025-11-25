package ast;

public class AST_EXP_BINOP extends AST_EXP
{
	public AST_EXP left;
	public AST_EXP right;
	public String op;
	
	public AST_EXP_BINOP(int line, AST_EXP left, AST_EXP right, String op)
	{
		serialNumber = AST_Node_Serial_Number.getFresh();
		this.line = line;
		this.left = left;
		this.right = right;
		this.op = op;
	}
	
	public void printMe()
	{
		if (left != null) left.printMe();
		if (right != null) right.printMe();
		
		AST_GRAPHVIZ.getInstance().logNode(serialNumber, String.format("BINOP\\n(%s)", op));
		if (left != null) AST_GRAPHVIZ.getInstance().logEdge(serialNumber, left.serialNumber);
		if (right != null) AST_GRAPHVIZ.getInstance().logEdge(serialNumber, right.serialNumber);
	}
}
