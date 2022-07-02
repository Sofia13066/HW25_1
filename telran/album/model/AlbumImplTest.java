package telran.album.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// import telran.album.model.AlbumImpl;
// import telran.album.model.Photo;

public class AlbumImplTest {

  LocalDateTime time1 = LocalDateTime.of(2016, 4, 4, 18, 20, 01);
  LocalDateTime time2 = LocalDateTime.of(2021, 2, 20, 11, 12, 29);
  LocalDateTime time3 = LocalDateTime.of(2022, 3, 2, 18, 20, 03);
  LocalDateTime time4 = LocalDateTime.of(2017, 3, 2, 18, 20, 03);
  LocalDateTime time5 = LocalDateTime.of(2018, 7, 25, 12, 15, 03);
  AlbumImpl alb = new AlbumImpl(5);
  Photo photo1 = new Photo(0, 0, "title1", "url1", time1);
  Photo photo2 = new Photo(0, 1, "title2", "url2", time2);
  Photo photo3 = new Photo(0, 2, "title3", "url3", time3);
  Photo photo3_1 = new Photo(0, 2, "title3", "url3_1", time3);
  Photo photo4 = new Photo(1, 3, "title4", "url4", time4);

  @BeforeEach
  void setUp() {
    alb.addPhoto(photo3);
    alb.addPhoto(photo2);
    alb.addPhoto(photo1);
    alb.addPhoto(photo4);
  }

  @Test
  void testAddPhoto() {
    assertFalse(alb.addPhoto(photo3));
    assertFalse(alb.addPhoto(photo4));
    assertEquals(alb.size(), 4);
  }

  @Test
  void testRemovePhoto() {
    alb.removePhoto(photo2.getPhotoId(), photo2.getAlbumId());
    assertTrue(alb.removePhoto(photo1.getPhotoId(), photo1.getAlbumId()));
  }

  @Test
  void testUpdatePhoto() {
    alb.updatePhoto(2, 0, "url3_1");
    assertEquals(alb.getPhotoFromAlbum(2, 0), photo3_1);
  }

  @Test
  void testGetPhotoFromAlbum() {
    assertEquals(photo1, alb.getPhotoFromAlbum(0, 0));
  }

  @Test
  void testGetAllPhotoFromAlbum() {
    Photo[] fromAlb = alb.getAllPhotoFromAlbum(0);
    for (int i = 0; i < fromAlb.length; i++) {
      System.out.println(fromAlb[i]);
    }
    assertEquals(fromAlb.length, 3);
  }

  @Test
  void testSize() {
    assertEquals(alb.size(), 3);
  }

}
