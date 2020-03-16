/*
* Infomation.java
*
* All Right Reserved
* Copyright (c) 2020 FPT University
 */
package model;

/**
 * Information.<br>
 *
 * <pre>
 * Class mô tả đối tượng Information
 * Trong class này sẽ tiến hành các xử lí dưới đây
 *
 * . GetId.
 * . SetId.
 * . GetName.
 * . SetName.
 * . GetContent.
 * . SetContent.
 * </pre>
 *
 * @author FU HuyNQHE130510
 * @version 1.0
 */
public class Information {

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
}
