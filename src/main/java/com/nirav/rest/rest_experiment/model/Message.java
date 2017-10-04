package com.nirav.rest.rest_experiment.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
public class Message
{
    private int id;
    private String message;
    private String author;
    private Date created;

    public Message()
    {
    }

    public Message(int id, String message, String author)
    {
        this.id = id;
        this.message = message;
        this.author = author;
        this.created = new Date();
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

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public Date getCreated()
    {
        return created;
    }

    public void setCreated(Date created)
    {
        this.created = created;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }

        Message message1 = (Message) o;

        if (id != message1.id) { return false; }
        if (message != null
            ? !message.equals(message1.message)
            : message1.message != null) { return false; }
        if (author != null
            ? !author.equals(message1.author)
            : message1.author != null) { return false; }
        return created != null
               ? created.equals(message1.created)
               : message1.created == null;
    }

    @Override
    public int hashCode()
    {
        int result = id;
        result = 31 * result + (message != null
                                ? message.hashCode()
                                : 0);
        result = 31 * result + (author != null
                                ? author.hashCode()
                                : 0);
        result = 31 * result + (created != null
                                ? created.hashCode()
                                : 0);
        return result;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("Message{");
        sb.append("id=").append(id);
        sb.append(", message='").append(message).append('\'');
        sb.append(", author='").append(author).append('\'');
        sb.append(", created=").append(created);
        sb.append('}');
        return sb.toString();
    }
}
