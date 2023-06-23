package com.sporthelper.fullstackbackend.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sporthelper.fullstackbackend.exception.UserNotFoundException;
import com.sporthelper.fullstackbackend.model.User;
import com.sporthelper.fullstackbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.FilenameUtils;



import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    User getUserById(@PathVariable Long id){
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }
    @PutMapping("/editUser/{id}")
    User updateUser(@RequestBody User newUser, @PathVariable Long id){
        return userRepository.findById(id)
                .map(user -> {
                    user.setUser_name(newUser.getUser_name());
                    user.setAge(newUser.getAge());
                    user.setEmail(newUser.getEmail());
                    user.setIntroduction(newUser.getIntroduction());
                    user.setFirst_name(newUser.getFirst_name());
                    user.setLast_name(newUser.getLast_name());
                    user.setMain_sport(newUser.getMain_sport());
                    user.setPhone_number(newUser.getPhone_number());
                    user.setPassword(newUser.getPassword());
                    user.setLocation(newUser.getLocation());
                    user.setLiked_players(newUser.getLiked_players());
                    return userRepository.save(user);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }

    @PostMapping(value = "/addUser", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    User newUser(@RequestParam("user") String user,
    @RequestParam("file") MultipartFile file)  {
        ObjectMapper mapper = new ObjectMapper();
        User userNew;
        try {
            userNew = mapper.readValue(user, User.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        try {
            String type = FilenameUtils.getExtension(file.getOriginalFilename());
            String filepath = "C:\\Users\\nagyr\\OneDrive\\Desktop\\sport-helper\\src\\usersPhotoGallery\\" + userNew.getUser_name() +"." + type;
            File path = new File(filepath);
            path.createNewFile();
            FileOutputStream output = new FileOutputStream(path);
            output.write(file.getBytes());
            output.close();
        } catch (Exception e) {
            return null; // Why we return User?
        }

        return userRepository.save(userNew);
    }

//    @PutMapping("/user/{user_name}")
//    User updateUser(@RequestBody User newUser, @PathVariable String user_name){
//        return userRepository.
//    }

}
