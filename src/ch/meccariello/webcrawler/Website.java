package ch.meccariello.webcrawler;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Website {

	String url;
	String title;
	Document document;
	ArrayList<String> links = new ArrayList<>();
	boolean visited;

	public Website(String url) {
		this.url = url;
		fetchContent();
		visited = true;
	}

	private void fetchContent() {
		try {
			document = Jsoup.connect(url).execute().parse();
			title = document.title();
			document.select("a[href]").forEach(link -> links.add(link.attr("abs:href")));
		} catch (IOException ex) {}
	}

}
