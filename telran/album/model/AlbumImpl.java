package telran.album.model;

import java.util.Arrays;

public class AlbumImpl implements Album {
  private Photo[] photos;
  private int size = 0;

  public AlbumImpl(int capacity) {
    this.photos = new Photo[capacity];
  }

  @Override
  public boolean addPhoto(Photo photo) {
    if (size == 0) {
      photos[0] = photo;
      size++;
      return true;
    }
    int index = Arrays.binarySearch(photos, 0, this.size, photo);
    if (index >= 0) {
      return false;
    }
    index = -index - 1;
    Photo[] temp = new Photo[photos.length];
    System.arraycopy(this.photos, 0, temp, 0, size);
    temp[index] = photo;
    System.arraycopy(this.photos, index, temp, index + 1, size);
    size++;
    this.photos = temp;
    return true;
  }

  @Override
  public boolean removePhoto(int photoId, int albumId) {
    int i = getIndexPhotoFromAlbum(photoId, albumId);
    if (i == -1) {
      return false;
    }
    size--;
    Photo[] temp = new Photo[size];
    System.arraycopy(this.photos, 0, temp, 0, i);
    System.arraycopy(this.photos, i+1, temp, i, size - i);
    this.photos = temp;
    return true;
  }

  @Override
  public boolean updatePhoto(int photoId, int albumId, String url) {
    int i = getIndexPhotoFromAlbum(photoId, albumId);
    if (i == -1) {
      return false;
    }
    photos[i].setUrl(url);
    return true;
  }

  public boolean updatePhoto(int photoId, int albumId, String url, String title) {
    int i = getIndexPhotoFromAlbum(photoId, albumId);
    if (i == -1) {
      return false;
    }
    photos[i].setUrl(url);
    photos[i].setTitle(title);

    return false;
  }

  @Override
  public Photo getPhotoFromAlbum(int photoId, int albumId) {
    int index = getIndexPhotoFromAlbum(photoId, albumId);
    if (index == -1) {
      return null;
    }
    return photos[index];
  }

  @Override
  public Photo[] getAllPhotoFromAlbum(int albumId) {
    if (size == 0) {
      return null;
    }
    int counter = 0;
    Photo[] temp = new Photo[size];
    for (int i = 0; i < size; i++) {
      if (photos[i].getAlbumId() == albumId) {
        temp[counter] = photos[i];
        counter++;
      }
    }
    Photo[] res = new Photo[counter];
    System.arraycopy(temp, 0, res, 0, counter);
    return res;
  }

  @Override
  public int size() {
    return this.size;
  }

  private int getIndexPhotoFromAlbum(int photoId, int albumId) {
    if (size == 0) {
      return -1;
    }
    for (int i = 0; i < size; i++) {
      if (photos[i].getAlbumId() == albumId && photos[i].getPhotoId() == photoId) {
        return i;
      }
    }
    return -1;
  }
}