package com.company.depinv;

import java.io.IOException;
import java.io.PrintWriter;

public class MessagePrinter {

	//Writes message to a file (Tightly Coupled dependent on printwriter and json formatter)
	/*public void writeMessage(Message msg, String fileName) throws IOException {
		Formatter formatter = new JSONFormatter();//creates formatter
		try(PrintWriter writer = new PrintWriter(new FileWriter(fileName))) { //creates print writer
			writer.println(formatter.format(msg)); //formats and writes message
			writer.flush();
			writer.close();
		}
	} */
	
	public void writeMessage(Message msg, Formatter formatter, PrintWriter writer) throws IOException {		
			writer.println(formatter.format(msg));
			writer.flush();
	}
}
