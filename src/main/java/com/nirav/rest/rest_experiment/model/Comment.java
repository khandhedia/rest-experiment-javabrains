package com.nirav.rest.rest_experiment.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
public class Comment
{
    private int id;
    private String message;
    private Date created;
    private String author;


    public Comment()
    {

    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public Date getCreated()
    {
        return created;
    }

    public void setCreated(Date created)
    {
        this.created = created;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }

        Comment comment = (Comment) o;

        if (getId() != comment.getId()) { return false; }
        if (getMessage() != null
            ? !getMessage().equals(comment.getMessage())
            : comment.getMessage() != null) { return false; }
        if (getCreated() != null
            ? !getCreated().equals(comment.getCreated())
            : comment.getCreated() != null) { return false; }
        return getAuthor() != null
               ? getAuthor().equals(comment.getAuthor())
               : comment.getAuthor() == null;
    }

    @Override
    public int hashCode()
    {
        int result = getId();
        result = 31 * result + (getMessage() != null
                                ? getMessage().hashCode()
                                : 0);
        result = 31 * result + (getCreated() != null
                                ? getCreated().hashCode()
                                : 0);
        result = 31 * result + (getAuthor() != null
                                ? getAuthor().hashCode()
                                : 0);
        return result;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("Comment{");
        sb.append("id=").append(id);
        sb.append(", message='").append(message).append('\'');
        sb.append(", created=").append(created);
        sb.append(", author='").append(author).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
