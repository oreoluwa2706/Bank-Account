package africa.semicolon;


import africa.semicolon.Controllers.PostControllers;
import africa.semicolon.dtos.requests.CreatePostRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import javax.swing.*;

@SpringBootApplication
@EnableMongoRepositories

public class Main {
    //private static PostControllers postControllers = new PostControllers();

    public static void main(String[] args) {
        //displayMenu();
        SpringApplication.run(Main.class, args);
    }

}
/**
"""
    private static void displayMenu(){
        String mainMenu= """
                press 1 to create post
                press 2 to view post;
                press 3 to exit
                """;

        String userInput = input(mainMenu);
        switch ((Integer.parseInt(String.valueOf(userInput.charAt(0))))){
            case 1 -> createPost();
            case 2 -> viewPost();
            case 3 -> exitFromApp();
        }
    }
    private static void createPost(){
        String title = input("Enter post title");
        String body = input("Enter post body");
        CreatePostRequest createPostRequest = new CreatePostRequest();
        createPostRequest.setTitle(title);
        createPostRequest.setBody(body);
        print(postControllers.createPost(createPostRequest));
        displayMenu();
    }

    private static void viewPost(){
        String userInput = input("Enter post id");
        print(postControllers.viewPost(Integer.parseInt(String.valueOf(userInput))).toString());
        displayMenu();
    }
private static void exitFromApp(){
        print("Thank you for choosing our app");
        System.exit(0);
}
    private static String input(String prompt) {
        return JOptionPane.showInputDialog(prompt);
    }

    private static void print(String prompt){
        JOptionPane.showMessageDialog(null, prompt);
    }

}
*/