package modules.nine.homework.book.parser;

import modules.nine.homework.book.Book;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class XmlParserBooks {

    private Document doc;
    private String file;

    public XmlParserBooks(String file) throws ParserConfigurationException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        doc = docBuilder.newDocument();
        Element root = doc.createElement("Books");
        doc.appendChild(root);
        this.file = file;
    }

    public void addBookNode(Book book) {
        Element node = getBookNode(book);
        Element relatedBooks = doc.createElement("RelatedBooks");
        node.appendChild(relatedBooks);
        book.series.forEach(b -> {
            Element relatedBook = getBookNode(b);
            relatedBooks.appendChild(relatedBook);
        });
        doc.getElementsByTagName("Books").item(0).appendChild(node);
    }

    private Element getBookNode(Book book) {
        Element node = doc.createElement("book");
        Element bookName = doc.createElement("name");
        bookName.setTextContent(book.getName());
        node.appendChild(bookName);
        Element bookYear = doc.createElement("year");
        bookYear.setTextContent(book.getYear().toString());
        node.appendChild(bookYear);
        Element bookArticle = doc.createElement("article");
        bookArticle.setTextContent(book.getArticle());
        node.appendChild(bookArticle);
        return node;
    }

    public void writeXml() throws TransformerException, FileNotFoundException {
        FileOutputStream output = new FileOutputStream(file);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(output);
        transformer.transform(source, result);
    }
}
