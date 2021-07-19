package com.example.memmana6.dao.entity;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Data  //综合注解了，等于同时使用@Getter, @Setter, @ToString, @EqualsAndHashCode,@RequiredArgsConstructor
@Repository   //以便在其它层使用命令@Autowired News news
public class News {

	private Integer id;
	private String contentPage;
	private String contentTitle;
	private Date publishDate;
	
	/*public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContentPage() {
		return contentPage;
	}
	public void setContentPage(String contentPage) {
		this.contentPage = contentPage;
	}
	public String getContentTitle() {
		return contentTitle;
	}
	public void setContentTitle(String contentTitle) {
		this.contentTitle = contentTitle;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	@Override
	public String toString() {
		return "News [id=" + id + ", contentPage=" + contentPage + ", contentTitle=" + contentTitle + ", publishDate="
				+ publishDate + "]";
	}*/
}
