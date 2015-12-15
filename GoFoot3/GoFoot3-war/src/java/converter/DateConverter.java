/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Maxime
 */
@FacesConverter("myDateConverter")
public class DateConverter implements javax.faces.convert.Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(!value.isEmpty())
        {
            try {
                int firstSlash = value.indexOf('/');
                int day = Integer.parseInt(value.substring(0,firstSlash));
                int lastSlash = value.lastIndexOf('/');
                int month = Integer.parseInt(value.substring(firstSlash + 1, lastSlash));
                Integer year = Integer.parseInt(value.substring(lastSlash + 1));

                if(!isValidDate(day, month, year))
                    throw new Exception();

                if(year.toString().length() != 4)
                    throw new Exception();

                GregorianCalendar gregC = new GregorianCalendar(year, month - 1, day);
                return gregC.getTime();
            } catch (Exception e) {
                FacesMessage msg = new FacesMessage("Erreur de conversion de date", "Date invalide");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ConverterException(msg);
            }
        }
        else
            return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Date birthdate = (Date)value;
        GregorianCalendar gregC = new GregorianCalendar();
        gregC.setTime(birthdate);
        int day = gregC.get(Calendar.DAY_OF_MONTH);
        int month = gregC.get(Calendar.MONTH) + 1;
        int year = gregC.get(Calendar.YEAR);
        return day + "/" + month + "/" + year;
    }
    
    private Boolean isValidDate(int day, int month, int year){
        int lastDay = getLastDayOfMonthYear(month, year);
        return day < lastDay;
    }
    
    private int getLastDayOfMonthYear(int month, int year){
        if(month == 2)
            return (isLeapYear(year)) ? 29 : 28;
        else if(month == 4 || month == 6 || month == 9 || month == 11)
            return 30;
        else 
            return 31;
    }
    
    private Boolean isLeapYear(int year){
        return (year % 4 == 0 || (year % 100 == 0 && year % 400 == 0));
    }
}
