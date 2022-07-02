package telran.album.model;

import java.time.LocalDateTime;

public class Photo implements Comparable<Photo> {
  private int albumId;
  private int photoId;
  private String title;
  private String url;
  private LocalDateTime date;

  public Photo(int albumId, int photoId, String title, String url, LocalDateTime date) {
    this.albumId = albumId;
    this.photoId = photoId;
    this.title = title;
    this.url = url;
    this.date = date;
  }
  public Photo(int albumId, int photoId) {
    this.albumId = albumId;
    this.photoId = photoId;
  }

  public int getAlbumId() {
    return albumId;
  }

  public int getPhotoId() {
    return photoId;
  }

  public String getTitle() {
    return title;
  }

  public String getUrl() {
    return url;
  }

  public LocalDateTime getDate() {
    return date;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  @Override
  public String toString() {
    return "Photo [albumId=" + albumId + ", date=" + date + ", photoId=" + photoId + ", title=" + title + ", url=" + url
        + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((title == null) ? 0 : title.hashCode());
    result = prime * result + ((url == null) ? 0 : url.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Photo other = (Photo) obj;
    if (title == null) {
      if (other.title != null)
        return false;
    } else if (!title.equals(other.title))
      return false;
    if (url == null) {
      if (other.url != null)
        return false;
    } else if (!url.equals(other.url))
      return false;
    return true;
  }

  @Override
  public int compareTo(Photo other) {
    return this.date.compareTo(other.getDate());
  }
}