package domain.product;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Mars on 14.10.2016.
 */
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "product_")
    private Product product;

    @Column(name = "author_")
    private String author;

    @Column(name = "text_")
    private String text;

    @Column(name = "rating_")
    private Integer rating;

    @Column(name = "answer_")
    private String answer;

    @Column(name = "date_")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date date;

    @Column(name = "city_")
    private String city;

    @Column(name = "status_")
    private Boolean status;

    public Review() {
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Review review = (Review) o;

        if (id != null ? !id.equals(review.id) : review.id != null) return false;
        if (product != null ? !product.equals(review.product) : review.product != null) return false;
        if (author != null ? !author.equals(review.author) : review.author != null) return false;
        if (text != null ? !text.equals(review.text) : review.text != null) return false;
        if (rating != null ? !rating.equals(review.rating) : review.rating != null) return false;
        if (answer != null ? !answer.equals(review.answer) : review.answer != null) return false;
        if (date != null ? !date.equals(review.date) : review.date != null) return false;
        if (city != null ? !city.equals(review.city) : review.city != null) return false;
        return status != null ? status.equals(review.status) : review.status == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (product != null ? product.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (answer != null ? answer.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
