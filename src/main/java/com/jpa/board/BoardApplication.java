package com.jpa.board;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.IntStream;

@SpringBootApplication
public class BoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoardApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(UserRepository userRepository, BoardRepository boardRepository) {
        return args ->
                IntStream.rangeClosed(1, 154).forEach(i -> {
                    User user =  User.builder()
                            .name("user" + i)
                            .build();

                    userRepository.save(user);

                    Board board = Board.builder()
                            .title("board" + i)
                            .writer(user)
                            .build();

                    boardRepository.save(board);
                });
    }

}
