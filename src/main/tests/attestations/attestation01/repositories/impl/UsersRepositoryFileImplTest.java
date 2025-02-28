package attestations.attestation01.repositories.impl;

import attestations.attestation01.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


import static org.junit.jupiter.api.Assertions.*;

    class UsersRepositoryFileImplTest {
    private UsersRepositoryFileImpl usersRepository;
    private static final String TEST_FILE_PATH = "src/main/tests/resources/inputUsers.txt"; // Путь к тестовому файлу

    @BeforeEach
    void setUp() {
        usersRepository = new UsersRepositoryFileImpl();
        // Создаем тестовый файл
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TEST_FILE_PATH))) {
            writer.write("f5a8a3cb-4ac9-4b3b-8a65-c424e129b9d2|2023-12-25T19:10:11.556|noisemc_99|789ghs|789ghs|Крылов|Виктор|Павлович|25|true");
            writer.newLine();
            writer.write("f5a8a3cb-4ac9-4b3b-8a65-c424e129b9d4|2023-12-25T19:10:11.556|noise_99|789ghs|789ghs|Крылов|Виктор|Павлович|25|false");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testCreateUser () {
        User user = new User("f5a8a3cb-4ac9-4b3b-8a65-c424e129b9d2|2023-12-25T19:10:11.556|noisemc_99|789ghs|789ghs|Крылов|Виктор|Павлович|25|true");
        usersRepository.create(user);
        // Проверяем, что пользователь добавлен в список
        User foundUser  = usersRepository.findById("f5a8a3cb-4ac9-4b3b-8a65-c424e129b9d2");
        assertNotNull(foundUser);
        assertEquals("noisemc_99", foundUser.getLogin());}


    @Test
    public void testFindById_UserExists() {
        User user  = new User("f5a8a3cb-4ac9-4b3b-8a65-c424e129b9d2|2023-12-25T19:10:11.556|noisemc_99|789ghs|789ghs|Крылов|Виктор|Павлович|25|true");
        usersRepository.create(user);
        // Проверяем, что пользователь найден по id
        User user1 = usersRepository.findById("f5a8a3cb-4ac9-4b3b-8a65-c424e129b9d2");
        assertNotNull(user1);
        assertEquals("noisemc_99", user1.getLogin());
        }


        @Test
        public void testUpdateUser () {
            User user  = new User("f5a8a3cb-4ac9-4b3b-8a65-c424e129b9d2|2023-12-25T19:10:11.556|noisemc_99|789ghs|789ghs|Крылов|Виктор|Павлович|25|true");
            usersRepository.create(user);
            // Проверяем, что данные пользователя изменяются
            User user1 = new User("f5a8a3cb-4ac9-4b3b-8a65-c424e129b9d2|2023-12-25T19:10:11.556|noisemc_99|789ghs|789ghs|Пчелкин|Виктор|Павлович|25|true");
            usersRepository.update(user1);

            User updatedUser  = usersRepository.findById("f5a8a3cb-4ac9-4b3b-8a65-c424e129b9d2");
            assertEquals("noisemc_99", updatedUser.getLogin());
        }

        @Test // Проверяем, что пользователь с id, не может быть удален, т.к. не существует
        public void testDeleteById_UserDoesNotExist() {
            assertThrows(RuntimeException.class, () -> usersRepository.deleteById("f5a8a3cb-4ac9-4b3b-8a65-c424e129b9d8"));
        }

        @Test // Проверяем, что пользователь строка с данными имеет неверный формат
        public void testInvalidInputFormat() {
            assertThrows(RuntimeException.class, () -> {
                new User("fdksdfjsf|user|201201"); // Неправильный формат строки
            });
        }


    }
