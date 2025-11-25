import java.io.*;
import java.io.PrintWriter;
import java_cup.runtime.Symbol;
import ast.*;

public class Main
{
	static public void main(String argv[])
	{
		Lexer l;
		Parser p;
		Symbol s;
		AST_PROGRAM ast = null;
		FileReader fileReader;
		PrintWriter fileWriter;
		String inputFileName = argv[0];
		String outputFileName = argv[1];
		
		try
		{
			/********************************/
			/* [1] Initialize a file reader */
			/********************************/
			fileReader = new FileReader(inputFileName);

			/********************************/
			/* [2] Initialize a file writer */
			/********************************/
			fileWriter = new PrintWriter(outputFileName);
			
			/******************************/
			/* [3] Initialize a new lexer */
			/******************************/
			l = new Lexer(fileReader);
			
			/*******************************/
			/* [4] Initialize a new parser */
			/*******************************/
			p = new Parser(l);

			/***********************************/
			/* [5] 3 ... 2 ... 1 ... Parse !!! */
			/***********************************/
			try
			{
				ast = (AST_PROGRAM) p.parse().value;
				
				/****************************************/
				/* [6] Check for syntax errors          */
				/****************************************/
				if (p.errorLine >= 0)
				{
					fileWriter.format("ERROR(%d)\n", p.errorLine);
				}
				else
				{
					fileWriter.println("OK");
					
					/*************************/
					/* [7] Print the AST ... */
					/*************************/
					if (ast != null)
					{
						ast.printMe();
					}
					
					/*************************************/
					/* [8] Finalize AST GRAPHIZ DOT file */
					/*************************************/
					AST_GRAPHVIZ.getInstance().finalizeFile();
				}
			}
			catch (Exception e)
			{
				// Syntax error occurred
				if (p.errorLine >= 0)
				{
					fileWriter.format("ERROR(%d)\n", p.errorLine);
				}
				else
				{
					fileWriter.format("ERROR(%d)\n", l.getLine());
				}
			}
			
			/*************************/
			/* [9] Close output file */
			/*************************/
			fileWriter.close();
    	}
		catch (Exception e)
		{
			// Lexical error - file contains "ERROR" for lexical errors
			try
			{
				PrintWriter errorWriter = new PrintWriter(outputFileName);
				errorWriter.println("ERROR");
				errorWriter.close();
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}
}
