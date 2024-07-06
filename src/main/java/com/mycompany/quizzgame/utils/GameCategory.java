/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.quizzgame.utils;

/**
 *
 * @author tsant
 */
public class GameCategory {
    private String title;
    private String description;
    private String theme;

    public GameCategory(String title, String description, String theme) {
        this.title = title;
        this.description = description;
        this.theme = theme;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getTheme() {
        return theme;
    }
}