package com.lingjoin.sentimentAnalysis;


public class SentimentAnalysis {

	public static int state=0;
	
	public static int init(String arg){
		state=CLJSAnalysisLibrary.Instance.LJST_Inits(arg, 1, "0");
		return state;
	}
	
	public static byte[] getParagraphSent(String lpszParagraph){
		byte[] szRes=new byte[0];
		if(state==1){
			szRes=new byte[10000];
			CLJSAnalysisLibrary.Instance.LJST_GetParagraphSent(lpszParagraph, szRes);
		}
//		String result=new String();
//		try {
//			result = new String(szRes,"utf8");
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return szRes;
	}
	
	public static boolean getFileSent(String lpszFilename, String szRes){
		if(state==1)
			return CLJSAnalysisLibrary.Instance.LJST_GetFileSent(lpszFilename, szRes);
		else
			return false;
	}
	
	public int importUserDict(String lpszFilename,boolean bOverwrite){
		if(state==1)
			return CLJSAnalysisLibrary.Instance.LJST_ImportUserDict(lpszFilename, bOverwrite);
		else
			return 0;
	}
	
	public static void exits(){
		CLJSAnalysisLibrary.Instance.LJST_Exits();
	}
}
