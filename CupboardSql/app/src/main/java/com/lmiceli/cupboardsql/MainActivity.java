package com.lmiceli.cupboardsql;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.lmiceli.cupboardsql.model.Post;
import com.lmiceli.cupboardsql.model.PracticeDatabaseHelper;
import com.lmiceli.cupboardsql.model.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // setup database
        PracticeDatabaseHelper dbHelper = new PracticeDatabaseHelper(this);
//        SQLiteDatabase db = dbHelper.getWritableDatabase();

        User user = dbHelper.findById(User.class, 1L);

        if (user == null){
            user = new User();
            user.setUserName("Pedro");
            user.setProfilePictureUrl("some-url.com");
            dbHelper.addItem(user);
        }

        Post post = dbHelper.findById(Post.class, 1L);

        if (post == null){
            post = new Post();
            post.setUser(user);
            post.setText("This is my philosophy");
            dbHelper.addItem(post);
        }

        List<Post> allPosts = dbHelper.getAll(Post.class);

        if (allPosts.size() > 0){
            TextView postView = (TextView) findViewById(R.id.post);
            Post post1 = allPosts.get(0);

            postView.setText(post1.getText());
            TextView authorView = (TextView) findViewById(R.id.author);

            authorView.setText("by " + getUsername(dbHelper, post1));
        }

    }

    private String getUsername(PracticeDatabaseHelper dbHelper, Post post1) {
        String userName;

        try {
            // FIXME, there has to be a better way to get the lazy loaded data
            User userFromPost = post1.getUser();
            userFromPost = dbHelper.findById(User.class, userFromPost.get_id());
            userName = userFromPost.getUserName();
        }
        catch (NullPointerException e) {
            userName = "Anonymous";
        }
        return userName;
    }
}
