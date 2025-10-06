//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ru.yandex.practicum.catsgram.model;

import lombok.Data;

@Data
public class Image {
    private Long id;
    private long postId;
    private String originalFileName;
    private String filePath;

    public Image() {
    }
}
