package org.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {

    private final CakeBaker cakeBaker;

    public Main(CakeBaker cakeBaker) {
        this.cakeBaker = cakeBaker;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) {

        cakeBaker.bakeCake();

    }
}