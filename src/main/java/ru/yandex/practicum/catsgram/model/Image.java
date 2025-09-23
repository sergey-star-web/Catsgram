//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ru.yandex.practicum.catsgram.model;

public class Image {
    Long id;
    long postId;
    String originalFileName;
    String filePath;

    public Image() {
    }

    public Long getId() {
        return this.id;
    }

    public long getPostId() {
        return this.postId;
    }

    public String getOriginalFileName() {
        return this.originalFileName;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setPostId(final long postId) {
        this.postId = postId;
    }

    public void setOriginalFileName(final String originalFileName) {
        this.originalFileName = originalFileName;
    }

    public void setFilePath(final String filePath) {
        this.filePath = filePath;
    }

    public String toString() {
        Long var10000 = this.getId();
        return "Image(id=" + var10000 + ", postId=" + this.getPostId() + ", originalFileName=" + this.getOriginalFileName() + ", filePath=" + this.getFilePath() + ")";
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Image)) {
            return false;
        } else {
            Image other = (Image)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$id = this.getId();
                Object other$id = other.getId();
                if (this$id == null) {
                    if (other$id != null) {
                        return false;
                    }
                } else if (!this$id.equals(other$id)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Image;
    }

    public int hashCode() {
        int result = 1;
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        return result;
    }
}
