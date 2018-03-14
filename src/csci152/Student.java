/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152;

/**
 *
 * @author Master
 */
public class Student implements Comparable {
//implements Comparable
    
    private int ID;
    private String name;

    public Student(String n, int id) {
        ID = id;
        name = n;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return ID;
    }

    @Override
    public int compareTo(Object newStudent) {
        Student st = (Student)newStudent;
//        return ID.compareTo(st.getId());
        if (ID > st.getId()) {
            return 1;
        } else {
            return -1;
        }

//        return name.compareTo(st.getName());
    }

    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            Student sobj = (Student) obj;
            return ID == sobj.ID && name.equals(sobj.name);
        }
        return false;
    }
    
    @Override
    public String toString(){
        return "[" + getName() + "; " + getId() + "]";
    }
}