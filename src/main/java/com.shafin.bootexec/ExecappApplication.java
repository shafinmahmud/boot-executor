package com.shafin.bootexec;

import com.shafin.bootexec.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

/**
 * @author shafin
 * @since 3/20/2018
 */
@SpringBootApplication
public class ExecappApplication implements CommandLineRunner {

    @Autowired
    private ApplicationContext appContext;

    public static void main(String[] args) {
        SpringApplication.run(ExecappApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        BookService bookService = (BookService) appContext.getBean("bookService");
        bookService.getBooks().forEach(b -> System.out.println(b.getName()));
    }
}
