//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ru.yandex.practicum.catsgram.model;

import java.time.Instant;

public class Post {
    Long id;
    long authorId;
    String description;
    Instant postDate;

    public Post() {
    }

    public Long getId() {
        return this.id;
    }

    public long getAuthorId() {
        return this.authorId;
    }

    public String getDescription() {
        return this.description;
    }

    public Instant getPostDate() {
        return this.postDate;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setAuthorId(final long authorId) {
        this.authorId = authorId;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setPostDate(final Instant postDate) {
        this.postDate = postDate;
    }

    public String toString() {
        Long var10000 = this.getId();
        return "Post(id=" + var10000 + ", authorId=" + this.getAuthorId() + ", description=" + this.getDescription() + ", postDate=" + String.valueOf(this.getPostDate()) + ")";
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Post)) {
            return false;
        } else {
            Post other = (Post)o;
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
        return other instanceof Post;
    }

    public int hashCode() {
        int result = 1;
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        return result;
    }
}
