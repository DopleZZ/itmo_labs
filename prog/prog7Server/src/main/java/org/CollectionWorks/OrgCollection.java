package org.CollectionWorks;

import java.time.LocalDate;
import java.util.PriorityQueue;

import org.OrgDataWorks.Organization;

public class OrgCollection {
    private static LocalDate initDate;
    private static PriorityQueue<Organization> organizationCollection = new PriorityQueue<>();

    public OrgCollection() {
        initDate = LocalDate.now();
    }

    /**
     * Добавить объект в коллекцию
     * 
     * @param o
     */
    public static void addObj(Organization o) {
        organizationCollection.add(o);
    }

    /**
     * получить копию коллекции
     * 
     * @return PriorityQueue<Organization>
     */
    public static PriorityQueue<Organization> getCollection() {
        PriorityQueue<Organization> collectionCopy = new PriorityQueue<>(organizationCollection);
        // collectionCopy = organizationCollection;
        return collectionCopy;
    }

    /**
     * Очистить коллекцию
     */
    public static void clear() {
        while (!organizationCollection.isEmpty()) {
            organizationCollection.clear();
        }
    }

    /**
     * получить количество объектов в коллекции
     * 
     * @return int
     */
    public static int getSize() {
        return organizationCollection.size();
    }

    /**
     * получить информацию о коллекции
     */
    public static String info() {
        return String.format(
                "Дата создания: %s\nКоличество элементов: %s",
                initDate, organizationCollection.size());
    }

    /**
     * получить оригинальную коллекцию
     * 
     * @return PriorityQueue<Organization>
     */
    public static PriorityQueue<Organization> getCollectionLink() {
        return organizationCollection;
    }

}