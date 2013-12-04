package net.zhanghc.nlp.core.pipeline;

import java.util.Properties;

public class DefaultProperties {
	 public static Properties defaultChineseProperties(String annotators) {
		Properties props = new Properties();
		props.setProperty("annotators", annotators);
		props.setProperty("customAnnotatorClass.segment", "edu.stanford.nlp.pipeline.ChineseSegmenterAnnotator");
		props.setProperty("segment.model", "edu/stanford/nlp/models/segmenter/chinese/ctb.gz");
		props.setProperty("segment.sighanCorporaDict", "edu/stanford/nlp/models/segmenter/chinese");
		props.setProperty("segment.serDictionary", "edu/stanford/nlp/models/segmenter/chinese/dict-chris6.ser.gz");
		props.setProperty("segment.sighanPostProcessing", "true");
		props.setProperty("ssplit.isOneSentence", "true");
		props.setProperty("pos.model", "edu/stanford/nlp/models/pos-tagger/chinese-distsim/chinese-distsim.tagger");
		props.setProperty("ner.model", "edu/stanford/nlp/models/ner/chinese.misc.distsim.crf.ser.gz");
		props.setProperty("ner.applyNumericClassifiers", "false");
		props.setProperty("ner.useSUTime", "false");
		props.setProperty("parse.model", "edu/stanford/nlp/models/lexparser/chinesePCFG.ser.gz");
		props.setProperty("parse.flags", "");
		return props;
	}
	
	public static Properties defaultEnglishProperties(String annotators) {
		Properties props = new Properties();
		props.setProperty("annotators", annotators);
		return props;
	}

}
