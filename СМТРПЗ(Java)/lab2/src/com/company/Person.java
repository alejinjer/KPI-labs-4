package com.company;
import java.util.Objects;

public class Person {
    private final String m_name;
    private final int m_age;

    public Person(String name, int age) {
        m_name = name;
        m_age = age;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return m_age == person.m_age &&
                Objects.equals(m_name, person.m_name);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(m_name, m_age);
    }
}
