package net.zhanghc.nlp.data.util;

public class CharUtil {

	public static CharType classify(char c) {
		if(c <= '9' && c >= '0')
			return CharType.Numeric;
		if((c <= 'z' && c >= 'a') || (c <= 'Z' && c >= 'A'))
			return CharType.Latin;
		if(c <= 0x9FBF && c >= 0x4E00)
			return CharType.CJK;
		if(c <= 0xFF19 && c >= 0xFF10)
			return CharType.FWNumeric;
		if((c <= 0xFF3A && c >= 0xFF21) || (c <= 0xFF5A && c >= 0xFF41))
			return CharType.FWLatin;
		if(c == 0x3000 || c == ' ')
			return CharType.Space;
		if((c >= 0x0021 && c <= 0x007F) || 
				(c >= 0x2000 && c <= 0x206F) ||
				(c >= 0x3000 && c <= 0x303F) ||
				(c >= 0xFE50 && c <= 0xFE6F) ||
				(c >= 0xFF00 && c <= 0xFF66))
			return CharType.Punctuation;
		if((c <= 0x03A9 && c >= 0x0391) || (c <= 0x03C9 && c >= 0x03B1))
			return CharType.Greek;
		if((c >= 0x20A0 && c <= 0x20CF) /*currency*/ || (c >= 0x2460 && c <= 0x24FF) /*label*/)
			return CharType.Symbol;
		if(c >= 0x25A0 && c <= 0x25FF)
			return CharType.Geometric;
		if((c >= 0x2200 && c <= 0x22FF) || (c >= 0x2A00 && c <= 0x2AFF))
			return CharType.Math;
		return CharType.Other;
	}

}
