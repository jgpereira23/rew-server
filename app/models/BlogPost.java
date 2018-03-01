package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.*;

import com.avaje.ebean.Model;

//BlogPost.java

@Entity
public class BlogPost extends Model {

	@Id
	public Long id;

	@Column(length = 255, nullable = false)
	@NotNull
	@Size(max = 255)
	public String subject;

	@Column(columnDefinition = "TEXT")
	@NotNull
	public String content;

	@ManyToOne
	public User user;

	public Long commentCount;

	@OneToMany(cascade = CascadeType.ALL)
	public List<PostComment> comments;

	public static final Finder<Long, BlogPost> find = new Finder<Long, BlogPost>(Long.class, BlogPost.class);

	public static List<BlogPost> findBlogPostsByUser(final User user) {
		return find.where().eq("user", user).findList();
	}

	public static BlogPost findBlogPostById(final Long id) {
		return find.where().eq("id", id).findUnique();
	}

}