package homeworks.homework12;


import java.util.Objects;

public class Person {
    private String surname;
    private String name;
    private String patronymic;
    private String birthDate;
    private Long phoneNumber;
    private String gender;
    private Integer age;

    public Person(String surname, String name, String patronymic, String birthDate, Long phoneNumber, String gender, Integer age) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.age = age;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getBirthdate() {
        return birthDate;
    }

    public void setDate(String birthdate) {
        this.birthDate = birthdate;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(surname, person.surname) && Objects.equals(name, person.name) && Objects.equals(patronymic, person.patronymic) && Objects.equals(birthDate, person.birthDate) && Objects.equals(phoneNumber, person.phoneNumber) && Objects.equals(gender, person.gender) && Objects.equals(age, person.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name, patronymic, birthDate, phoneNumber, gender, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", date=" + birthDate +
                ", phoneNumber=" + phoneNumber +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }
}
