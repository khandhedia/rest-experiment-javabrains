package com.nirav.rest.rest_experiment.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
public class Profile
{
    private int id;
    private String profileName;
    private String firstName;
    private String lastName;
    private Date dateCreated;

    public Profile(int id, String profileName, String firstName, String lastName)
    {
        this.id = id;
        this.profileName = profileName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateCreated = new Date();
    }

    public Profile()
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

    public String getProfileName()
    {
        return profileName;
    }

    public void setProfileName(String profileName)
    {
        this.profileName = profileName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public Date getDateCreated()
    {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated)
    {
        this.dateCreated = dateCreated;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }

        Profile profile = (Profile) o;

        if (getId() != profile.getId()) { return false; }
        if (getProfileName() != null
            ? !getProfileName().equals(profile.getProfileName())
            : profile.getProfileName() != null) { return false; }
        if (getFirstName() != null
            ? !getFirstName().equals(profile.getFirstName())
            : profile.getFirstName() != null) { return false; }
        if (getLastName() != null
            ? !getLastName().equals(profile.getLastName())
            : profile.getLastName() != null) { return false; }
        return getDateCreated() != null
               ? getDateCreated().equals(profile.getDateCreated())
               : profile.getDateCreated() == null;
    }

    @Override
    public int hashCode()
    {
        int result = getId();
        result = 31 * result + (getProfileName() != null
                                ? getProfileName().hashCode()
                                : 0);
        result = 31 * result + (getFirstName() != null
                                ? getFirstName().hashCode()
                                : 0);
        result = 31 * result + (getLastName() != null
                                ? getLastName().hashCode()
                                : 0);
        result = 31 * result + (getDateCreated() != null
                                ? getDateCreated().hashCode()
                                : 0);
        return result;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("Profile{");
        sb.append("id=").append(id);
        sb.append(", profileName='").append(profileName).append('\'');
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", dateCreated=").append(dateCreated);
        sb.append('}');
        return sb.toString();
    }
}
