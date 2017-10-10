package com.nirav.rest.rest_experiment.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage
{
    private String errorMessage;
    private String errorCode;
    private String documentation;

    public ErrorMessage(String errorMessage, String errorCode, String documentation)
    {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.documentation = documentation;
    }

    public ErrorMessage()
    {
    }

    public String getErrorMessage()
    {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage)
    {
        this.errorMessage = errorMessage;
    }

    public String getErrorCode()
    {
        return errorCode;
    }

    public void setErrorCode(String errorCode)
    {
        this.errorCode = errorCode;
    }

    public String getDocumentation()
    {
        return documentation;
    }

    public void setDocumentation(String documentation)
    {
        this.documentation = documentation;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }

        ErrorMessage that = (ErrorMessage) o;

        if (getErrorMessage() != null
            ? !getErrorMessage().equals(that.getErrorMessage())
            : that.getErrorMessage() != null) { return false; }
        if (getErrorCode() != null
            ? !getErrorCode().equals(that.getErrorCode())
            : that.getErrorCode() != null) { return false; }
        return getDocumentation() != null
               ? getDocumentation().equals(that.getDocumentation())
               : that.getDocumentation() == null;
    }

    @Override
    public int hashCode()
    {
        int result = getErrorMessage() != null
                     ? getErrorMessage().hashCode()
                     : 0;
        result = 31 * result + (getErrorCode() != null
                                ? getErrorCode().hashCode()
                                : 0);
        result = 31 * result + (getDocumentation() != null
                                ? getDocumentation().hashCode()
                                : 0);
        return result;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("ErrorMessage{");
        sb.append("errorMessage='").append(errorMessage).append('\'');
        sb.append(", errorCode='").append(errorCode).append('\'');
        sb.append(", documentation='").append(documentation).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
