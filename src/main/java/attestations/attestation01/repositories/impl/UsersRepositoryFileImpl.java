package attestations.attestation01.repositories.impl;

import attestations.attestation01.model.User;
import attestations.attestation01.repositories.UsersRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UsersRepositoryFileImpl implements UsersRepository {

    private static final List <User> USERS = new ArrayList<>();
    private static final String FILE_PATH = "src/main/resources/outputUsers.txt";

    @Override
    public void create(User user) {
        USERS.add(user);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            bw.write(user.toString());
            bw.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
  }

    @Override
    public User findById(String id) {
        if (USERS.isEmpty()) {
            findAll();
        }
        return USERS.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElseThrow(()->new RuntimeException("Пользователь не найден"));
    }

    @Override
    public List<User> findAll() {
        if (USERS.isEmpty()) {
            try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/inputUsers.txt"))){
                List<User> userFromFile  = br.lines()
                        .map(User::new)
                        .toList();
                USERS.addAll(userFromFile);
                return USERS;
            }
            catch (IOException e) {
                System.out.println("Ошибка чтения файла:" + e.getMessage());
                return Collections.emptyList();
            }
        }
        return USERS;
    }

    @Override
    public void update(User user) {
        if (USERS.isEmpty()) {
            findAll();
        }
        boolean userFound =false;

        for (int i = 0; i < USERS.size(); i++) {
            User existingUser = USERS.get(i);
            if (existingUser.getId().equals(user.getId())) {
                USERS.set(i, user);
                userFound = true;
                break;
            }
        }
        if (userFound) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
                for (User user1 : USERS) {
                    writer.write(user1.toString());
                    writer.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else  {
            USERS.add(user);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
                for (User user1 : USERS) {
                    writer.write(user1.toString());
                    writer.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        }

    @Override
    public void deleteById(String id) {
        if (USERS.isEmpty()) {
            findAll();
        }
        boolean userExist = USERS.stream().anyMatch(user -> user.getId().equals(id));

        if (!userExist) {
            throw new RuntimeException("Пользователя с заданным id не существует");
        }
        USERS.removeIf(user -> user.getId().equals(id));
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (User user : USERS) {
            bw.write(user.toString());
            bw.newLine();}
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteAll() {
        USERS.clear();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            bw.write("");
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
