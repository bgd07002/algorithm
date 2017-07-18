package Courses.UW143Spring16.HW2_HTMLValidator;

import org.junit.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class HtmlValidatorTest {

    String htmlCorrectString = "<!doctype html public \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n"+
            "<!-- This is a comment -->\n"+
            "<html>\n"+
            "<head>\n"+
            "<title>Turtles are cool</title>\n"+
            "<meta http-equiv=\"Content-Type\" content=\"text/html\">\n"+
            "<link href=\"style.css\" type=\"text/css\" />\n"+
            "</head>\n"+
            "<body>\n"+
            "<p>Turtles swim in the <a href=\"http://ocean.com/\">ocean</a>.</p>\n"+
            "<p>Some turtles are over 100 years old. Here is a picture of a turtle:\n"+
            "<img src=\"images/turtle.jpg\" width=\"100\" height=\"100\" />\n"+
            "</p>\n"+
            "</body>\n"+
            "</html>";

    String htmlWrongString = "<!doctype html public \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n"+
            "<!-- This is a comment -->\n"+
            "<html>\n"+
            "<head>\n"+
            "<title>Turtles are cool</title>\n"+
            "<meta http-equiv=\"Content-Type\" content=\"text/html\">\n"+
            "<link href=\"style.css\" type=\"text/css\" />\n"+
            "</head>\n"+
            "</head>\n"+ //extra </head>
            "<body>\n"+
            "<p>Turtles swim in the <a href=\"http://ocean.com/\">ocean</a>.</p>\n"+
            "<p>Some turtles are over 100 years old. Here is a picture of a turtle:\n"+
            "<img src=\"images/turtle.jpg\" width=\"100\" height=\"100\" />\n"+ //missing </p>
            "</body>\n"; //missing html

    @Test
    public void htmlValidatorTest() throws IOException {
        HtmlValidator correctHtml = new HtmlValidator(htmlCorrectString);
        String errorMessage = correctHtml.validate();
        Assert.assertEquals("", errorMessage);

        HtmlValidator wrongHtml = new HtmlValidator(htmlWrongString);
        errorMessage = wrongHtml.validate();
        StringBuilder expectedError = new StringBuilder("ERROR: Unexpected tag </head>")
                .append("\n")
                .append("ERROR: Unclosed tag <p>").append("\n")
                .append("ERROR: Unclosed tag <html>").append("\n");
        Assert.assertEquals(expectedError.toString(), errorMessage);
    }

    @Test
    public void networkHtmlValidatorTest() throws IOException {
        HtmlValidator correctHtml = new HtmlValidator("http://courses.cs.washington.edu/courses/cse143/16sp/index.shtml");
        String errorMessage = correctHtml.validate();
        StringBuilder expectedError = new StringBuilder("ERROR: Unexpected tag </p>").append("\n")
                .append("ERROR: Unexpected tag </p>").append("\n");
        System.out.println(errorMessage);
        Assert.assertEquals(expectedError.toString(), errorMessage);
    }

}
