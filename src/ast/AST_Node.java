package ast;

public abstract class AST_Node
{
	/*******************************************/
	/* The serial number is for debug purposes */
	/*******************************************/
	public int serialNumber;
	
	/******************************/
	/* Line number in source file */
	/******************************/
	public int line;
	
	/***********************************************/
	/* The default message for an unknown AST node */
	/***********************************************/
	public void printMe()
	{
		System.out.print("AST NODE UNKNOWN\n");
	}
}
