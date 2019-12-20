package pdf1;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.poi.util.SystemOutLogger;

public class Student {

	String name,middle,surname,mother_name,regular,sex,prn,year,sem,roll;
	Subject s[];
	public final String getName() {
		return name;
	}
	public final void setName(String name) {
		this.name = name;
	}
	public final String getMiddle() {
		return middle;
	}
	public final void setMiddle(String middle) {
		this.middle = middle;
	}
	public final String getSurname() {
		return surname;
	}
	public final void setSurname(String surname) {
		this.surname = surname;
	}
	public final String getMother_name() {
		return mother_name;
	}
	public final void setMother_name(String mother_name) {
		this.mother_name = mother_name;
	}
	public final String getRegular() {
		return regular;
	}
	public final void setRegular(String regular) {
		this.regular = regular;
	}
	public final String getSex() {
		return sex;
	}
	public final void setSex(String sex) {
		this.sex = sex;
	}
	public final String getPrn() {
		return prn;
	}
	public final void setPrn(String prn) {
		this.prn = prn;
	}
	public final String getYear() {
		return year;
	}
	public final void setYear(String year) {
		this.year = year;
	}
	public final String getSem() {
		return sem;
	}
	public final void setSem(String sem) {
		this.sem = sem;
	}
	public final String getRoll() {
		return roll;
	}
	public final void setRoll(String roll) {
		this.roll = roll;
	}
	public final Subject[] getS() {
		return s;
	}
	public final void setS(Subject[] s) {
		this.s = s;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", middle=" + middle + ", surname=" + surname + ", mother_name=" + mother_name
				+ ", regular=" + regular + ", sex=" + sex + ", prn=" + prn + ", year=" + year + ", sem=" + sem
				+ ", roll=" + roll + "]";
	}
	
	public void display() {
		
		System.out.println( "Student [name=" + name + ", middle=" + middle + ", surname=" + surname + ", mother_name=" + mother_name
					+ ", regular=" + regular + ", sex=" + sex + ", prn=" + prn + ", year=" + year + ", sem=" + sem
					+ ", roll=" + roll + ",");
		System.out.println();
		for(int j=0;j<s.length;j++)	
		{
			if(s[j]==null)
				break;
			s[j].display();
			
		}
		}
		
	

}
