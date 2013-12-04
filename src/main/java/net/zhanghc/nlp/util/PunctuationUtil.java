package net.zhanghc.nlp.util;

import java.util.HashSet;

public class PunctuationUtil {

	static HashSet<Character> EndPunc = new HashSet<Character>();
	static HashSet<Character> SubPunc = new HashSet<Character>();
	static HashSet<Character> AccPunc = new HashSet<Character>();
	static HashSet<Character> LeftPunc = new HashSet<Character>();
	static HashSet<Character> RightPunc = new HashSet<Character>();

	static {
		EndPunc.add((char)0x0021); //!
		EndPunc.add((char)0x002E); //.
		EndPunc.add((char)0x003F); //?
		EndPunc.add((char)0x3002); //。
		EndPunc.add((char)0xFF01); //！
		EndPunc.add((char)0xFF0E); //．
		EndPunc.add((char)0xFF1F); //？

		SubPunc.add((char)0x002C); //,
		SubPunc.add((char)0x003A); //:
		SubPunc.add((char)0x003B); //;
		SubPunc.add((char)0xFE30); //︰
		SubPunc.add((char)0xFF0C); //，
		SubPunc.add((char)0xFF1A); //：
		SubPunc.add((char)0xFF1B); //；

		AccPunc.add((char)0x2026); //…
		AccPunc.add((char)0x3001); //、

		LeftPunc.add((char)0x0022); //"
		LeftPunc.add((char)0x0028); //(
		LeftPunc.add((char)0x005B); //[
		LeftPunc.add((char)0x007B); //{
		LeftPunc.add((char)0x3008); //〈
		LeftPunc.add((char)0x300A); //《
		LeftPunc.add((char)0x300C); //「
		LeftPunc.add((char)0x300E); //『
		LeftPunc.add((char)0x3010); //【
		LeftPunc.add((char)0x3014); //〔
		LeftPunc.add((char)0x3016); //〖
		LeftPunc.add((char)0x2018); //‘
		LeftPunc.add((char)0x201C); //“
		LeftPunc.add((char)0xFF02); //＂
		LeftPunc.add((char)0xFF08); //（
		LeftPunc.add((char)0xFF1C); //＜
		LeftPunc.add((char)0xFF3B); //［
		LeftPunc.add((char)0xFF5B); //｛

		RightPunc.add((char)0x0022); //"
		RightPunc.add((char)0x0029); //)
		RightPunc.add((char)0x005D); //]
		RightPunc.add((char)0x007D); //}
		RightPunc.add((char)0x3009); //〉
		RightPunc.add((char)0x300B); //》
		RightPunc.add((char)0x300D); //」
		RightPunc.add((char)0x300F); //』
		RightPunc.add((char)0x3011); //】
		RightPunc.add((char)0x3015); //〕
		RightPunc.add((char)0x3017); //〗
		RightPunc.add((char)0x2019); //’
		RightPunc.add((char)0x201D); //”
		RightPunc.add((char)0xFF02); //＂
		RightPunc.add((char)0xFF09); //）
		RightPunc.add((char)0xFF1E); //＞
		RightPunc.add((char)0xFF3D); //］
		RightPunc.add((char)0xFF5D); //｝
	}

	public static boolean isEndPunc(char c) {
		return EndPunc.contains(c);
	}

	public static boolean isSubPunc(char c) {
		return SubPunc.contains(c);
	}

	public static boolean isAcceptablePunc(char c) {
		return AccPunc.contains(c) || 
				LeftPunc.contains(c) || 
				RightPunc.contains(c);
	}

	public static boolean isLeftPunc(char c) {
		return LeftPunc.contains(c);
	}

	public static boolean isRightPunc(char c) {
		return RightPunc.contains(c);
	}

	public static boolean isConjPunc(char c, boolean isChinese) {
		if(isChinese)
			return c == 0x3001;
		else
			return c == 0x002C;
	}

	public static boolean isLegalPunc(char c) {
		return EndPunc.contains(c) || 
				SubPunc.contains(c) || 
				AccPunc.contains(c) || 
				LeftPunc.contains(c) || 
				RightPunc.contains(c);
	}

}
