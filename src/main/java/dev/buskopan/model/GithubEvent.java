package dev.buskopan.model;

import java.io.Serializable;
import java.util.Objects;

public class GithubEvent implements Serializable {

    private String id;
    private String type;
    private GithubRepo repo;

    public GithubEvent() {
    }

    public GithubEvent(String id, String type, GithubRepo repo) {
        this.id = id;
        this.type = type;
        this.repo = repo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public GithubRepo getRepo() {
        return repo;
    }

    public void setRepo(GithubRepo repo) {
        this.repo = repo;
    }

    @Override
    public String toString() {
        return "GithubEvent{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", repo=" + repo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GithubEvent that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(type, that.type) && Objects.equals(repo, that.repo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, repo);
    }
}
