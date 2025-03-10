package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;


public class User {
    private String id;
    private LocalDateTime localDateTime;
    private String login;
    private String password;
    private String confirmPassword;
    private String surname;
    private String name;
    private String patronymic;
    private Integer age;
    boolean isWorker;

    public  User (String line) {
        String [] elements = line.split("\\|");
        this.id = elements [0];
        if (!elements [1].isEmpty()){
            this.localDateTime = LocalDateTime.now();}
        String login = elements[2];
        if (!isValidLogin(login)) {
            throw new IllegalArgumentException("Логин должен содержать буквы, цифры и знак подчеркивания, а также должен быть меньше 20 символов");
        }
        this.login = login;
        String password = elements[3];
        String confirmPassword = elements[4];
        if (!isValidPassword(password) || !password.equals(confirmPassword)) {
            throw new IllegalArgumentException("Пароли должны совпадать и содержать буквы, цифры, знак подчеркивания, и быть меньше 20 символов");
        }
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.surname = validateName(elements[5], "Фамилия");
        this.name = validateName(elements[6], "Имя");
        this.patronymic = elements.length > 7 ? validateName(elements[7], "Отчество") : null;
        if (elements.length > 8 && !elements[8].isEmpty()) {
            try {
                this.age = Integer.parseInt(elements[8]);
                if (this.age < 0) {
                    throw new IllegalArgumentException("Возраст не может быть отрицательным числом");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Возраст должен быть числом", e);
            }
        } else {
            this.age = null; // Если возраст отсутствует
        }
        if (!elements[9].isEmpty()){
        this.isWorker = false;}

    }
    private boolean isValidLogin(String login) {
        return login.length() < 20 && login.matches("^(?=.*[a-zA-Z])(?=.*\\d|.*_)[a-zA-Z\\d_]+$"); //проверка, что логин содержит буквы, цифры и _, число символов меньше 20
    }

    private boolean isValidPassword(String password) {
        return password.length() < 20 && password.matches("^(?=.*[a-zA-Z])(?=.*\\d|.*_)[a-zA-Z\\d_]+$");// проверка, что пароль содержит буквы, цифры и _, число символов меньше 20
    }

    private String validateName(String name, String fieldName) { //проверка, что имя состоит только из букв
        if (!name.matches("[a-zA-Zа-яА-ЯёЁ]+")) {
            throw new IllegalArgumentException(fieldName + " должно состоять только из букв");
        }
        return name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getLogin() {
        if (login.length() < 20 && login.matches("^(?=.*[a-zA-Z])(?=.*\\d|.*_)[a-zA-Z\\d_]+$")) {
            System.out.println(" Логин должен содержать буквы, цифры, знак подчеркивания и быть не более 20 символов");
        }
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        if (password.length() < 20 && password.matches("^(?=.*[a-zA-Z])(?=.*\\d|.*_)[a-zA-Z\\d_]+$")) {
            System.out.println("Пароль должен содержать буквы, цифры, знак подчеркивания и быть не более 20 символов");
        }
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        if (password!=confirmPassword) {
            System.out.println("Пароли не совпадают");
        }
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getSurname() {
        if (!surname.matches("[a-zA-Zа-яА-ЯёЁ]+")){
            System.out.println("Фамилия не должна содержать цифр");
        }

        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        if (!name.matches("[a-zA-Zа-яА-ЯёЁ]+")){
            System.out.println("Имя не должно содержать цифр");
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        if (!patronymic.matches("[a-zA-Zа-яА-ЯёЁ]+")){
            System.out.println("Отчество не должно содержать цифр");
        }
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Integer getAge() {

        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isWorker() {
        isWorker = false;
        return isWorker;
    }

    public void setWorker(boolean worker) {
        isWorker = worker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return isWorker == user.isWorker && Objects.equals(id, user.id) && Objects.equals(localDateTime, user.localDateTime) && Objects.equals(login, user.login) && Objects.equals(password, user.password) && Objects.equals(confirmPassword, user.confirmPassword) && Objects.equals(surname, user.surname) && Objects.equals(name, user.name) && Objects.equals(patronymic, user.patronymic) && Objects.equals(age, user.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, localDateTime, login, password, confirmPassword, surname, name, patronymic, age, isWorker);
    }

    @Override
    public String toString() {
        return id + "|" + localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) + "|" + login + "|" + password + "|" + confirmPassword + "|" + surname + "|" + name + "|" + patronymic + "|" + age + "|" + isWorker;
    }
}
