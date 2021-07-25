package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Comment;
import entities.Post;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		Date PostDate = sdf.parse("21/06/2018 13:05:44");
		String PostTitle = "Traveling New Zealand";
		String PostContent = "I'm going to visit this wonderful country!";
		int PostLike = 12;
		
		Comment comment1 = new Comment("Have a nice trip");
		Comment comment2 = new Comment("Wow that's awesome!");
		
		Post post = new Post(PostDate, PostTitle, PostContent, PostLike);
		post.addComment(comment1);
		post.addComment(comment2);
		
		System.out.println(post);
		
		sc.close();
	}

}
