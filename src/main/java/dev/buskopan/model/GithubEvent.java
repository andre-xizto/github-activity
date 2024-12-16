package dev.buskopan.model;

import java.io.Serializable;

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
}
