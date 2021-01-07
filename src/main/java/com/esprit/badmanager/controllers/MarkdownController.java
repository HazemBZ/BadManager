package com.esprit.badmanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.badmanager.entities.Markdown;
import com.esprit.badmanager.services.MarkdownService;

@RestController
@RequestMapping("/markdown")
public class MarkdownController {

	@Autowired
	MarkdownService markdownService;
	
	@GetMapping("/parse")
	public String getMarkdownParse() {
		System.out.println("HIT GET PARSE");
		String MARKDOWN = "## hello there \n So there is no *urf* level \n ~~or so it seems~~";
		return markdownService.parseMarkdown(MARKDOWN);
	}
	
	@PostMapping("/parse")
	public Markdown postMarkdownParse(@RequestBody Markdown markdown) {
		System.out.println("HIT  POST PARSE");
		return new Markdown(markdownService.parseMarkdown(markdown.getData()));
	}
	
}
