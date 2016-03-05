/*
 * @author
 * 
 * Harish Fulara(2014143)
 * Anant Mittal(2014015)
 */

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mac
 */
public class Person {
    private SimpleStringProperty name;
    private SimpleStringProperty enrollmentNumber;
    private SimpleStringProperty link;  
    
    Person(String name,String enrollmentNumber,String link)
    {
        
        this.name=new SimpleStringProperty(name);
        this.enrollmentNumber=new SimpleStringProperty(enrollmentNumber);
        this.link=new SimpleStringProperty(link);
        
        
    }
    public void setname(String value)
    {
        name.set(value);
    }
    public String getname()
    {
        return name.get();
    }
    public void setenrollmentNumber(String value)
    {
        enrollmentNumber.set(value);
    }
    public String getenrollmentNumber()
    {
        return enrollmentNumber.get();
    }
     public void setlink(String value)
    {
        link.set(value);
    }
    public String getlink()
    {
        return link.get();
    }
    
    public StringProperty firstColumnProperty()
    {
        return name;
    }
    public StringProperty secondColumnProperty()
    {
        return enrollmentNumber;
    }
    public StringProperty thirdColumnProperty()
    {
        return link;
    }  
}
