package part1.lesson02;

import java.util.ArrayList;
import java.util.List;

public class ObjectBox<T> {
    private List<T> list = new ArrayList<>();

    public void addObject(T item) {
        list.add(item);
    }
    public void deleteObject(T item) {
        list.remove(item);
    }
    public void dump() {
        System.out.println(list);
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
