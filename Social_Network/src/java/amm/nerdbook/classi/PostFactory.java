/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.classi;

import java.util.*;

/**
 *
 * @author edef
 */
public class PostFactory {

//Pattern Design Singleton
    private static PostFactory singleton;

    public static PostFactory getInstance() {
        if (singleton == null) {
            singleton = new PostFactory();
        }
        return singleton;
    }

    private ArrayList<Post> listaPost = new ArrayList<Post>();

    private PostFactory() {

        UtenteFactory userFactory = UtenteFactory.getInstance();
        GruppoFactory groupFactory = GruppoFactory.getInstance();

        //creazione post
        Post post1 = new Post();
        post1.setId(0);
        post1.setAutore(userFactory.getUtenteById(0));
        post1.setUser(userFactory.getUtenteById(0));
        post1.setGroup(null);
        post1.setPostType(Post.Type.TEXT);
        post1.setContent("Oggi è proprio una bella giornata");
        post1.setUrlAllegato("");

        Post post2 = new Post();
        post2.setId(1);
        post2.setAutore(userFactory.getUtenteById(0));
        post2.setUser(userFactory.getUtenteById(1));
        post2.setGroup(null);
        post2.setPostType(Post.Type.IMAGE);
        post2.setContent("");
        post2.setUrlAllegato("img/imgPost2.jpg");

        Post post3 = new Post();
        post3.setId(2);
        post3.setAutore(userFactory.getUtenteById(1));
        post3.setUser(userFactory.getUtenteById(0));
        post3.setGroup(null);
        post3.setPostType(Post.Type.IMAGE);
        post3.setContent("Ahahahaaaaaa");
        post3.setUrlAllegato("img/imgPost3.jpeg");

        Post post4 = new Post();
        post4.setId(3);
        post4.setAutore(userFactory.getUtenteById(2));
        post4.setUser(userFactory.getUtenteById(2));
        post4.setGroup(null);
        post4.setPostType(Post.Type.IMAGE);
        post4.setContent("");
        post4.setUrlAllegato("img/imagesPost.jpg");

        Post post5 = new Post();
        post5.setId(4);
        post5.setAutore(userFactory.getUtenteById(1));
        post5.setUser(userFactory.getUtenteById(1));
        post5.setGroup(null);
        post5.setPostType(Post.Type.TEXT);
        post5.setContent("Ciao e buona giornata a tutti amici ");
        post5.setUrlAllegato("");

        Post post6 = new Post();
        post6.setId(5);
        post6.setAutore(userFactory.getUtenteById(3));
        post6.setUser(userFactory.getUtenteById(3));
        post6.setGroup(null);
        post6.setPostType(Post.Type.LINK);
        post6.setContent("Vamos blaugrana !!!");
        post6.setUrlAllegato("http://it.wikipedia.org/wiki/Futbol_Club_Barcelona");

        listaPost.add(post1);
        listaPost.add(post2);
        listaPost.add(post3);
        listaPost.add(post4);
        listaPost.add(post5);
        listaPost.add(post6);

    }

    public Post getPostById(int id) {
        for (Post post : this.listaPost) {
            if (post.getId() == id) {
                return post;
            }
        }
        return null;
    }

    public List getPostByUtente(Utente usr) {

        List<Post> listaPost = new ArrayList<Post>();

        for (Post post : this.listaPost) {
            if (post.getUser() != null && post.getUser().equals(usr)) {
                listaPost.add(post);
            }
        }

        return listaPost;
    }

    public List getPostByGruppo(Gruppo gr) {

        List<Post> listaPost = new ArrayList<Post>();

        for (Post post : this.listaPost) {
            if (post.getGroup() != null && post.getGroup().equals(gr)) {
                listaPost.add(post);
            }
        }
        return listaPost;
    }

    public List getPostByAutore(Utente usr) {

        List<Post> listaPost = new ArrayList<Post>();

        for (Post post : this.listaPost) {
            if (post.getAutore().equals(usr)) {
                listaPost.add(post);
            }
        }
        return listaPost;
    }
}
