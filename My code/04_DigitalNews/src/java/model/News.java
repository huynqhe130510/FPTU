/*
* News.java
*
* All Right Reserved
* Copyright (c) 2020 FPT University
 */
package model;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * News.<br>
 *
 * <pre>
 * Class mô tả đối tượng News
 * Trong class này sẽ tiến hành các xử lí dưới đây
 *
 * . getId.
 * . setId.
 * . getTitle.
 * . setTile.
 * . getContent.
 * . setContent.
 * . getShort_content.
 * . setShort_content.
 * . getWriter.
 * . setWriter.
 * . getImage_link.
 * . setImage_link.
 * . getDate_published.
 * . setDate_published.
 *
 * 
 * </pre>
 *
 * @author FU HuyNQHE130510
 * @version 1.0
 */
public class News {

    /**
     * Store id.
     */
    private int id;
    /**
     * Store title.
     */
    private String title;
    /**
     * Store content.
     */
    private String content;
    /**
     * Store short_content.
     */
    private String short_content;
    /**
     * Store writer.
     */
    private String writer;
    /**
     * Store image_link.
     */
    private String image_link;
    /**
     * Store date_published.
     */
    private Date date_published;

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
     * get title <br>
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set title.<br>
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
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
     * get short_content <br>
     *
     * @return the short_content
     */
    public String getShort_content() {
        return short_content;
    }

    /**
     * Set short_content.<br>
     *
     * @param short_content the short_content
     */
    public void setShort_content(String short_content) {
        this.short_content = short_content;
    }

    /**
     * get writer <br>
     *
     * @return the writer
     */
    public String getWriter() {
        return writer;
    }

    /**
     * Set writer.<br>
     *
     * @param writer the writer
     */
    public void setWriter(String writer) {
        this.writer = writer;
    }

    /**
     * get image_link <br>
     *
     * @return the image_link
     */
    public String getImage_link() {
        return image_link;
    }

    /**
     * Set image_link.<br>
     *
     * @param image_link the image_link
     */
    public void setImage_link(String image_link) {
        this.image_link = image_link;
    }

    /**
     * get date_published <br>
     *
     * @return the date_published
     */
    public String getDate_published() {
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("MMM dd yyyy - hh:mm a");
        String date = dateFormat1.format(this.date_published);
        return date;
    }

    /**
     * Set date_published.<br>
     *
     * @param date_published the date_published
     */
    public void setDate_published(Date date_published) {
        this.date_published = date_published;
    }
}
