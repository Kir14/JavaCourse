package moduleThree.HomeWork.comp.src;

import java.util.Objects;

public class Notebook {
    private double width;
    private double height;
    private int pages;

    public Notebook() {
        width = 1.2;
        height = 4.0;
        pages = 456;
    }

    public Notebook(double width, double height, int pages) {
        this.width = width;
        this.height = height;
        this.pages = pages;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPages() {
        return pages;
    }

    public String toString() {
        return "Notebook pages " + pages + " " + width + "x" + height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notebook notebook = (Notebook) o;
        return Double.compare(width, notebook.width) == 0 && Double.compare(height, notebook.height) == 0 && pages == notebook.pages;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height, pages);
    }
}
