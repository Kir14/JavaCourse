package modules.five.list.todolist;

import java.util.ArrayList;

/*
Разработайте список дел, который управляется командами в консоли. Команды: LIST, ADD, EDIT, DELETE.
Принцип работы команд:
•	LIST — выводит дела с их порядковыми номерами;
•	ADD — добавляет дело в конец списка или дело на определённое место, сдвигая остальные дела вперёд, если указать номер;
•	EDIT — заменяет дело с указанным номером;
•	DELETE — удаляет.

 */

public class ToDoList {
    private ArrayList<String> list;

    public ToDoList() {
        list = new ArrayList<>();
    }

    public ArrayList<String> getList() {
        return list;
    }

    public void addItem(String item) {
        list.add(item);
    }

    public boolean addItem(String item, int index) {
        if (!(index < list.size())) {
            return false;
        }
        list.add(index, item);
        return true;
    }

    public boolean editItem(String newItem, int index) {
        if (!(index < list.size())) {
            return false;
        }
        list.add(index, newItem);
        list.remove(index + 1);
        return true;
    }

    public boolean deleteItem(int index) {
        if (!(index < list.size())) {
            return false;
        }
        list.remove(index);
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(i).append(" - ").append(list.get(i)).append("\n");
        }
        return sb.toString();
    }

}
