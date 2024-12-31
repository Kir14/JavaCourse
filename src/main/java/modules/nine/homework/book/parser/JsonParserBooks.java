package modules.nine.homework.book.parser;

import modules.nine.homework.book.Book;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class JsonParserBooks {

    private JSONObject mainObject;
    private String file;

    public JsonParserBooks(String file) {
        mainObject = new JSONObject();
        JSONArray arr = new JSONArray();
        mainObject.put("Books", arr);
        this.file = file;
    }

    public void addBook(Book book) {
        JSONObject bookJson = getJsonBook(book);
        JSONArray relatedBooks = new JSONArray();
        book.series.forEach(b -> {
            JSONObject relatedBook = getJsonBook(b);
            relatedBooks.add(relatedBook);
        });
        bookJson.put("RelatedBooks", relatedBooks);
        ((JSONArray) mainObject.get("Books")).add(bookJson);
    }

    public JSONObject getJsonBook(Book book) {
        JSONObject obj = new JSONObject();
        obj.put("name", book.getName());
        obj.put("year", book.getYear());
        obj.put("article", book.getArticle());
        return obj;
    }

    public void writeJson() throws IOException {
        FileWriter fw = new FileWriter(file);
        fw.write(mainObject.toJSONString());
        fw.flush();
        fw.close();
    }
}
