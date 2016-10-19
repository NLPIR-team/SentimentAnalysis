package com.lingjoin.sentimentAnalysis;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface CLJSAnalysisLibrary extends Library {

	CLJSAnalysisLibrary Instance=(CLJSAnalysisLibrary) Native.loadLibrary("LJSentimentAnalysis", CLJSAnalysisLibrary.class);
	
	public int LJST_Inits(String path, int encode, String sLicenceCode);
	
	public boolean LJST_GetParagraphSent(String lpszParagraph, byte[] szRes);
	
	public boolean LJST_GetFileSent(String lpszFilename, String szRes);

	public int LJST_ImportUserDict(String lpszFilename,boolean bOverwrite);
	
	public void LJST_Exits();
}
