package ru;

import ru.UsersDAO;
import ru.Users;
import ru.Notes;

import java.util.List;

public class UsersService {

    private UsersDAO usersDao = new UsersDAO();

    public UsersService() {
    }

    public Users findUser(int id) {
        return usersDao.findById(id);
    }

    public void saveUser(Users user) {
        usersDao.save(user);
    }

    public void deleteUser(Users user) {
        usersDao.delete(user);
    }

    public void updateUser(Users user) {
        usersDao.update(user);
    }
    public void deleteNotes(Notes notes) {
        usersDao.delete(notes);
    }

    public void updateNotes(Notes notes) {
        usersDao.update(notes);
    }


    public List<Users> findAllUsers() {
        return usersDao.findAll();
    }

    public Notes findAutoById(int id) {
        return usersDao.findNotesById(id);
    }


}