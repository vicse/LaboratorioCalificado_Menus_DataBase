package com.ore.vicse.notas.repositories;

import com.ore.vicse.notas.models.User;
import com.orm.SugarRecord;

import java.util.List;

public class UserRepository {

    public static List<User>list(){
        List<User> users= SugarRecord.listAll(User.class);
        return users;
    }
    public static Boolean InicioDeSesion(String nombre,String contraseña){
        List<User> users= SugarRecord.listAll(User.class);
        for (User user: users ) {
            if (user.getFirstname().equals(nombre) && user.getPassword().equals(contraseña)){
               return true;
            }
        }
        return false;
    }
    public static User read(Long id){
        User user= SugarRecord.findById(User.class, id);
        return user;
    }

    public static void create(String firstname, String fullname, String email, String password){
        User user = new User(firstname,fullname,email,password);
        SugarRecord.save(user);
    }

    public static  void update(String firstname, String fullname, String email, String password, Long id){
        User user=SugarRecord.findById(User.class, id);
        user.setFirstname(firstname);
        user.setFullname(fullname);
        user.setEmail(email);
        user.setPassword(password);
        SugarRecord.save(user);
    }

    public static void delete(Long id){
        User user = SugarRecord.findById(User.class, id);
        SugarRecord.delete(user);
    }

}
