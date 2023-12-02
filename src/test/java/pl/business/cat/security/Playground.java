package pl.business.cat.security;

public class Playground {

	public static void main(String[] args) {
			String split = "/questions/15076684/in-java-whats-the-best-way-to-read-a-url-and-split-it-into-its-parts";
			String[] splited = split.split("/");
			for(int i=0;i<splited.length ;i++)
				System.out.println(splited[i]);

	}

}
