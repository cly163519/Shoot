package cn.tedu.shoot;

import java.io.InputStream;

public class TestImageLoad {

        public static void main(String[] args) {
            System.out.println("Trying to load images...");
            try {
                java.net.URL url = TestImageLoad.class.getResource("/images/airplane.png");
                System.out.println("getResource: " + url);
                InputStream stream = TestImageLoad.class.getClassLoader().getResourceAsStream("images/airplane.png");
                System.out.println("getClassLoader().getResourceAsStream: " + (stream != null ? "Success" : "Failed"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


