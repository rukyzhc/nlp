package net.zhanghc.nlp.util;

import static org.junit.Assert.*;

import net.zhanghc.nlp.util.Splitter.DefaultSplitter;

import org.junit.Test;

public class TestSplitter {

	@Test
	public void test() {
		String s1 = "中华人民共和国，中央人民政府，现在成 立啦！！'. 我们就是 要求。 \n\r 我们就是这么要求的\n 好的";
		String[] ss1 = new String[] {
				"中华人民共和国，中央人民政府，现在成 立啦！！'. ",
				"我们就是 要求。 \n\r ",
				"我们就是这么要求的\n ",
				"好的"
		};
		String s2 = "This is what we want! This is the world?!Lucky!";
		String[] ss2 = new String[] {
				"This is what we want! ",
				"This is the world?!",
				"Lucky!"
		};
		Splitter splitter = DefaultSplitter.instance();
		
		splitter.setSource(s1);
		int i = 0;
		while(splitter.next()) {
			assertEquals(ss1[i++], splitter.current());
		}
		
		splitter.setSource(s2);
		i = 0;
		while(splitter.next()) {
			assertEquals(ss2[i++], splitter.current());
		}
	}

}
