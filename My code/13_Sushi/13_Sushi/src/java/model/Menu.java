/*
* Menu.java
*
* All Right Reserved
* Copyright (c) 2020 FPT University
 */
package model;

/**
 * Menu.<br>
 *
 * <pre>
 * Class mô tả đối tượng Menu
 * Trong class này sẽ tiến hành các xử lí dưới đây
 *
 * . GetId.
 * . SetId.
 * . GetName.
 * . SetName.
 * . GetContent.
 * . SetContent.
 * . GetPrice.
 * . SetPrice.
 * </pre>
 *
 * @author FU HuyNQHE130510
 * @version 1.0
 */
public class Menu {

    /**
     * Store id.
     */
    private int id;
    /**
     * Store name.
     */
    private String name;
    /**
     * Store content.
     */
    private String content;
    /**
     * Store price.
     */
    private double price;

    /**
     * get id <br>
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Set id.<br>
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * get name <br>
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Set name.<br>
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get content <br>
     *
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * Set content.<br>
     *
     * @param content the content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * get price <br>
     *
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Set price.<br>
     *
     * @param price the price
     */
    public void setPrice(double price) {
        this.price = price;
    }
}
