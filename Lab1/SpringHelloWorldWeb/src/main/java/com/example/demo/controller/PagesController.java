package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PagesController {

	@GetMapping("/")
	@ResponseBody
	String helloworld() {
		return "Hello World!";
	}
	

	@GetMapping("/team")
	@ResponseBody
	String team() {
		String body = "<HTML><body>This is our team:<br>"
				+ "<a href=\"https://github.com/lizzochek\">Liza</a>  </body></HTML><br>"
				+ "<a href=\"https://github.com/yehorbk\">Yehor</a>  </body></HTML><br>"
				+ "<a href=\"https://github.com/a-mountain\">Maksim</a>  </body></HTML><br>"
				+ "We are an enthusiastic, reliable, responsible and hard working team.<br>"
				+ "We are able to work well both in a team environment as well as using own initiative.<br>"
				+ "We are motivated to acquire new skills and self-develop.";
		return body;
	}
	

	@GetMapping("/liza")
	@ResponseBody
	String liza() {
		return "This is Liza<br>"
				+ "<i>Technology stack:</i> JavaScript, Node.js, HTML/CSS, React, Java, SQL.<br>"
				+ "<i>Loves to:</i> read books and listen to the sounds of rain, solve math problems, cycle in the forest,<br>"
				+ "draw sketches, do art makeup.";
	}
	

	@GetMapping("/yehor")
	@ResponseBody
	String yehor() {
		return "This is Yehor<br>"
				+ "<i>Technology stack:</i> Java, JavaScript, Go, C#, Swift, Docker…<br>"
				+ "<i>Loves to:</i> design software, listen to music, play music, travel.<br>";
	}
	

	@GetMapping("/maksim")
	@ResponseBody
	String maksym() {
		return "This is Maksim<br>"
				+ "<i>Technology stack:</i> Java, Kotlin, JavaScript.<br>"
				+ "<i>Loves to:</i> play computer games, drink beer, read books, write clean code, and listen to the sounds of my enemies crying.<br>";
	}
}
