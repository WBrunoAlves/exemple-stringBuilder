package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");//hora constante
	
	private Date moment;
	private String title;
	private String content;
	private Integer likes;
	
	private List<Comment> comments = new ArrayList<>();// lista do coments para fazer a composição
	
	/*CONSTRUTORS*/
	public Post() {
	}

	public Post(Date moment, String title, String content, Integer likes) {
		this.moment = moment;
		this.title = title;
		this.content = content;
		this.likes = likes;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	public List<Comment> getComments() {
		return comments;
	}

	/*OBS: não por a lista no set e como construtor, ao invez disso
	 * criar os dois metodos abaixo de adicionar e remover, assim os métodos erão resposaveis
	 * para isso e*/
	public void addComment(Comment comment) {
		comments.add(comment);
	}

	public void removeComment(Comment comment) {
		comments.remove(comment);
	}
	/*
	 * A CLASSE StringBuilder serve para subistituir as concatenaçoes dos strings melhorando e facilitando 
	 * */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(title + "\n");
		sb.append(likes);
		sb.append(" Likes - ");
		sb.append(sdf.format(moment) + "\n"); //hora
		sb.append(content + "\n");
		sb.append("Comments:\n");
		//para cada objeto c da lista cooments acrecenta os comentarios
		for (Comment c : comments) {
			sb.append(c.getText() + "\n");
		}
		return sb.toString(); //conmverte o stringBuilder para string
	}
}
