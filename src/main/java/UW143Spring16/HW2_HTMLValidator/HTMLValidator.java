package UW143Spring16.HW2_HTMLValidator;

import java.io.IOException;
import java.net.URL;
import java.io.InputStream;
import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Write a class that examines HTML to figure out whether it represents "valid" sequences of
 * tags. Your validator will use stacks and queues to figure out whether the tags match. Instructor-provided code will read
 * HTML pages from files and break them apart into tags for you; it's your job to see whether the tags match correctly.
 */

public class HtmlValidator {

    private String htmlText;
    LinkedList<HtmlTag> tags;

    public HtmlValidator(String htmlTextOrUrl) throws IOException {
        this.htmlText = (htmlTextOrUrl.startsWith("<!"))? htmlTextOrUrl : readCompleteFileOrURL(htmlTextOrUrl);
        tags = HtmlTag.tokenize(htmlText);
    }

    public String validate() {

        Stack<HtmlTag> tagStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (HtmlTag tag : tags) {
            if (tag.isSelfClosing())
                continue;

            if (tag.isOpenTag())
                tagStack.push(tag);
            else {
                if (tag.getElement().equals(tagStack.peek().getElement()))
                    tagStack.pop();
                else {
                    boolean isFound = false;
                    for (HtmlTag aTag : tagStack) {
                        if (tag.getElement().equals(aTag.getElement())) {
                            tagStack.remove(aTag);
                            isFound = true;
                            break;
                        }
                    }
                    if (!isFound)
                        sb.append("ERROR: Unexpected tag " + tag.toString()).append("\n");
                }
            }
        }
        while (tagStack.size() > 0){
            sb.append("ERROR: Unclosed tag " + tagStack.pop().toString()).append("\n");
        }
        return sb.toString();
    }

    /**
     * Returns an input stream to read from the given address.
     * Works with URLs or normal file names.
     */
    public InputStream getInputStream(String address) throws IOException {
        if (isURL(address)) {
            return new URL(address).openStream();
        } else {
            // local file
            return new FileInputStream(address);
        }
    }

    /**
     * Returns true if the given string represents a URL.
     * */
    public boolean isURL(String address) {
        return address.startsWith("http://") || address.startsWith("https://") ||
                address.startsWith("www.") ||
                address.endsWith("/") ||
                address.endsWith(".com") || address.contains(".com/") ||
                address.endsWith(".org") || address.contains(".org/") ||
                address.endsWith(".edu") || address.contains(".edu/") ||
                address.endsWith(".gov") || address.contains(".gov/");
    }

    /**
     * Opens the given address for reading input, and reads it until the end
     * of the file, and returns the entire file contents as a big String.
     *
     * If address starts with http[s]:// , assumes address is a URL and tries
     * to download the data from the web.  Otherwise, assumes the address
     * is a local file and tries to read it from the disk.
     */
    public String readCompleteFileOrURL(String address) throws IOException {
        InputStream stream = getInputStream(address);   // open file
        // read each letter into a buffer
        StringBuffer buffer = new StringBuffer();
        while (true) {
            int ch = stream.read();
            if (ch < 0) {
                break;
            }

            buffer.append((char) ch);
        }
        return buffer.toString();
    }

}
