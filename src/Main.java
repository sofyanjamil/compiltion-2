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
				if (p.errorLine > 0)
				{
					// Syntax error occurred during parsing
					fileWriter.print("ERROR(" + p.errorLine + ")");
				}
				else
				{
					// Parsing successful
					fileWriter.print("OK");
					
					/*************************/
					/* [7] Print the AST ... */
					/*************************/
					if (ast != null)
					{
						ast.printMe();
						
						/*************************************/
						/* [8] Finalize AST GRAPHIZ DOT file */
						/*************************************/
						AST_GRAPHVIZ.getInstance().finalizeFile();
					}
				}
			}
			catch (Exception e)
			{
				// Syntax error - parser threw exception
				if (p.errorLine > 0)
				{
					fileWriter.print("ERROR(" + p.errorLine + ")");
				}
				else
				{
					// Fallback: use current lexer line
					fileWriter.print("ERROR(" + l.getLine() + ")");
				}
			}
			
			/*************************/
			/* [9] Close output file */
			/*************************/
			fileWriter.println();
			fileWriter.close();
    	}
		catch (Exception e)
		{
			// Lexical error - output just ERROR
			try
			{
				PrintWriter errorWriter = new PrintWriter(outputFileName);
				errorWriter.print("ERROR");
				errorWriter.println();
				errorWriter.close();
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}
}
