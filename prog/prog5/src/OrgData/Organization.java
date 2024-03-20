package OrgData;

import java.time.LocalDate;
import Enums.OrganizationType;
import Interfaces.OrganizationInterface;

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

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public Coordinates getCoordinates(){
        return this.coordinates;
    }

    @Override
    public LocalDate getCreationDate(){
        return this.creationDate;
    }

    @Override
    public double getAnnualTurnover(){
        return this.annualTurnover;
    }

    @Override
    public String getFullName(){
        return this.fullName;
    }

    @Override
    public long getEmployeesCount(){
        return this.employeesCount;
    }

    @Override
    public OrganizationType getOrganizationType(){
        return this.type;
    }

    @Override
    public Address getAddress(){
        return this.officialAddress;
    }


    @Override
    public int compareTo(Organization o) {
        if (o == null)return 0;
        else {
            return compare(this.employeesCount, o.getEmployeesCount());
        }
    }

    private int compare(Long emp1, Long emp2) {
        return emp1.compareTo(emp2);
    }
}