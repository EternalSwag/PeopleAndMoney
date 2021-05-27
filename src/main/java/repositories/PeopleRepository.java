package repositories;

import model.Person;

import java.util.*;

public class PeopleRepository {

    private Map<Integer, Person> personList = null;

    public PeopleRepository(Map<Integer, Person> personList) {
        this.personList = personList;
    }

    public Person getPersonById(int id) {
        return personList.get(id);
    }

    public Map<Integer, Person> getPersonList() {
        return personList;
    }

    public List<Person> getPeopleAsList() {
        List<Person> result = new ArrayList<>();
        Iterator it = personList.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            result.add((Person) pair.getValue());
        }
        return result;
    }

}
