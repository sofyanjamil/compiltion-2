package ast;

public class AST_STMT_ASSIGN extends AST_STMT
{
	public AST_VAR var;
	public AST_EXP exp;
	public AST_NEW_EXP newExp;
	
	public AST_STMT_ASSIGN(int line, AST_VAR var, AST_EXP exp, AST_NEW_EXP newExp)
	{
		serialNumber = AST_Node_Serial_Number.getFresh();
		this.line = line;
		this.var = var;
		this.exp = exp;
		this.newExp = newExp;
	}
	
	public void printMe()
	{
		if (var != null) var.printMe();
		if (exp != null) exp.printMe();
		if (newExp != null) newExp.printMe();
		
		AST_GRAPHVIZ.getInstance().logNode(serialNumber, "ASSIGN");
		if (var != null) AST_GRAPHVIZ.getInstance().logEdge(serialNumber, var.serialNumber);
		if (exp != null) AST_GRAPHVIZ.getInstance().logEdge(serialNumber, exp.serialNumber);
		if (newExp != null) AST_GRAPHVIZ.getInstance().logEdge(serialNumber, newExp.serialNumber);
	}
}
