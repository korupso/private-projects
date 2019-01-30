package ch.meccariello.webcrawler;

import java.util.ArrayList;

public class WebCrawler {

	public static void main(String[] args) {

		ArrayList<String> visited = new ArrayList<>();
		ArrayList<String> unvisited = new ArrayList<>();
		ArrayList<Website> websites = new ArrayList<>();
		
		unvisited.add("http://news.ycombinator.com/");
		
		while (true) {
			Website website = new Website(unvisited.get(0));
			visited.add(website.url);
			unvisited.addAll(website.links);
			websites.add(website);
			System.out.println(website.title + "(" + website.url + ")");
			
			unvisited.remove(0);
		}

	}

}
