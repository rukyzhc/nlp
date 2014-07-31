package net.zhanghc.nlp.data.postag;

public enum BuiltInCN {
	N, NR, NZ,//noun
	V, VSHI, VYOU, VI,//verb
	A, //predictive adjective
	J, //modifier
	D, //adverb
	F, //localizer
	G, //morpheme
	R, RR, RZ, //pronoun
	M, Q, //quantity
	P, PBA, PBEI, //preposition
	C, CC, //conjunction
	T, //time
	U, UA, UDE1, UDE2, UDE3, UETC, UO, //particle
	Y, //final
	E, //interjection
	O, //onomatopoeia
	W, //puncuation
	I, //new word / idiom 
	X, //foreign and other
	;
	
	public static String convert(String pos, TagSet from, TagSet to) {
		return fromNative(toNative(pos, from), to);
	}

	public static String toNative(String pos, TagSet from) {
		switch(from) {
		case PENNTREE_CN:
			PennTreeCN pt = PennTreeCN.valueOf(pos.toUpperCase());
			return pt.toNative().name();
		case ICTCLAS_CN:
			IctclasCN ic = IctclasCN.valueOf(pos.toUpperCase());
			return ic.toNative().name();
		case BUILTIN_CN:
		default:
			return pos;
		}
	}

	public static String fromNative(String pos, TagSet to) {
		BuiltInCN p = BuiltInCN.valueOf(pos);
		switch(to) {
		case PENNTREE_CN:
			return PennTreeCN.fromNative(p).name();
		case ICTCLAS_CN:
			return IctclasCN.fromNative(p).name();
		case BUILTIN_CN:
		default:
			return pos;
		}
	}

}
