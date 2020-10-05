package org.de.dao;

import org.de.model.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDao {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Name 1"));
        people.add(new Person(++PEOPLE_COUNT, "Name 2"));
        people.add(new Person(++PEOPLE_COUNT, "Name 3"));
        people.add(new Person(++PEOPLE_COUNT, "Name 4"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){

        return people.stream().filter(person->person.getId()==id).findAny().orElse(null);
    }
}
