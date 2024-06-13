package org.OrgDataWorks;

import java.time.LocalDate;

import org.EnumWorks.OrganizationType;
import org.InterfaceWorks.OrganizationInterface;

public class Organization  implements Comparable<Organization>, OrganizationInterface{
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private double annualTurnover; //Значение поля должно быть больше 0
    private String fullName; //Поле может быть null
    private Long employeesCount; //Поле может быть null, Значение поля должно быть больше 0
    private OrganizationType type; //Поле может быть null
    private Address officialAddress; //Поле может быть null

    
    public Organization(long id, String name, Coordinates coordinates, LocalDate creationDate, double annualTurnover, String fullName, Long employeesCount, OrganizationType type, Address officialAddress){
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.annualTurnover = annualTurnover;
        this.fullName = fullName;
        this.employeesCount = employeesCount;
        this.type = type;
        this.officialAddress = officialAddress;
    }

    
    /** 
     * @return long
     */
    @Override
    public long getId() {
        return id;
    }

    
    /** 
     * @return String
     */
    @Override
    public String getName(){
        return this.name;
    }

    
    /** 
     * Позволяет получить координаты организации
     * @return Coordinates
     */
    @Override
    public Coordinates getCoordinates(){
        return this.coordinates;
    }

    
    /** 
     * Позволяет получить дату создания организации
     * @return LocalDate
     */
    @Override
    public LocalDate getCreationDate(){
        return this.creationDate;
    }

    
    /** 
     * Позволяет получить годовой доход организации
     * @return double
     */
    @Override
    public double getAnnualTurnover(){
        return this.annualTurnover;
    }

    
    /** 
     * Позволяет получить полное название организации
     * @return String
     */
    @Override
    public String getFullName(){
        return this.fullName;
    }

    
    /** 
     * Позволяет получить количество работников организации
     * @return long
     */
    @Override
    public long getEmployeesCount(){
        return this.employeesCount;
    }

    
    /** 
     * Позволяет получить тип организации
     * @return OrganizationType
     */
    @Override
    public OrganizationType getOrganizationType(){
        return this.type;
    }
    
    
    /** 
     * Позволяет получить адресс организации
     * @return Address
     */
    @Override
    public Address getAddress(){
        return this.officialAddress;
    }


    

    @Override
    public int compareTo(Organization o) {
        if (o == null)return 0;
        else {
            return compare(this.id, o.getId());
        }
    }

    private int compare(Long id1, Long id2) {
        return id1.compareTo(id2);
    }

    public String getSId(){
        return String.valueOf(this.id);
    }
}