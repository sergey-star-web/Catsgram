//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ru.yandex.practicum.catsgram.model;


import java.time.Instant;
import lombok.Data;

@Data
public class Post {
    Long id;
    long authorId;
    String description;
    Instant postDate;

    public Post() {
    }
}
