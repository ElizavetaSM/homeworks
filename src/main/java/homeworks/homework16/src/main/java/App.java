import model.User;
import repositories.UsersRepository;
import repositories.UsersRepositoryFileImpl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class App {
    public static void main (String [] args )  {
       UsersRepository usersRepository = new UsersRepositoryFileImpl();
        try { //добавление пользователей
            boolean isFileEmpty = true;
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/inputUsers.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                isFileEmpty = false;
                User user = new User(line);
                usersRepository.create(user);
            }
            if (isFileEmpty) {
            System.out.println("Файл пуст");
        }
       br.close();}
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<User> users = usersRepository.findAll(); // выгрузка в файл пользователей

        usersRepository.findById("f5a8a3cb-4ac9-4b3b-8a65-c424e129b9d2"); // поиск пользователя по id


        User user = new User("f5a8a3cb-4ac9-4b3b-8a65-c424e129b9d2|2023-12-25T19:10:11.556|noisemc_99|789ghs|789ghs|Пчелкин|Виктор|Павлович|25|true");
        usersRepository.update(user); //обновление файла с пользователями

        usersRepository.deleteById("f5a8a3cb-4ac9-4b3b-8a65-c424e129b9d2"); // удаление пользователя по id
        usersRepository.deleteAll(); //удаление всех пользователей




    }
}
