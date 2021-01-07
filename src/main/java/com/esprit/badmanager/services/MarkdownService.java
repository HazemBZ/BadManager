package com.esprit.badmanager.services;

import org.springframework.stereotype.Service;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.MutableDataSet;

@Service
public class MarkdownService {

	
	public String parseMarkdown(String markdown) {
		// possibility of adding advanced options
		MutableDataSet options = new MutableDataSet();
		
		Parser parser = Parser.builder(options).build();
		HtmlRenderer renderer = HtmlRenderer.builder(options).build();
		
		Node document = parser.parse(markdown);
		String html = renderer.render(document);
		return html;
		
	}
}
