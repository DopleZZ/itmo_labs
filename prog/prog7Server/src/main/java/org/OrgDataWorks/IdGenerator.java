package org.OrgDataWorks;

public class IdGenerator {
    
public static long id;


/** Генерирует новое значение айди
 * @return long
 */
public long generateNew(){
    id = id +1;
    return IdGenerator.id;
    }
}