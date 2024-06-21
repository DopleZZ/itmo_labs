package org.OrgDataWorks;

public class IdGenerator {

    private static long id;

    /**
     * Генерирует новое значение айди
     * 
     * @return long
     */
    public long generateNew() {
        return id += 1;
    }

    public static long getId() {
        return id;
    }

    public static void setId(Long newId) {
        id = newId;
    }
}